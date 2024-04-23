package BusinessLogic;

import DataAccess.OrderDAO;
import Model.Orderr;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
The OrderrBLL class manages the business logic for operations related to orders.
 * This class provides methods to perform operations such as finding, inserting orders from the database.
 * The class utilizes a OrderDAO object to interact with the database and execute the corresponding CRUD (Create, Read, Update, Delete) operations.
 * To use this class, initialize a OrderBLL object and then call its methods as needed.
 */

public class OrderBLL  {
    private OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    public List<Orderr> getAllOrders() {
        OrderDAO orderDAO = new OrderDAO();
        List<Orderr> orderList = orderDAO.findAll();
        if (orderList.isEmpty()) {
            System.out.println("No orders found!");
        } else {
            System.out.println("All orders retrieved successfully!");
        }
        return orderList;
    }

    public Orderr findOrderById(int id) {
        Orderr st = orderDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }else{
            System.out.println("Product with id " + id + " found");
        }
        return st;
    }

    public void insertOrder(Orderr order) {
        orderDAO.insert(order);
    }

}
