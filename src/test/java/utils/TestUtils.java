package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static java.util.Objects.requireNonNull;

public class TestUtils {
    public static Double getConstantValue(String constantKey) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData/ExchangeRates.json"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.

            return (Double) jsonObject.get(constantKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double getExpectedExchangeRate(String symbol) {
        return requireNonNull(getConstantValue(symbol));
    }

}
