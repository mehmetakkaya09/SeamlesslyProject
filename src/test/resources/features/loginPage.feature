Feature: Login functionality
  Agile Story:
  As a user, I sould be able to login.

  Background: Homepage
    Given User is on the login page

  @smoke @regression
  Scenario: User can ogin with valid credentials by clicking login button
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard

  @smoke @regression
  Scenario: User can ogin with valid credentials by pressing enter key
    When user can write valid username
    And user can write valid password
    And user can press enter key
    Then user can see dashboard

  @smoke @regression
  Scenario Template: User cannot login with invalid credentials
    When user can write invalid username "<username>"
    And user can write invalid password "<password>"
    And user can click login button
    Then user cannot see dashboard and sees the notice wrong message
    Examples:
      | username    | password    |
      | aaaa1111    | jirajiraş   |
      | aaaa1111    | Employee123 |
      | Employee170 | jirajiraş   |
      | EMPLOYEE170 | Employee123 |

  @smoke @regression
  Scenario Template: User cannot login with blank credentials
    When user can write invalid username "<username>"
    And user can write invalid password "<password>"
    And user can click login button
    Then user cannot see dashboard and sees the notice blank message
    Examples:
      | username    | password    |
      |             | Employee123 |
      | Employee170 |             |
      |             |             |

  Scenario: user can see the password in a form of dots by default
    When user can write valid password
    Then user can see the password in a form of dots

  Scenario: user can see the password explicitly if needed
    When user can write valid password
    And User can click to toggle button
    Then User can see the password

  Scenario: user can see the "Forgot password?" link
    Then user can see the Forgot password link

  @smoke @regression
  Scenario: user can see the "Reset Password" button on the next page after clicking on forget password link
    And User can click Forgot password link
    Then user can see reset password link

  Scenario: user can see valid username placeholder
    Then user can see username placeholder

  Scenario: user can see valid username placeholder
    Then user can see password placeholder