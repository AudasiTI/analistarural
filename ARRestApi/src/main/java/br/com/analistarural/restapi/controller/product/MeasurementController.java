package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Measurement;
import br.com.analistarural.restapi.service.product.MeasurementService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;
	
	@RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public Iterable<Measurement> getMeasurements() {
        return measurementService.findAll();
	}
	
	
	@RequestMapping(value = "/measurement", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMeasurement(@Valid @RequestBody Measurement measurement){
		measurementService.save(measurement);
	}
}
