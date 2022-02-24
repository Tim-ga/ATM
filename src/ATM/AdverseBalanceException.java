package ATM.src.ATM;

public class AdverseBalanceException extends RuntimeException {
    public AdverseBalanceException(String description){
        super(description);
    }
}
