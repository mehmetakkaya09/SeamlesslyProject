@SEAMLES10-364
Feature: Login functionality

  User Story :

  As a user, I should be able to login.

  Acceptance Criteria:

  1-User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
  2-User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty
  3-User can see the password in a form of dots by default
  4-User can see the password explicitly if needed
  5-User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page after clicking on forget password link
  6-User can see valid placeholders on Username and Password fields
sword fields


  Background: Homepage
    Given User is on the login page

  @smoke @regression @SEAMLES10-363
  Scenario: User can login with valid credentials by clicking login button
    When user can write valid username
    And user can write valid password
    And user can click login button
    Then user can see dashboard

  @smoke @regression @SEAMLES10-365
  Scenario: User can ogin with valid credentials by pressing enter key
    When user can write valid username
    And user can write valid password
    And user can press enter key
    Then user can see dashboard

  @smoke @regression @SEAMLES10-366
  Scenario Outline: User cannot login with invalid credentials
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

  @smoke @regression  @SEAMLES10-367
  Scenario Outline: User cannot login with blank credentials
    When user can write invalid username "<username>"
    And user can write invalid password "<password>"
    And user can click login button
    Then user cannot see dashboard and sees the notice blank message
    Examples:
      | username    | password    |
      |             | Employee123 |
      | Employee170 |             |
      |             |             |
@SEAMLES10-368
  Scenario: user can see the password in a form of dots by default
    When user can write valid password
    Then user can see the password in a form of dots
@SEAMLES10-369
  Scenario: user can see the password explicitly if needed
    When user can write valid password
    And User can click to toggle button
    Then User can see the password
@SEAMLES10-370
  Scenario: user can see the "Forgot password?" link
    Then user can see the Forgot password link

  @smoke @regression @SEAMLES10-371
  Scenario: user can see the "Reset Password" button on the next page after clicking on forget password link
    And User can click Forgot password link
    Then user can see reset password link
@SEAMLES10-372
  Scenario: user can see valid username placeholder
    Then user can see username placeholder
@SEAMLES10-373
  Scenario: user can see valid username placeholder
    Then user can see password placeholder