package endpoints.foreignExchangeRates;

import client.BaseClient;
import io.restassured.response.Response;

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

    private ExchangeRatesResponse getResponse(Response response) {
        ExchangeRatesResponse exchangeRatesResponse = response.as(ExchangeRatesResponse.class);
        exchangeRatesResponse.setHttpStatusCode(response.getStatusCode());
        return exchangeRatesResponse;
    }

}
