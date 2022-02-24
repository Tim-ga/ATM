package ATM.src.TestATM;
import ATM.src.ATM.ATM;
import ATM.src.ATM.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

public class ATMTest {
    ATM actualATM1;
    ATM actualATM2;

    @Before
    public void initialization() {
        Card creditCard = new CreditCard("Ivan", "Petrov", new BigDecimal("100"));
        Card debitCard = new DebitCard("Ivan", "Petrov", new BigDecimal("100"));

        actualATM1 = new ATM(creditCard);
        actualATM2 = new ATM(debitCard);
    }

    @Test
    public void subtractBalance() {
        actualATM1.subtractBalance(new BigDecimal("50"));
        actualATM2.subtractBalance(new BigDecimal("50"));

        ATM expectedATM1 = new ATM (new CreditCard("Ivan", "Petrov", new BigDecimal("50")));
        ATM expectedATM2 = new ATM (new DebitCard("Ivan", "Petrov", new BigDecimal("50")));

        Assert.assertEquals(expectedATM1, actualATM1);
        Assert.assertEquals(expectedATM2, actualATM2);
    }

    @Test
    public void addBalance() {
        actualATM1.addBalance(new BigDecimal("50"));
        actualATM2.addBalance(new BigDecimal("50"));

        ATM expectedATM1 = new ATM (new CreditCard("Ivan", "Petrov", new BigDecimal("150")));
        ATM expectedATM2 = new ATM (new DebitCard("Ivan", "Petrov", new BigDecimal("150")));

        Assert.assertEquals(expectedATM1, actualATM1);
        Assert.assertEquals(expectedATM2, actualATM2);
    }

    @Test
    public void getConversionRate() {
        actualATM1.setExchangeRate(new BigDecimal("2"));
        actualATM2.setExchangeRate(new BigDecimal("2"));

        BigDecimal actual1 = actualATM1.getConversionRate();
        BigDecimal actual2 = actualATM2.getConversionRate();

        BigDecimal expected = new BigDecimal("25");

        actual1.compareTo(expected);
        actual2.compareTo(expected);
    }

    @Test(expected = AdverseBalanceException.class)
    public void subtractBalanceCreditCardExeption() {
        actualATM1.subtractBalance(new BigDecimal("2101"));
    }

    @Test(expected = AdverseBalanceException.class)
    public void subtractBalanceDebitCardExeption() {
        actualATM2.subtractBalance(new BigDecimal("101"));
    }
}