package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestUtils {
    public static Double getConstantValue(String constantKey) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData/ExchangeRates.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (Double) jsonObject.get(constantKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
