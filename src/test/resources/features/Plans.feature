Feature: CSR Plans Page Feature

  @US_8
  Scenario: Validate Plans are exist in table
    Given Login with username as "supervisor" and password as "tek_supervisor"
    When Wait 2 Second
    When Click on "Plans" Link
    When Wait 4 Second
    Then Validate Section title is "Plans"
    Then Validate Table row is 4
    And Validate All Plans are Valid