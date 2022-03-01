Feature: Verifying Calm ReliefFactor and place order

  Scenario Outline: Placing Order with Energy in Relief Factor website
    Given Launching ReliefFactor URL
    And Click Products
    And Click Energy
    And Click Order Now button
    And Click 1 Bottle Option button
    And Click 1 Bottle Radio button
    Then Click Order Now button again
    When Entering "<FirstName>","<LastName>","<Email>","<PhoneNumber>"
    And Clicking Contine to shipping button
    When Entering "<StreetAddress>"
    And Clicking Contine to Payment button
    And Entering "<CardNumber>","<ExpiryMonth>","<ExpiryYear>" and "<CVV>"
    And Click Review your order button
    And Click CheckBox
    Then Click Complete Order button

    Examples: 
      | FirstName | LastName | Email         | PhoneNumber | StreetAddress   | CardNumber          | ExpiryMonth | ExpiryYear | CVV |
      | ABC       | DE       | abc@gmail.com |  1234567846 | 1 Apple ParkWay | 4000 0000 0000 0002 | January     |       2027 | 456 |