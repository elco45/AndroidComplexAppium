Feature: Verify something appears after clicking any option in graphics
meow

Scenario Outline: There are elements
Given The list of elements in graphics
When Click on "<arg1>" button
Then I can view a "<arg2>" image


Examples:
|   arg1           |   arg2         |
|   Clipping       |   Clipping     |
|   Layers         |   Layers       |
|   SensorTest     |   SensorTest   |