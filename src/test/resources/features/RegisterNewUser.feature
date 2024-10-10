Feature:Register new user

  @UI @Run
  Scenario Outline: Register new user
    Given User navigates to the home page
    And User clicks on Register button
    And User insert <firstName>, <lastName>
    And User insert <city>, <address>
#    And User insert <state>, <zipCode>
#    And User insert <phone>, <ssn>

    Examples:
      | username | password | city     | firstName | lastName | browserName | address   | state    | zipCode | phone  | ssn   |
      | sorin    | 123      | chisinau | sorea     | cuce     | chrome      | korolinko | chisinau | 2025    | 060372 | 12345 |
#      | sorin    | 123      |      |           |          | firefox     |