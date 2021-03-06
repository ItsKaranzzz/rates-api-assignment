package endpoints.foreignExchangeRates;

import client.BaseClient;
import io.restassured.response.Response;

import static constants.Constants.INVALID_LATEST_EXCHANGE_RATE_HOST;

public class LatestExchangeRatesClient extends BaseClient {

    public ExchangeRatesResponse getLatestForeignExchangeRatesData() {
        Response response = get(LATEST_EXCHANGE_RATES_HOST);
        return getResponse(response);
    }

    public ExchangeRatesResponse getLatestForeignExchangeRatesBasedOnSymbol(String symbolValue) {
        Param symbol = new Param("symbol", symbolValue);
        Response response = get(LATEST_EXCHANGE_RATES_HOST, symbol);
        return getResponse(response);
    }

    public ExchangeRatesResponse getForeignExchangeRatesBasedOnSpecificDate(String date) {
        Response response = get(LATEST_EXCHANGE_RATES_HOST, date);
        return getResponse(response);
    }

    public ExchangeRatesResponse getForeignExchangeRatesWithInvalidUri() {
        Response response = get(INVALID_LATEST_EXCHANGE_RATE_HOST);
        return getResponse(response);
    }

    private ExchangeRatesResponse getResponse(Response response) {
        ExchangeRatesResponse exchangeRatesResponse = response.as(ExchangeRatesResponse.class);
        exchangeRatesResponse.setHttpStatusCode(response.getStatusCode());
        return exchangeRatesResponse;
    }

}
