package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Doctor;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Procedure;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Room;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Status;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Study;

/**
 * ProcedureRepository tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProcedureRepositoryTest {

	private static final String DESCRIPTION = "abc";
	private static final Status STATUS = Status.PLANNED;
	private static final LocalDateTime START_TIME = LocalDateTime.now();
	private static final LocalDateTime END_TIME = LocalDateTime.now().plusHours(5);
	
	@Autowired
	ProcedureRepository procedureRepository;
	@Autowired
	StudyRepository studyRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	RoomRepository roomRepository;
	@Autowired
	PatientRepository patientRepository;
	
	/**
	 * prepare test objects
	 */
	@Before
	public void setUp() {
		patientRepository.save(Study.EXAMPLE.getPatient());
		studyRepository.save(Study.EXAMPLE);
		doctorRepository.save(Doctor.EXAMPLE);
		roomRepository.save(Room.EXAMPLE);
	}
	
	/**
	 * test repository is in context
	 */
	@Test
	public void contextLoads() {
		assertThat(procedureRepository).isNotNull();
	}

	/**
	 * test save and retrieve
	 */
	@Test
	public void testSaveAndFind() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
		assertThat(procedureRepository.findOne(procedure.getId())).isNotNull().isEqualTo(procedure);
	}

	/**
	 * test description not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testDescriptionNotEmpty() {
		Procedure procedure = new Procedure(null, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test study not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testStudyNotEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, null, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test description not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testDoctorNotEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, null, Room.EXAMPLE, STATUS,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test description not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testRoomNotEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, null, STATUS,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test status not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testStatusNotEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, null,
				START_TIME, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test start time not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testStartTimeNotEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				null, END_TIME);
		procedureRepository.save(procedure);
	}

	/**
	 * test end time may be empty
	 */
	@Test()
	public void testEndTimeMayBeEmpty() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				START_TIME, null);
		procedureRepository.save(procedure);
		assertThat(procedureRepository.findOne(procedure.getId())).isNotNull().isEqualTo(procedure);
	}
}
