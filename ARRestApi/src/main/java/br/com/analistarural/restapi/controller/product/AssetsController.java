package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.Assets;
import br.com.analistarural.restapi.service.product.AssetsService;


@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class AssetsController {

	@Autowired
	private AssetsService assetsService;
	
	@RequestMapping(value = "/assets", method = RequestMethod.GET)
    public Iterable<Assets> getAssets() {
        return assetsService.findAll();
	}
	
	
	@RequestMapping(value = "/asset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveAsset(@Valid @RequestBody Assets assets){
		assetsService.save(assets);
	}
	
}
