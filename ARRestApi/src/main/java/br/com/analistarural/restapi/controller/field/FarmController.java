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

import br.com.analistarural.domain.dto.field.FarmDTO;
import br.com.analistarural.restapi.service.field.FarmService;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class FarmController {

	@Autowired
	private FarmService farmService;

	// @Secured("ROLE_ADMIN")
	// @RequestMapping(value = "/farms", method = RequestMethod.GET)
	// public @ResponseBody Iterable<Farm> getFarms(@AuthenticationPrincipal
	// UserAccount user) {
	// return (Iterable<Farm>)
	// farmService.findFarmsBySystemAccount(user.getSystemAccount());
	// }

	// @Secured("ROLE_ADMIN")
	@RequestMapping(value = "/farms/systemaccount/{system_account_id}", method = RequestMethod.GET)
	public @ResponseBody Iterable<FarmDTO> getFarms(@PathVariable("system_account_id") Long systemID) {
		return farmService.findFarmsBySystemAccount(systemID);
	}

	@RequestMapping(value = "/farms/{farm_id}", method = RequestMethod.GET)
	public @ResponseBody FarmDTO getFarm(@PathVariable("farm_id") Long farmID) {
		return farmService.findFarmByID(farmID);
	}

	@RequestMapping(value = "/farms", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFarm(@Valid @RequestBody FarmDTO farmDTO) {
		farmService.save(farmDTO);
	}

	@RequestMapping(value = "/farms/{farm_id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteFarm(@PathVariable("farm_id") Long farmID) {
		farmService.delete(farmID);
		return "Registro excluído com sucesso.";
	}
}