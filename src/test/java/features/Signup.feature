Feature: To test sign up feature of website

@EndToEnd
@Signup
Scenario: Test sign up
Given application is launched
When user clicks Signin
Then user specifies email
And user clicks create account
Then user account is created