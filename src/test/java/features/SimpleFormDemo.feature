Feature: Test Simple Form Demo

Background: Selenium Easy Demo website is launched
Given application is launched
And Input Forms is visible
When user selects Input Forms
Then Input Forms dropdown is displayed
And user selects simple form demo

@Functional
@InputForms
Scenario: Test Single Input Field
Given user enters message
When user clicks Show Message
Then entered message is displayed

@Functional
@InputForms
Scenario: Test Two Input Fields
Given user enters value of a
And user enters value of b
When user clicks Get Total
Then sum is displayed
