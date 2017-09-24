package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Sex tests
 * 
 * @author marcus
 *
 */
public class SexTest {

	/**
	 * test available enums
	 */
	@Test
	public void testValues() {
		assertThat(Sex.values()).containsExactlyInAnyOrder(Sex.FEMALE, Sex.MALE);
	}

	/**
	 * test enum valueOf creation
	 */
	@Test
	public void testValueOf() {
		assertThat(Sex.valueOf("FEMALE")).isEqualTo(Sex.FEMALE);
		assertThat(Sex.valueOf("MALE")).isEqualTo(Sex.MALE);
	}
}
