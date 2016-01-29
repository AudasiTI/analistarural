package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.entity.product.ChemicalElement;
import br.com.analistarural.restapi.service.product.ChemicalElementService;


@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ChemicalElementsController {

	@Autowired
	private ChemicalElementService chemicalElementService;
	
	@RequestMapping(value = "/chemicalElements", method = RequestMethod.GET)
    public Iterable<ChemicalElement> getChemicalElement() {
        return chemicalElementService.findAll();
	}
	
	
	@RequestMapping(value = "/chemicalElement", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveChemicalElement(@Valid @RequestBody ChemicalElement chemicalElement){
		chemicalElementService.save(chemicalElement);
	}
}
