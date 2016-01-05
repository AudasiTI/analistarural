package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.DefensiveType;
import br.com.analistarural.restapi.service.product.DefensiveTypeService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class DefensiveTypeController {

	@Autowired
	private DefensiveTypeService defensiveTypeService;
	
	@RequestMapping(value = "/defensiveTypes", method = RequestMethod.GET)
    public Iterable<DefensiveType> getDefensiveTypes() {
        return defensiveTypeService.findAll();
	}
	
	
	@RequestMapping(value = "/defensiveType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveDefensiveType(@Valid @RequestBody DefensiveType defensiveType){
		defensiveTypeService.save(defensiveType);
	}
}
