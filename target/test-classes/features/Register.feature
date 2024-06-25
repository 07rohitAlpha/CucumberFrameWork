Feature: Registration functionality

Scenario: User creates an account only with mandatroy fields
Given User navigates to Register into below fields
When User enters the details into below fields 
|firstName |Rohit                    |
|lastName  |Kumar                    |
|telephone |9876543222               |
|password  |12345                    |
And user selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register into below fields
When User enters the details into below fields
|firstName   |Rohit                    |
|lastName    |Kumar                    |
|email       |urbanrohita072533@gmail.com  |
|telephone   |9876543222               |
|password    |12345                    |
And user selects Yes for Newsletter
And user selects Privacy Policy     
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register into below fields
When User enters the details into below fields with duplicate email
|firstName   |Rohit                    |
|lastName    |Kumar                    |
|email       |urbanrohita0444@gmail.com|
|telephone   |9876543223               |
|password    |12345                    |
And user selects Yes for Newsletter
And user selects Privacy Policy     
And User clicks on Continue button
Then user should get a proper warning about duplicate email

Scenario: user creates an account without filling any details
Given User navigates to Register into below fields
When user dont enter any details into fileds 
And User clicks on Continue button
Then user should get proper warning message for every mandatory field






