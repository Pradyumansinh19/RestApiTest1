#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Perform opration on library API

 
  Scenario Outline: Add  book to library
    Given Add book with "<name>" "<isbn>" "<aisle>" "<author>"
  
    When user call "add" with "POST" method
   
   
    Then API call got successfull with status code 200
    
   Examples:
   |	name	|	isbn	|	aisle	|	author	|
   |	KP4		|	kp1		|	1211	|		kp4		|
   
   Scenario: Delete book from library
   Given delete book with "ID"
   When user call "delete" with "POST" method
   Then API call got successfull with status code 200
   

