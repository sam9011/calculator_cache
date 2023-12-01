package com.java.calculator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.calculator.exception.CalculatorException;
import com.java.calculator.service.CalculatorService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/calculatorapi/v1")
@Slf4j
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	

	@PostMapping("/addition")
	private Integer add(@RequestParam("val1")Integer value1, @RequestParam("val2") Integer value2 ) {
		log.info("started addition value 1 = {} and value 2 = {}",value1,value2);
		return calculatorService.add(value1,value2);
	}
	
	@PostMapping("/substract")
	private Integer substract(@RequestParam("val1")Integer value1, @RequestParam("val2") Integer value2 ) {
		log.info("started substract value 1 = {} and value 2 = {}",value1,value2);
		return calculatorService.substract(value1,value2);
	}
	
	@PostMapping("/devide")
	private Integer devide(@RequestParam("val1")Integer value1, @RequestParam("val2") Integer value2 ) {
		log.info("started devide value 1 = {} and value 2 = {}",value1,value2);
		try {
			return calculatorService.devide(value1,value2);
		} catch (CalculatorException e) {
			// return zero in case of can not devide by 0
			return 0;
		}
	}
	
	@PostMapping("/multi")
	private Integer multi(@RequestParam("val1")Integer value1, @RequestParam("val2") Integer value2 ) {
		log.info("started multi value 1 = {} and value 2 = {}",value1,value2);
		return calculatorService.multi(value1,value2);
	}
}
