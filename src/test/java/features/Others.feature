Feature: Test Others dropdown

Background: Selenium Easy Demo website is launched
Given application is launched
When popups have been closed
Then Others option is visible

@Others
@Functional
Scenario: Test Others dropdown click
When user clicks Others
Then Others dropdown opens 