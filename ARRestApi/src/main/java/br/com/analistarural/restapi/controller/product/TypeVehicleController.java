package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.TypeVehicle;
import br.com.analistarural.restapi.service.product.TypeVehicleService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class TypeVehicleController {

	@Autowired
	private TypeVehicleService typeVehicleService;
	
	@RequestMapping(value = "/typeVehicles", method = RequestMethod.GET)
    public Iterable<TypeVehicle> getTypeVehicles() {
        return typeVehicleService.findAll();
	}
	
	
	@RequestMapping(value = "/typeVehicle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveTypeVehicle(@Valid @RequestBody TypeVehicle typeVehicle){
		typeVehicleService.save(typeVehicle);
	}
}
