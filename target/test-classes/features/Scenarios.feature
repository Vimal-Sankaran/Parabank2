Feature: ParaBank Customer Registration

  Scenario: Register a new customer in ParaBank

    Given I enter first name "John" in registration page
    And I enter last name "Smith" in registration page
    And I enter address "12 Anna Street" in registration page
    And I enter city "Chennai" in registration page
    And I enter state "TN" in registration page
    And I enter zip code "600001" in registration page
    And I enter phone number "9876543210" in registration page
    And I enter SSN "123456789" in registration page
    And I enter username "john_demo" in registration page
    And I enter password "demo123" in registration page
    And I enter confirm password "demo123" in registration page
    When I click register button in registration page