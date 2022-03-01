Feature: Verifying ReliefFactor and place order

  Scenario Outline: Placing Single Order in Relief Factor website
    Given Launching ReliefFactor URL
    And Click Order button
    When Entering "<FirstName>","<LastName>","<Email>" and "<Phone>"
    And Clicking Contine to Shopping button
    When Entering "<StreetAddress>"
    And Clicking Contine to Payment button
    And Entering "<CardNumber>","<ExpiryMonth>","<ExpiryYear>","<CVV>"
    And Click Review your order button
    Then Click Complete Order button

    Examples: 
      | FirstName | LastName | Email         | Phone      | StreetAddress   | CardNumber          | ExpiryMonth | ExpiryYear | CVV |
      | ABC       | DE       | abc@gmail.com | 1234567846 | 1 Apple ParkWay | 4000 0000 0000 0002 | January     |       2027 | 456 |