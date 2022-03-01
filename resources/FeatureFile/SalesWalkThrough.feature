Feature: Verifying saleswalkthrough in Magnento and place order
 
  Scenario Outline: Placing Order with Saleswalkthrough in Magnento website
    Given Launching ReliefFactor URL
    When Entering "<UserName>","<Password>" and click Login button
    And click Sales button
    And click Saleswalkthrough button
    And click ReliefFactor button
    When Entering "<FirstName>","<LastName>"
    And click Save and Continue button
    And Click First-time customer button
    And click Week Quickstart
    And clicking Two Save and Continue button
    When click Checkbox button
    And clicking Double Save and Continue button
    When Enter "<StreetAddress>","<City>","<Country>","<State>","<PostalCode>","<Telephone>"
    And Click Three checkBox button
    And clicking Save & Continue button
    And Click CheckBox for Billing Address button
    When clicking Save and Continue button
    When Entering "<CardNumber>","<ExpiryMonth>","<ExpiryYear>" and "<CVV>"
    And Click Save and Process button
    Then Click OrderNo button

    Examples: 
      | UserName   | Password | FirstName | LastName | StreetAddress   | City      | Country       | State      | PostalCode | Telephone  | CardNumber          | ExpiryMonth  | ExpiryYear | CVV |
      | testuser01 | test123  | Chadle    | Bo       | 1 Apple ParkWay | Cupertino | United States | California |      95014 | 1234567846 | 4000 0000 0000 0002 | 01 - January |       2027 | 456 |
