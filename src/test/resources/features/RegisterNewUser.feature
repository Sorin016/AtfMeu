Feature:Register new user

  @UI @Run
  Scenario Outline: Register new user
    Given User navigates to the home page
    And User clicks on <Register> button
#    And User insert
    Examples:
      | username | password | city | firstName | lastName | browserName |
      | sorin    | 123      |      |           |          | chrome      |
#      | sorin    | 123      |      |           |          | firefox     |