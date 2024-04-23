package Model;
/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * Class where the orderr model is described
 */
public class Orderr {
    public int id;
    public int clientID;
    public int productID;
    public String clientName;
    public String productName;
    public int quantity;

    public Orderr() {
    }

    public Orderr(int orderID, int clientID, int productID, String clientName, String productName, int productQuantity) {
        this.id = orderID;
        this.clientID = clientID;
        this.productID = productID;
        this.clientName = clientName;
        this.productName = productName;
        this.quantity = productQuantity;
    }

    public int isId() {
        return id;
    }

    public void setId(int orderID) {
        this.id = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int isQuantity() {
        return quantity;
    }

    public void setQuantity(int productQuantity) {
        this.quantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Order { " +
                "orderID = " + id +
                ", clientID = " + clientID +
                ", productID = " + productID +
                ", clientName = '" + clientName + '\'' +
                ", productName = '" + productName + '\'' +
                ", productQuantity = " + quantity +
                "}";
    }
}
