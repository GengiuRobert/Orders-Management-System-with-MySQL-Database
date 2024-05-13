package Presentation;

import javax.swing.*;
import java.awt.*;
/**
 * The CreateOrderView class represents the graphical user interface (GUI) component for creating new orders.
 * It provides an interface for users to input order details such as client ID, product ID, and quantity.
 * This view class allows users to interact with the system by initiating order creation and displaying relevant feedback.
 * Users can input required information and submit orders, triggering appropriate actions in the underlying system.
 * The CreateOrderView class facilitates user interaction with the order creation process and ensures a seamless user experience.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class CreateOrderView extends JFrame {
    public JPanel panel;
    public JButton showClientsTableButton;
    public JButton showProductsTableButton;
    public JLabel createOrderLabel;
    public JLabel createOrderIDProductLabel;
    public JLabel createOrderIDClientLabel;
    public JLabel createOrderQuantityLabel;
    public JTextField createOrderIDClientTextField;
    public JTextField createOrderIDProductTextField;
    public JTextField createOrderQuantityTextField;
    public JButton createOrderButton;
    public JLabel mandatoryCreateOrderLabel;
    public JLabel createOrderClientNameLabel;
    public JTextField createOrderClientNameTextField;
    public JTextField createOrderProductNameTextField;
    public JLabel createOrderProductNameLabel;
    public JLabel createOrderIdLabel;
    public JTextField createOrderIdTextField;
    public JButton showOrderButton;
    public JLabel updateOrderLabel;
    public JLabel updateOrderIDProductLabel;
    public JLabel updateOrderIdLabel;
    public JTextField updateOrderIDTextField;
    public JTextField updateOrderIDProductTextField;
    public JLabel updateOrderQuantityLabel;
    public JTextField updateOrderQuantityTextField;
    public JButton updateOrderButton;
    public JLabel updateOrderIDClientLabel;
    public JTextField updateOrderIDClientTextField;
    public JLabel updateClientNameLabel;
    public JTextField updateClientNameTextField;
    public JLabel updateProductNameLabel;
    public JTextField updateProductNameTextField;
    public JLabel deleteOrderLabel;
    public JButton deleteOrder;
    public JTextField deleteOrderIDTextField;
    public JLabel deleteOrderIDLabel;
    public JLabel mandatoryDeleteOrderLabel;
    public JLabel mandatoryUpdateOrderLabel;
    public CreateOrderView() {
        setTitle("Create Order View");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        mandatoryCreateOrderLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryCreateOrderLabel.setBounds(350, 200, 500, 40);
        mandatoryCreateOrderLabel.setFont(new Font("Arial", Font.BOLD, 25));

        showClientsTableButton = new JButton("Show Clients");
        showClientsTableButton.setBounds(300, 5, 220, 50);
        showClientsTableButton.setFont(new Font("Arial", Font.BOLD, 20));
        showClientsTableButton.setBackground(new Color(144, 238, 144));

        showOrderButton = new JButton("Show Orders");
        showOrderButton.setBounds(50, 5, 220, 50);
        showOrderButton.setFont(new Font("Arial", Font.BOLD, 20));
        showOrderButton.setBackground(new Color(144, 238, 144));

        showProductsTableButton = new JButton("Show Products");
        showProductsTableButton.setBounds(300, 60, 220, 50);
        showProductsTableButton.setFont(new Font("Arial", Font.BOLD, 20));
        showProductsTableButton.setBackground(new Color(144, 238, 144));

        createOrderLabel = new JLabel("Create New Order Section");
        createOrderLabel.setBounds(25, 120, 400, 30);
        createOrderLabel.setFont(new Font("Arial", Font.BOLD, 18));

        createOrderIdLabel = new JLabel("Introduce Order ID");
        createOrderIdLabel.setBounds(5, 160, 400, 15);
        createOrderIdLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderIDClientLabel = new JLabel("Introduce Client ID");
        createOrderIDClientLabel.setBounds(5, 185, 400, 15);
        createOrderIDClientLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderIDProductLabel = new JLabel("Introduce Product ID");
        createOrderIDProductLabel.setBounds(5, 210, 400, 15);
        createOrderIDProductLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderQuantityLabel = new JLabel("Introduce Quantity");
        createOrderQuantityLabel.setBounds(5, 235, 400, 15);
        createOrderQuantityLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderClientNameLabel = new JLabel("Introduce Name (C)");
        createOrderClientNameLabel.setBounds(5, 260, 400, 15);
        createOrderClientNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderProductNameLabel = new JLabel("Introduce Name (P)");
        createOrderProductNameLabel.setBounds(5, 285, 400, 15);
        createOrderProductNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        createOrderIdTextField = new JTextField();
        createOrderIdTextField.setBounds(180, 160, 160, 20);
        createOrderIdTextField.setFont(new Font("Arial", Font.BOLD, 15));
        createOrderIdTextField.setBackground(new Color(144, 238, 144));

        createOrderIDClientTextField = new JTextField();
        createOrderIDClientTextField.setBounds(180, 185, 160, 20);
        createOrderIDClientTextField.setFont(new Font("Arial", Font.BOLD, 12));
        createOrderIDClientTextField.setBackground(new Color(144, 238, 144));

        createOrderIDProductTextField = new JTextField();
        createOrderIDProductTextField.setBounds(180, 210, 160, 20);
        createOrderIDProductTextField.setFont(new Font("Arial", Font.BOLD, 12));
        createOrderIDProductTextField.setBackground(new Color(144, 238, 144));

        createOrderQuantityTextField = new JTextField();
        createOrderQuantityTextField.setBounds(180, 235, 160, 20);
        createOrderQuantityTextField.setFont(new Font("Arial", Font.BOLD, 12));
        createOrderQuantityTextField.setBackground(new Color(144, 238, 144));

        createOrderClientNameTextField = new JTextField();
        createOrderClientNameTextField.setBounds(180, 260, 160, 20);
        createOrderClientNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        createOrderClientNameTextField.setBackground(new Color(144, 238, 144));

        createOrderProductNameTextField = new JTextField();
        createOrderProductNameTextField.setBounds(180, 285, 160, 20);
        createOrderProductNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        createOrderProductNameTextField.setBackground(new Color(144, 238, 144));

        createOrderButton = new JButton("Create Order");
        createOrderButton.setBounds(25, 310, 220, 30);
        createOrderButton.setFont(new Font("Arial", Font.BOLD, 15));
        createOrderButton.setBackground(new Color(144, 238, 144));

        updateOrderLabel = new JLabel("Update Order Section");
        updateOrderLabel.setBounds(25, 345, 400, 30);
        updateOrderLabel.setFont(new Font("Arial", Font.BOLD, 18));
        updateOrderLabel.setBackground(new Color(144, 238, 144));

        updateOrderIdLabel = new JLabel("Introduce Order ID");
        updateOrderIdLabel.setBounds(5, 385, 400, 15);
        updateOrderIdLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateOrderIdLabel.setBackground(new Color(144, 238, 144));

        updateOrderIDClientLabel = new JLabel("Introduce Client ID");
        updateOrderIDClientLabel.setBounds(5, 410, 400, 15);
        updateOrderIDClientLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateOrderIDClientLabel.setBackground(new Color(144, 238, 144));

        updateOrderIDProductLabel = new JLabel("Introduce Product ID");
        updateOrderIDProductLabel.setBounds(5, 435, 400, 15);
        updateOrderIDProductLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateOrderIDProductLabel.setBackground(new Color(144, 238, 144));

        updateOrderQuantityLabel = new JLabel("Introduce Quantity");
        updateOrderQuantityLabel.setBounds(5, 460, 400, 15);
        updateOrderQuantityLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateOrderQuantityLabel.setBackground(new Color(144, 238, 144));

        updateClientNameLabel = new JLabel("Introduce Name (C)");
        updateClientNameLabel.setBounds(5, 485, 400, 15);
        updateClientNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateClientNameLabel.setBackground(new Color(144, 238, 144));

        updateProductNameLabel = new JLabel("Introduce Name (P)");
        updateProductNameLabel.setBounds(5, 510, 400, 15);
        updateProductNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        updateProductNameLabel.setBackground(new Color(144, 238, 144));

        updateOrderIDTextField = new JTextField();
        updateOrderIDTextField.setBounds(180, 385, 160, 20);
        updateOrderIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateOrderIDTextField.setBackground(new Color(144, 238, 144));

        updateOrderIDClientTextField = new JTextField();
        updateOrderIDClientTextField.setBounds(180, 410, 160, 20);
        updateOrderIDClientTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateOrderIDClientTextField.setBackground(new Color(144, 238, 144));

        updateOrderIDProductTextField = new JTextField();
        updateOrderIDProductTextField.setBounds(180, 435, 160, 20);
        updateOrderIDProductTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateOrderIDProductTextField.setBackground(new Color(144, 238, 144));

        updateOrderQuantityTextField = new JTextField();
        updateOrderQuantityTextField.setBounds(180, 460, 160, 20);
        updateOrderQuantityTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateOrderQuantityTextField.setBackground(new Color(144, 238, 144));

        updateClientNameTextField = new JTextField();
        updateClientNameTextField.setBounds(180, 485, 160, 20);
        updateClientNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateClientNameTextField.setBackground(new Color(144, 238, 144));

        updateProductNameTextField = new JTextField();
        updateProductNameTextField.setBounds(180, 510, 160, 20);
        updateProductNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        updateProductNameTextField.setBackground(new Color(144, 238, 144));

        updateOrderButton = new JButton("Update Order");
        updateOrderButton.setBounds(25, 540, 220, 30);
        updateOrderButton.setFont(new Font("Arial", Font.BOLD, 15));
        updateOrderButton.setBackground(new Color(144, 238, 144));

        deleteOrderLabel = new JLabel("Delete Order Section");
        deleteOrderLabel.setFont(new Font("Arial", Font.BOLD, 18));
        deleteOrderLabel.setBackground(new Color(144, 238, 144));
        deleteOrderLabel.setBounds(25, 575, 400, 30);

        deleteOrderIDLabel = new JLabel("Introduce Order ID");
        deleteOrderIDLabel.setFont(new Font("Arial", Font.BOLD, 15));
        deleteOrderIDLabel.setBackground(new Color(144, 238, 144));
        deleteOrderIDLabel.setBounds(5, 610, 400, 15);

        deleteOrderIDTextField = new JTextField();
        deleteOrderIDTextField.setBounds(180, 610, 160, 20);
        deleteOrderIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        deleteOrderIDTextField.setBackground(new Color(144, 238, 144));

        deleteOrder = new JButton("Delete Order");
        deleteOrder.setBounds(25, 640, 220, 30);
        deleteOrder.setFont(new Font("Arial", Font.BOLD, 15));
        deleteOrder.setBackground(new Color(144, 238, 144));

        mandatoryUpdateOrderLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryUpdateOrderLabel.setBounds(350, 435, 500, 40);
        mandatoryUpdateOrderLabel.setFont(new Font("Arial", Font.BOLD, 25));

        mandatoryDeleteOrderLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryDeleteOrderLabel.setBounds(350, 600, 500, 40);
        mandatoryDeleteOrderLabel.setFont(new Font("Arial", Font.BOLD, 25));

        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.add(mandatoryDeleteOrderLabel);
        panel.add(mandatoryUpdateOrderLabel);
        panel.add(deleteOrder);
        panel.add(deleteOrderIDTextField);
        panel.add(deleteOrderIDLabel);
        panel.add(deleteOrderLabel);
        panel.add(updateOrderButton);
        panel.add(updateProductNameTextField);
        panel.add(updateClientNameTextField);
        panel.add(updateOrderQuantityTextField);
        panel.add(updateOrderIDProductTextField);
        panel.add(updateOrderIDClientTextField);
        panel.add(updateOrderIDTextField);
        panel.add(updateOrderIdLabel);
        panel.add(updateOrderQuantityLabel);
        panel.add(updateClientNameLabel);
        panel.add(updateProductNameLabel);
        panel.add(updateOrderIDClientLabel);
        panel.add(updateOrderIDProductLabel);
        panel.add(updateOrderLabel);
        panel.add(showOrderButton);
        panel.add(createOrderIdLabel);
        panel.add(createOrderIdTextField);
        panel.add(createOrderClientNameLabel);
        panel.add(createOrderClientNameTextField);
        panel.add(createOrderProductNameLabel);
        panel.add(createOrderProductNameTextField);
        panel.add(mandatoryCreateOrderLabel);
        panel.add(createOrderButton);
        panel.add(createOrderQuantityTextField);
        panel.add(createOrderIDProductTextField);
        panel.add(createOrderIDClientTextField);
        panel.add(createOrderQuantityLabel);
        panel.add(showClientsTableButton);
        panel.add(showProductsTableButton);
        panel.add(createOrderLabel);
        panel.add(createOrderIDClientLabel);
        panel.add(createOrderIDProductLabel);
        panel.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    public int getCreateOrderIDTextField(){
        return Integer.parseInt(createOrderIdTextField.getText());
    }
    public int getCreateOrderIDClientTextField(){
        return Integer.parseInt(createOrderIDClientTextField.getText());
    }
    public int getCreateOrderQuantityTextField(){
        return Integer.parseInt(createOrderQuantityTextField.getText());
    }
    public int getCreateOrderIDProductTextField(){
        return Integer.parseInt(createOrderIDProductTextField.getText());
    }
    public String getCreateOrderClientNameTextField(){
        return createOrderClientNameTextField.getText();
    }
    public String getCreateOrderProductNameTextField(){
        return createOrderProductNameTextField.getText();
    }

    public int getUpdateOrderIDTextField(){
        return Integer.parseInt(updateOrderIDTextField.getText());
    }
    public int getUpdateOrderIDClientTextField(){
        return Integer.parseInt(updateOrderIDClientTextField.getText());
    }
    public int getUpdateOrderQuantityTextField(){
        return Integer.parseInt(updateOrderQuantityTextField.getText());
    }
    public int getUpdateOrderIDProductTextField(){
        return Integer.parseInt(updateOrderIDProductTextField.getText());
    }
    public String getUpdateOrderClientNameTextField(){
        return updateClientNameTextField.getText();
    }
    public String getUpdateOrderProductNameTextField(){
        return updateProductNameTextField.getText();
    }
    public int getDeleteOrderIDTextField(){
        return Integer.parseInt(deleteOrderIDTextField.getText());
    }
}
