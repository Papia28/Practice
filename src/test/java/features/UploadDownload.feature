Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched

@Upload
Scenario: Test the uploading a file functionality
	When user clicks Elements
	And user clicks on Upload and Download
	And user clicks on choose a file
	And user uploads a file
	Then chosen file is uploaded