package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * The ProductView class represents the graphical user interface (GUI) component for managing product-related operations.
 * It provides functionalities for viewing, adding, updating, and deleting product information.
 * This view class presents product data in a structured manner and offers interactive features for user engagement.
 * Users can perform actions such as adding new products, modifying existing product details, and removing products from the system.
 * The ProductView class ensures smooth interaction between users and the underlying business logic layer.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class ProductView extends JFrame {

    public JPanel panel;
    public JButton showProductTableButton;
    public JTextField newProductNameTextField;
    public JTextField newProductIDTextField;
    public JTextField newProductPriceTextField;
    public JLabel newProductLabel;
    public JLabel newProductNameLabel;
    public JLabel newProductPriceLabel;
    public JLabel newProductIDLabel;
    public JButton newProductButton;
    public JTextField editProductNameTextField;
    public JTextField editProductPriceTextField;
    public JLabel editProductLabel;
    public JLabel editProductNameLabel;
    public JLabel editProductPriceLabel;
    public JLabel editProductIDLabel;
    public JTextField editProductIDTextField;
    public JButton editProductButton;
    public JLabel deleteProductLabel;
    public JLabel deleteProductIDLabel;
    public JTextField deleteProductIDTextField;
    public JButton deleteProductButton;
    public JLabel mandatoryCreateLabel;
    public JLabel mandatoryEditLabel;
    public JLabel mandatoryDeleteLabel;
    public JLabel newProductQuantityLabel;
    public JLabel editProductQuantityLabel;
    public JTextField newProductQuantityTextField;
    public JTextField editProductQuantityTextField;

    public ProductView(){
        setTitle("Products View");
        setPreferredSize(new Dimension(800, 600));
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        showProductTableButton = new JButton("Show Products");
        showProductTableButton.setBounds(300, 5, 220, 50);
        showProductTableButton.setFont(new Font("Arial", Font.BOLD, 20));
        showProductTableButton.setBackground(new Color(144, 238, 144));

        mandatoryCreateLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryCreateLabel.setBounds(350, 120, 500, 40);
        mandatoryCreateLabel.setFont(new Font("Arial", Font.BOLD, 25));

        newProductLabel = new JLabel("Create New Product Section");
        newProductLabel.setBounds(25, 60, 400, 30);
        newProductLabel.setFont(new Font("Arial", Font.BOLD, 18));

        newProductIDLabel = new JLabel("Introduce ID");
        newProductIDLabel.setBounds(5, 95, 400, 15);
        newProductIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newProductNameLabel = new JLabel("Introduce Name");
        newProductNameLabel.setBounds(5, 120, 400, 15);
        newProductNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newProductPriceLabel = new JLabel("Introduce Price");
        newProductPriceLabel.setBounds(5, 145, 400, 15);
        newProductPriceLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newProductQuantityLabel = new JLabel("Introduce Quantity");
        newProductQuantityLabel.setBounds(5, 170, 400, 15);
        newProductQuantityLabel.setFont(new Font("Arial", Font.BOLD, 15));

        newProductIDTextField = new JTextField();
        newProductIDTextField.setBounds(145, 95, 160, 20);
        newProductIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newProductIDTextField.setBackground(new Color(144, 238, 144));

        newProductNameTextField = new JTextField();
        newProductNameTextField.setBounds(145, 120, 160, 20);
        newProductNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newProductNameTextField.setBackground(new Color(144, 238, 144));

        newProductPriceTextField = new JTextField();
        newProductPriceTextField.setBounds(145, 145, 160, 20);
        newProductPriceTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newProductPriceTextField.setBackground(new Color(144, 238, 144));

        newProductQuantityTextField = new JTextField();
        newProductQuantityTextField.setBounds(145, 170, 160, 20);
        newProductQuantityTextField.setFont(new Font("Arial", Font.BOLD, 12));
        newProductQuantityTextField.setBackground(new Color(144, 238, 144));

        newProductButton = new JButton("Create Product");
        newProductButton.setBounds(25, 195, 220, 30);
        newProductButton.setFont(new Font("Arial", Font.BOLD, 15));
        newProductButton.setBackground(new Color(144, 238, 144));

        mandatoryEditLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryEditLabel.setBounds(350, 315, 500, 40);
        mandatoryEditLabel.setFont(new Font("Arial", Font.BOLD, 25));

        editProductLabel = new JLabel("Edit Product Section (by ID)");
        editProductLabel.setBounds(25, 250, 400, 30);
        editProductLabel.setFont(new Font("Arial", Font.BOLD, 18));

        editProductIDLabel = new JLabel("Introduce ID");
        editProductIDLabel.setBounds(5, 285, 400, 15);
        editProductIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editProductNameLabel = new JLabel("Introduce Name");
        editProductNameLabel.setBounds(5, 310, 400, 15);
        editProductNameLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editProductPriceLabel = new JLabel("Introduce Price");
        editProductPriceLabel.setBounds(5, 335, 400, 15);
        editProductPriceLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editProductQuantityLabel = new JLabel("Introduce Quantity");
        editProductQuantityLabel.setBounds(5, 360, 400, 15);
        editProductQuantityLabel.setFont(new Font("Arial", Font.BOLD, 15));

        editProductIDTextField = new JTextField();
        editProductIDTextField.setBounds(145, 285, 160, 20);
        editProductIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editProductIDTextField.setBackground(new Color(144, 238, 144));

        editProductNameTextField = new JTextField();
        editProductNameTextField.setBounds(145, 310, 160, 20);
        editProductNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editProductNameTextField.setBackground(new Color(144, 238, 144));

        editProductPriceTextField = new JTextField();
        editProductPriceTextField.setBounds(145, 335, 160, 20);
        editProductPriceTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editProductPriceTextField.setBackground(new Color(144, 238, 144));

        editProductQuantityTextField = new JTextField();
        editProductQuantityTextField.setBounds(145, 360, 160, 20);
        editProductQuantityTextField.setFont(new Font("Arial", Font.BOLD, 12));
        editProductQuantityTextField.setBackground(new Color(144, 238, 144));


        editProductButton = new JButton("Edit Product");
        editProductButton.setBounds(25, 385, 220, 30);
        editProductButton.setFont(new Font("Arial", Font.BOLD, 15));
        editProductButton.setBackground(new Color(144, 238, 144));

        mandatoryDeleteLabel = new JLabel("Mandatory fields in the section -> all");
        mandatoryDeleteLabel.setBounds(350, 465, 500, 40);
        mandatoryDeleteLabel.setFont(new Font("Arial", Font.BOLD, 25));

        deleteProductLabel = new JLabel("Delete Product Section (by ID)");
        deleteProductLabel.setBounds(25, 440, 400, 30);
        deleteProductLabel.setFont(new Font("Arial", Font.BOLD, 18));

        deleteProductIDLabel = new JLabel("Introduce ID");
        deleteProductIDLabel.setBounds(5, 475, 400, 15);
        deleteProductIDLabel.setFont(new Font("Arial", Font.BOLD, 15));

        deleteProductIDTextField = new JTextField();
        deleteProductIDTextField.setBounds(145, 475, 160, 20);
        deleteProductIDTextField.setFont(new Font("Arial", Font.BOLD, 12));
        deleteProductIDTextField.setBackground(new Color(144, 238, 144));

        deleteProductButton = new JButton("Delete Product");
        deleteProductButton.setBounds(25, 500, 220, 30);
        deleteProductButton.setFont(new Font("Arial", Font.BOLD, 15));
        deleteProductButton.setBackground(new Color(144, 238, 144));

        panel.add(editProductQuantityLabel);
        panel.add(editProductQuantityTextField);
        panel.add(newProductQuantityLabel);
        panel.add(newProductQuantityTextField);
        panel.add(mandatoryDeleteLabel);
        panel.add(mandatoryEditLabel);
        panel.add(mandatoryCreateLabel);
        panel.add(deleteProductButton);
        panel.add(deleteProductIDTextField);
        panel.add(deleteProductLabel);
        panel.add(deleteProductIDLabel);
        panel.add(editProductLabel);
        panel.add(editProductButton);
        panel.add(editProductIDTextField);
        panel.add(editProductNameTextField);
        panel.add(editProductPriceTextField);
        panel.add(editProductIDLabel);
        panel.add(editProductNameLabel);
        panel.add(editProductPriceLabel);
        panel.add(showProductTableButton);
        panel.add(newProductButton);
        panel.add(newProductPriceTextField);
        panel.add(newProductPriceLabel);
        panel.add(newProductNameTextField);
        panel.add(newProductNameLabel);
        panel.add(newProductLabel);
        panel.add(newProductIDLabel);
        panel.add(newProductIDTextField);
        panel.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(panel);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public int getNewProductIDTextField() {
        return Integer.parseInt(newProductIDTextField.getText());
    }
    public String getNewProductNameTextField() {
        return newProductNameTextField.getText();
    }
    public int getNewPriceTextField() {
        return Integer.parseInt(newProductPriceTextField.getText());
    }
    public int getNewProductQuantityTextField() {
        return Integer.parseInt(newProductQuantityTextField.getText());
    }

    public int getEditProductIDTextField() {
        return Integer.parseInt(editProductIDTextField.getText());
    }
    public String getEditProductNameTextField() {
        return editProductNameTextField.getText();
    }
    public int getEditPriceTextField() {
        return Integer.parseInt(editProductPriceTextField.getText());
    }
    public int getEditProductQuantityTextField() {
        return Integer.parseInt(editProductQuantityTextField.getText());
    }


    public int getDeleteProductIDTextField() {
        return Integer.parseInt(deleteProductIDTextField.getText());
    }
}
