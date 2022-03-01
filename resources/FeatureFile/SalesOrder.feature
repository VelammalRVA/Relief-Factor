Feature: Verifying Sales Order in Magnento and place order
  I want to use this template for my feature file

  Scenario Outline: Placing Order with Sales in Magnento website
    Given Launching ReliefFactor URL
    When Entering "<UserName>","<Password>" and click Login button
    And click Sales button
    And click Orders button
    And click Create New Order button
    And click Create New Customer button
    And click Add products and Selected button
    When Entering "<Email>","<FirstName>","<LastName>","<StreetAdress>","<Country>","<State>","<City>","<PostalCode>","<PhoneNumber>","<CreditCardType>","<CreditCardNo>","<ExpiryMonth>","<ExpiryYear>","<CVV>"
    And click Shipping Method
    And Submit button

    Examples: 
      | UserName   | Password | Email          | FirstName | LastName | StreetAdress    | Country       | State      | City      | PostalCode | PhoneNumber | CreditCardType | CreditCardNo        | ExpiryMonth  | ExpiryYear | CVV |
      | testuser01 | test123  | ross@gmail.com | ross      | Geller   | 1 Apple ParkWay | United States | California | Cupertino |      95014 |  1234567846 | Visa           | 4000 0000 0000 0002 | 01 - January |       2027 | 643 |
