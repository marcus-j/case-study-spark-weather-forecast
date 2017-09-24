package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Procedure tests
 * 
 * @author marcus
 *
 */
public class ProcedureTest {

	private static final String DESCRIPTION = "abc";
	private static final Status STATUS = Status.PLANNED;
	private static final LocalDateTime START_TIME = LocalDateTime.now();
	private static final LocalDateTime END_TIME = LocalDateTime.now().plusHours(5);
	private static final long ID = 300L;

	/**
	 * test construction
	 */
	@Test
	public void Procedure() {
		Procedure procedure = new Procedure();
		assertThat(procedure.getId()).isEqualTo(0L);
		assertThat(procedure.getDescription()).isNull();
		assertThat(procedure.getEndTime()).isNull();
		assertThat(procedure.getStartTime()).isNull();
		assertThat(procedure.getStatus()).isNull();
		assertThat(procedure.getDoctor()).isNull();
		assertThat(procedure.getRoom()).isNull();
		assertThat(procedure.getStudy()).isNull();
	}

	/**
	 * test construction
	 */
	@Test
	public void ProcedureStringStudyDoctorRoomStatusLocalDateTimeLocalDateTime() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, STATUS,
				START_TIME, END_TIME);
		assertThat(procedure.getId()).isEqualTo(0L);
		assertThat(procedure.getDescription()).isEqualTo(DESCRIPTION);
		assertThat(procedure.getEndTime()).isEqualTo(END_TIME);
		assertThat(procedure.getStartTime()).isEqualTo(START_TIME);
		assertThat(procedure.getStatus()).isEqualTo(STATUS);
		assertThat(procedure.getDoctor()).isEqualTo(Doctor.EXAMPLE);
		assertThat(procedure.getRoom()).isEqualTo(Room.EXAMPLE);
		assertThat(procedure.getStudy()).isEqualTo(Study.EXAMPLE);
	}

	/**
	 * test set/get study
	 */
	@Test
	public void testSetGetStudy() {
		Procedure procedure = new Procedure();
		procedure.setStudy(Study.EXAMPLE);
		assertThat(procedure.getStudy()).isEqualTo(Study.EXAMPLE);
	}

	/**
	 * test set/get doctor
	 */
	@Test
	public void testSetGetDoctor() {
		Procedure procedure = new Procedure();
		procedure.setDoctor(Doctor.EXAMPLE);
		assertThat(procedure.getDoctor()).isEqualTo(Doctor.EXAMPLE);
	}

	/**
	 * test set/get room
	 */
	@Test
	public void getRoom() {
		Procedure procedure = new Procedure();
		procedure.setRoom(Room.EXAMPLE);
		assertThat(procedure.getRoom()).isEqualTo(Room.EXAMPLE);
	}

	/**
	 * test set/get id
	 */
	@Test
	public void testSetGetId() {
		Procedure procedure = new Procedure();
		procedure.setId(Long.valueOf(ID));
		assertThat(procedure.getId()).isEqualTo(ID);
	}

	/**
	 * test set/get description
	 */
	@Test
	public void testSetGetDescription() {
		Procedure procedure = new Procedure();
		procedure.setDescription(DESCRIPTION);
		assertThat(procedure.getDescription()).isEqualTo(DESCRIPTION);
	}

	/**
	 * test set/get status
	 */
	@Test
	public void testSetGetStatus() {
		Procedure procedure = new Procedure();
		procedure.setStatus(STATUS);
		assertThat(procedure.getStatus()).isEqualTo(STATUS);
	}

	/**
	 * test set/get start time
	 */
	@Test
	public void testSetGetStartTime() {
		Procedure procedure = new Procedure();
		procedure.setStartTime(START_TIME);
		assertThat(procedure.getStartTime()).isEqualTo(START_TIME);
	}

	/**
	 * test set/get end time
	 */
	@Test
	public void testSetGetEndTime() {
		Procedure procedure = new Procedure();
		procedure.setEndTime(END_TIME);
		assertThat(procedure.getEndTime()).isEqualTo(END_TIME);
	}

	/**
	 * test hash code
	 */
	@Test
	public void testHashCode() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED,
				START_TIME, END_TIME);
		assertThat(procedure.hashCode()).isEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, new Study(), Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION + "x", Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, new Doctor("a doctor"),
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				new Room("a room"), Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.IN_PROGRESS, START_TIME, END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME.plusHours(2), END_TIME).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME.plusHours(2)).hashCode());
		assertThat(procedure.hashCode()).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE,
				Room.EXAMPLE, Status.FINISHED, START_TIME, null).hashCode());
	}

	/**
	 * test equals
	 */
	@Test
	public void testEquals() {
		Procedure procedure = new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED,
				START_TIME, END_TIME);
		assertThat(procedure).isEqualTo(procedure);
		assertThat(procedure).isNotEqualTo(Doctor.EXAMPLE);
		assertThat(procedure).isEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME));
		assertThat(new Procedure(DESCRIPTION, null, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME)).isEqualTo(new Procedure(DESCRIPTION, null, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION + "x", new Study(), Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, new Doctor("a doctor"),
				Room.EXAMPLE, Status.FINISHED, START_TIME, END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, new Room("a room"),
				Status.FINISHED, START_TIME, END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME.plusHours(2), END_TIME));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(procedure).isNotEqualTo(null);

		assertThat(new Procedure(null, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, null, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, Study.EXAMPLE, null, Room.EXAMPLE, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, null, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, null, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, null,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
								Status.FINISHED, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, START_TIME,
				null)).isNotEqualTo(
						new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED,
								START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(null, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(null, Study.EXAMPLE, null, Room.EXAMPLE, Status.FINISHED,
								START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(null, Study.EXAMPLE, null, Room.EXAMPLE, Status.FINISHED, START_TIME,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(null, Study.EXAMPLE, null, null, Status.FINISHED, START_TIME,
								END_TIME.plusHours(2)));
		assertThat(new Procedure(null, Study.EXAMPLE, null, null, Status.FINISHED, START_TIME, END_TIME.plusHours(2)))
				.isNotEqualTo(new Procedure(null, Study.EXAMPLE, null, null, null, START_TIME, END_TIME.plusHours(2)));
		assertThat(new Procedure(null, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, null,
				END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(null, Study.EXAMPLE, Doctor.EXAMPLE, null, Status.FINISHED, null,
								END_TIME.plusHours(2)));
		assertThat(
				new Procedure(null, null, Doctor.EXAMPLE, Room.EXAMPLE, Status.FINISHED, null, END_TIME.plusHours(2)))
						.isNotEqualTo(new Procedure(null, null, Doctor.EXAMPLE, Room.EXAMPLE, null, null,
								END_TIME.plusHours(2)));
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, new Study(), Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME));
		procedure.setId(5L);
		assertThat(procedure).isNotEqualTo(new Procedure(DESCRIPTION, Study.EXAMPLE, Doctor.EXAMPLE, Room.EXAMPLE,
				Status.FINISHED, START_TIME, END_TIME));
	}
}