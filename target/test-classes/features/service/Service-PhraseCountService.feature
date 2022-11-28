Feature: Phrase Pattern Matcher integration test
  Counts occurrences of each unique 3 sequence word in the document
  1. User Enters a filename with location and 1 as pattern type
  2. User Enters a filename with path that has null value and 1 as pattern type
  3. User enters a filename with path that has only two words and 1 as pattern type

  Scenario: User Enters file name with valid input data and "3" as input
    Given check service classes are wired
    When user Enters file name as "src/test/resources/testfiles/goodfile.txt" and "3" as count pattern type
    Then expect the following word count results
      | PatternCounter goodfile.txt 3 |   |
      | 1000 a big                    | 1 |
      | a big surprise                | 2 |
      | big surprise 2000             | 1 |
      | surprise 2000 hello           | 1 |
      | 2000 hello is                 | 1 |
      | hello is a                    | 1 |
      | is a big                      | 1 |
      | big surprise 1000             | 1 |

  Scenario: User Enters file name which has empty content and "3" as input
    Given check service classes are wired
    When user Enters file name as "src/test/resources/testfiles/nullfile.txt" and "3" as count pattern type
    Then expect an empty output

  Scenario: User Enters file name with partial content and "3" as input
    Given check service classes are wired
    When user Enters file name as "src/test/resources/testfiles/partialfile.txt" and "3" as count pattern type
    Then expect output with words count having atleast three words and skips the rest
      | PatternCounter partialfile.txt 3 |   |
      | 1000 a big                       | 1 |
      | a big surprise                   | 2 |
      | big surprise 2000                | 1 |
      | surprise 2000 hello              | 1 |
      | 2000 hello is                    | 1 |
      | hello is a                       | 1 |
      | is a big                         | 1 |
