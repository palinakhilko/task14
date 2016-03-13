package com.epam.logic;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.epam.context.Context;
import com.epam.logic.CalculatorPrimitive;
import com.epam.logic.FactorialCalculator;

@RunWith(JUnit4.class)
public class FactorialCalculatorTest {
		
	private CalculatorPrimitive calculator; 
	
	@BeforeClass
	public static void calculate_checkReturnValue() {
		int validNumberOfPosition = 5;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(validNumberOfPosition);
		assertEquals(new FactorialCalculator().calculate(context).getClass(), Integer.class);
	}
	
	@Before
	public void initCalculator() {
		calculator = new FactorialCalculator();
	}
	
	@Test
	public void calculate_zero() {
		int numberOfPosition = 0;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(numberOfPosition);
		
		Integer expectedResult = null;
		assertEquals(calculator.calculate(context), expectedResult);
	}
	
	@Test
	public void calculate_one() {
		int numberOfPosition = 1;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(numberOfPosition);
		
		Integer expectedResult = 1;
		assertEquals(calculator.calculate(context), expectedResult);
	}
	
	@Test
	public void calculate_positiveValue() {
		int numberOfPosition = 5;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(numberOfPosition);
		//1*2*3*4*5 = 120
		Integer expectedResult = 120;
		assertEquals(calculator.calculate(context), expectedResult);
	}
	
	@Test
	public void calculate_negativeValue() {
		int numberOfPosition = -5;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(numberOfPosition);
		
		Integer expectedResult = null;
		assertEquals(calculator.calculate(context), expectedResult);
	}
}
