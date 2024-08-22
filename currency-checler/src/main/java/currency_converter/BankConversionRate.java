package currency_converter;

import org.openqa.selenium.WebDriver;

public class BankConversionRate {
    private WebDriver driver;

    // Banks URL
    private static final String rbcUrl =
            "https://www.rbcbank.com/cgi-bin/tools/cadusd-foreign-exchange-calculator/start.cgi";
    private static final String tdUrl =
            "https://www.td.com/ca/en/personal-banking/solutions/exchange/currency-converter";


    public BankConversionRate(WebDriver driver) {
        this.driver = driver;
    }
    protected int rbcConversionRate(int cadAmount, String currency) {
        System.out.println(STR."Converted $\{cadAmount}CAD to \{currency}");
        int convertedAmount = 0;


        return convertedAmount;
    }

    protected String tdConversionRate(int cadAmount, String currency) {
        return null;
    }

}
