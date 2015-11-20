package br.com.analistarural.restapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping("/farms1")
	public @ResponseBody Iterable<Farm> getFarms(
			@AuthenticationPrincipal UserAccount user) {
		return (Iterable<Farm>) farmService.findFarmsBySystemAccount(user.getSystemAccount());
	}
	
	@RequestMapping(value = "/farm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFarm(@Valid @RequestBody Farm farm){
		farmService.save(farm);
	}
	
	@RequestMapping(value = "/farms", method = RequestMethod.GET)
    public Iterable<Farm> getFarms() {
        return farmService.findAll();
	}
}
