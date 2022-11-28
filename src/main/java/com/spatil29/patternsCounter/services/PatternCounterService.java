package com.spatil29.patternsCounter.services;

import java.util.Map;

import com.spatil29.patternsCounter.io.filereader.FileContentReader;
import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.patterns.factory.PatternFactory;
/**
 * Pattern counter Service
 *The service calls the pattern factory to get the instance of the matcher specified
 */
public class PatternCounterService implements IPatternCounterService {
	PatternFactory patternFactory = new PatternFactory();
	IPatternCounter patternCounter;

	@Override
	public Map<String,  Integer> findPatternfromFile(String file, String patternType) throws Exception {
		Map<String, Integer> result = null;
		if(patternType == null)
		{
			return result;
		}
		else
		{
			patternCounter = patternFactory.getPatternSpecificObject(patternType);
		}
		String[] input = FileContentReader.getFileContent(file);
		if(patternCounter != null)
		{
			result = patternCounter.getPatternCount(input[0], input[1]);
		}
		else {
			throw new Exception("Pattern type entered is null or not a number");
		}

		return result;			
	}

}
