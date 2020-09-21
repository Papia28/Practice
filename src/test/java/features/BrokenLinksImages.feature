Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks elements
And user clicks on Broken Links and Images

@BrokenImages
Scenario: Test broken images
Then user verifies if image is broken
And user verifies if image is not broken

@BrokenLinks
Scenario: Test broken links
Then user verifies if link is broken
And user verifies if link is not broken