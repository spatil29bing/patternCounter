package com.spatil29.patternsCounter.io.implementation;

import java.util.Scanner;
import java.io.InputStream;

import com.spatil29.patternsCounter.io.StandardKeyBoardInput;

/**
 * The standard input that supports the keyboard
 * */

public class KeyBoardInput implements StandardKeyBoardInput {
	private Scanner scanner;


	public KeyBoardInput() {
		this.scanner = new Scanner(System.in);
	}
	/*
		Takes the file name and pattern as input from command line which is entered by user
	 */
	@Override
	public String[] getUserInput() {
		String[] inputs = new String[2];
		for (int i = 0; i < 2; i++) {
			inputs[i] = scanner.nextLine();
		}
		if (scanner != null) {
			scanner.close();
		}
		return inputs;
	}

}
