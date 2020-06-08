Feature: Test Selenium Easy Demo website Input Forms

Background: Selenium Easy Demo website is launched
Given application is launched
And popups have been closed
Then Input Forms is visible

@Functional
@InputForms
Scenario: Test Input Forms click
When 	user selects Input Forms
Then Input Forms dropdown is displayed