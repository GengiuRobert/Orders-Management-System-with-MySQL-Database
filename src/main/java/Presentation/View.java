package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * The MainView class represents the main graphical user interface (GUI) component of the application.
 * It serves as the entry point for users and provides access to various functionalities and features.
 * This view class typically contains navigation elements, such as buttons or menus, for accessing different parts of the application.
 * The MainView class may also display important information or provide notifications to users.
 * It acts as the central hub for user interaction and serves as the primary interface for accessing and navigating through the application's functionalities.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class View extends JFrame {
    public JPanel panel;
    public JLabel welcomeLabel;
    public JButton clientOperationsButton;
    public JButton productOperationsButton;
    public JButton createProductOrdersButton;
    public View(){
        setPreferredSize(new Dimension(450, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        welcomeLabel = new JLabel("W E L C O M E");
        welcomeLabel.setBounds(165, 0, 400, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        clientOperationsButton = new JButton("Client Operations");
        clientOperationsButton.setBounds(110, 50, 220, 50);
        clientOperationsButton.setFont(new Font("Arial", Font.BOLD, 20));
        clientOperationsButton.setBackground(new Color(144, 238, 144));

        productOperationsButton = new JButton("Product Operations");
        productOperationsButton.setBounds(110, 105, 220, 50);
        productOperationsButton.setFont(new Font("Arial", Font.BOLD, 20));
        productOperationsButton.setBackground(new Color(144, 238, 144));

        createProductOrdersButton = new JButton("Create Order");
        createProductOrdersButton.setBounds(110, 160, 220, 50);
        createProductOrdersButton.setFont(new Font("Arial", Font.BOLD, 20));
        createProductOrdersButton.setBackground(new Color(144, 238, 144));


        panel.add(welcomeLabel);
        panel.add(clientOperationsButton);
        panel.add(productOperationsButton);
        panel.add(createProductOrdersButton);
        panel.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(panel);



        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
