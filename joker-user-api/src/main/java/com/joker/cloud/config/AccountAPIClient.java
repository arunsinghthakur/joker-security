package com.joker.cloud.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("JOKER-ACCOUNT-API")
public interface AccountAPIClient{
	
	@RequestMapping("/rest/account/info")
	public String acccountNumber();
}
