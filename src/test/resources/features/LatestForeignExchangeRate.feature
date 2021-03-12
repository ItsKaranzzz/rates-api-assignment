Feature: Validate the rates apis for latest foreign exchange rates

  Background:
    Given foreign exchange rates api is available

  @smoke
  Scenario: Verify successful retrieval of latest exchange rate service
    Then the exchange rates api response should be successful

  @smoke
  Scenario: Verify exchange rate retrieved for CZK symbol
    Then the exchange rates api response should be expected for CZK symbol

  @regression
  Scenario: Verify invalid latest exchange rate api
    When foreign exchange rates api is not correct
    Then the exchange rates api response should not be successful
