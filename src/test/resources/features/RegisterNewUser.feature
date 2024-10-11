Feature:Register new user

  @UI @Run
  Scenario Outline: Register new user
    Given User navigates to the home page
    And User clicks on Register button
    And User insert all necessary information for register page
      | firstName | lastName | address   | city     | state    | zipCode | phone   | ssn   |
      | sorea     | cuce     | korolinko | chisinau | chisinau | 2025    | 0690377 | 12345 |
    And User has <error> message
      | userNameIsRequired    | passwordIsRequired    | confirmPasswordIsRequired          |
      | Username is required. | Password is required. | Password confirmation is required. |
    And User insert <username> and <password>
    Then User has a <message>


    Examples:
      | username | password | error                         | message              |
      | madam    | 123      | Complite all mandatory fields | register with sucess |
