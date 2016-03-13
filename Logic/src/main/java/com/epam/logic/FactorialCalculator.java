package com.epam.logic;

import com.epam.context.Context;

/**
 * Represents math logic which is related 
 * with factorial numbers
 */
public class FactorialCalculator implements CalculatorPrimitive {

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
		int fact = 1; 
		for (int i = 1; i <= position; i++) {
			fact *= i;
	    }
	    return fact;
	}
}
