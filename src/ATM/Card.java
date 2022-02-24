package ATM.src.ATM;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Card {
    private String firstName;
    private String secondName;
    protected BigDecimal balance;

    public Card(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Card(String firstName, String secondName, BigDecimal balance) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public abstract BigDecimal subtractBalance(BigDecimal amount);

    public BigDecimal addBalance(BigDecimal amount) {
        balance = balance.add(amount);
        return balance;
    }

    public BigDecimal getConversionRate(BigDecimal exchangeRate) {
        BigDecimal result = balance.divide(exchangeRate);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(firstName, card.firstName) && Objects.equals(secondName, card.secondName) && Objects.equals(balance, card.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, balance);
    }

    @Override
    public String toString() {
        return "Card{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

