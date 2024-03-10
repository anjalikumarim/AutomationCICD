
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page
  @tag2
  Scenario: Title of your scenario
    Given Logged in  <username> and <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
   
    Then "Thank you for the order." message is displayed on Confirmation page

 

    Examples: 
      | name         	 		|	password			|productName		|
      | kanu12@gmail.com	|Abc@1234567890	|ADIDAS ORIGINAL| 				
