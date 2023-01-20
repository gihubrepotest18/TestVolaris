Feature: Volaris

  Scenario: Validate volaris search
    Given I am in volaris page
    When I select currency "English" and language "Dólares americanos - USD"
    Then I select "Guadalajara" as departure and "Seattle" as destination
    And I select next future month in departure and return day
    And I return the day with lowest price
    And I return the day with highest price

