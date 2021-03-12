package client;

import constants.Constants;
import utils.Utils;

import java.util.Properties;

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


}
