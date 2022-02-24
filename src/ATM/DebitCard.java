package ATM.src.ATM;

import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String firstName, String secondName) {
        super(firstName, secondName);
    }

    public DebitCard(String firstName, String secondName, BigDecimal balance) {
        super(firstName, secondName, balance);
    }

    @Override
    public BigDecimal subtractBalance(BigDecimal amount) throws AdverseBalanceException {
        if (balance.compareTo(amount) < 0) {
            throw new AdverseBalanceException("Отказано! На балансе недостаточно средств!");
        }
        balance = balance.subtract(amount);
        return balance;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "balance=" + balance +
                "} " + super.toString();
    }
}

