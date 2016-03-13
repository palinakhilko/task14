package com.epam.output;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import com.epam.output.ConsoleWriterImpl;

@RunWith(JUnit4.class)
public class ConsoleWriterImplTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void outputData_successfulResult() throws IOException {
		
		String result = "result";
		ConsoleWriterImpl consoleWriter = Mockito.spy(new ConsoleWriterImpl());
		consoleWriter.outputData(result);
		
		String actualResult = outContent.toString();
		assertEquals(result, actualResult);
	}
	
	
	@Test
	public void outputData_emptyResult() throws IOException {
		
		String result = "";
		ConsoleWriterImpl consoleWriter = Mockito.spy(new ConsoleWriterImpl());
		consoleWriter.outputData(result);
		
		String actualResult = outContent.toString();
		assertEquals(actualResult, result);
	}
}
