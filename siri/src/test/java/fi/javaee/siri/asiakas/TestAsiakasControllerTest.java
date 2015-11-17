package fi.javaee.siri.asiakas;

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
public class TestAsiakasControllerTest {

	@Autowired WebApplicationContext wac; 
	@Autowired MockHttpSession session;
	@Autowired MockHttpServletRequest request;

	@Mock
	private Asiakas personService;

	@Mock
	private AsiakasController asiakasController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();    
	}

	@Test
	public void TestDeleteView() throws Exception {
		mockMvc.perform(get("/customers/list/delete").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("customer_list"));
	}

	@Test
	public void TestEditView() throws Exception {
		mockMvc.perform(get("/customers/list/edit").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("customer_edit"));
	}
	
	@Test
	public void TestEddView() throws Exception {
		mockMvc.perform(get("/customers/list/add").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("customer_add"));
	}

	@Test
	public void TestListAllView() throws Exception {
		mockMvc.perform(get("/customers/list/").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("customer_list"));
	}

}
