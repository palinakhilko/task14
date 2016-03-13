package com.epam.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.epam.controller.BeanFactory;
import com.epam.logic.FactorialCalculator;

@RunWith(JUnit4.class)
public class BeanFactoryTest {

	private BeanFactory beanFactory;

	@BeforeClass
	public static void getInstance_checkReturnValue() {
		assertEquals(BeanFactory.getInstance().getClass(), BeanFactory.class);
	}
	
	@Before
	public void initBeanFactory() {
		beanFactory = BeanFactory.getInstance();
	}

	@Test
	public void getEntityByCode_validCode() {
		String validKey = "FA";
		Object expectedResult = FactorialCalculator.class;
		assertNotNull(beanFactory.getEntityByCode(validKey));
		assertEquals(beanFactory.getEntityByCode(validKey).getClass(),
				expectedResult);
	}

	@Test
	public void getEntityByCode_invalidCode() {
		String invalidKey = "invalid_key";
		Object expectedResult = null;
		assertEquals(beanFactory.getEntityByCode(invalidKey), expectedResult);
	}
}
