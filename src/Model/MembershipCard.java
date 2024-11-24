package Model;
import java.util.Date;
public class MembershipCard {

    private String cardNumber;
    private Date expiryDate;

    // Constructor
    public MembershipCard(String cardNumber, Date expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
