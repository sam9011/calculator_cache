package com.java.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.java.calculator.dao.Calculator;

@SpringBootTest
public class CalculatorApplicationTests {


	private int port = 8080;
	
	
	private String baseUrl="http://localhost";

	
	private static RestTemplate restTemplate;
	
	@Autowired
	private H2DatabaseTest h2dbRepository;
	
	@Before
	public void init() {
		restTemplate = new RestTemplate();
		
		
	}
	
	
	@Test
	public void testAddition() {
		
		 HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
		 // Create a HttpEntity object with the request body and the headers
        HttpEntity<String> requestEntity = new HttpEntity<>("Content-Type", headers);

        // Send the POST request

		baseUrl = baseUrl.concat(":").concat(port+"").concat("/addition");
		String url =baseUrl.concat("?val1=16&val2=20");
		  // Send the POST request
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        System.out.println(response);
		Calculator cal = h2dbRepository.findById(1).get();
		int ans =cal.getValue1()+cal.getValue2();
		
		assertEquals(36, ans);
	}
	
	

}
