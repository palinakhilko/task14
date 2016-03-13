package com.epam.context;

/**
 * Represent class holding external data
 * 
 */
public class Context {

	private final int numberPosition;
	private final String calculatorClass;
	private final String dataWriter;
	
	public Context(int number, String calculatorClass, String dataWriter) {
	    this.numberPosition = number;
	    this.calculatorClass = calculatorClass;
	    this.dataWriter = dataWriter;
	}

	public int getNumberPosition() {
		return numberPosition;
	}

	public String getCalculatorClass() {
		return calculatorClass;
	}

	public String getDataWriter() {
		return dataWriter;
	}
}