package com.java.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.java.calculator.exception.CalculatorException;
import com.java.calculator.service.CalculatorService;

@SpringBootTest
class CalculatorApplicationTests {



//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	
	@Autowired
	MockMvc mockMvc;
	
//	@DynamicPropertySource
//	static void setProperty(DynamicPropertyRegistry registory) {
//		registory.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}
	
	@Test
	void addition() {
//		mockMvc.perform(MockMvcRequestBuilders.post("/calculatorapi/v1/addition")
//				.contentType(MediaType.APPLICATION_JSON)
		
	}
	
	@Autowired
	private CalculatorService service ;
	
	
	@Test
	void add() {
		
		Integer value1=10;
		Integer value2=20;
		Integer ans = null;
		
		ans = service.add(value1,value2);
//		assertEquals(25,ans);
	}
	
	@Test
	void sub() {
		Integer value1=10;
		Integer value2=20;
		Integer ans = null;
		
		ans = service.substract(value1,value2);
//		assertEquals(10-15,ans);
		
	}
	
	@Test
	void devide() throws CalculatorException {
		Integer value1=10;
		Integer value2=20;
		Integer ans = null;
		
		ans = service.devide(value1,value2);
//		assertEquals((10/15),ans);
	}
	
	@Test
	void multi() {
		Integer value1=10;
		Integer value2=20;
		Long ans = null;
		
		ans = service.multi(value1,value2).longValue();
//		assertEquals(0, ans);
	}
	


}
