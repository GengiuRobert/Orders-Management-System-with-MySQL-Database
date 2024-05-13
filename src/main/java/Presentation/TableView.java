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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.List;

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
            if (firstObject != null) {
                Field[] fields = firstObject.getClass().getDeclaredFields();
                for (Field field : fields) {
                    model.addColumn(field.getName());
                }

                for (Object obj : objects) {
                    Object[] rowData = new Object[fields.length];
                    int i = 0;
                    for (Field field : fields) {
                        field.setAccessible(true);
                        try {
                            rowData[i] = field.get(obj);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                    model.addRow(rowData);
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
