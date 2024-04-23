package Presentation;

import Model.Client;
import Model.Orderr;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 * The TableView class represents a graphical component for displaying data in tabular format.
 * It provides a visual representation of data stored in a list or a database table.
 * This class allows users to view and interact with tabular data, such as clients, orders, or products.
 * TableView typically includes features for sorting, filtering, and selecting data rows.
 * It serves as a convenient way to present data to users in an organized and structured manner.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class TableView extends JFrame {
    public JPanel panel;
    public JTable tableView;

    public TableView(List<?> objects) {
        setTitle("Table View");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (!objects.isEmpty()) {
            Object firstObject = objects.get(0);
            if (firstObject instanceof Client) {
                model.addColumn("ID");
                model.addColumn("Name");
                model.addColumn("Email");
                model.addColumn("Age");
                for (Object obj : objects) {
                    Client client = (Client) obj;
                    model.addRow(new Object[]{
                            client.getId(),
                            client.getName(),
                            client.getEmail(),
                            client.getAge()
                    });
                }
            } else if (firstObject instanceof Orderr) {
                model.addColumn("ID");
                model.addColumn("Client ID");
                model.addColumn("Product ID");
                model.addColumn("Client Name");
                model.addColumn("Product Name");
                model.addColumn("Product Quantity");
                for (Object obj : objects) {
                    Orderr order = (Orderr) obj;
                    model.addRow(new Object[]{
                            order.isId(),
                            order.getClientID(),
                            order.getProductID(),
                            order.getClientName(),
                            order.getProductName(),
                            order.isQuantity()
                    });
                }
            } else if (firstObject instanceof Product) {
                model.addColumn("ID");
                model.addColumn("Name");
                model.addColumn("Price");
                model.addColumn("Quantity");

                for (Object obj : objects) {
                    Product product = (Product) obj;
                    model.addRow(new Object[]{
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            product.getQuantity()
                    });
                }
            }
        }

        tableView = new JTable(model);
        tableView.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tableView);
        scrollPane.setBounds(50, 50, 700, 400);
        panel.add(scrollPane);
        panel.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }
}
