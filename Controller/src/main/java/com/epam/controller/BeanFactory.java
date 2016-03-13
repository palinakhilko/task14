package com.epam.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.logic.FactorialCalculator;
import com.epam.logic.FibonacciCalculator;
import com.epam.output.ConsoleWriterImpl;
import com.epam.output.FileWriterImpl;

/**
 * Returns object corresponding by key.
 *
 */
public class BeanFactory implements IFactory {

	private static BeanFactory beanInstance;
	private static final Logger log = Logger.getLogger(BeanFactory.class);
	private Map<String, Object> beanMap;

	private BeanFactory() {
		beanMap = new HashMap<String, Object>();
		beanMap.put("FA", new FactorialCalculator());
		beanMap.put("FB", new FibonacciCalculator());
		beanMap.put("C", new ConsoleWriterImpl());
		beanMap.put("F", new FileWriterImpl());
	}

	public static BeanFactory getInstance() {
		if (beanInstance == null) {
			beanInstance = new BeanFactory();
		}
		return beanInstance;
	}

	@Override
	public Object getEntityByCode(String key) {
		if (beanMap.containsKey(key)) {
			return beanMap.get(key);
		} else {
			log.error("Cannot find bean with next code: " + key);
			return null;
		}
	}
}
