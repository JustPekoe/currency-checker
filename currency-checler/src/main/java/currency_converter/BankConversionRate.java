package currency_converter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    protected String rbcConversionRate(int cadAmount, String currency) {
        System.out.println(STR."Converting $\{cadAmount}CAD to \{currency}");
        String convertedAmount = null;

        // Add input to the "Current I Have"
        WebElement currencyHaveAmount = driver.findElement(By.id("currency-have-amount"));
        currencyHaveAmount.sendKeys(Stråing.valueOf(cadAmount));

        // Pressing enter without a specific target
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        // Get the currency that I want after conversion is completed
        WebElement currencyWantAmount = driver.findElement(By.id("currency-want-amount"));




        return convertedAmount;
    }

    protected String tdConversionRate(int cadAmount, String currency) {
        return null;
    }

}
