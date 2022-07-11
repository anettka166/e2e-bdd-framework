Feature: Google search functionality

  Scenario: test google search for unicorns
    Given user goes to google search page
    When user enters "unicorns" in the search input box
    And user presses enter key
    Then user shoud see results for searched item



