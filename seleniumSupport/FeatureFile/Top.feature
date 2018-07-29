
Feature: Log in Feature
Scenario: Check with valid credential
Given Navigate to the log In page
When userEnter userName 
And Password
Then logIn is sucessfull  

