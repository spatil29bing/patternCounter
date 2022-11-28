Feature: Number Pattern Matcher integration test
  Counts occurrences of each unique numbers in the document
  1. User Enters a filename with location and 2 as pattern type
  2. User Enters a filename with path that has null value and 2 as pattern type
  3. User enters a filename with path that has only two words and 2 as pattern type

  Scenario: User Enters file name with valid content and "2" as input
    Given check service class is wired
    When user Enters file name as "src/test/resources/testfiles/goodfile.txt" and "2" as input pattern type
    Then expect the following number count results
      | PatternCounter goodfile.txt 2 |   |
      |                          1000 | 2 |
      |                          2000 | 1 |

  Scenario: User Enters file name with null content and "2" as input
    Given check service class is wired
    When user Enters file name as "src/test/resources/testfiles/nullfile.txt" and "2" as input pattern type
    Then expect empty output

  Scenario: User Enters file name with less than 3 words and "2" as input
    Given check service class is wired
    When user Enters file name as "src/test/resources/testfiles/badfile.txt" and "2" as input pattern type
    Then expect empty output
