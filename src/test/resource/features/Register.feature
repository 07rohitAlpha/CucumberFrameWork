Feature: Registration functionality

Scenario: User creates an account only with mandatroy fields
Given User navigates to Register into below fields
When User enters the details into below fields 
|firstName |Rohit                    |
|lastName  |Kumar                    |
|email     |urbanrohita07@gmail.com  |
|telephone |9876543222               |
|password  |12345                    |
And user selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: user creates an account with all fileds
Given User navigate to Register into below fileds
When User enters the details into below fileds
|firstName   |Rohit                    |
|lastName    |Kumar                    |
|email       |urbanrohita07@gmail.com  |
|telephone   |9876543222               |
|password    |12345                    |
And user selects Yes for Newsletter
And user selects Privacy Policy     
And user clicks on Continue button
Then user account should get created successfully

Scenario: user creates a duplicate account
Given User navigate to Register into below fileds
When User enters the details into below fileds
|firstName   |Rohit                    |
|lastName    |Kumar                    |
|email       |urbanrohita07@gmail.com  |
|telephone   |9876543222               |
|password    |12345                    |
And user selects Yes for Newsletter
And user selects Privacy Policy     
And user clicks on Continue button
Then user should get a proper warning about duplicate email

Scenario: user creates an account without filling any details
Given user navigate to register into below fileds
When user dont enter any details into fileds 
And Click on Continue button
Then user should get proper warning message for every mandatory filed






