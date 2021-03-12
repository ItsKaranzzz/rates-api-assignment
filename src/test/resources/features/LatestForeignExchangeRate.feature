Feature: Validate the rates apis for latest foreign exchange rates

  Background:
    When foreign exchange rates api is available

  Scenario: Verify successful retrieval of latest exchange rate service
    Then the exchange rates api response should be successful

  Scenario: Verify exchange rate retrieved for CZK symbol
    Then the exchange rates api response should be expected for CZK symbol

  Scenario: Verify invalid latest exchange rate api
    When foreign exchange rates api is not correct
    Then the exchange rates api response should not be successful
