Feature: User login and logout functionality

  Scenario: Login and logout positive flow
    Given user is on the home page
    When user clicks on the sigh in link
    And user should be navigated to login screen
    And user enters "Kevinlee123@gmail.com" and "Kevin123" in the credentials input
    And user clicks on login button
    And user should be navigated to account page
    Then user should be able to see their name on top
    And user clicks on sign out link
    Then user should be navigated to login screen
