Feature: Validating Accounts Table

Background: Login step repeat for each scenario
  Given Login with username as "supervisor" and password as "tek_supervisor"
  When Wait 2 Second


  @US_9
  Scenario: Validate Account Table rows

    When Click on "Accounts" Link
    When Wait 60 Second
    Then Validate accounts table has 10 rows

@US_10
    Scenario: Validate Change Item per page
      When Click on "Accounts" Link
      When Wait 60 Second
      Then Validate accounts table has 10 rows
      When change item per page to "25"
      When Wait 2 Second
      Then Validate accounts table has 25 rows
       When change item per page to "5"
      When Wait 2 Second
      Then Validate accounts table has 5 rows
      When change item per page to "100"
      When Wait 2 Second
      Then Validate accounts table has 100 rows





