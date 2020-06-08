Feature: Test the drag and drop functionality

Background: Selenium Easy Demo website is launched
Given application is launched
When popups have been closed
Then Others option is visible
When user clicks Others
Then Others dropdown opens
And user selects Drag and Drop

@Others
@DragAndDrop
@Functional
Scenario: Test dragging and dropping of items
When user drags and drops all items
Then all items displayed in list