package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.ProducedSeed;
import br.com.analistarural.restapi.service.product.ProducedSeedService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ProducedSeedController {

	@Autowired
	private ProducedSeedService producedSeedService;
	
	@RequestMapping(value = "/producedSeeds", method = RequestMethod.GET)
    public Iterable<ProducedSeed> getProducedSeeds() {
        return producedSeedService.findAll();
	}
	
	
	@RequestMapping(value = "/producedSeed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveProducedSeed(@Valid @RequestBody ProducedSeed producedSeed){
		producedSeedService.save(producedSeed);
	}
}
