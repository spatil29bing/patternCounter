package com.spatil29.patternsCounter.services;

import java.util.Map;

/**
 * @return Map&lt;String,Integer&gt;- The unique item as key and count as number
 * @throws Exception Run time exception
 */
public interface IPatternCounterService {
	Map<String,  Integer> findPatternfromFile(String file, String patternType) throws Exception;

}
