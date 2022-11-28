Feature: PatternFactory feature
  Pattern factory can take a pattern value as string and returns corresponding matcher
  Presently supported pattern counters with type
   type = 1 => WordCounter
   type = 2 => NumberCounter
   type = 3 => PhraseCounter

  Scenario: the type entered is 1
    Given a factory instance
    And  reset all fields
    When the entered string is "1"
    Then check whether the factory returned a WordCounter instance

  Scenario: the type entered is 2
    Given a factory instance
    When the entered string is "2"
    Then check whether the factory returned a NumberCounter instance

  Scenario: the type entered is 3
    Given a factory instance
    When the entered string is "3"
    Then check whether the factory returned a PhraseCounter instance

  Scenario: the type entered is empty/null
    Given a factory instance
    When the entered string is ""
    Then check whether the factory returned null instance

  Scenario: the type entered is greater than 3
    Given a factory instance
    When the entered string is "4"
    Then check whether the factory returned null instance
