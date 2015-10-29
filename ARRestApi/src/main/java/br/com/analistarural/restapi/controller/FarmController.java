package br.com.analistarural.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.restapi.service.FarmService;

@RestController
@RequestMapping(value = "/api/farm", produces = { "application/json;charset=UTF-8" })
public class FarmController {
	
	@Autowired
	private FarmService farmService;

}
