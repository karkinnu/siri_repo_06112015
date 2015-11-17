package fi.javaee.siri.yritys;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import fi.javaee.siri.config.SiriTestConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SiriTestConfiguration.class}, loader = SpringApplicationContextLoader.class)
public class TestYritysController {

	@Autowired WebApplicationContext wac; 
	@Autowired MockHttpSession session;
	@Autowired MockHttpServletRequest request;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();    
	}

	@Test
	public void TestDeleteView() throws Exception {
		mockMvc.perform(get("/companies/list/delete").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("company_list"));
	}

	@Test
	public void TestEditView() throws Exception {
		mockMvc.perform(get("/companies/list/edit").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("company_edit"));
	}
	
	@Test
	public void TestAddView() throws Exception {
		mockMvc.perform(get("/companies/list/add").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("company_add"));
	}

	@Test
	public void TestListAllView() throws Exception {
		mockMvc.perform(get("/companies/list/").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("company_list"));
	}

}
