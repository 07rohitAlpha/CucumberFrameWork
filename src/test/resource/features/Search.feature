Feature: Search functionality

Scenario: User searches for a valid product
Given user opens the Application
When user enetrs valid product "HP" inti Search box filed
And user clicks on searhc button
Then user should get valid product displayed in search results

Scenario: user searches for an invalid product
Given user opens the application 
When user enters invalid product "Honda" into search box filed
And user clicks on search button
Then user should get a message about no product matching

Scenario: user searches without any product
Given user opens the application 
When user dont enter any product name into search bos filed 
And user clicks on Search button
Then user should get a message about no product matching

