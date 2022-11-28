package com.spatil29.patternsCounter.utils;
import java.util.regex.Pattern;

public class PatternCounterUtilis {
	public static final String PROGRAM_NAME = "PatternCounter";


    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	public static boolean isNumericType(String patternType) {
		return patternType.chars().allMatch(Character::isDigit);
		// TODO Auto-generated method stub
	}
	
	public static boolean isNumeric(String strNum)
	{
		 if (strNum == null)
	        {
	            return false;
	        }
	        return pattern.matcher(strNum).matches();
	}

	public static String[] convertStringToArray(String str) {
		String[] stringArr = null;
		if (checkStringIsValid(str)) {
			stringArr = str.split(" ");
			if (checkLengthOfStringArr(stringArr)) {
				stringArr = null;
			}
		}
		return stringArr;

	}
	
	private static boolean checkStringIsValid(String str)
	{
		if(str == null || str.length() == 0)return false;
		return true;
	}
	
	private static boolean checkLengthOfStringArr(String[] inputArr)
	{
		if (inputArr.length < 3)
		{
			return true;
		}
		return false;
	}

	public static String getPatternInfo(String fileName, int patternTypeNumber) {
		// TODO Auto-generated method stub
		return PROGRAM_NAME + " "  + " " + fileName + " " + patternTypeNumber;
	}

	public static String isDigitAfterDecimalPointZero(String string) {
		String valueAfterPoint = string.split(".")[1];
		if(valueAfterPoint == "0")
		{
			int num = Integer.parseInt(string);
			string = Integer.toString(num);
			
		}

		// TODO Auto-generated method stub
		return string;
	}

}
