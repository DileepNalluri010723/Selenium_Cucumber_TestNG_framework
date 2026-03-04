Feature: Cart feature

Scenario Outline: Add item to cart
Given User is on the login page
When User enters the '<UserName>' and '<Password>'
Then User should be logged in succesfully
When User clicks on Add to cart button for '<Product>'
Examples:
|UserName|Password|Product|
|standard_user|secret_sauce|Sauce Labs Backpack|
|standard_user|secret_sauce|Sauce Labs Bike Light|
|standard_user|secret_sauce|Sauce Labs Bolt T-Shirt|
|standard_user|secret_sauce|Sauce Labs Backpack|
|standard_user|secret_sauce|Sauce Labs Bike Light|
|standard_user|secret_sauce|Sauce Labs Bolt T-Shirt|

