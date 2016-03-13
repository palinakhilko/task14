package com.epam.controller;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import com.epam.context.Context;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * Utility for loading data from file
 *
 */
public class PropertyTextDataLoader {

	/**
	 * List of immutable external data
	 */
	private List<Context> contextArray = new ArrayList<>();

	/*Singleton instance of PropertyTextDataLoader */
	private static volatile PropertyTextDataLoader propDataLoaderInstance;
	
	private static final String CONFIG_FILE_NAME = "conf.properties"; 
	private static final Logger log = Logger.getLogger(PropertyTextDataLoader.class);
	

	private PropertyTextDataLoader() {
		try {
			File file = null;
			URI uri = this.getClass().getResource(CONFIG_FILE_NAME).toURI();
			file = new File(uri);
			
			List<String> lines =  FileUtils.readLines(file);
			for (String line : lines) {
				String [] values = line.trim().split("\\s+");
				int number = Integer.valueOf(values [0]);
				String calculatorClass = values[1];
				String dataWriter = values[2];
				Context context = new Context(number, calculatorClass, dataWriter);
				contextArray.add(context);
			}
		} catch (Exception e) {
			log.error("Error loading property file! ", e);
		}
	}
	
	public List<Context> getContextList() {
		return contextArray;
	}
	
	public static synchronized PropertyTextDataLoader getInstance() {
		if (propDataLoaderInstance == null){
				propDataLoaderInstance = new PropertyTextDataLoader();
		}
		return propDataLoaderInstance;
	}
}
