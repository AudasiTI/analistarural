package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.Defensive;
import br.com.analistarural.restapi.service.product.DefensiveService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class DefensiveController {

	@Autowired
	private DefensiveService defensiveService;
	
	@RequestMapping(value = "/defensives", method = RequestMethod.GET)
    public Iterable<Defensive> getDefensives() {
        return defensiveService.findAll();
	}
	
	
	@RequestMapping(value = "/defensive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveDefensive(@Valid @RequestBody Defensive defensive){
		defensiveService.save(defensive);
	}
	
}
