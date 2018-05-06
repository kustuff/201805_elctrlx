package com.electrolux.ctest.restapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplianceApplicationTests {

	@Autowired
	private WebApplicationContext webAppContext;
	private String appUrl = "http://localhost:8080/RestApiApplianceApp/";
	private MockMvc mockMvc;
	private MediaType jsonContentType =
			new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());


	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}

	@Test
	/*
	 * Get state after command ON.
	 */
	public void testGetAfterOn() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(appUrl + "execute").content("{\"command\":\"ON\"}")
				.contentType(MediaType.APPLICATION_JSON).accept(jsonContentType));
		mockMvc.perform(MockMvcRequestBuilders.get(appUrl + "state")).andExpect(status().isOk())
				.andExpect(content().json("{\"state\":\"ON\"}"));
	}

	@Test
	/*
	 * Get state after command OFF.
	 */
	public void testGetAfterOff() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(appUrl + "execute").content("{\"command\":\"OFF\"}")
				.contentType(MediaType.APPLICATION_JSON).accept(jsonContentType));
		mockMvc.perform(MockMvcRequestBuilders.get(appUrl + "state")).andExpect(status().isOk())
				.andExpect(content().json("{\"state\":\"OFF\"}"));
	}

	@Test
	/*
	 * Get state after command WASH.
	 */
	public void testGetAfterWash() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(appUrl + "execute").content("{\"command\":\"WASH\"}")
				.contentType(MediaType.APPLICATION_JSON).accept(jsonContentType));
		mockMvc.perform(MockMvcRequestBuilders.get(appUrl + "state")).andExpect(status().isOk())
				.andExpect(content().json("{\"state\":\"WASHING\"}"));
	}


	//    etc.etc.etc.    etc.etc.etc.    etc.etc.etc.
	//    etc.                etc.        etc.
	//    etc.etc.etc.        etc.        etc.
	//    etc.                etc.        etc.
	//    etc.etc.etc.        etc.        etc.etc.etc.

}
