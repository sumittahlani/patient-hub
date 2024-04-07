package com.example.demo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Patient;

public class PatientHubControllerTest extends PatientHubTest{
	@Override
	@Before
	public void setUp() {
	   super.setUp();
	}
	
	@Test
	public void getPatientByIdTest() throws Exception {
	   String uri = "/patientshub/getPatient/1";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Patient patient = super.mapFromJson(content, Patient.class);
	}
}
