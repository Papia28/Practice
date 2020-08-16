Feature: Test the drag and drop functionality

Background: ToolsQA Demo website is launched
Given application is launched

@DragAndDrop1
Scenario: Test dragging and dropping of items
When user clicks Interactions
Then Interactions page opens
When user selects Droppable
And user drags and drops item
Then text changes