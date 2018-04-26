package org.upsi.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mocoss")
public class MoCoSSController {
	public static final Logger logger = LoggerFactory.getLogger(MoCoSSController.class);

}
