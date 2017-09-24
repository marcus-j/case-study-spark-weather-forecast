package de.marcusjanke.casestudies.medicalprocedurescheduler.domain;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

/**
 * Study tests
 * 
 * @author marcus
 *
 */
public class StudyTest {

	private static final Patient PATIENT = new Patient("Doe", Sex.FEMALE, LocalDate.now());
	private static final String DESCRIPTION = "abc";
	private static final Status STATUS = Status.PLANNED;
	private static final LocalDateTime START_TIME = LocalDateTime.now();
	private static final LocalDateTime END_TIME = LocalDateTime.now().plusHours(5);
	private static final long ID = 300L;

	/**
	 * test construction
	 */
	@Test
	public void Study() {
		Study study = new Study();
		assertThat(study.getId()).isEqualTo(0L);
		assertThat(study.getDescription()).isNull();
		assertThat(study.getEndTime()).isNull();
		assertThat(study.getStartTime()).isNull();
		assertThat(study.getStatus()).isNull();
		assertThat(study.getPatient()).isNull();
	}

	/**
	 * test construction
	 */
	@Test
	public void StudyJPatientStringStatusLocalDateTimeLocalDateTime() {
		Study study = new Study(PATIENT, DESCRIPTION, STATUS, START_TIME, END_TIME);
		assertThat(study.getId()).isEqualTo(0L);
		assertThat(study.getDescription()).isEqualTo(DESCRIPTION);
		assertThat(study.getEndTime()).isEqualTo(END_TIME);
		assertThat(study.getStartTime()).isEqualTo(START_TIME);
		assertThat(study.getStatus()).isEqualTo(STATUS);
		assertThat(study.getPatient()).isEqualTo(PATIENT);
	}

	/**
	 * test set/get id
	 */
	@Test
	public void testSetGetId() {
		Study study = new Study();
		study.setId(Long.valueOf(ID));
		assertThat(study.getId()).isEqualTo(ID);
	}

	/**
	 * test set/get patient
	 */
	@Test
	public void testSetGetPatient() {
		Study study = new Study();
		study.setPatient(PATIENT);
		assertThat(study.getPatient()).isEqualTo(PATIENT);
	}

	/**
	 * test set/get description
	 */
	@Test
	public void testSetGetDescription() {
		Study study = new Study();
		study.setDescription(DESCRIPTION);
		assertThat(study.getDescription()).isEqualTo(DESCRIPTION);
	}

	/**
	 * test set/get status
	 */
	@Test
	public void testSetGetStatus() {
		Study study = new Study();
		study.setStatus(STATUS);
		assertThat(study.getStatus()).isEqualTo(STATUS);
	}

	/**
	 * test set/get start time
	 */
	@Test
	public void testSetGetStartTime() {
		Study study = new Study();
		study.setStartTime(START_TIME);
		assertThat(study.getStartTime()).isEqualTo(START_TIME);
	}

	/**
	 * test set/get end time
	 */
	@Test
	public void testSetGetEndTime() {
		Study study = new Study();
		study.setEndTime(END_TIME);
		assertThat(study.getEndTime()).isEqualTo(END_TIME);
	}

	/**
	 * test toString
	 */
	@Test
	public void testToString() {
		Study study = new Study(PATIENT, DESCRIPTION, STATUS, START_TIME, END_TIME);
		assertThat(study.toString()).isEqualTo("Study [id=" + 0L + ", patient=" + PATIENT + ", description="
				+ DESCRIPTION + ", status=" + STATUS + ", startTime=" + START_TIME + ", endTime=" + END_TIME + "]");
	}

	/**
	 * test hash code
	 */
	@Test
	public void testHashCode() {
		Study study = new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME);
		assertThat(study.hashCode())
				.isEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME).hashCode());
		assertThat(study.hashCode()).isNotEqualTo(
				new Study(new Patient(), DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME).hashCode());
		assertThat(study.hashCode()).isNotEqualTo(
				new Study(PATIENT, "something else", Status.IN_PROGRESS, START_TIME, END_TIME).hashCode());
		assertThat(study.hashCode())
				.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.FINISHED, START_TIME, END_TIME).hashCode());
		assertThat(study.hashCode()).isNotEqualTo(
				new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME.plusHours(2), END_TIME).hashCode());
		assertThat(study.hashCode()).isNotEqualTo(
				new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME.plusHours(2)).hashCode());
	}

	/**
	 * test equals
	 */
	@Test
	public void testEquals() {
		Study study = new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME);
		assertThat(study).isEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(null, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME)).isEqualTo(new Study(null, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, null, Status.IN_PROGRESS, START_TIME, END_TIME))
		.isEqualTo(new Study(PATIENT, null, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, null, END_TIME))
		.isEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, null, END_TIME));
		assertThat(study).isNotEqualTo(new Study(new Patient(), DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(study).isNotEqualTo(new Study(PATIENT, "something else", Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(study).isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.FINISHED, START_TIME, END_TIME));
		assertThat(study)
				.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME.plusHours(2), END_TIME));
		assertThat(study)
				.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME.plusHours(2)));
		assertThat(study).isNotEqualTo(null);
		assertThat(new Study(null, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME))
		.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, null, Status.IN_PROGRESS, START_TIME, END_TIME))
		.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, null))
		.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, null, END_TIME))
		.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		assertThat(new Study(PATIENT, DESCRIPTION, null, START_TIME, END_TIME))
		.isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
		study.setId(5L);
		assertThat(study).isNotEqualTo(new Study(PATIENT, DESCRIPTION, Status.IN_PROGRESS, START_TIME, END_TIME));
	}
}