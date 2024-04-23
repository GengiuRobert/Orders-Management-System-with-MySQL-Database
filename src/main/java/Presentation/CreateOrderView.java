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
    public CreateOrderView() {
        setTitle("Create Order View");
        setSize(800, 400);
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

        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
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
        return Integer.parseInt(createOrderIDClientTextField.getText());
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
    public int getCreateOrderIdTextField(){
        return Integer.parseInt(createOrderIdTextField.getText());
    }

}
