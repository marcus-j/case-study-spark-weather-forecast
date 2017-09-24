package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Room;

/**
 * RoomRepository tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RoomRepositoryTest {

	private static final String NAME = "Room A";
	
	@Autowired
	RoomRepository roomRepository;

	/**
	 * test repository is in context
	 */
	@Test
	public void contextLoads() {
		assertThat(roomRepository).isNotNull();
	}

	/**
	 * test save and retrieve
	 */
	@Test
	public void testSaveAndFind() {
		Room room = new Room(NAME);
		roomRepository.save(room);
		assertThat(roomRepository.findOne(room.getId())).isNotNull().isEqualTo(room);
	}

	/**
	 * test name not empty
	 */
	@Test(expected = ConstraintViolationException.class)
	public void testNameNotEmpty() {
		Room room = new Room();
		roomRepository.save(room);
	}
}
