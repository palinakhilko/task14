package com.epam.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import com.epam.controller.PropertyTextDataLoader;

@RunWith(JUnit4.class)
public class PropertyTextDataLoaderTest {

	@BeforeClass
	public static void getInstance_checkReturnValue() {

		assertEquals(PropertyTextDataLoader.getInstance().getClass(),
				PropertyTextDataLoader.class);
	}

	@Test
	public void getInstance_checkConstructor() {
		PropertyTextDataLoader  propertyTextLoader = Mockito.spy(PropertyTextDataLoader.getInstance());
		
		assertNotNull(propertyTextLoader.getContextList());
		assertFalse(propertyTextLoader.getContextList().isEmpty());
	}
}
