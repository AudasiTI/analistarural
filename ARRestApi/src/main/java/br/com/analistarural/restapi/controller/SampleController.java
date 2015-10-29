package br.com.analistarural.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.User;
import br.com.analistarural.domain.entity.account.UserAccount;
import br.com.analistarural.restapi.service.UserAccountService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class SampleController {

	@Autowired
	private UserAccountService userService;

	@RequestMapping("/")
	public String home() {
		return "hello!!!";
	}

	@Secured("ROLE_GUEST")
	@RequestMapping("/guest")
	public String guest() {
		return "hello!!!";
	}

	@Secured("ROLE_GUEST")
	@RequestMapping("/hello")
	public String home(@AuthenticationPrincipal UserAccount user) {
		return String.format("Hello, %s!", user.getEmail());
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/users")
	public @ResponseBody Iterable<UserAccount> getUsers() {
		return userService.findAll();
	}
}
