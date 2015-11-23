package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.Fertilizer;
import br.com.analistarural.restapi.service.product.FertilizerService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FertilizerController {

	@Autowired
	private FertilizerService fertilizerService;
	
	@RequestMapping(value = "/fertilizers", method = RequestMethod.GET)
    public Iterable<Fertilizer> getFertilizers() {
        return fertilizerService.findAll();
	}
	
	
	@RequestMapping(value = "/fertilizer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFertilizer(@Valid @RequestBody Fertilizer fertilizer){
		fertilizerService.save(fertilizer);
	}
	
	
}
