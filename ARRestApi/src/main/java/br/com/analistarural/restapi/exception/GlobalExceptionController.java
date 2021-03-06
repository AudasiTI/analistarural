package br.com.analistarural.restapi.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionController {

	@ResponseBody
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(BAD_REQUEST)
	public Map handleBadRequests(HttpServletRequest request, Exception exception) {
		return new HashMap() {
			{
				put("status", BAD_REQUEST.value());
				put("message", exception.getMessage());
				put("Caused", ExceptionUtils.getRootCauseMessage(exception
						.getCause()));
			}
		};
	}
}
