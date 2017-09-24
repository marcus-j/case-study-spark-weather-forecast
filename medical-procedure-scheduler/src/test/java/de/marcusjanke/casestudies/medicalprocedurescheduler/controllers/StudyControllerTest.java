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
 * StudyController tests
 * 
 * @author marcus
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudyControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private StudyController studyController;

	/**
	 * test controller is in context
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(studyController).isNotNull();
	}

	/**
	 * test valid table view is returned
	 */
	@Test
	public void getStudiesReturnsStudies() throws Exception {
		assertThat(this.mockMvc.perform(get("/studies")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString()).contains("<h1>Studies</h1>").doesNotContain("HTTP 400")
						.doesNotContain("HTTP 500");
	}

	/**
	 * test add study
	 */
	@Test
	public void testAddStudy() throws Exception {
		assertThat(this.mockMvc
				.perform(post("/studies").param("description", "a description").param("patient", "1")
						.param("status", "PLANNED").param("startTime", "2017-05-05T12:15")
						.param("startTime", "2017-05-05T16:15"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString()).contains("<h1>Studies</h1>")
						.doesNotContain("HTTP 400").doesNotContain("HTTP 500");
	}
}