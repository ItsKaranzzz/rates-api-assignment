package endpoints.foreignExchangeRates;

import client.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExchangeRatesResponse extends BaseResponse {

    private String base;
    private Rates rates;
    private String date;
    private String error;

    @Getter
    @Setter
    public static class Rates {
        private Double GBP;
        private Double HKD;
        private Double IDR;
        private Double ILS;
        private Double DKK;
        private Double INR;
        private Double CHF;
        private Double MXN;
        private Double CZK;
        private Double SGD;
        private Double THB;
        private Double HRK;
        private Double MYR;
        private Double NOK;
        private Double CNY;
        private Double BGN;
        private Double PHP;
        private Double SEK;
        private Double PLN;
        private Double ZAR;
        private Double CAD;
        private Double ISK;
        private Double BRL;
        private Double RON;
        private Double NZD;
        private Double TRY;
        private Double JPY;
        private Double RUB;
        private Double KRW;
        private Double HUF;
        private Double AUD;
    }
}
