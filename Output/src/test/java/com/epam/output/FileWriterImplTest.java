package com.epam.output;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import com.epam.context.Context;
import java.lang.Exception;
import com.epam.output.FileWriterImpl;

@RunWith(JUnit4.class)
public class FileWriterImplTest {
		
	@Rule
	public final TemporaryFolder folder = new TemporaryFolder();
	
	
	@Test
	public void outputData_successResult() {
		String result = "result";
		String actualResult = null;
		
		try {
			final File tempFile = folder.newFile("temp.txt");
			String pathTempFile = tempFile.getAbsolutePath();
			
			FileWriterImpl fileWriter = Mockito.spy(new FileWriterImpl());
			when(fileWriter.getPath()).thenReturn(pathTempFile);
			fileWriter.outputData(result);
			
			BufferedReader br = new BufferedReader(new FileReader(pathTempFile));
			actualResult = br.readLine();
			br.close();

		} catch (Exception e) {
			fail("Cannot find created temp file!" + e);
		} 

		assertEquals(result, actualResult);
	}
	
	@Test(expected = Exception.class)
	public void outputData_wrongFilePath() throws Exception {
		String result = "result";
		final File tempFile = folder.newFile("temp.txt");
		String pathTempFile = tempFile.getAbsolutePath();

		tempFile.setReadOnly();
		
		FileWriterImpl fileWriter = Mockito.spy(new FileWriterImpl());
		when(fileWriter.getPath()).thenReturn(pathTempFile);

		fileWriter.outputData(result);
	}
}
