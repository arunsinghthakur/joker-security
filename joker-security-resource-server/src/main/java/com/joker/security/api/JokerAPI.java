package com.joker.security.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class JokerAPI {

	@GetMapping("/greet")
	@PreAuthorize("hasRole('ROLE_USER') and #oauth2.hasScope('read')")
	public String greeting(@RequestParam("name") String name) {
		return "Welcome to Joker security system - " + name;
	}
}
