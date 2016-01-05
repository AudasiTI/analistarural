package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Vehicle;
import br.com.analistarural.restapi.service.product.VehicleService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public Iterable<Vehicle> getVehicles() {
        return vehicleService.findAll();
	}
	
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveVehicler(@Valid @RequestBody Vehicle vehicle){
		vehicleService.save(vehicle);
	}
}
