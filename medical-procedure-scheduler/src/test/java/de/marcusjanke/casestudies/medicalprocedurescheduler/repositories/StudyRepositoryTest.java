package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Patient;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Sex;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Status;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Study;

/**
 * StudyRepository tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudyRepositoryTest {

	private static final Patient PATIENT = new Patient("Doe", Sex.FEMALE, LocalDate.now());
	private static final String DESCRIPTION = "abc";
	private static final Status STATUS = Status.PLANNED;
	private static final LocalDateTime START_TIME = LocalDateTime.now();
	private static final LocalDateTime END_TIME = LocalDateTime.now().plusHours(5);

	@Autowired
	StudyRepository studyRepository;
	@Autowired
	PatientRepository patientRepository;

	/**
	 * prepare test objects
	 */
	@Before
	public void setUp() {
		patientRepository.save(PATIENT);
	}

	/**
	 * test repository is in context
	 */
	@Test
	public void contextLoads() {
		assertThat(studyRepository).isNotNull();
	}

	/**
	 * test save and retrieve
	 */
	@Test
	public void testSaveAndFind() {
		Study study = new Study(PATIENT, DESCRIPTION, STATUS, START_TIME, END_TIME);
		studyRepository.save(study);
		assertThat(studyRepository.findOne(study.getId())).isNotNull().isEqualTo(study);
	}

	/**
	 * test patient not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testPatientNotEmpty() {
		Study study = new Study(null, DESCRIPTION, STATUS, START_TIME, END_TIME);
		studyRepository.save(study);
	}

	/**
	 * test description not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testDescriptionNotEmpty() {
		Study study = new Study(PATIENT, null, STATUS, START_TIME, END_TIME);
		studyRepository.save(study);
	}

	/**
	 * test status not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testStatusNotEmpty() {
		Study study = new Study(PATIENT, DESCRIPTION, null, START_TIME, END_TIME);
		studyRepository.save(study);
	}

	/**
	 * test start time not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testStartTimeNotEmpty() {
		Study study = new Study(PATIENT, DESCRIPTION, STATUS, null, END_TIME);
		studyRepository.save(study);
	}

	/**
	 * test end time may be empty
	 */
	@Test()
	public void testEndTimeMayBeEmpty() {
		Study study = new Study(PATIENT, DESCRIPTION, STATUS, START_TIME, null);
		studyRepository.save(study);
		assertThat(studyRepository.findOne(study.getId())).isNotNull().isEqualTo(study);
	}
}
