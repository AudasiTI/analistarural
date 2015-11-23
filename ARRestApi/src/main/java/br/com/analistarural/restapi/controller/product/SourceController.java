package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Source;
import br.com.analistarural.restapi.service.product.SourceService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class SourceController {

	@Autowired
	private SourceService sourceService;
	
	@RequestMapping(value = "/sources", method = RequestMethod.GET)
    public Iterable<Source> getFarms() {
        return sourceService.findAll();
	}
	
	@RequestMapping(value = "/source", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveSource(@Valid @RequestBody Source source){
		sourceService.save(source);
	}
	
	@RequestMapping(value = "/delsource", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteSource(@Valid @RequestBody Long id){
		sourceService.delete(id);
	}
	
}
