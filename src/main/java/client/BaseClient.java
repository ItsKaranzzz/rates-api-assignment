package client;

import constants.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import utils.Utils;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BaseClient {

    public String LATEST_EXCHANGE_RATES_HOST = getLatestExchangeRatesHost();
    public String PAST_EXCHANGE_RATES_HOST = getPastExchangeRatesHost();

    private String getLatestExchangeRatesHost() {
        return readProperties().getProperty("LATEST_FOREIGN_EXCHANGE_RATE");
    }

    private String getPastExchangeRatesHost() {
        return readProperties().getProperty("SPECIFIC_DATE_EXCHANGE_RATE");
    }

    private Properties readProperties() {
        return Utils.getProperty(Constants.CONFIG_FILE_PATH);
    }

    public Response get(String uri) {
        return given()
                .contentType(ContentType.JSON)
                .get(uri);
    }

    public Response get(String uri, Param queryParam) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam(queryParam.key, queryParam.value)
                .get(uri);
    }

    public Response get(String uri, String pathParam) {
        return given()
                .contentType(ContentType.JSON)
                .get(uri + "/" + pathParam);
    }

    public Response get(String uri, String pathParam, Param queryParam) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam(queryParam.key, queryParam.value)
                .get(uri + "/" + pathParam);
    }

    @Getter
    @Setter
    public static class Param {
        String key;
        String value;

        public Param(String symbol, String symbolValue) {
            this.key = symbol;
            this.value = symbolValue;
        }
    }
}
