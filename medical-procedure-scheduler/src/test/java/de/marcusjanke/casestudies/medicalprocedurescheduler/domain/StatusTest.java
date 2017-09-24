package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Status tests
 * 
 * @author marcus
 *
 */
public class StatusTest {

	/**
	 * test available enums
	 */
	@Test
	public void testValues() {
		assertThat(Status.values()).containsExactlyInAnyOrder(Status.FINISHED, Status.IN_PROGRESS, Status.PLANNED);
	}

	/**
	 * test enum valueOf creation
	 */
	@Test
	public void testValueOf() {
		assertThat(Status.valueOf("FINISHED")).isEqualTo(Status.FINISHED);
		assertThat(Status.valueOf("IN_PROGRESS")).isEqualTo(Status.IN_PROGRESS);
		assertThat(Status.valueOf("PLANNED")).isEqualTo(Status.PLANNED);
	}
}
