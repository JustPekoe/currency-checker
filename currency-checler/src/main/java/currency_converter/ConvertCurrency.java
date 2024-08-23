package currency_converter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConvertCurrency {
    private static final String WEBDRIVER_PATH = "~/IdeaProjects/currency-checler/chromedriver-mac-x64/chromedriver";
    public WebDriver driver;
    private int cadAmount;
    private String currency;

    @BeforeEach
    public void beforeEachTest() {
        System.setProperty("webdriver.chrome.driver", WEBDRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://www.telus.com/my-account");
    }

    @AfterEach
    public void afterEachTest() {
        driver.close();
    }

    // Go to bank URLs and scrape the page to determine the best currency rate
    private void openBankWebpages(){
        String[] listOfBanks = {"RBC", "TD"};
        String convertedRate =  null;

        BankConversionRate conversionRate = new BankConversionRate(driver);

        for (String bank : listOfBanks) {
           if (bank.equals("RBC")) {
               convertedRate = conversionRate.rbcConversionRate(cadAmount, currency);
            } else if (bank.equals("TD")) {
               convertedRate = conversionRate.tdConversionRate(cadAmount, currency);
           } else {
                System.out.println("Bank name is not valid. Please enter one of these banks: RBC, TD");
           }
        }

        System.out.println(STR."Converted $\{convertedRate}CAD to \{currency}");
    }

    // Go to credit card URLs and scrape the page to determine the best currency rate
    private void openCreditCardWebpages() {
        String[] listOfCreditCards = {"Mastercard", "Visa"};

        CreditCardConversionRate conversionRate = new CreditCardConversionRate(driver);


        for (String bank : listOfCreditCards) {
            if (bank.equals("Mastercard")) {
                conversionRate.mastercardConversionRate(cadAmount, currency);
            } else if (bank.equals("Visa")) {
                conversionRate.visaConversionRate(cadAmount, currency);
            } else {
                System.out.println("Bank name is not valid. Please enter one of these banks: RBC, TD");
            }
        }
    }

    public void main(String[] args) {
        // Set up the ChromeDriver path
        this.cadAmount = 100;
        this.currency = "USD";

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        //TODO: Display available banks and credit cards that can be used in the converter

        //TODO: Get user input of what banks/credit cards to to get currency of

        // Open banks webpages (RBC, CIBC, TD, etc.)
        openBankWebpages();

        // Open credit card webpages (E.g. Mastercard, Visa, etc.)
        openCreditCardWebpages();

        // Close the browser
        driver.quit();
    }
}