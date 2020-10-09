Feature: To test the functionalities of the AUT

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks on Alerts Frames and Windows
Then Alerts Frames and Windows page opens

@BrowserWindows
Scenario: Test new tab
Given user clicks Browser Windows
When user clicks New Tab
Then new tab is opened
And user prints text in it
And user switches back to parent window

@BrowserWindows
Scenario: Test new window
Given user clicks Browser Windows
When user clicks New Window
Then new window is opened
And user prints text in it
And user switches back to parent window

@BrowserWindows
Scenario: Test new window message
Given user clicks Browser Windows
When user clicks New Window Message
Then new message window is opened
#And user prints text in it
And user switches back to parent window