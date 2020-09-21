Feature: Test drag and drop functionalities using Robot class functions

Background: ToolsQA Demo website is launched
Given application is launched

@DragAndDropRobot
Scenario: Test dragging and dropping of items using Robot class functions
When user clicks Interactions using Robot
Then Interactions page opens using Robot
When user selects Droppable using Robot
And user drags and drops item using Robot
Then text changes using Robot