package com.joker.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/rest")
public class UserAPI {

	@Autowired
	private AccountAPIClient accountAPI;
	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/greet")
	// @PreAuthorize("hasRole('USER') and #oauth2.hasScope('read')")
	public String greeting(@RequestParam("name") String name) {
		return "Welcome to Joker Cloud system - " + name + ". Your account number is - " + doRequest();
		// return "Welcome to Joker Cloud system - " + name + ". Your account number is - " + accountAPI.acccountNumber();
	}

	public String doRequest() {
		RestTemplate rest = new RestTemplate();
		Application application = eurekaClient.getApplication("joker-account-api");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String hostname = instanceInfo.getHostName();
		int port = instanceInfo.getPort();
		String appName = instanceInfo.getAppName();
		String url = "http://" + hostname + ":" + port + "/" + appName.toLowerCase() + "/rest/account/info";
		return rest.getForEntity(url, String.class).getBody();
	}
}
