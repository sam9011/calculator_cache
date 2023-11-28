package com.java.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.calculator.dao.Calculator;

@Repository("calculatorRepository")
public interface CalculatorRepository extends JpaRepository<Calculator,Integer>{

}
