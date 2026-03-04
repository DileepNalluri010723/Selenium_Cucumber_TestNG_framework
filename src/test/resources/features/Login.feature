Feature: Login feature

Scenario Outline: Login functionality check
Given User is on the login page
When User enters the '<UserName>' and '<Password>'
Then User should be logged in succesfully
Examples:
|UserName|Password|
|standard_user|secret_sauce|


Scenario Outline: Invalid Login functionality check
Given User is on the login page
When User enters the '<UserName>' and '<Password>'
Then User should see the error message '<ErrorMessage>'
Examples:
|UserName|Password|ErrorMessage|
|standard_user|test|Epic sadface: Username and password do not match any user in this service|

Scenario Outline: Login functionality check
Given User is on the login page
When User enters the '<UserName>' and '<Password>'
Then User should be logged in succesfully
Examples:
|UserName|Password|
|standard_user|secret_sauce|


Scenario Outline: Invalid Login functionality check
Given User is on the login page
When User enters the '<UserName>' and '<Password>'
Then User should see the error message '<ErrorMessage>'
Examples:
|UserName|Password|ErrorMessage|
|standard_user|test|Epic sadface: Username and password do not match any user in this service|