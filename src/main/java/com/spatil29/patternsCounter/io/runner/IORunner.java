package com.spatil29.patternsCounter.io.runner;

import com.spatil29.patternsCounter.io.StandardKeyBoardInput;
import com.spatil29.patternsCounter.io.implementation.KeyBoardInput;
import com.spatil29.patternsCounter.io.implementation.ConsoleOutput;

import java.util.Map;

import com.spatil29.patternsCounter.io.StandardConsoleOutput;


public class IORunner {
	StandardKeyBoardInput standardInput;
	StandardConsoleOutput standardOutput;
	
	public IORunner(KeyBoardInput keyBoardInput, ConsoleOutput consoleOutput) {
		// TODO Auto-generated constructor stub
		this.standardInput = keyBoardInput;
		this.standardOutput = consoleOutput;
	}
	
	public String[] getUserInput() {
		if (this.standardInput != null) {
			return this.standardInput.getUserInput();
		} else {
			return new String[2];
		}
	}
	
	public void printResult(Map<String, Integer> result) {
		if (this.standardOutput != null) {
			this.standardOutput.printResult(result);
		}

	}
	

}
