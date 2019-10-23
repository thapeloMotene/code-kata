package stringkata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {
	
@Test
public void shouldReturnZeroOnEmptyString() {
	assertEquals(0, Calculator.Add(""));
}


@Test 
public void shouldReturnSingleNumber() {
	assertEquals(1, Calculator.Add("1"));
	
}

@Test
public void shouldReturnSumOfTwoNumbersCommaDelimited() {
	assertEquals(3, Calculator.Add("1,2"));
}


@Test 
public void shouldReturnSumOfMultipleCommaDelimited() {
	assertEquals(6, Calculator.Add("1,2,3"));
}

@Test 
public void shouldAcceptNewLineAsSeparotor() {
	assertEquals(10, Calculator.Add("1,2,3\n4"));
}


@Test 
public void shouldAcceptCustomSepartors() {
	assertEquals(3, Calculator.Add("//#\n1#2"));
}


@Test
public void shouldThrowErrorOnNegativeNumbers() {
	
	try {
		Calculator.Add("1,-2,-3");
		fail("Error must be thrown");
		
	}catch(RuntimeException ex) {
		
	}
}


@Test
public void errorContainsNumber() {
	try {
		Calculator.Add("1,-2,-3");
		fail("Error must be thrown");
		
	}catch(RuntimeException ex) {
		
		assertEquals("Negative Numbers Not Allowed: -2,-3", ex.getMessage());
	}
}



}
