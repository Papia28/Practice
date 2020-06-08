Feature: To test the Select Dropdowns of Selenium Easy Demo website

Background: Selenium Easy Demo website is launched
Given application is launched
And popups have been closed
When user selects Input Forms
Then Input Forms dropdown is displayed
And user selects Select Dropdown List

@Functional
@SelectSingle
Scenario: Test selecting single Day
When user selects single day
Then selected day is displayed

@Functional
@Select
Scenario: Test selecting single state
#When user selects single state
#And user clicks First Selected
#Then first selected state is displayed

@Functional
@Select
Scenario: Test selecting single state scenario 2
#When user selects single state
#And user clicks Get All Selected
#Then all selected state is displayed

@Functional
@Select
Scenario: Test selecting multiple places
#When user selects multiple places
#And user clicks First Selected
#Then First Selection result is displayed
#When user clicks Get All Selected
#Then all selection result is displayed