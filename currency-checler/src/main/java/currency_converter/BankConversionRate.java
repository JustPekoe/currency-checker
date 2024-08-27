package currency_converter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankConversionRate {
    private final WebDriver driver;

    // Banks URL
    private static final String rbcUrl =
            "https://www.rbcbank.com/cgi-bin/tools/cadusd-foreign-exchange-calculator/start.cgi";
    private static final String tdUrl =
            "https://www.td.com/ca/en/personal-banking/solutions/exchange/currency-converter";


    public BankConversionRate(WebDriver driver) {
        this.driver = driver;
    }

    protected String rbcConversionRate(int cadAmount, String currency) {
        // Go to RBC's CAD to USD conversion calculator
        driver.get(rbcUrl);

        System.out.println(STR."Converting $\{cadAmount}CAD to \{currency}");
        String convertedAmount = null;

        // Add input to the "Current I Have"
        WebElement currencyHaveAmount = driver.findElement(By.id("currency-have-amount"));
        currencyHaveAmount.sendKeys(String.valueOf(cadAmount));

        // Pressing enter without a specific target
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        // Get the currency that I want after conversion is completed
        WebElement currencyWantAmount = driver.findElement(By.id("currency-want-amount"));

        convertedAmount = currencyWantAmount.getAttribute("value");

        return convertedAmount;
    }

    protected String tdConversionRate(int cadAmount, String currency) {
        // Go to TD's CAD to USD conversion calculator
        driver.get(tdUrl);

        System.out.println(STR."Converting $\{cadAmount}CAD to \{currency}");
        String convertedAmount = null;

        // Add input to the "Current I Have"
        WebElement currencyHaveAmount = driver.findElement(By.id("currency-have-amount"));
        currencyHaveAmount.sendKeys(String.valueOf(cadAmount));

        // Pressing enter without a specific target
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        // Get the currency that I want after conversion is completed
        WebElement currencyWantAmount = driver.findElement(By.id("currency-want-amount"));

        convertedAmount = currencyWantAmount.getAttribute("value");
        
        return convertedAmount;
    }
}
