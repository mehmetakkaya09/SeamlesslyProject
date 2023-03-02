Feature: Login functionality
  Agile Story:
  As a user, I sould be able to login.
Background: Homepage
  Given User is on the home page

  Scenario: User can login with valid credentials
    When user can write username
    And  user can write password
    And user can click login button
    Then user can see dashboard