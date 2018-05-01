package org.upsi.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocoss")
public class MoCoSSController {
	static final Logger logger = LoggerFactory.getLogger(MoCoSSController.class);
	
	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String test( ) {
		String stringTEST = "Testing..";
		return stringTEST;
	}

}
