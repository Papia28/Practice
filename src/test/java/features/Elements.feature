Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks Elements

@BrokenImages
Scenario: Test broken images
When user clicks on Broken Links and Images
Then user verifies if image is broken
And user verifies if image is not broken

@BrokenLinks
Scenario: Test broken links
When user clicks on Broken Links and Images
Then user verifies if link is broken
And user verifies if link is not broken

@Textbox
Scenario: Test JDBC via Textbox
When user clicks Textbox
Then user writes fullname

@Upload
Scenario: Test the uploading a file functionality
Then user clicks on Upload and Download
And user clicks on choose a file
And user uploads a file
And chosen file is uploaded