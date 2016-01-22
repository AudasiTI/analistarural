package br.com.analistarural.restapi.controller.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = { "application/json;charset=UTF-8" })
public class LoginController {

	// @Autowired
	// private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Boolean> login(@RequestParam("userLogin") String userLogin) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("status", true);
		return map;
	}
}
