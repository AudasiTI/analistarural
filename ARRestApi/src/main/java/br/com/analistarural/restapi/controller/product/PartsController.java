package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Parts;
import br.com.analistarural.restapi.service.product.PartsService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class PartsController {

	@Autowired
	private PartsService partsService;
	
	@RequestMapping(value = "/parts", method = RequestMethod.GET)
    public Iterable<Parts> getParts() {
        return partsService.findAll();
	}
	
	
	@RequestMapping(value = "/part", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveParts(@Valid @RequestBody Parts parts){
		partsService.save(parts);
	}
}
