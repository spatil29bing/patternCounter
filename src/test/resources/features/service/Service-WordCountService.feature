Feature: Word Pattern Matcher integration test
  Counts occurrences of each unique word in the document
  1. User Enters a filename with location and 1 as pattern type
  2. User Enters a filename with path that has null value and 1 as pattern type
  3. User enters a filename with path that has only two words and 1 as pattern type

  Scenario: User Enters a filename with calid input and 1 as pattern type
    Given service class is wired
    When user enters "src/test/resources/testfiles/goodfile.txt" as filename and "1" as pattern type
    Then expect the following results
      | PatternCounter goodfile.txt 1 |   |
      | a                             | 2 |
      | big                           | 2 |
      | surprise                      | 2 |
      | hello                         | 1 |
      | is                            | 1 |

  Scenario: User Enters a filename with path that has null value and 1 as pattern type
    Given service class is wired
    When user enters "src/test/resources/testfiles/nullfile.txt" as filename and "1" as pattern type
    Then expect empty result

  Scenario: User enters a filename with path that has only two words and 1 as pattern type
    Given service class is wired
    When user enters "src/test/resources/testfiles/badfile.txt" as filename and "1" as pattern type
    Then expect empty result
