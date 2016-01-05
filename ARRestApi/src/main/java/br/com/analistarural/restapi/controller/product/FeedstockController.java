package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.Feedstock;
import br.com.analistarural.restapi.service.product.FeedstockService;


@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FeedstockController {

	@Autowired
	private FeedstockService feedstockService;
	
	@RequestMapping(value = "/feedstocks", method = RequestMethod.GET)
    public Iterable<Feedstock> getFeedstocks() {
        return feedstockService.findAll();
	}
	
	
	@RequestMapping(value = "/feedstock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFeedstock(@Valid @RequestBody Feedstock feedstock){
		feedstockService.save(feedstock);
	}
}
