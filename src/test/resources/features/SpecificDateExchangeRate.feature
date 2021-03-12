Feature: Validate the rates apis for foreign exchange rates on specific dates

  Background:
    Given foreign exchange rates api for specific date is available

  @smoke
  Scenario:
    Then the exchange rates api response for specific date should be successful

  @smoke
  Scenario:
    Then the exchange rates api response on specific date should be expected for CAD symbol

  @regression
  Scenario:
    When future date is provided to the foreign exchange rates service
    Then the exchange rates api response should have the data based on current date
