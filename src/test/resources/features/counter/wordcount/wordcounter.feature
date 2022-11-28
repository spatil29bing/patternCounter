Feature: Word counter service implementation
  This service method counts the distinct number of words in the string

  Scenario: A valid text string and file name is passed
    Given Word count service is properly wired
    And result is reset
    When a valid text with content "1000 a big surprise 2000 hello is a big surprise 1000" is passed with file name as "filename.txt" is passed
    Then make sure the result is not empty
    And check the value is as expected
      | PatternCounter filename.txt 1 |   |
      | a                             | 2 |
      | big                           | 2 |
      | surprise                      | 2 |
      | hello                         | 1 |
      | is                            | 1 |

  Scenario: A text string which is empty and file name is passed
    Given Word count service is properly wired
    And result is reset
    When a valid text with content "" is passed with file name as "filename.txt" is passed
    And check the value is empty

  Scenario: A text string with less than 3 words and file name is passed
    Given Word count service is properly wired
    And result is reset
    When a valid text with content "one two" is passed with file name as "filename.txt" is passed
    And check the value is empty

  Scenario: A text string with exactly 3 and same words and file name is passed
    Given Word count service is properly wired
    And result is reset
    When a valid text with content "test test test" is passed with file name as "filename.txt" is passed
    Then make sure the result is not empty
    And check the value is as expected
      | PatternCounter filename.txt 1 |   |
      | test                          | 3 |

  Scenario: To test the case sensitiveness of input text
    Given Word count service is properly wired
    And result is reset
    When a valid text with content "test TEST test" is passed with file name as "filename.txt" is passed
    Then make sure the result is not empty
    And check the value is as expected
      | PatternCounter filename.txt 1 |   |
      | test                          | 2 |
      | TEST                          | 1 |
