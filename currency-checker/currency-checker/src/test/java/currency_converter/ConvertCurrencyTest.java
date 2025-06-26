package currency_converter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertCurrencyTest {
    private ConvertCurrency convertCurrency;

    @BeforeEach
    public void setupTestCase() {
        System.out.println("Test setup has started...");
        this.convertCurrency = new ConvertCurrency();
        this.convertCurrency.setUp();
    }

    @AfterEach
    public void tearDownTestCase() {
        System.out.println("Test teardown and clean up has started...");
        this.convertCurrency.tearDown();
    }

    @Test
    public void validateRbc () {
        System.out.print("Validating RBC Flow");
        this.convertCurrency.openBankWebpages("RBC");
    }

    @Test
    public void validateTd () {
        System.out.print("Validating TD Flow");
        this.convertCurrency.openBankWebpages("RBC");
    }
}