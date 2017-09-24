package de.marcusjanke.casestudies.medicalprocedurescheduler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.DoctorRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.PatientRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.RoomRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.StudyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DummyDataLoaderTest { 
		
	@Autowired
	DummyDataLoader dummydataloader;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private StudyRepository studyRepository;
	
	/**
	 * test DummyDataLoader is in context
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(dummydataloader).isNotNull();
	}
	
	/**
	 * test DummyDataLoader has loaded dummy data
	 */
	@Test
	public void testDummyDataAvailable() throws Exception {
		assertThat(doctorRepository.findAll()).isNotNull().isNotEmpty();
		assertThat(patientRepository.findAll()).isNotNull().isNotEmpty();
		assertThat(roomRepository.findAll()).isNotNull().isNotEmpty();
		assertThat(studyRepository.findAll()).isNotNull().isNotEmpty();
	}
}