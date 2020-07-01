Feature: add product to cart
  Scenario: add product without login
    Given user is on home page
    When user searching product
    And choose the product
    Then user add to cart
    Then the result is user must be logged

  Scenario: there is no product on the cart
    When user go to check page cart
    Then there is default caption for empty cart


  Scenario: add 3 product to cart after login
    When user is on login page
    Then User search product with keyword ROG
    Then user add 3 product to cart
    Then the counter product in cart is 3

  Scenario: delete 1 product after add cart
    When user is on cart page
    Then user delete product in chart
    Then the counter product in cart is 2




