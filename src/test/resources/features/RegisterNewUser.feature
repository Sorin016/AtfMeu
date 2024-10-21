Feature:Register new user

  @UI
  Scenario Outline: Register new user

    Given User clicks on Register button
    And User inserts all necessary information for register page
      | firstName | lastName | address   | city     | state    | zipCode | phone   | ssn   |
      | sorea     | cuce     | korolinko | chisinau | chisinau | 2025    | 0690377 | 12345 |
    And User has <error> message
      | userNameIsRequired    | passwordIsRequired    | confirmPasswordIsRequired          |
      | Username is required. | Password is required. | Password confirmation is required. |
    And User inserts <username> and <password>
    Then User has a <message>


    Examples:
      | username | password | error                         | message              |
      | madam1   | 123      | Complite all mandatory fields | register with sucess |
      | level1   | 123      | Complite all mandatory fields | register with sucess |

  @UI
  Scenario Outline: Open new account
    Given User find and inserts <username> and <password>
    And User clicks on Login button
    And User has a <message>
    When User navigates to the Open New Account Page
    And User select <account type>
    And User choose last existing account to transfer funds into the new account
    Then User clicks on Open New Account button
    And User has opened an account
    And User checks the new account details


    Examples:
      | username | password | message           | account type |
      | lulu     | 123      | Accounts Overview | CHECKING     |
      | lulu     | 123      | Accounts Overview | SAVINGS      |

