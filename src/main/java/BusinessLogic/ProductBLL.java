package BusinessLogic;

import BusinessLogic.Validators.ClientAgeValidator;
import BusinessLogic.Validators.EmailValidator;
import BusinessLogic.Validators.ProductQuantityValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.AbstractDAO;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
The ProductBLL class manages the business logic for operations related to products.
 * This class provides methods to perform operations such as finding, inserting, updating, and deleting products from the database.
 * It also includes methods for validating quantity data before processing.
 * The class utilizes a ProductDAO object to interact with the database and execute the corresponding CRUD (Create, Read, Update, Delete) operations.
 * To use this class, initialize a ProductBLL object and then call its methods as needed.
 */


public class ProductBLL  {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductQuantityValidator());
        productDAO = new ProductDAO();
    }

    public List<Product> getAllClients() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productDAOAll = productDAO.findAll();
        if (productDAOAll.isEmpty()) {
            System.out.println("No products found!");
        } else {
            System.out.println("All products retrieved successfully!");
        }
        return productDAOAll;
    }

    public Product findClientById(int id) {
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }else{
            System.out.println("Product with id " + id + " found");
        }
        return st;
    }

    public void insertProduct(Product product) {
        productDAO.insert(product);
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        Product product = productDAO.findById(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            productDAO.update(product);
        }
    }
    public void updateProduct(Product product) {
        productDAO.update(product);
    }
    public void deleteProductById(Product product) {
        productDAO.delete(product);
    }
}
