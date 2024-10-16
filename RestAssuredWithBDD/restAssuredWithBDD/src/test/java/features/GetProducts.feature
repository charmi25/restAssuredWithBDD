
  Feature: Get all products from the api

    Scenario: Verify the get api for the products
      Given I hit the url of get products api endpoint
      When I pass the url of products in the request
      Then I receive the response code as 200


    Scenario Outline: Verify the rate of the first product is correct
      Given I hit the url of get products api endpoint
      When I pass the url of products in the request
      Then I verify that the rate of the first product is <FirstProductRate>
      Examples:
        | FirstProductRate |
        | 3.9              |
        
        
        Scenario Outline: validate post product api status code works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response code as 200
   Examples:
     | ProductTitle |
     | Shoes        |

  Scenario Outline: validate post product api response body works correctly
    Given I hit the url of post product api endpoint
    When I pass the url of products in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response body with id as <id>
    Examples:
      | ProductTitle | id |
      | Shoes        | 21 |
      
      
       Scenario Outline: validate delete product api status code works correctly
    Given I hit the url of delete product api endpoint
    When I pass the url of delete products in the request with <Productnumber>
    Then I receive the response code as 200
   Examples:
     | Productnumber |
     | 5             |
          Scenario Outline: validate put product api status code works correctly
    Given I hit the url of put product api endpoint
    When I pass the url of products in the request with <Productnumber>
    Then I receive the response code as 200
   Examples:
     | Productnumber |
     | 6             |