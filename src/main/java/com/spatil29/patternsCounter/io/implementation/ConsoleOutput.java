package com.spatil29.patternsCounter.io.implementation;

import java.io.PrintStream;
import java.util.Map;

import com.spatil29.patternsCounter.io.*;

/**
 * The standard output that supports Console output 
 *
 */
public class ConsoleOutput implements StandardConsoleOutput {

	public ConsoleOutput(PrintStream ps) {
	}

	public ConsoleOutput() {

	}

	@Override
	public void printResult(Map<String, Integer> result) {
		if (result != null) {
			printResults(result);
		}

	}

	/**
	 * Iterates the hashMap which is generated according to the content in file and pattern Type
	 * and print the results to console one line apart
	 * @param result Map&lt;String,Integer&gt;- The unique item as key and count as number
	 */
	private void printResults(Map<String, Integer> result) {
		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			String key = entry.getKey().toString();
			Integer value = entry.getValue();
			if ((key != null) && (value == null)) {
				System.out.println(key);
			} else {
				System.out.println(key + ", " + value);
			}
		}

	}

}
