package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Variety;
import br.com.analistarural.restapi.service.product.VarietyService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class VarietyController {

	@Autowired
	private VarietyService varietyService;
	
	@RequestMapping(value = "/varietys", method = RequestMethod.GET)
    public Iterable<Variety> getVarietys() {
        return varietyService.findAll();
	}
	
	
	@RequestMapping(value = "/variety", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveVariety(@Valid @RequestBody Variety variety){
		varietyService.save(variety);
	}
	
}
