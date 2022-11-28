Feature: Number Counter Service Implementation
  The contents of the file is provided and to see whether the core logic is working or not

  
  Scenario: A valid file content and file name is given as input
    Given number pattern counter is initialized
    When an input of "1000 a big surprise 2000 hello is a big surprise 1000" and "filename.txt" is passed as input parameters
    Then check whether the counter is returning correct counts
      | PatternCounter filename.txt 2 |   |
      |                          1000 | 2 |
      |                          2000 | 1 |
		And check whether the "1000" count is 2 and "2000" count is 1
		
		Scenario: A valid file with content less than three words and file name is given as input
    Given number pattern counter is initialized
    When an input of "1000 a" and "filename.txt" is passed as input parameters
		And check whether the result is empty