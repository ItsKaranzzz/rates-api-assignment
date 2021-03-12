package stepDefs;

import endpoints.foreignExchangeRates.ExchangeRatesResponse;
import endpoints.foreignExchangeRates.SpecificDateExchangeRatesClient;
import io.cucumber.java8.En;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static utils.GetExchangeRateData.*;

public class SpecificDateForeignExchangeRateSteps implements En {
    SpecificDateExchangeRatesClient specificDateExchangeRatesClient;
    ExchangeRatesResponse exchangeRatesResponse;

    public SpecificDateForeignExchangeRateSteps() {
        When("^foreign exchange rates api for specific date is available$", () -> {
            specificDateExchangeRatesClient = new SpecificDateExchangeRatesClient();
        });
        Then("^the exchange rates api response for specific date should be successful$", () -> {
            exchangeRatesResponse = specificDateExchangeRatesClient.getSpecificForeignExchangeRatesData(CURRENT_DATE);
            assertEquals(exchangeRatesResponse.getHttpStatusCode(), 200, "current date FER response was not success");
        });
        Then("^the exchange rates api response on specific date should be expected for (\\w+) symbol$", (String symbol) -> {
            exchangeRatesResponse = specificDateExchangeRatesClient.getSpecificDateForeignExchangeRatesBasedOnSymbol(PAST_DATE, symbol);
            assertEquals(exchangeRatesResponse.date, PAST_DATE, "Specific date returned was not matching as per the get request");
            assertEquals(exchangeRatesResponse.rates.CAD, getExpectedExchangeRate(symbol), "Symbol value for specific date FER didnt match");
        });
        When("^future date is provided to the foreign exchange rates service", () -> {
            exchangeRatesResponse = specificDateExchangeRatesClient.getSpecificForeignExchangeRatesData(FUTURE_DATE);
        });
        Then("^the exchange rates api response should have the data based on current date$", () -> {
            assertEquals(exchangeRatesResponse.getHttpStatusCode(), 200, "Future specific FER response was not sucessful");
            assertNotEquals(exchangeRatesResponse.date, FUTURE_DATE, "data for future date is also getting retrieved");
        });
    }
}
