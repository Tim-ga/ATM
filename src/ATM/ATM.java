package ATM.src.ATM;
import java.math.BigDecimal;
import java.util.Objects;

public class ATM {
    protected BigDecimal exchangeRate;
    private Card card;

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public ATM(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal subtractBalance(BigDecimal amount) {
        return card.subtractBalance(amount);
    }

    public BigDecimal addBalance(BigDecimal amount) {
        return card.addBalance(amount);
    }

    public BigDecimal getConversionRate() {
        BigDecimal result = card.getConversionRate(getExchangeRate());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return Objects.equals(card, atm.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }

    @Override
    public String toString() {
        return "ATM{" +
                "card=" + card +
                '}';
    }
}

