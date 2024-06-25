Feature: Login functionality

Scenario: Login with valid credentials
Given User navigate to login page
When  User enters valid email address "urbanrohita071@gmail.com" into email field
And   User enters valid password "123456" into password field
And   User clicks on login button
Then  User should get successfully logged in

Scenario: Login with invalid credentials
Given User navigate to login page
When User enters invalid email address into email field
And User enters invalid password "124537833" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid username and valid password 
Given User navigate to login page
When User enters invalid email address into email field
And User enters valid password "123345" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid username and invalid password
Given User navigate to login page
When  User enters valid email address "urbanrohita071@gmail.com" into email field
And   User enters invalid password "23211" into password field
And   User clicks on login button
Then  User should get a proper warning message about credentials mismatch


Scenario: Login without providing any credentails
Given User navigate to login page
When  User dont enters the email address into the email field 
And   User dont enters the password into the passowrd field
And   User clicks on login button
Then  User should get a proper warning message about credentials mismatch

