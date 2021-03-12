package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Objects;

public class TestUtils {
    public static String getConstantValue(String constantKey) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/test/java/utils/TestUtils"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray constantValue = (JSONArray) jsonObject.get(constantKey);

            return constantValue.toJSONString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double getExpectedExchangeRate(String symbol) {
        Double value = Double.valueOf(Objects.requireNonNull(getConstantValue(symbol)));
        return value;
    }

}
