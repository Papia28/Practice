Feature: Test Selenium Easy Demo website Input Forms

Background: Selenium Easy Demo website is launched
Given application is launched

@Functional
@InputForms
Scenario: Test Simple Form Demo
Given Input Forms is visible
When 	user selects Input Forms
Then Input Forms dropdown is displayed