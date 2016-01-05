package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Seed;
import br.com.analistarural.restapi.service.product.SeedService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class SeedController {

	@Autowired
	private SeedService seedService;
	
	@RequestMapping(value = "/seeds", method = RequestMethod.GET)
    public Iterable<Seed> getSeeds() {
        return seedService.findAll();
	}
	
	
	@RequestMapping(value = "/seed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveSeed(@Valid @RequestBody Seed seed){
		seedService.save(seed);
	}
}
