package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

/**
 * Patient tests
 * 
 * @author marcus
 *
 */
public class PatientTest {

	private static final String NAME = "DOE";
	private static final LocalDate DATE_OF_BIRTH = LocalDate.now();
	private static final long ID = 300L;
	private static final Sex SEX = Sex.FEMALE;

	/**
	 * test construction
	 */
	@Test
	public void testPatient() {
		Patient patient = new Patient();
		assertThat(patient.getId()).isEqualTo(0L);
		assertThat(patient.getName()).isNull();
		assertThat(patient.getDateOfBirth()).isNull();
		assertThat(patient.getSex()).isNull();
	}

	/**
	 * test construction
	 */
	@Test
	public void testPatientNameSexDateOfBirth() {
		Patient patient = new Patient(NAME, SEX, DATE_OF_BIRTH);
		assertThat(patient.getId()).isEqualTo(0L);
		assertThat(patient.getName()).isEqualTo(NAME);
		assertThat(patient.getDateOfBirth()).isEqualTo(DATE_OF_BIRTH);
		assertThat(patient.getSex()).isEqualTo(SEX);
	}

	/**
	 * test set/get id
	 */
	@Test
	public void testSetGetId() {
		Patient patient = new Patient();
		patient.setId(Long.valueOf(ID));
		assertThat(patient.getId()).isEqualTo(ID);
	}

	/**
	 * test set/get name
	 */
	@Test
	public void testSetGetName() {
		Patient patient = new Patient();
		patient.setName(NAME);
		assertThat(patient.getName()).isEqualTo(NAME);
	}

	/**
	 * test set/get sex
	 */
	@Test
	public void testSetGetSex() {
		Patient patient = new Patient();
		patient.setSex(SEX);
		assertThat(patient.getSex()).isEqualTo(SEX);
	}

	/**
	 * test set/get date of birth
	 */
	@Test
	public void testSetGetDateOfBirth() {
		Patient patient = new Patient();
		patient.setDateOfBirth(DATE_OF_BIRTH);
		assertThat(patient.getDateOfBirth()).isEqualTo(DATE_OF_BIRTH);
	}

	/**
	 * test toString
	 */
	@Test
	public void testToString() {
		Patient patient = new Patient(NAME, SEX, DATE_OF_BIRTH);
		assertThat(patient.toString()).isEqualTo("Patient [id=" + String.valueOf(0L) + ", name=" + NAME + ", sex=" + SEX
				+ ", dateOfBirth=" + DATE_OF_BIRTH + "]");
	}

	/**
	 * test hash code
	 */
	@Test
	public void testHashCode() {
		Patient patient = new Patient(NAME, Sex.MALE, DATE_OF_BIRTH);
		assertThat(patient.hashCode()).isEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient("another name", Sex.MALE, DATE_OF_BIRTH).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient(NAME, Sex.FEMALE, DATE_OF_BIRTH).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH.plusDays(2)).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient(null, Sex.MALE, DATE_OF_BIRTH).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient(NAME, null, DATE_OF_BIRTH).hashCode());
		assertThat(patient.hashCode()).isNotEqualTo(new Patient(NAME, Sex.MALE, null).hashCode());
		assertThat(new Patient(null, Sex.MALE, DATE_OF_BIRTH).hashCode()).isNotEqualTo(new Patient("another name", Sex.MALE, DATE_OF_BIRTH).hashCode());
		assertThat(new Patient(NAME, null, DATE_OF_BIRTH).hashCode()).isNotEqualTo(new Patient(NAME, Sex.FEMALE, DATE_OF_BIRTH).hashCode());
		assertThat(new Patient(NAME, Sex.MALE, null).hashCode()).isNotEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH.plusDays(2)).hashCode());
	}
	
	/**
	 * test equals
	 */
	@Test
	public void testEquals() {
		Patient patient = new Patient(NAME, Sex.MALE, DATE_OF_BIRTH);
		assertThat(patient).isEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH));
		assertThat(new Patient(null, Sex.MALE, DATE_OF_BIRTH)).isEqualTo(new Patient(null, Sex.MALE, DATE_OF_BIRTH));
		assertThat(patient).isNotEqualTo(null);
		assertThat(patient).isNotEqualTo(new Patient("another name", Sex.MALE, DATE_OF_BIRTH));
		assertThat(patient).isNotEqualTo(new Patient(NAME, Sex.FEMALE, DATE_OF_BIRTH));
		assertThat(patient).isNotEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH.plusDays(2)));		
		assertThat(patient).isNotEqualTo(new Patient(null, Sex.MALE, DATE_OF_BIRTH));
		assertThat(patient).isNotEqualTo(new Patient(NAME, null, DATE_OF_BIRTH));
		assertThat(patient).isNotEqualTo(new Patient(NAME, Sex.MALE,null));
		assertThat(new Patient(null, Sex.MALE, DATE_OF_BIRTH)).isNotEqualTo(new Patient("another name", Sex.MALE, DATE_OF_BIRTH));
		assertThat(new Patient(NAME, null, DATE_OF_BIRTH)).isNotEqualTo(new Patient(NAME, Sex.FEMALE, DATE_OF_BIRTH));
		assertThat(new Patient(NAME, Sex.MALE,null)).isNotEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH.plusDays(2)));
		patient.setId(6);
		assertThat(patient).isNotEqualTo(new Patient(NAME, Sex.MALE, DATE_OF_BIRTH));
	}
}