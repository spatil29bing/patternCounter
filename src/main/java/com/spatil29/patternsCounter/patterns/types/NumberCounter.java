package com.spatil29.patternsCounter.patterns.types;

import java.util.*;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.utils.PatternCounterUtilis;
/**
 * Number counter service that has the logic to split the input string,
 * identify unique numbers and gives the count of distinct numbers
 * <br>
 * Limitations: Decimal numbers are counted as string
 *
 */
public class NumberCounter implements IPatternCounter{
	public static final int PATTERN_TYPE_NUMBER = 2;


	public Map<String , Integer> getPatternCount(String file, String fileName)
	{
        String[] fileContent = PatternCounterUtilis.convertStringToArray(file);
		HashMap<String, Integer> patternMap = new LinkedHashMap<>();

        if(fileContent != null)
        {
            int n = fileContent.length;
        	String patternInfo = PatternCounterUtilis.getPatternInfo(fileName, PATTERN_TYPE_NUMBER);
        	patternMap.put(patternInfo, null);
        	for(int i = 0 ; i < n ; i++)
            {
                if(PatternCounterUtilis.isNumeric(fileContent[i]))
                {
                	//String key = PatternCounterUtilis.isDigitAfterDecimalPointZero(fileContent[i]);
                    patternMap.put(fileContent[i], patternMap.getOrDefault(fileContent[i],0) + 1);

                }
                else
                {
                    continue;
                }
                
            }
        }

		return patternMap;
		
	}
	
	
}
