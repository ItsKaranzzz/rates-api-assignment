package endpoints.foreignExchangeRates;

import client.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExchangeRatesResponse extends BaseResponse {

    public String base;
    public Rates rates;
    public String date;
    public String error;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rates {
        public Double GBP;
        public Double HKD;
        public Double IDR;
        public Double ILS;
        public Double DKK;
        public Double INR;
        public Double CHF;
        public Double MXN;
        public Double CZK;
        public Double SGD;
        public Double THB;
        public Double HRK;
        public Double MYR;
        public Double NOK;
        public Double CNY;
        public Double BGN;
        public Double PHP;
        public Double SEK;
        public Double PLN;
        public Double ZAR;
        public Double CAD;
        public Double ISK;
        public Double BRL;
        public Double RON;
        public Double NZD;
        public Double TRY;
        public Double JPY;
        public Double RUB;
        public Double KRW;
        public Double HUF;
        public Double AUD;
    }
}
