Feature: Test Selenium Easy Demo website Input Forms

Background: Selenium Easy Demo website is launched
Given application is launched
And popups have been closed

@Functional
@InputForms
Scenario: Test Input Forms click
Given Input Forms is visible
When 	user selects Input Forms
Then Input Forms dropdown is displayed