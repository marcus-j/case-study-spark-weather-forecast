package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Room tests
 * 
 * @author marcus
 *
 */
public class RoomTest { 

	private static final String NAME = "Room A";
	private static final long ID = 300L;

	/**
	 * test construction
	 */
	@Test
	public void testRoom() {
		Room room = new Room();
		assertThat(room.getId()).isEqualTo(0L);
		assertThat(room.getName()).isNull();		
	}

	/**
	 * test construction
	 */
	@Test
	public void testRoomName() {
		Room room = new Room(NAME);
		assertThat(room.getId()).isEqualTo(0L);
		assertThat(room.getName()).isEqualTo(NAME);	
	}

	/**
	 * test set/get id
	 */
	@Test
	public void testSetGetId() {
		Room room = new Room();
		room.setId(Long.valueOf(ID));
		assertThat(room.getId()).isEqualTo(ID);
	}

	/**
	 * test set/get name
	 */
	@Test
	public void testSetGetName() {
		Room room = new Room();
		room.setName(NAME);
		assertThat(room.getName()).isEqualTo(NAME);
	}

	/**
	 * test toString
	 */
	@Test
	public void testToString() {
		Room room = new Room(NAME);
		assertThat(room.toString()).isEqualTo("Room [id=" + 0L + ", name=" + NAME + "]");
	}
	
	/**
	 * test hash code
	 */
	@Test
	public void testHashCode() {
		Room room = new Room(NAME);
		assertThat(room.hashCode()).isEqualTo(new Room(NAME).hashCode());
		assertThat(new Room(null).hashCode()).isNotEqualTo(new Room("another room").hashCode());
		assertThat(room.hashCode()).isNotEqualTo(new Room("another room").hashCode());
		assertThat(room.hashCode()).isNotEqualTo(new Room(null).hashCode());
	}
	
	/**
	 * test equals
	 */
	@Test
	public void testEquals() {
		Room room = new Room(NAME);
		assertThat(room).isEqualTo(new Room(NAME));
		assertThat(new Room(null)).isEqualTo(new Room(null));
		assertThat(new Room(null)).isNotEqualTo(new Room("another room"));
		assertThat(room).isNotEqualTo(new Room("another room"));
		assertThat(room).isNotEqualTo(new Room(null));
		assertThat(room).isNotEqualTo(null);
	}
}