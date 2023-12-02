package com.java.calculator;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.calculator.dao.Calculator;

public interface H2DatabaseTest extends JpaRepository<Calculator, Integer>{

}
