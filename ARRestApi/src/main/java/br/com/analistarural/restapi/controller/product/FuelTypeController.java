package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.FuelType;
import br.com.analistarural.restapi.service.product.FuelTypeService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FuelTypeController {

	@Autowired
	private FuelTypeService fuelTypeService;
	
	@RequestMapping(value = "/fuelTypes", method = RequestMethod.GET)
    public Iterable<FuelType> getFuelTypes() {
        return fuelTypeService.findAll();
	}
	
	
	@RequestMapping(value = "/fuelType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFuelType(@Valid @RequestBody FuelType fuelType){
		fuelTypeService.save(fuelType);
	}
}
