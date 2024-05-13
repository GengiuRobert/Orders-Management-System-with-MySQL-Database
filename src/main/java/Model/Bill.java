package Model;
import java.math.BigDecimal;

public record Bill(int billId, String clientName, String productName, int quantity, BigDecimal totalPrice) {

    public BigDecimal calculateTotalAmount() {
        return BigDecimal.valueOf(quantity).multiply(totalPrice);
    }
}
