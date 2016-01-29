package br.com.analistarural.restapi.controller.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.analistarural.domain.entity.product.Tools;
import br.com.analistarural.restapi.service.product.ToolsService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class ToolsController {
	
	@Autowired
	private ToolsService toolsService;
	
	@RequestMapping(value = "/tools", method = RequestMethod.GET)
    public Iterable<Tools> getTools() {
        return toolsService.findAll();
	}
	
	
	@RequestMapping(value = "/Tools", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveTools(@Valid @RequestBody Tools tools){
		toolsService.save(tools);
	}

}
