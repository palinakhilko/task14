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
import com.epam.logic.FibonacciCalculator;

@RunWith(JUnit4.class)
public class FibonacciCalculatorTest {

	private CalculatorPrimitive calculator;
	
	@BeforeClass
	public static void calculate_checkReturnValue() {
		int validNumberOfPosition = 9;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(validNumberOfPosition);
		assertEquals(new FibonacciCalculator().calculate(context).getClass(), Integer.class);
	}
	
	@Before
	public void initCalculator() {
		calculator = new FibonacciCalculator();
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
		int numberOfPosition = 7;
		Context context = mock(Context.class);
		when(context.getNumberPosition()).thenReturn(numberOfPosition);
		//1+1=2 (3); 1+2=3 (4); 2+3=5 (5); 3+5=8 (6); 5+8=13 (7);
		Integer expectedResult = 13;
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
