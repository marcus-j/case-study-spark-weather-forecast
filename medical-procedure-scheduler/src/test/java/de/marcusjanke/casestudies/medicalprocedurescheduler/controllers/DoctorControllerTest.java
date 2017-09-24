package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * DoctorController tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DoctorControllerTest {

	@Autowired
	private DoctorController doctorController;
	@Autowired
	private MockMvc mockMvc;

	/**
	 * test controller is in context
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(doctorController).isNotNull();
	}

	/**
	 * test valid table view is returned
	 */
	@Test
	public void getDoctorsReturnsDoctors() throws Exception {
		assertThat(this.mockMvc.perform(get("/doctors")).andExpect(status().isOk()).andReturn()
		.getResponse().getContentAsString()).contains("<h1>Doctors</h1>").doesNotContain("HTTP 400").doesNotContain("HTTP 500");
	}

	/**
	 * test add doctor
	 */
	@Test
	public void testAddDoctor() throws Exception {
		assertThat(this.mockMvc.perform(post("/doctors").param("name", "a name")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString()).contains("<h1>Doctors</h1>").doesNotContain("HTTP 400").doesNotContain("HTTP 500");
	}
}