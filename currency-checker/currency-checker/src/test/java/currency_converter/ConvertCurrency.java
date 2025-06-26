package currency_converter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


public class ConvertCurrency {
    public WebDriver driver;
    public ChromeDriverService service;
    private int cadAmount;
    private String currency;


    // Set up the Web Drivers
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().clearDriverCache().setup();

        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--profile-directory=Default");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-plugins-discovery");
        options.addArguments("--incognito");

        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        driver = new ChromeDriver(service);

        try {
            // Start the service
            service.start();

            // Initialize WebDriver with ChromeOptions
            driver = new ChromeDriver(service, options);

        } catch (Exception e) {
            e.printStackTrace();
            if (service != null && service.isRunning()) {
                service.stop();
            }
            throw new RuntimeException("Failed to set up WebDriver", e);
        }
    }

    // Close drivers when operations are completed
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    // Go to bank URLs and scrape the page to determine the best currency rate
    public void openBankWebpages(String bank){
        //String[] listOfBanks = {"RBC", "TD"};
        String convertedRate =  null;

        BankConversionRate conversionRate = new BankConversionRate(this.driver);

        if (bank.equals("RBC")) {
            convertedRate = conversionRate.rbcConversionRate(cadAmount, currency);
        } else if (bank.equals("TD")) {
            convertedRate = conversionRate.tdConversionRate(cadAmount, currency);
        } else {
            System.out.println("Bank name is not valid. Please enter one of these banks: RBC, TD");
        }

        System.out.println(STR."Converted $\{convertedRate}CAD to \{currency}");
    }

    // Go to credit card URLs and scrape the page to determine the best currency rate
    public void openCreditCardWebpages() {
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
}