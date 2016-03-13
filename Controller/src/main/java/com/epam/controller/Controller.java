package com.epam.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.logic.CalculatorPrimitive;
import com.epam.output.DataWriterDecorator;
import com.epam.output.IDataWriter;
import com.epam.context.Context;
import org.apache.log4j.Logger;

/**
 * Represent manager which runs application
 * 
 */
public class Controller {

	private static final Logger log = Logger.getLogger(Controller.class);

	public static void main(String[] args) {
		log.info("Application started!");
		try {
			PropertyTextDataLoader dataLoader = PropertyTextDataLoader
					.getInstance();
			BeanFactory bean = BeanFactory.getInstance();
			Map<IDataWriter, String> writers = new HashMap<>();
			for (Context context : dataLoader.getContextList()) {

				CalculatorPrimitive primitive = (CalculatorPrimitive) bean
						.getEntityByCode(context.getCalculatorClass());
				Integer result = primitive.calculate(context);
				IDataWriter dataWriter = (IDataWriter) bean
						.getEntityByCode(context.getDataWriter());

				if (writers.containsKey(dataWriter)) {
					String resultWriter = writers.get(dataWriter) + " "
							+ result.toString();
					writers.put(dataWriter, resultWriter);
				} else {
					writers.put(dataWriter, result.toString());
				}
			}
			for (Map.Entry<IDataWriter, String> entry : writers.entrySet()) {
				String result = entry.getValue();
				IDataWriter dataWriter = new DataWriterDecorator(entry.getKey());
				dataWriter.outputData(result);
			}
		} catch (Exception e) {
			log.error("Error occurs, see logs.", e);
		}
		log.info("Application finished.");
	}
}
