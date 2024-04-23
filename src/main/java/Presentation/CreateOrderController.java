package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Client;
import Model.Orderr;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * * The CreateOrderController class manages user interactions and business logic related to creating orders.
 *  * It coordinates between the CreateOrderView (user interface) and the OrderBLL (business logic layer).
 *  * This controller class provides methods for handling user actions, such as creating a new order, displaying client and product information,
 *  * and updating the view based on user input.
 *  * It ensures proper communication between the user interface and the underlying business logic, facilitating the creation and management of orders in the system. */
public class CreateOrderController {
    public CreateOrderView createOrderView;
    public int clientId;
    public int productId;
    public int orderId;
    public int quantity ;
    public String clientName;
    public String productName;

    public CreateOrderController(CreateOrderView createOrderView) {
        this.createOrderView = createOrderView;
        addCreateClientListener();
        showClients();
        showProducts();
        showOrders();
    }

    private void createNewOrder() {
        orderId = createOrderView.getCreateOrderIDTextField();
        clientId = createOrderView.getCreateOrderIDClientTextField();
        productId = createOrderView.getCreateOrderIDProductTextField();
        quantity = createOrderView.getCreateOrderQuantityTextField();
        clientName = createOrderView.getCreateOrderClientNameTextField();
        productName = createOrderView.getCreateOrderProductNameTextField();

        ProductBLL productBLL = new ProductBLL();
        Product product = productBLL.findClientById(productId);
        if (product != null) {
            int availableQuantity = product.getQuantity();
            if (availableQuantity >= quantity) {
                int newQuantity = availableQuantity - quantity;
                productBLL.updateProductQuantity(productId, newQuantity);
                Orderr order = new Orderr(orderId, clientId, productId, clientName, productName, quantity);
                OrderBLL orderBLL = new OrderBLL();
                orderBLL.insertOrder(order);

                System.out.println("Order created");
            } else {
                createOrderView.mandatoryCreateOrderLabel.setText("UNDER-STOCK");
            }
        } else {
            createOrderView.mandatoryCreateOrderLabel.setText("Product not found!");
        }
    }

    private void showClientsView() {
        ClientBLL clientBLL = new ClientBLL();
        List<Client> clients = clientBLL.getAllClients();
        TableView tableView = new TableView(clients);
    }
    private void showProductsView() {
        ProductBLL clientBLL = new ProductBLL();
        List<Product> clients = clientBLL.getAllClients();
        TableView tableView = new TableView(clients);
    }
    private void showOrdersView() {
        OrderBLL orderBLL = new OrderBLL();
        List<Orderr> clients = orderBLL.getAllOrders();
        TableView tableView = new TableView(clients);
    }

    private void addCreateClientListener() {
        createOrderView.createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewOrder();
            }
        });
    }

    private void showClients() {
        createOrderView.showClientsTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClientsView();
            }
        });
    }
    private void showProducts() {
        createOrderView.showProductsTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductsView();
            }
        });
    }

    private void showOrders() {
        createOrderView.showOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOrdersView();
            }
        });
    }

}
