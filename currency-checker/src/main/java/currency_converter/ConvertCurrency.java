package currency_converter;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


public class ConvertCurrency {
    private static final String WEBDRIVER_PATH = "/Users/t979940/IdeaProjects/currency-checker/chromedriver-mac-x64/chromedriver";
    public WebDriver driver;
    public ChromeDriverService service;
    private int cadAmount;
    private String currency;


    // Set up the Web Drivers
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", WEBDRIVER_PATH);

        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--profile-directory=Default");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--incognito");

        // Create ChromeDriverService instance
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(WEBDRIVER_PATH))
                .usingAnyFreePort()
                .build();

        try {
            // Start the service
            service.start();

            // Initialize WebDriver with ChromeOptions
            driver = new ChromeDriver(service, options);

        } catch (Exception e) {
            e.printStackTrace();
            tearDown();
        }

        //driver = new ChromeDriver(options);
    }

    // Close drivers when operations are completed
    public void tearDown() {
        service.stop();
        driver.quit();
    }

    // Go to bank URLs and scrape the page to determine the best currency rate
    private void openBankWebpages(){
        String[] listOfBanks = {"RBC", "TD"};
        String convertedRate =  null;

        BankConversionRate conversionRate = new BankConversionRate(this.driver);

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
        ConvertCurrency converter = new ConvertCurrency();
        converter.setUp();

        try {
            // Set up the ChromeDriver path
            converter.cadAmount = 100;
            converter.currency = "USD";

            //TODO: Display available banks and credit cards that can be used in the converter

            //TODO: Get user input of what banks/credit cards to to get currency of

            // Open banks webpages (RBC, CIBC, TD, etc.)
            converter.openBankWebpages();

            // Open credit card webpages (E.g. Mastercard, Visa, etc.)
            converter.openCreditCardWebpages();
        } finally {
            // Close the browser
            converter.tearDown();
        }
    }
}