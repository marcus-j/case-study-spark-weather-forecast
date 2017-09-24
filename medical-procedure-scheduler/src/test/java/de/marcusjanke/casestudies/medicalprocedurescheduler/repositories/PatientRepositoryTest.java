package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Patient;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Sex;

/**
 * PatientRepository tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PatientRepositoryTest {

	@Autowired
	PatientRepository patientRepository;

	/**
	 * test repository is in context
	 */
	@Test
	public void contextLoads() {
		assertThat(patientRepository).isNotNull();
	}

	/**
	 * test save and retrieve
	 */
	@Test
	public void testSaveAndFind() {
		Patient patient = new Patient("testSaveAndFind", Sex.FEMALE, LocalDate.now());
		patientRepository.save(patient);
		assertThat(patientRepository.findOne(patient.getId())).isNotNull().isEqualTo(patient);
	}

	/**
	 * test name not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testNameNotEmpty() {
		Patient patient = new Patient(null, Sex.FEMALE, LocalDate.now());
		patientRepository.save(patient);
	}

	/**
	 * test sex can be empty
	 */
	@Test()
	public void testSexMayBeEmpty() {
		Patient patient = new Patient("name", null, LocalDate.now());
		patientRepository.save(patient);
		assertThat(patientRepository.findOne(patient.getId())).isNotNull().isEqualTo(patient);
	}

	/**
	 * test day of birth can be empty
	 */
	@Test()
	public void testDayOfBirthMayBeEmpty() {
		Patient patient = new Patient("name", Sex.FEMALE, null);
		patientRepository.save(patient);
		assertThat(patientRepository.findOne(patient.getId())).isNotNull().isEqualTo(patient);
	}
}
