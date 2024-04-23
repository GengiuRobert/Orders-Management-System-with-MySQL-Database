package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The ClientView class represents the graphical user interface (GUI) component for managing client-related operations.
 * It allows users to view, add, update, and delete client information.
 * This view class displays client data in a structured format and provides interactive elements for user interaction.
 * Users can perform actions such as adding new clients, editing existing client details, and deleting clients from the system.
 * The ClientView class ensures a seamless user experience by facilitating interactions with the underlying business logic layer.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class ClientView extends JFrame {
    public JPanel panel;
    public JButton showClientsTableButton;
    public JTextField newClientNameTextField;
    public JTextField newClientIDTextField;
    public JTextField newClientAgeTextField;
    public JTextField newClientEmailTextField;
    public JLabel newClientLabel;
    public JLabel newClientNameLabel;
    public JLabel newClientAgeLabel;
    public JLabel newClientIDLabel;
    public JLabel newClientEmailLabel;
    public JButton newClientButton;
    public JTextField editClientNameTextField;
    public JTextField editClientAgeTextField;
    public JTextField editClientEmailTextField;
    public JLabel editClientLabel;
    public JLabel editClientNameLabel;
    public JLabel editClientAgeLabel;
    public JLabel editClientIDLabel;
    public JTextField editClientIDTextField;
    public JLabel editClientEmailLabel;
    public JButton editClientButton;
    public JLabel deleteClientLabel;
    public JLabel deleteClientIDLabel;
    public JTextField deleteClientIDTextField;
    public JButton deleteClientButton;
    public JLabel mandatoryCreateLabel;
    public JLabel mandatoryEditLabel;
    public JLabel mandatoryDeleteLabel;

    public ClientView() {
        setPreferredSize(new Dimension(800, 600));
        setTitle("Clients View");
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        showClientsTableButton = new JButton("Show Clients");
        showClientsTableButton.setBounds(300, 5, 220, 50);
        showClientsTableButton.setFont(new Font("Arial", Font.BOLD, 20));
        showClientsTableButton.setBackground(new Color(144, 238, 144));

        mandatoryCreateLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryCreateLabel.setBounds(350, 120, 500, 40);
        mandatoryCreateLabel.setFont(new Font("Arial", Font.BOLD, 25));

        newClientLabel = new JLabel("Create New Client Section");
        newClientLabel.setBounds(25, 60, 400, 30);
        newClientLabel.setFont(new Font("Arial", Font.BOLD, 18));

        newClientIDLabel = new JLabel("Introduce ID");
        newClientIDLabel.setBounds(5, 95, 400, 15);
        newClientIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newClientNameLabel = new JLabel("Introduce Name");
        newClientNameLabel.setBounds(5, 120, 400, 15);
        newClientNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newClientAgeLabel = new JLabel("Introduce Age");
        newClientAgeLabel.setBounds(5, 145, 400, 15);
        newClientAgeLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newClientEmailLabel = new JLabel("Introduce Email");
        newClientEmailLabel.setBounds(5, 170, 400, 15);
        newClientEmailLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newClientIDTextField = new JTextField();
        newClientIDTextField.setBounds(135, 95, 160, 20);
        newClientIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newClientIDTextField.setBackground(new Color(144, 238, 144));

        newClientNameTextField = new JTextField();
        newClientNameTextField.setBounds(135, 120, 160, 20);
        newClientNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newClientNameTextField.setBackground(new Color(144, 238, 144));

        newClientAgeTextField = new JTextField();
        newClientAgeTextField.setBounds(135, 145, 160, 20);
        newClientAgeTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newClientAgeTextField.setBackground(new Color(144, 238, 144));

        newClientEmailTextField = new JTextField();
        newClientEmailTextField.setBounds(135, 170, 160, 20);
        newClientEmailTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newClientEmailTextField.setBackground(new Color(144, 238, 144));

        newClientButton = new JButton("Create Client");
        newClientButton.setBounds(25, 195, 220, 30);
        newClientButton.setFont(new Font("Arial", Font.BOLD, 15));
        newClientButton.setBackground(new Color(144, 238, 144));

        mandatoryEditLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryEditLabel.setBounds(350, 315, 500, 40);
        mandatoryEditLabel.setFont(new Font("Arial", Font.BOLD, 25));

        editClientLabel = new JLabel("Edit Client Section (by ID)");
        editClientLabel.setBounds(25, 250, 400, 30);
        editClientLabel.setFont(new Font("Arial", Font.BOLD, 18));

        editClientIDLabel = new JLabel("Introduce ID");
        editClientIDLabel.setBounds(5, 285, 400, 15);
        editClientIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editClientNameLabel = new JLabel("Introduce Name");
        editClientNameLabel.setBounds(5, 310, 400, 15);
        editClientNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editClientAgeLabel = new JLabel("Introduce Age");
        editClientAgeLabel.setBounds(5, 335, 400, 15);
        editClientAgeLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editClientEmailLabel = new JLabel("Introduce Email");
        editClientEmailLabel.setBounds(5, 360, 400, 15);
        editClientEmailLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editClientIDTextField = new JTextField();
        editClientIDTextField.setBounds(135, 285, 160, 20);
        editClientIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editClientIDTextField.setBackground(new Color(144, 238, 144));

        editClientNameTextField = new JTextField();
        editClientNameTextField.setBounds(135, 310, 160, 20);
        editClientNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editClientNameTextField.setBackground(new Color(144, 238, 144));

        editClientAgeTextField = new JTextField();
        editClientAgeTextField.setBounds(135, 335, 160, 20);
        editClientAgeTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editClientAgeTextField.setBackground(new Color(144, 238, 144));

        editClientEmailTextField = new JTextField();
        editClientEmailTextField.setBounds(135, 360, 160, 20);
        editClientEmailTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editClientEmailTextField.setBackground(new Color(144, 238, 144));

        editClientButton = new JButton("Edit Client");
        editClientButton.setBounds(25, 385, 220, 30);
        editClientButton.setFont(new Font("Arial", Font.BOLD, 15));
        editClientButton.setBackground(new Color(144, 238, 144));

        mandatoryDeleteLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryDeleteLabel.setBounds(350, 465, 500, 40);
        mandatoryDeleteLabel.setFont(new Font("Arial", Font.BOLD, 25));

        deleteClientLabel = new JLabel("Delete Client Section (by ID)");
        deleteClientLabel.setBounds(25, 440, 400, 30);
        deleteClientLabel.setFont(new Font("Arial", Font.BOLD, 18));

        deleteClientIDLabel = new JLabel("Introduce ID");
        deleteClientIDLabel.setBounds(5, 475, 400, 15);
        deleteClientIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        deleteClientIDTextField = new JTextField();
        deleteClientIDTextField.setBounds(135, 475, 160, 20);
        deleteClientIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        deleteClientIDTextField.setBackground(new Color(144, 238, 144));

        deleteClientButton = new JButton("Delete Client");
        deleteClientButton.setBounds(25, 500, 220, 30);
        deleteClientButton.setFont(new Font("Arial", Font.BOLD, 15));
        deleteClientButton.setBackground(new Color(144, 238, 144));

        panel.add(mandatoryDeleteLabel);
        panel.add(mandatoryEditLabel);
        panel.add(mandatoryCreateLabel);
        panel.add(deleteClientButton);
        panel.add(deleteClientIDTextField);
        panel.add(deleteClientLabel);
        panel.add(deleteClientIDLabel);
        panel.add(editClientLabel);
        panel.add(editClientButton);
        panel.add(editClientIDTextField);
        panel.add(editClientNameTextField);
        panel.add(editClientAgeTextField);
        panel.add(editClientEmailTextField);
        panel.add(editClientIDLabel);
        panel.add(editClientNameLabel);
        panel.add(editClientEmailLabel);
        panel.add(editClientAgeLabel);
        panel.add(showClientsTableButton);
        panel.add(newClientButton);
        panel.add(newClientEmailTextField);
        panel.add(newClientAgeTextField);
        panel.add(newClientAgeLabel);
        panel.add(newClientNameTextField);
        panel.add(newClientEmailLabel);
        panel.add(newClientNameLabel);
        panel.add(newClientLabel);
        panel.add(newClientIDLabel);
        panel.add(newClientIDTextField);
        panel.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(panel);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public int getNewClientIDTextField() {
        return Integer.parseInt(newClientIDTextField.getText());
    }
    public String getNewClientNameTextField() {
        return newClientNameTextField.getText();
    }
    public String getNewEmailTextField() {
        return newClientEmailTextField.getText();
    }
    public int getNewClientAgeTextField() {
        return Integer.parseInt(newClientAgeTextField.getText());
    }

    public int getEditClientIDTextField() {
        return Integer.parseInt(editClientIDTextField.getText());
    }
    public String getEditClientNameTextField() {
        return editClientNameTextField.getText();
    }
    public String getEditEmailTextField() {
        return editClientEmailTextField.getText();
    }
    public int getEditClientAgeTextField() {
        return Integer.parseInt(editClientAgeTextField.getText());
    }

    public int getDeleteClientIDTextField() {
        return Integer.parseInt(deleteClientIDTextField.getText());
    }
}
