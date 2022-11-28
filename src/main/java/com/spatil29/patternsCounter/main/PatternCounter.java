package com.spatil29.patternsCounter.main;

import java.util.Map;

import com.spatil29.patternsCounter.io.implementation.ConsoleOutput;
import com.spatil29.patternsCounter.io.implementation.KeyBoardInput;
import com.spatil29.patternsCounter.io.runner.IORunner;
import com.spatil29.patternsCounter.services.IPatternCounterService;
import com.spatil29.patternsCounter.services.PatternCounterService;


/***
 * PatternCounter
 * This is the main class to run the application
 *
 * Assumptions used for running the code:
 * 1. Java Version needed is 1.8 onwards
 * 2. Input file contents are expected to be in a single line rather than multi lines
 * 3. Only whole numbers are considered as numbers not decimals
 * 4. If the file does not have minimum 3 words, none of the scenarios gets executed and returns empty
 * 5. For Pattern 3 (Phrases) if there are not enough words to make 3 consecutive words for the last phrase,
 * then that line is skipped
 * 6. Cucumber is used as tool for BDD and Maven as build tool
 * 7. Run time exception with proper message is thrown if there occurs any exception scenarios
 * 8. IO and core logic are loosely coupled. IO wired via Dependency Injection and Service class uses Factory
 * 9. Data preprocessing : If content from input file data contains punctuation or special character except spaces " " then they
 * are removed from the input file data.
 * 10. If want to add more patterns in future then additional classes can be created in package com.spatil29.patternsCounter.patterns.types;
 * 11. addtional cases  for those particular pattern to switch   should be added in factory method
 ***/

/**
 * My Logic:
 * 1.) Take input i.e. fileName and patternType  from command line.
 * 2.) Pass the input to service. In service pattern type is passed as a input to the
 * PatternFactory method and object of given pattern type is created
 * 3.) The file content is also read in service. The file content is preprocessed.
 * 4.) The file content, filname are sent as parameter to object created by factory method.
 * 5.) The NumberCounter, WordCounter, PhrasesCounter generate the desired output i.e. unique key,value pair
 * 6.) finally the output is printed to command line in desired string format.
* */

public class PatternCounter {
  private static IPatternCounterService patternCounterService;

  public static void main(String[] args) {
    //System.out.println("Hello World!");
    IORunner io = new IORunner(new KeyBoardInput(), new ConsoleOutput());
    String inputs[] = io.getUserInput();
    Map<String, Integer> result = null;
	patternCounterService = new PatternCounterService();
    try {
		result = patternCounterService.findPatternfromFile(inputs[0], inputs[1]);
	} catch (Exception e) {
		System.err.println("Run time exception occured :" + e);
	}
    //System.out.println("Hello world!");
    io.printResult(result);
  }
}
