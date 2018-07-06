package com.joker.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/rest/account")
public class AccountAPI {
	
	@GetMapping("/info")
	//@PreAuthorize("hasRole('USER') and #oauth2.hasScope('read')")
	public String acccountNumber() {
		return "877987987987";
	}
}
