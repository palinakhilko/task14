package com.epam.output;

import java.lang.Exception;

/**
 * Transforms result before output.
 *
 */
public class DataWriterDecorator implements IDataWriter {
	
	IDataWriter writer;
	
	public DataWriterDecorator (IDataWriter wr) {
		this.writer = wr;
	}
	
	/**
	 * Outputs each result in separate line
	 * @param result - data should be outputted
	 * @throws ApplicationException
	 */
	@Override
	public void outputData(String result) throws Exception {
		
		String resultLines =  result.replace(' ', '\n');
		writer.outputData(resultLines);
	}
}
