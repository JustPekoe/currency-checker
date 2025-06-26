package currency_converter;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

        // Validate the heading of the page
        WebElement pageHeading = driver.findElement(By.id("page-title"));
        String actualText = pageHeading.getText();
        String expectedText = "CAD ⇔ USD | USD ⇔ CAD Currency Converter";
        Assertions.assertEquals(expectedText, actualText);

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("currency-have-amount")));

        // Clear existing text and input new text
        inputElement.clear();
        inputElement.sendKeys("100");

        /*WebElement currencyHaveAmount = driver.findElement(By.id("currency-have-amount"));
        currencyHaveAmount.sendKeys(String.valueOf(cadAmount));

        // Pressing enter without a specific target
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        // Get the currency that I want after conversion is completed
        WebElement currencyWantAmount = driver.findElement(By.id("currency-want-amount"));

        convertedAmount = currencyWantAmount.getAttribute("value");
        */
        System.out.println("Got to here");
        return convertedAmount;
    }
}



/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    @Test
    public void successfulLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("your_login_page_url");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("valid_username");
        passwordField.sendKeys("valid_password");
        loginButton.click();

        //Assuming after successful login, the page redirects to "/dashboard"
        Assertions.assertEquals("your_dashboard_url", driver.getCurrentUrl(), "Login failed, incorrect URL");

        driver.quit();
    }

     @Test
    public void invalidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("your_login_page_url");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("invalid_username");
        passwordField.sendKeys("invalid_password");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error-message"));

         //Assuming after invalid login, error message is displayed
        Assertions.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
        Assertions.assertEquals("Invalid username or password", errorMessage.getText(), "Incorrect error message");

        driver.quit();
    }
}
 */