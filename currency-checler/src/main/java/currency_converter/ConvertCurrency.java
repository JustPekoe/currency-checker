package currency_converter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConvertCurrency {
    private static final String WEBDRIVER_PATH = "/usr/local/bin/chromedriver";
    public WebDriver driver;

    private static String rbcUrl = "https://www.rbcbank.com/cgi-bin/tools/cadusd-foreign-exchange-calculator/start.cgi";
    private static String tdUrl = "https://www.td.com/ca/en/personal-banking/solutions/exchange/currency-converter";

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

    private void openBankWebpages(){
        String[] listOfBanks = {"CIBC", "RBC", "TD", "Tangerine"};

        for (String bank : listOfBanks) {
           if (bank.equals("RBC")) {
                driver.get(rbcUrl);
            } else if (bank.equals("TD")) {
                driver.get(tdUrl);
            } else {
                System.out.println("Bank name is not valid. Please enter one of these banks: RBC, TD");
            }
        }
    }

    private void openCreditCardWebpages() {
        String[] listOfCreditCards = {"Mastercard", "Visa"};

    }

    public void startConversion() {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        //TODO: Display available banks and credit cards that can be used in the converter

        //TODO: Get user input of what banks/credit cards to to get currency of

        // Open banks webpages (RBC, CIBC, TD, etc.)
        openBankWebpages();


        // Open credit card webpages (E.g. Mastercard, Visa, etc.)
        openCreditCardWebpages();

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}