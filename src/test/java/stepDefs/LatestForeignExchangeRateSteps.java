package stepDefs;

import endpoints.foreignExchangeRates.ExchangeRatesResponse;
import endpoints.foreignExchangeRates.LatestExchangeRatesClient;
import io.cucumber.java8.En;
import utils.TestUtils;

import static org.testng.Assert.assertEquals;

public class LatestForeignExchangeRateSteps implements En {
    LatestExchangeRatesClient latestExchangeRatesClient;
    ExchangeRatesResponse exchangeRatesResponse;

    public LatestForeignExchangeRateSteps() {
        When("^foreign exchange rates api is available$", () -> {
            latestExchangeRatesClient = new LatestExchangeRatesClient();
        });
        Then("^the exchange rates api response should be successful$", () -> {
            latestExchangeRatesClient = new LatestExchangeRatesClient();
            assertEquals(latestExchangeRatesClient.getLatestForeignExchangeRatesData().getHttpStatusCode(), 200, "Latest exchange rate api status was not successful");
        });
        When("^foreign exchange rates api is not correct$", () -> {
            latestExchangeRatesClient = new LatestExchangeRatesClient();
            exchangeRatesResponse = latestExchangeRatesClient.getForeignExchangeRatesWithInvalidUri();
        });
        Then("^the exchange rates api response should not be successful$", () -> {
            assertEquals(exchangeRatesResponse.getHttpStatusCode(), 404, "Api not found error code didn't matched!");
            assertEquals(exchangeRatesResponse.getError(), "Requested URL /api/latest/apii not found", "No error retrieved");
        });
        Then("^the exchange rates api response should be expected for (\\w+) symbol$", (String symbol) -> {
            latestExchangeRatesClient = new LatestExchangeRatesClient();
            ExchangeRatesResponse exchangeRatesResponse = latestExchangeRatesClient.getLatestForeignExchangeRatesBasedOnSymbol(symbol);
            assertEquals(exchangeRatesResponse.getBase(), symbol, "base returned was not expected");
            Double expectedValue = TestUtils.getExpectedExchangeRate(symbol);
            assertEquals(exchangeRatesResponse.getRates().getGBP(), expectedValue, "symbol " + symbol + "value returned was not expected");
        });
    }
}
