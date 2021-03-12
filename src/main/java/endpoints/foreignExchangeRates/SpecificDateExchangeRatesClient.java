package endpoints.foreignExchangeRates;

import client.BaseClient;
import io.restassured.response.Response;

public class SpecificDateExchangeRatesClient extends BaseClient {

    public ExchangeRatesResponse getSpecificForeignExchangeRatesData(String date) {
        Response response = get(PAST_EXCHANGE_RATES_HOST, date);
        return getResponse(response);
    }

    public ExchangeRatesResponse getSpecificDateForeignExchangeRatesBasedOnSymbol(String date, String symbolValue) {
        Param symbol = new Param("symbol", symbolValue);
        Response response = get(PAST_EXCHANGE_RATES_HOST, date, symbol);
        return getResponse(response);
    }

    private ExchangeRatesResponse getResponse(Response response) {
        ExchangeRatesResponse exchangeRatesResponse = response.as(ExchangeRatesResponse.class);
        exchangeRatesResponse.setHttpStatusCode(response.getStatusCode());
        return exchangeRatesResponse;
    }
}
