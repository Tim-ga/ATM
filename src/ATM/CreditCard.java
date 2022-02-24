package ATM.src.ATM;

import java.math.BigDecimal;

public class CreditCard extends Card {

    public CreditCard(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public CreditCard(String firstName, String secondName, BigDecimal balance) {
        super(firstName, secondName, balance);
    }

    @Override
    public BigDecimal subtractBalance(BigDecimal amount) throws AdverseBalanceException {
        if (balance.subtract(amount).compareTo(new BigDecimal("-2000")) < 0) {
            throw new AdverseBalanceException("Отказано! Превышен доступный лимит снятия средств!\n" +
                    "Максимальный отрицательный баланс не может превышать 2000 BYN!");
        }
        balance = balance.subtract(amount);
        return balance;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "balance=" + balance +
                "} " + super.toString();
    }
}
