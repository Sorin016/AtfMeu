Feature: First

  @Run
  Scenario Outline: Incercarea prima
    Given User login on the site with <username> and <password>
    And User opens new <accountType> and <accountID> for <customerID>
    When User checks that new account was created with success

#    And User is
    Examples:
      | username | password | accountType | customerID | accountID |
      | level    | 123      | saveing     | 12434      |  13566     |
#      | fas      | 123      | saveing |          | 16430      |
#      | fas      | 123      | saveing |          | 17873     |
#      | fas      | 123      | saveing |          | 17984     |
#      | fas      | 123      | saveing |          | 14987     |
#      | fas      | 123      | checking |          |