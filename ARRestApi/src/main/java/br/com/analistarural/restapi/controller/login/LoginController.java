package br.com.analistarural.restapi.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analistarural.domain.dto.UserLoginDTO;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class LoginController {

	// @Autowired
	// private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Boolean> login(@Valid @RequestBody UserLoginDTO userLogin) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("status", true);
		return map;
	}
}
