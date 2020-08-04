Feature: To test the Select Dropdowns of Selenium Easy Demo website

Background: Selenium Easy Demo website is launched
Given application is launched
And popups have been closed
And Input Forms is visible
When user selects Input Forms
Given Input Forms dropdown is displayed
And user selects Select Dropdown List

@Select
@InputForms
@SingleSelect
Scenario: Test selecting single Day
When user selects single day
Then selected day is displayed

@Select
@InputForms
@MultiSelect
Scenario: Test selecting multiple states
When user selects multiple states
#And user clicks First Selected
#Then first selected state is displayed
When user clicks Get All Selected
Then all selected states are displayed