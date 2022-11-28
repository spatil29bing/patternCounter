package com.spatil29.patternsCounter.patterns.types;

import java.util.LinkedHashMap;
import java.util.Map;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.utils.PatternCounterUtilis;
/**
 * Phrase Counter can get distinct count of combination of 3 consecutive words
 * <br>
 * Note: If the word count is less than 3 then that line is omitted
 */
public class PhraseCounter implements IPatternCounter{
	public static final int PATTERN_TYPE_NUMBER = 3;


	public Map<String , Integer> getPatternCount(String file, String fileName)
	{
		String[] fileContent = PatternCounterUtilis.convertStringToArray(file);
		Map<String, Integer> patternMap = new LinkedHashMap<>();
        if(fileContent != null)
        {
			int n = fileContent.length;
        	String patternInfo = PatternCounterUtilis.getPatternInfo(fileName, PATTERN_TYPE_NUMBER);
        	patternMap.put(patternInfo, null);
        	 for(int i = 0; i < n - 2;i++)
             {
                 if (isPhrasePossible(fileContent, i)) {
                     String key = getKeyForPhrase(fileContent, i);
                     patternMap.put(key, patternMap.getOrDefault(key,0) + 1);
                 }
             }
        }
		return patternMap;
		
	}
	
	 private static String getKeyForPhrase(String[] data, int i) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(data[i] + " ");
	        sb.append(data[i + 1] + " ");
	        sb.append(data[i + 2] + " ");
	        return sb.toString().trim();
	    }

	    private static boolean isPhrasePossible(String[] data, int start) {
	        return (data.length >= start + 2);
	    }

}
