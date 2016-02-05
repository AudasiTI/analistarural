package br.com.analistarural.restapi.controller.product;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/measurements/{idMeasurement}", method = RequestMethod.GET)
    public Optional<Measurement> getMeasurement(@PathVariable("idMeasurement") Long idMeasurement) {
        return measurementService.findByIdMeasurement(idMeasurement);
	}
	
	
	@RequestMapping(value = "/measurements", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveMeasurement(@Valid @RequestBody Measurement measurement){
		measurementService.save(measurement);
	}
	
	@RequestMapping(value = "/measurements/{idMeasurement}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteMeasurement(@PathVariable("idMeasurement") Long idMeasurement) {
		measurementService.delete(idMeasurement);
	}
}
