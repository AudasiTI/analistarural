package br.com.analistarural.restapi.controller.field;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.dto.field.FieldsDTO;
import br.com.analistarural.restapi.service.field.FieldService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FieldController {

	@Autowired
	private FieldService fieldService;

	@RequestMapping(value = "/fields/farm/{farm_id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<FieldsDTO> getFieldsByFarm(@PathVariable("farm_id") Long farmID) {
		return fieldService.findFieldsByFarm(farmID);
	}

	@RequestMapping(value = "/fields/systemaccount/{system_account_id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<FieldsDTO> getFieldsBySystemAccount(
			@PathVariable("system_account_id") Long systemAccountID) {
		return fieldService.findFieldsBySystemAccount(systemAccountID);
	}

	@RequestMapping(value = "/fields/{field_id}", method = RequestMethod.GET)
	public @ResponseBody FieldsDTO getField(@PathVariable("field_id") Long fieldID) {
		return fieldService.findFieldByID(fieldID);
	}

	@RequestMapping(value = "/fields", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveField(@Valid @RequestBody FieldsDTO fieldDTO) {
		fieldService.save(fieldDTO);
	}

	@RequestMapping(value = "/fields/{field_id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteField(@PathVariable("field_id") Long fieldID) {
		fieldService.delete(fieldID);
		return "Registro excluído com sucesso.";
	}

}
