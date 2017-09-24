package de.marcusjanke.casestudies.medicalprocedurescheduler.handlers;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.validation.ConstraintViolationException;

/**
 * ConstraintViolationExceptionHandler tests
 * 
 * @author marcus
 *
 */
public class ConstraintViolationExceptionHandlerTest {

	/**
	 * test construction
	 */
	@Test
	public void testConstraintViolationExceptionHandler() {
		ConstraintViolationExceptionHandler constraintViolationExceptionHandler = new ConstraintViolationExceptionHandler();
		assertThat(constraintViolationExceptionHandler).isNotNull();
	}

	/**
	 * test return content on exception handling
	 */
	@Test
	public void handleConstraintExceptionModelException() {
		ConstraintViolationExceptionHandler constraintViolationExceptionHandler = new ConstraintViolationExceptionHandler();
		Model model = mock(Model.class);
		assertThat(constraintViolationExceptionHandler.handleConstraintViolationException(model,
				new ConstraintViolationException(null, null))).isEqualTo("error400");
	}
}