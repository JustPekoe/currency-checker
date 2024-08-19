package currency_converter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConvertCurrency {
    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        //TODO: Display available banks and credit cards that can be used in the converter

        //TODO: Get user input of what banks/credit cards to to get currency of

        // Open banks webpages (RBC, CIBC, TD, etc.)
        ConvertCurrency bankCurrencyValidator = new ConvertCurrency();
        bankCurrencyValidator.openBankWebpages(driver);


        // Open credit card webpages (E.g. Mastercard, Visa, etc.)
        ConvertCurrency creditCardCurrencyValidator = new ConvertCurrency();
        creditCardCurrencyValidator.openBankWebpages(driver);

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }

    private void openBankWebpages(WebDriver driver){
        String[] listOfBanks = {"CIBC", "RBC", "TD", "Tangerine"};

        for (String bank : listOfBanks) {
            if (bank.equals("CIBC")) {
                driver.get("https://www.google.com");
            } else if (bank.equals("RBC")) {
                driver.get("https://www.google.com");
            } else if (bank.equals("Tangerine")) {
                driver.get("https://www.google.com");
            }else if (bank.equals("TD")) {
                driver.get("https://www.google.com");
            } else {
                System.out.println("Bank name is not valid. " +
                                "Please enter one of these banks: ");
            }
        }
    }

    private void openCreditCardWebpages() {
        String[] listOfCreditCards = {"Mastercard", "Visa"};

    }
}
