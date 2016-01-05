package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.ProductFinished;
import br.com.analistarural.restapi.service.product.ProductFinishedService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ProductFinishedController {

	@Autowired
	private ProductFinishedService productFinishedService;
	
	@RequestMapping(value = "/productFinisheds", method = RequestMethod.GET)
    public Iterable<ProductFinished> getProductFinisheds() {
        return productFinishedService.findAll();
	}
	
	
	@RequestMapping(value = "/productFinished", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveProductFinished(@Valid @RequestBody ProductFinished productFinished){
		productFinishedService.save(productFinished);
	}
}
