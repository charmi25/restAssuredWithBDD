Feature: Validating the Products API

Scenario: Verify GET Products API
 Given I hit get products api
 When I pass url in request
 Then I validate response code as 200
