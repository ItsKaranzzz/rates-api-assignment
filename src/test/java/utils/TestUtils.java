package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static constants.Constants.EXCHANGE_RATES_DATA_FILE_PATH;

public class TestUtils {
    public static Double getConstantValue(String constantKey) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(EXCHANGE_RATES_DATA_FILE_PATH));
            JSONObject jsonObject = (JSONObject) obj;
            return (Double) jsonObject.get(constantKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
