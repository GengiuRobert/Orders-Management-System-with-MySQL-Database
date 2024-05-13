package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The MainController class serves as the primary controller for managing the overall application flow.
 * It coordinates interactions between different components of the application, such as views, controllers, and business logic layers.
 * This controller class initializes the application, sets up the user interface, and handles high-level user actions.
 * It ensures proper communication between various parts of the application and facilitates the execution of business processes.
 * MainController acts as the central hub for controlling the behavior and functionality of the entire application.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class Controller {
    public final View view;

    public Controller(View view) {
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.clientOperationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView clientView = new ClientView();
                ClientController clientController = new ClientController(clientView);
            }
        });

        view.productOperationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductView productView = new ProductView();
                ProductController productController = new ProductController(productView);
            }
        });

        view.createProductOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateOrderView createOrderView = new CreateOrderView();
                CreateOrderController createOrderController = new CreateOrderController(createOrderView);
            }
        });

        view.billOperationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillTableView createOrderView = new BillTableView();
            }
        });
    }

}
