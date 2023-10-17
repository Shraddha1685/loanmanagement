package com.loan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.controllers.CustomerController;
import com.loan.services.iCustomerService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;


@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	private static final String END_POINT_PATH = "/customer";
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectmapper;
	@MockBean private iCustomerService customerService;
	
	
	@Test
	public void testPostCustomer() throws JsonProcessingException {
		//Customer c = new Customer()
		
		
		Map<String,Object> body = new HashMap<>();
	    body.put("fname","new");
	    body.put("lname","Employee");
	    body.put("email","new@Employee.com");
	    body.put("phone",1234567);
	    body.put("gender","female");
	    body.put("password","secret");
	    body.put("confirmPassword","secret");
	    body.put("salary",60000.0);
	    body.put("adhaar",76545);
	    body.put("pan","abc4263");
	    body.put("walletAmt",3500.0);
	    
	    
		//String requestBody = objectmapper.writeValueAsString(c);
		
			try {
				mockMvc.perform(MockMvcRequestBuilders
						.post(END_POINT_PATH)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectmapper.writeValueAsString(body))
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
						
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void testGetCustomer() throws JsonProcessingException {
		String user_id = "10";
		String requestURI = END_POINT_PATH + "/" + user_id;
		
			try {
				mockMvc.perform(MockMvcRequestBuilders
						.get(requestURI)
						.contentType(MediaType.APPLICATION_JSON))						
						.andExpect(status().isNotFound())
						;
					
						
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
