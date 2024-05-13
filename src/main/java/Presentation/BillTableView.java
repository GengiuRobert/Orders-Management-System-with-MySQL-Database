package Presentation;
import Connection.ConnectionFactory;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Vector;

public class BillTableView extends JFrame {

    private JTable tableView;
    private DefaultTableModel tableModel;

    public BillTableView() {
        setTitle("Bill Table View");
        setSize(800, 600);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Client Name");
        tableModel.addColumn("Product Type");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Total Amount");

        tableView = new JTable(tableModel);
        tableView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableView.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));

        JScrollPane scrollPane = new JScrollPane(tableView);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        populateTable();
        addTableModelListener();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateTable() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM bill");

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("billId"));
                row.add(resultSet.getString("clientName"));
                row.add(resultSet.getString("productName"));
                row.add(resultSet.getInt("quantity"));
                row.add(resultSet.getFloat("totalPrice"));
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private void addTableModelListener() {
        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (column != -1) {
                    int billId = (int) tableModel.getValueAt(row, 0);
                    String clientName = (String) tableModel.getValueAt(row, 1);
                    String productName = (String) tableModel.getValueAt(row, 2);
                    Object quantityObject = tableModel.getValueAt(row, 3);
                    Object totalPriceObject = tableModel.getValueAt(row, 4);

                    if (quantityObject instanceof Integer && totalPriceObject instanceof BigDecimal totalPrice) {
                        int quantity = (int) quantityObject;
                        updateDatabase(billId, clientName, productName, quantity, totalPrice);
                    } else {
                        System.err.println("Invalid data types for Quantity or Total Price.");
                    }
                }
            }
        });
    }

    private void updateDatabase(int billId, String clientName, String productName, int quantity, BigDecimal totalPrice) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "UPDATE bill SET clientName = ?, productName = ?, quantity = ?, totalPrice = ? WHERE billId = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, clientName);
            statement.setString(2, productName);
            statement.setInt(3, quantity);
            statement.setBigDecimal(4, totalPrice);
            statement.setInt(5, billId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLException: " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}