Feature: Test Simple Form Demo

Background: Selenium Easy Demo website is launched
Given application is launched
And popups have been closed
And Input Forms is visible
When user selects Input Forms
Then Input Forms dropdown is displayed
And user selects Simple Form Demo
Then user is on Simple Form Demo page

@Functional
@InputForms
@SingleInput
Scenario: Test Single Input Field
When user enters message
And user clicks Show Message
Then entered message is displayed

@Functional
@InputForms
@DoubleInput
Scenario: Test Two Input Fields
When user enters value of a
And user enters value of b
And user clicks Get Total
Then sum is displayed
