package com.epam.output;

import java.lang.Exception;

/**
 * Represents abstraction which 
 * outputs result data
 *
 */
public interface IDataWriter {
	
	/**
	 * Outputs result
	 * @param result - data should be outputted
	 * @throws ApplicationException
	 */
	void outputData(String result) throws Exception;
}
