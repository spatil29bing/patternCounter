package com.spatil29.patternsCounter.patterns.factory;

import com.spatil29.patternsCounter.patterns.IPatternCounter;
import com.spatil29.patternsCounter.patterns.types.NumberCounter;
import com.spatil29.patternsCounter.patterns.types.PhraseCounter;
import com.spatil29.patternsCounter.patterns.types.WordCounter;
import com.spatil29.patternsCounter.utils.PatternCounterUtilis;

public class PatternFactory {

	public IPatternCounter getPatternSpecificObject(String patternType) {
		// TODO Auto-generated method stub
		IPatternCounter patternCounter = null;
		if((patternType == null) && PatternCounterUtilis.isNumericType(patternType))
		{
			return patternCounter;
		}
		else
		{
			patternType = patternType.trim();
			switch(patternType)
			{
				case "1":
					patternCounter = new WordCounter();
					break;
				case "2":
					patternCounter = new NumberCounter();
					break;
				case "3":
					patternCounter = new PhraseCounter();
					
			}
		}
		return patternCounter;
	}

}
