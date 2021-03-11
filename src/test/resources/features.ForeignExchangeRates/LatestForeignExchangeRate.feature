Feature: Validate the rates apis for latest foreign exchange rates

  Background:

  Scenario:
    When foreign exchange rates api is available
    Then the exchange rates api response should be successful

  Scenario:
    When foreign exchange rates api is available
    Then the exchange rates api response should have ...

  Scenario:
    When foreign exchange rates api is not correct
    Then the exchange rates api response should not be successful

