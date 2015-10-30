package br.com.analistarural.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.account.UserAccount;
import br.com.analistarural.domain.entity.field.Farm;
import br.com.analistarural.restapi.service.FarmService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FarmController {

	@Autowired
	private FarmService farmService;

	@Secured("ROLE_ADMIN")
	@RequestMapping("/farms")
	public @ResponseBody Iterable<Farm> getFarms(
			@AuthenticationPrincipal UserAccount user) {
		return (Iterable<Farm>) farmService.findFarmsBySystemAccount(user.getSystemAccount());
	}

}