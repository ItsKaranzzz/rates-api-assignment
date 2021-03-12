Feature: Validate the rates apis for foreign exchange rates on specific dates

  Background:  When foreign exchange rates api is available

  Scenario:
    Then the exchange rates api response for specific date should be successful

  Scenario:
    Then the exchange rates api response on specific date should be expected for CZK symbol

  Scenario:
    When a future date is provided to the foreign exchange rates api
    Then the exchange rates api response should have the data based on current date

