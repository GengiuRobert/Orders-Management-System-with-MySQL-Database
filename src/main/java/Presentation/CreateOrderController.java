package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import DataAccess.BillDAO;
import Model.Bill;
import Model.Client;
import Model.Orderr;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
        addDeleteClientListener();
        addUpdateClientListener();
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

                BillDAO billDAO = new BillDAO();
                BigDecimal totalPrice = BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity));
                Bill bill = new Bill(orderId, clientName, productName, quantity, totalPrice);
                billDAO.insert(bill);

                System.out.println(order.toString());
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
    private void updateOrder() {
        orderId = createOrderView.getUpdateOrderIDTextField();
        clientId = createOrderView.getUpdateOrderIDClientTextField();
        productId = createOrderView.getUpdateOrderIDProductTextField();
        quantity = createOrderView.getUpdateOrderQuantityTextField();
        clientName = createOrderView.getUpdateOrderClientNameTextField();
        productName = createOrderView.getUpdateOrderProductNameTextField();

        OrderBLL orderBLL = new OrderBLL();
        Orderr order = new Orderr(orderId, clientId, productId, clientName, productName, quantity);
        orderBLL.updateOrder(order);
        System.out.println("Order updated");
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
    private void deleteOrder() {
        orderId = createOrderView.getDeleteOrderIDTextField();
        OrderBLL orderBLL = new OrderBLL();
        Orderr orderr = orderBLL.findOrderById(orderId);
        orderBLL.deleteOrder(orderr);
        System.out.println("Order deleted");
    }
    private void addCreateClientListener() {
        createOrderView.createOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewOrder();
            }
        });
    }

    private void addUpdateClientListener() {
        createOrderView.updateOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOrder();
            }
        });
    }

    private void addDeleteClientListener() {
        createOrderView.deleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOrder();
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
