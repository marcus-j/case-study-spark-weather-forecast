package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Doctor;

/**
 * DoctorRepository tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DoctorRepositoryTest {

	@Autowired
	DoctorRepository doctorRepository;

	/**
	 * test repository is in context
	 */
	@Test
	public void contextLoads() {
		assertThat(doctorRepository).isNotNull();
	}

	/**
	 * test findByName
	 */
	@Test
	public void testFindByName() {
		Doctor doc = new Doctor("testFindByName");
		doctorRepository.save(doc);
		assertThat(doctorRepository.findByName(doc.getName()).get(0)).isNotNull().isEqualTo(doc);
	}

	/**
	 * test save and retrieve
	 */
	@Test
	public void testSaveAndFind() {
		Doctor doc = new Doctor("testSaveAndFind");
		doctorRepository.save(doc);
		assertThat(doctorRepository.findOne(doc.getId())).isNotNull().isEqualTo(doc);
	}

	/**
	 * test name not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testNameNotEmpty() {
		Doctor doc = new Doctor();
		doctorRepository.save(doc);
	}
}
