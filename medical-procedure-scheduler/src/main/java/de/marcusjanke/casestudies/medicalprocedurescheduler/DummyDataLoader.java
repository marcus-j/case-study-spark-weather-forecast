package de.marcusjanke.casestudies.medicalprocedurescheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Doctor;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Patient;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Room;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Sex;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Status;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Study;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.DoctorRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.PatientRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.RoomRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.StudyRepository;

/**
 * DummyDataLoader prepares dummy data during testing
 * 
 * @author marcus
 *
 */
@Component
public class DummyDataLoader implements ApplicationRunner {

	private final Logger logger = LoggerFactory.getLogger(DummyDataLoader.class);

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private StudyRepository studyRepository;

	/**
	 * run dummy data set up
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		prepareDummyDoctors();
		prepareDummyPatients();
		prepareDummyRooms();
		prepareDummyStudies();
	}

	/**
	 * prepare dummy rooms
	 */
	private void prepareDummyRooms() {
		roomRepository.save(new Room("Room A"));
		roomRepository.save(new Room("Room B"));
		roomRepository.save(new Room("Room C"));
		roomRepository.save(new Room("Room D"));
		roomRepository.findAll().forEach(room -> logger.info(String.format("Prepared room: %s", room)));
	}

	/**
	 * prepare dummy patients
	 */
	private void prepareDummyPatients() {
		patientRepository.save(new Patient("Doe", Sex.MALE, LocalDate.of(1980, Month.APRIL, 23)));
		patientRepository.save(new Patient("Dean", Sex.MALE, LocalDate.of(1970, Month.MARCH, 12)));
		patientRepository.save(new Patient("Downing", Sex.MALE, LocalDate.of(1960, Month.SEPTEMBER, 17)));
		patientRepository.findAll().forEach(patient -> logger.info(String.format("Prepared patient: %s", patient)));
	}

	/**
	 * prepare dummy doctors
	 */
	private void prepareDummyDoctors() {
		doctorRepository.save(new Doctor("Gonzales"));
		doctorRepository.save(new Doctor("Zimmermann"));
		doctorRepository.save(new Doctor("Crusher"));
		doctorRepository.findAll().forEach(doc -> logger.info(String.format("Prepared doctor: %s", doc)));
	}

	/**
	 * prepare dummy studies
	 */
	private void prepareDummyStudies() {
		studyRepository.save(new Study(patientRepository.findByName("Doe").get(0), "Insulin treatment", Status.PLANNED,
				LocalDateTime.now(), null));
		doctorRepository.findAll().forEach(doc -> logger.info(String.format("Prepared doctor: %s", doc)));
	}
}
