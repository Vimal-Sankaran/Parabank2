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
    And I enter username "john_demo1942" in registration page
    And I enter password "demo123" in registration page
    And I enter confirm password "demo123" in registration page
    When I click register button in registration page
    Given I click New Account link to open account
    Given I select savings accounts in dropdown"1"
    Given I click open account
    Given I navigate to new account details page
    Then I capture new account details to json file"TC03"



    Scenario: Create a new savings account and capture details to json file
      Given I register customer with json "TC03"
      Given I click New Account link to open account
      Given I select savings accounts in dropdown"1"
      Given I click open account
      Given I navigate to new account details page
      Then I capture new account details to json file"TC03"

  Scenario: Bill payment
    Given I register customer with json "TC03"
    And I create savings"1" account
    Then I capture new account details to json file"TC03"
    Given I click Bill Payment link from home page
    And I make bill payment"100.00" from savings account1 to Payee "TC02" using json file"TC03"

    Scenario: Update Customer information and store them in Json
      Given I register customer with json "TC03"
      And I create savings"1" account
      Given I click Update Contact information link
      And I update the address"1 Kings street" and phone"987654324567"
      And I click update profile button
      Then I validate the update message
      And I update customer info"1 Kings street","987654324567" in Json"TC01"
