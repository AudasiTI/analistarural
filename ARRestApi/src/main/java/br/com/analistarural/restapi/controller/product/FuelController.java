package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Fuel;
import br.com.analistarural.restapi.service.product.FuelService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FuelController {

	@Autowired
	private FuelService fuelService;
	
	@RequestMapping(value = "/fuels", method = RequestMethod.GET)
    public Iterable<Fuel> getFuels() {
        return fuelService.findAll();
	}
	
	
	@RequestMapping(value = "/fuel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFuel(@Valid @RequestBody Fuel fuel){
		fuelService.save(fuel);
	}
}
