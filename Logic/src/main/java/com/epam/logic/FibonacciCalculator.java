package com.epam.logic;

import com.epam.context.Context;

/**
 * Represents math logic which is related 
 * with Fibonacci numbers
 */
public class FibonacciCalculator implements CalculatorPrimitive {

	/**
	 * Calculate number row specified
	 * @param context contains external immutable data.
	 * @return number row specified
	 */
	public Integer calculate(Context context)
	{
		int position = context.getNumberPosition();
		if (position < 1) 
		{
			return null;	
		}
		int a = 1;
		int b = 1;
		int result = 1;
		int currentPos = 2;
		while (currentPos < position)
		{
			result = a + b;
			a = b;
			b = result;
			currentPos ++;
		}
		return result;
	}
}
