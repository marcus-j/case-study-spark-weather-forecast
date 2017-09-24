package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ProcedureController tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PatientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PatientController patientController;

	/**
	 * test controller is in context
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(patientController).isNotNull();
	}

	/**
	 * test valid table view is returned
	 */
	@Test
	public void getPatientsReturned() throws Exception {
		assertThat(this.mockMvc.perform(get("/patients")).andExpect(status().isOk()).andReturn()
		.getResponse().getContentAsString()).contains("<h1>Patients</h1>").doesNotContain("HTTP 400").doesNotContain("HTTP 500");
	}

	/**
	 * test add patient
	 */
	@Test
	public void testAddPatient() throws Exception {
		assertThat(this.mockMvc.perform(post("/patients").param("name", "a name")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString()).contains("<h1>Patients</h1>").doesNotContain("HTTP 400").doesNotContain("HTTP 500");
	}
}