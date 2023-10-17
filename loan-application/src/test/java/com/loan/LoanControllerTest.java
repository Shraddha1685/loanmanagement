package com.loan;

import org.json.JSONException;
import org.json.JSONObject;
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
import com.loan.controllers.LoanController;
import com.loan.services.iCustomerService;
import com.loan.services.iLoanService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;


@WebMvcTest(LoanController.class)
public class LoanControllerTest {
	private static final String END_POINT_PATH = "/loan";
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectmapper;
	@MockBean private iLoanService loanService;
	
	
	@Test
	public void testPostLoan() throws JsonProcessingException {
		//Customer c = new Customer()
		
		JSONObject customer = null;
		try {
			customer = new JSONObject()
			        .put("id", 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
		
		Map<String,Object> body = new HashMap<>();
	    body.put("loanAmt",20000);
	    body.put("loanType","personal");	    
	    body.put("duration",24);
	    body.put("monthlyEMI",3000);	    
	    body.put("walletAmt",3500.0);
	    body.put("customer",customer);
	    
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
	
	
	
	
}
