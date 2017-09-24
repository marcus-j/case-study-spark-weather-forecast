package de.marcusjanke.casestudies.medicalprocedurescheduler.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Default ExceptionHandler
 * 
 * @author marcus
 *
 */
@ControllerAdvice
public class DefaultExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	/**
	 * create handler
	 */
	public DefaultExceptionHandler() {
		logger.info("Created DefaultExceptionHandler");
	}
    
	/**
	 * handle exception
	 * 
	 * @param model
	 * @param e
	 * @return model view name
	 */
	@ExceptionHandler(Exception.class)
	public String handleConstraintException(Model model, Exception e) {
		logger.error(String.format("Encountered exception %s", e.getMessage()));
		model.addAttribute("message", e.getMessage());
		return "error500";
	}
}
