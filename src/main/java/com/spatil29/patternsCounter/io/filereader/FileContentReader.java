package com.spatil29.patternsCounter.io.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileContentReader {
	/**
		Reads the content from the file and it is called from PatternCounterService
		@param filePath - return content from the file
	 */
	public static String[]	getFileContent(String filePath) throws Exception
	{

		if(filePath == null)
		{
			throw new Exception("Exception occured while reading file name.File name not specified");
		}
		else
		{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			try {
				StringBuilder sb = new StringBuilder();

				File file = new File(filePath);
				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {
					sb.append(sc.nextLine());
				}
				if (sc != null) {
					sc.close();
				}
				String[] response = new String[2];
				String inputAfterProcessing = removeSpecialCharacterAndPunctuation(sb.toString());
				response[0] = inputAfterProcessing;
				response[1] = file.getName();
				//System.out.println(inputAfterProcessing);
				return response;
			} catch (IOException e) {
				throw new Exception("Exception Occured while reading the file." + e.getMessage());
			} finally {
				br.close();
			}
		}
	}
	/**
	Removes the special character like &,^,$ etc from the input string
	 @param s - return content from the file
	 */
	private static String removeSpecialCharacterAndPunctuation(String s) {
		s = s.replaceAll("[^a-zA-Z0-9. ]", "");
		// TODO Auto-generated method stub
		return s;
	}
}
