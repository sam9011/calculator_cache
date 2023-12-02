package com.java.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.java.calculator.dao.Calculator;
import com.java.calculator.exception.CalculatorException;
import com.java.calculator.repository.CalculatorRepository;


@Service("calculatorService")
public class CalculatorService {

	@Autowired
	private CalculatorRepository repository;
	
	
	@Cacheable(value = "Calculator",key = "#value1 + ' ' + #value2")
	public Integer add(Integer value1,Integer value2) {
		
		
		Calculator calculator = Calculator.builder()
				.value1(value1)
				.value2(value2)
				.build();
		
		calculator = repository.save(calculator);
		return value1 + value2;
	}

	@Cacheable(value = "Calculator",key = "#value1 + ' ' + #value2")
	public Integer substract(Integer value1,Integer value2) {
		
		Calculator calculator = Calculator.builder()
				.value1(value1)
				.value2(value2)
				.build();
		
		repository.save(calculator);
		
		return value1 - value2;
	}
	
	@Cacheable(value = "Calculator",key = "#value1 + ' ' + #value2")
	public Integer devide(Integer value1,Integer value2) throws CalculatorException{
		
		Calculator calculator = Calculator.builder()
				.value1(value1)
				.value2(value2)
				.build();
		
		repository.save(calculator);
		
		if(0==value2) {
			throw new CalculatorException("100"
					+ ""
					+ "1","0 can not be devid");
		}
		
		return value1 / value2;
	}

	@Cacheable(value = "Calculator",key = "#value1 + ' ' + #value2")
	public Integer multi(Integer value1,Integer value2) {
		
		Calculator calculator = Calculator.builder()
				.value1(value1)
				.value2(value2)
				.build();
		
		repository.save(calculator);
		return value1 * value2;
	}
}
