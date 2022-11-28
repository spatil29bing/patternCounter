Feature: Phrase Counter Service Implementation
  This service method counts the 3 letter phrases in the given text and is there are no 3 letters skips tat line

  Scenario: Valid input text and file name is given
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "1000 a big surprise 2000 hello is a big surprise 1000" and "filename.txt" is passed as input parameters
    Then check the result is as expected
      | PatternCounter filename.txt 3 |   |
      | 1000 a big                    | 1 |
      | a big surprise                | 2 |
      | big surprise 2000             | 1 |
      | surprise 2000 hello           | 1 |
      | 2000 hello is                 | 1 |
      | hello is a                    | 1 |
      | is a big                      | 1 |
      | big surprise 1000             | 1 |

  Scenario: null input text and file name is given
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "" and "filename.txt" is passed as input parameters
    Then check the result is empty

  Scenario: valid string input text with less than 3 characters and file name is given
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "one two" and "filename.txt" is passed as input parameters
    Then check the result is empty

  Scenario: valid string input text with exactly 3 characters and file name is given
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "one two three" and "filename.txt" is passed as input parameters
    Then check the result is below
      | PatternCounter filename.txt 3 |   |
      | one two three                 | 1 |
    And check the size is 2

  Scenario: valid string input text with exactly 4 characters and file name is given
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "one two three four" and "filename.txt" is passed as input parameters
    Then check the result is below
      | PatternCounter filename.txt 3 |   |
      | one two three                 | 1 |
      | two three four                | 1 |
    And check the size is 3 and last two words are skipped

  Scenario: To check the case sensitiveness of the output
    Given phrase counter service is initialized
    And make sure the initial result is null
    When an input text of "one two three one TWO three" and "filename.txt" is passed as input parameters
    Then check the result is below
      | PatternCounter filename.txt 3 |   |
      | one two three                 | 1 |
      | two three one                 | 1 |
      | three one TWO                 | 1 |
      | one TWO three                 | 1 |
    And check the size is 5 and last two words are skipped
