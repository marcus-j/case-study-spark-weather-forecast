package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 * 
 * @author marcus
 *
 */
@Controller
public class HomeController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * create HomeController
	 */
	public HomeController() {
		logger.info("Created HomeController");
	}

	/**
	 * get home (index) view
	 * @return home (index) view
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}