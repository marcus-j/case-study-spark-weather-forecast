package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * Doctor tests
 * 
 * @author marcus
 *
 */
public class DoctorTest { 

	private static final String NAME = "DOE";
	private static final long ID = 300L;
	
	/**
	 * test construction
	 */
	@Test
	public void testDoctor() {
		Doctor doctor = new Doctor();
		assertThat(doctor.getId()).isEqualTo(0L);
		assertThat(doctor.getName()).isNull();		
	}

	/**
	 * test construction
	 */
	@Test
	public void testDoctorName() {
		Doctor doctor = new Doctor(NAME);
		assertThat(doctor.getId()).isEqualTo(0L);
		assertThat(doctor.getName()).isEqualTo(NAME);	
	}

	/**
	 * test set/get id
	 */
	@Test
	public void testSetGetId() {
		Doctor doctor = new Doctor();
		doctor.setId(Long.valueOf(ID));
		assertThat(doctor.getId()).isEqualTo(ID);
	}

	/**
	 * test set/get name
	 */
	@Test
	public void testSetGetName() {
		Doctor doctor = new Doctor();
		doctor.setName(NAME);
		assertThat(doctor.getName()).isEqualTo(NAME);
	}

	/**
	 * test toString
	 */
	@Test
	public void testToString() {
		Doctor doctor = new Doctor(NAME);
		assertThat(doctor.toString()).isEqualTo("Doctor [id=" + 0L + ", name=" + NAME + "]");		
	}
	
	/**
	 * test hash code
	 */
	@Test
	public void testHashCode() {
		Doctor doctor = new Doctor(NAME);
		assertThat(doctor.hashCode()).isEqualTo(new Doctor(NAME).hashCode());
		assertThat(new Doctor(null).hashCode()).isNotEqualTo(new Doctor(NAME).hashCode());
		assertThat(doctor.hashCode()).isNotEqualTo(new Doctor(null).hashCode());
		assertThat(doctor.hashCode()).isNotEqualTo(new Doctor("another name").hashCode());
	}
	
	/**
	 * test equals
	 */
	@Test
	public void testEquals() {
		Doctor doctor = new Doctor(NAME);
		assertThat(doctor).isEqualTo(new Doctor(NAME));
		assertThat(doctor).isNotEqualTo(new Doctor("another name"));
		assertThat(new Doctor(null)).isNotEqualTo(new Doctor("another name"));
		assertThat(doctor).isNotEqualTo(new Doctor(null));
		assertThat(new Doctor(null)).isEqualTo(new Doctor(null));
		assertThat(doctor).isNotEqualTo(null);
	}
}