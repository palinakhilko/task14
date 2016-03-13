package com.epam.output;


public class ConsoleWriterImpl implements IDataWriter {

	/**
	 * Outputs result to console
	 * @param result - data should be outputted
	 */
	@Override
	public void outputData(String result) {
		System.out.print(result);
	}
}
