package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.Consumption;
import br.com.analistarural.restapi.service.product.ConsumptionService;


@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ConsumptionController {

	@Autowired
	private ConsumptionService consumptionService;
	
	@RequestMapping(value = "/consumptions", method = RequestMethod.GET)
    public Iterable<Consumption> getConsumption() {
        return consumptionService.findAll();
	}
	
	
	@RequestMapping(value = "/consumption", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFertilizer(@Valid @RequestBody Consumption consumption){
		consumptionService.save(consumption);
	}
}
