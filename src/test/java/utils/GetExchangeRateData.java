package utils;

import static java.util.Objects.requireNonNull;
import static utils.TestUtils.getConstantValue;

public class GetExchangeRateData {
    public static final String CURRENT_DATE = "2021-03-12";
    public static final String PAST_DATE = "2019-03-05";
    public static final String FUTURE_DATE = "2022-06-01";

    public static Double getExpectedExchangeRate(String symbol) {
        return requireNonNull(getConstantValue(symbol));
    }
}
