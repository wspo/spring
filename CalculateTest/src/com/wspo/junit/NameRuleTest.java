package com.wspo.junit;

import org.junit.Ignore;
import org.junit.Test;

public class NameRuleTest {

	@Test(expected = ArithmeticException.class) 
	public void divisionWithException() {  
	  int i = 1/0;
	} 
	
	@Ignore
	@Test(timeout = 1000)  
	public void infinity() {  
		while (true);  
	}  
}
