package currency_converter;

import org.openqa.selenium.WebDriver;

public class CreditCardConversionRate {
    private WebDriver driver;

    // Credit card companies URL
    private static final String mastercardUrl =
            "https://www.mastercard.ca/en-ca/personal/get-support/convert-currency.html";
    private static final String visaUrl =
            "https://www.visa.ca/en_CA/support/consumer/travel-support/exchange-rate-calculator.html";


    public CreditCardConversionRate(WebDriver driver) {
        this.driver = driver;
    }
    protected String mastercardConversionRate(int cadAmount, String currency) {
        return null;
    }

    protected String visaConversionRate(int cadAmount, String currency) {
        return null;
    }

}
