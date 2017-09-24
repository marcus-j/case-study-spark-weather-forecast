package de.marcusjanke.casestudies.medicalprocedurescheduler.handlers;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ConstraintViolation ExceptionHandler
 * 
 * @author marcus
 *
 */
@ControllerAdvice
public class ConstraintViolationExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(ConstraintViolationExceptionHandler.class);

	/**
	 * create handler
	 */
	public ConstraintViolationExceptionHandler() {
		logger.info("Created ConstraintViolationExceptionHandler");
	}	
    
	/**
	 * handle exception
	 * 
	 * @param model
	 * @param e
	 * @return model view name
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public String handleConstraintViolationException(Model model, ConstraintViolationException e) {
		logger.error(String.format("Encountered exception %s", e.getMessage()));
		model.addAttribute("message", e.getMessage());
		return "error400";
	}
}
