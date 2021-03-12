package stepDefs;

import endpoints.foreignExchangeRates.ExchangeRatesResponse;
import endpoints.foreignExchangeRates.LatestExchangeRatesClient;
import io.cucumber.java8.En;

import static constants.StatusCodes.NOT_FOUND_STATUS_CODE;
import static constants.StatusCodes.SUCCESS_CODE;
import static org.testng.Assert.assertEquals;
import static utils.GetExchangeRateData.getExpectedExchangeRate;

public class LatestForeignExchangeRateSteps implements En {
    LatestExchangeRatesClient latestExchangeRatesClient;
    ExchangeRatesResponse exchangeRatesResponse;

    public LatestForeignExchangeRateSteps() {
        Given("^foreign exchange rates api is available$", () -> {
            latestExchangeRatesClient = new LatestExchangeRatesClient();
        });
        Then("^the latest foreign exchange rates service response should be successful$", () -> {
            exchangeRatesResponse = latestExchangeRatesClient.getLatestForeignExchangeRatesData();
            assertEquals(exchangeRatesResponse.getHttpStatusCode(), SUCCESS_CODE, "Latest exchange rate api status was not successful");
        });
        When("^foreign exchange rates api is not correct$", () -> {
            exchangeRatesResponse = new LatestExchangeRatesClient().getForeignExchangeRatesWithInvalidUri();
        });
        Then("^the exchange rates api response should not be successful$", () -> {
            assertEquals(exchangeRatesResponse.getHttpStatusCode(), NOT_FOUND_STATUS_CODE, "Api not found error code didn't matched!");
            assertEquals(exchangeRatesResponse.getError(), "Requested URL /api/latest/apii not found", "No error retrieved");
        });
        Then("^the exchange rates api response should be expected for (\\w+) symbol$", (String symbol) -> {
            exchangeRatesResponse = new LatestExchangeRatesClient().getLatestForeignExchangeRatesBasedOnSymbol(symbol);
            assertEquals(exchangeRatesResponse.base, "EUR", "base returned was not expected");
            Double expectedValue = getExpectedExchangeRate(symbol);
            assertEquals(exchangeRatesResponse.rates.CZK, expectedValue, "symbol " + symbol + " value returned was not " + expectedValue);
        });
    }
}
