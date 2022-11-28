package com.spatil29.patternsCounter.patterns.types;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.utils.PatternCounterUtilis;

public class WordCounter implements IPatternCounter{
	public static final int PATTERN_TYPE_NUMBER = 1;



	public Map<String , Integer> getPatternCount(String file, String fileName)
	{
		String[] fileContent = PatternCounterUtilis.convertStringToArray(file);
		Map<String, Integer> patternMap = new LinkedHashMap<>();
        if(fileContent != null)
        {
            int n = fileContent.length;
        	String patternInfo = PatternCounterUtilis.getPatternInfo(fileName, PATTERN_TYPE_NUMBER);
        	patternMap.put(patternInfo, null);
        	for(int i = 0 ; i < n ; i++)
        	 {
                if(PatternCounterUtilis.isNumeric(fileContent[i]))
                {
                    continue;
                }
                else
                {
                    patternMap.put(fileContent[i], patternMap.getOrDefault(fileContent[i],0) + 1);
                }
            }
		
        }
        return patternMap;
	}

}
