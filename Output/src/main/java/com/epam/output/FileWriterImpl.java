package com.epam.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import java.lang.Exception;

public class FileWriterImpl implements IDataWriter {
	
	private static final Logger log = Logger.getLogger(FileWriterImpl.class);
	private static final String pathToFile = "D:\\file.txt";
	
	/**
	 * Outputs result to file
	 * @param result - data should be outputted
	 * @throws ApplicationException
	 */
	@Override
	public void outputData(String result) throws Exception {
		try
		{
			File file = new File(getPath());	
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();
	
		} catch (IOException e) {
			log.error("Error writing result file! Check path file!", e);
			throw new Exception(e);
		}
	}
	public String getPath() {
		return pathToFile;
	}
}
