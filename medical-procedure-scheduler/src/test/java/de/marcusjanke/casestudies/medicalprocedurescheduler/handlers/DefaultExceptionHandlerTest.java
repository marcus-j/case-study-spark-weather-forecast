package de.marcusjanke.casestudies.medicalprocedurescheduler.handlers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.ui.Model;

/**
 * DefaultExceptionHandler tests
 * 
 * @author marcus
 *
 */
public class DefaultExceptionHandlerTest { 
	
	/**
	 * test construction
	 */
	@Test
	public void testDefaultExceptionHandler() {
		DefaultExceptionHandler defaultExceptionHandler = new DefaultExceptionHandler();
		assertThat(defaultExceptionHandler).isNotNull();
	}

	/**
	 * test return content on exception handling
	 */
	@Test
	public void handleConstraintExceptionModelException() {
		DefaultExceptionHandler defaultExceptionHandler = new DefaultExceptionHandler();
		Model model = mock(Model.class);
		assertThat(defaultExceptionHandler.handleConstraintException(model, new ConstraintViolationException(null, null))).isEqualTo("error500");		
	}
	
}