Feature: Sign in as New User and Purchase a Product

  Scenario: Sign In as New User and Log into site and Add Products to cart and Purchase

    Given I Should Go sign up as a new user and sign in to Page
    And Direct to Dresses Tab and Select Items and add to Cart
 
    
    When I Go to check out in the drop down and Increase the quantity 
 

    Then I should Proceed with check out process and select Pay by check
    And Verify the order is completed