Feature: Test the drag and drop functionality

Background: ToolsQA Demo website is launched
Given application is launched
When user clicks Interactions

@DragAndDrop
Scenario: Test dragging and dropping of items
Then Interactions page opens
When user selects Droppable
And user drags and drops item
Then text changes

@DragAndDropRobot
Scenario: Test dragging and dropping of items using Robot class functions
When user clicks Interactions using Robot
Then Interactions page opens using Robot
When user selects Droppable using Robot
And user drags and drops item using Robot
Then text changes using Robot