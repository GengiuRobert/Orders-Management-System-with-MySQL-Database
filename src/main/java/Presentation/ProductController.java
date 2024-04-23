package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;
import BusinessLogic.Validators.ProductQuantityValidator;
import Model.Client;
import Model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * The CreateOrderController class manages user interactions and business logic related to creating orders.
 * It serves as a mediator between the CreateOrderView (user interface) and the OrderBLL (business logic layer).
 * This controller class provides methods for handling user actions, such as creating a new order, displaying client and product information,
 * and updating the view based on user input.
 * It ensures proper communication between the user interface and the underlying business logic,
 * facilitating the creation and management of orders in the system.
 *
 * @author Gengiu Robert Constantin
 * @since Apr 20, 2024
 */
public class ProductController {
    public ProductView productView;
    public String productNameCreate;
    public String productNameUpdate;
    public int productIdCreate;
    public int productIdUpdate;
    public int productIdDelete;
    public int productQuantityCreate;
    public int productQuantityUpdate;
    public int productPriceCreate;
    public int productPriceUpdate;

    public ProductController(ProductView productView) {
        this.productView = productView;
        addCreateProductListener();
        addUpdateProductListener();
        addDeleteProductListener();
        showProductListener();
    }

    private void createNewProduct() {
        productNameCreate =productView.getNewProductNameTextField();
        productPriceCreate = productView.getNewPriceTextField();
        productQuantityCreate = productView.getNewProductQuantityTextField();
        productIdCreate = productView.getNewProductIDTextField();
        Product client = new Product(productIdCreate, productNameCreate,productPriceCreate,productQuantityCreate);
        validateProductQuantity(client);
        ProductBLL clientBLL = new ProductBLL();
        clientBLL.insertProduct(client);
        System.out.println("Product created");
    }

    private void updateExistingProduct() {
        productNameUpdate =productView.getEditProductNameTextField();
        productPriceUpdate = productView.getEditPriceTextField();
        productQuantityUpdate = productView.getEditProductQuantityTextField();
        productIdUpdate = productView.getEditProductIDTextField();
        Product product = new Product(productIdUpdate, productNameUpdate,productPriceUpdate,productQuantityUpdate);
        validateProductQuantity(product);
        ProductBLL clientBLL = new ProductBLL();
        clientBLL.updateProduct(product);
        System.out.println("Product updated");
    }

    private void deleteExistingProduct() {
        ProductBLL clientBLL = new ProductBLL();
        productIdDelete = productView.getDeleteProductIDTextField();
        Product client = clientBLL.findClientById(productIdDelete);
        clientBLL.deleteProductById(client);
        System.out.println("Product deleted");
    }

    private void showProducts() {

        ProductBLL clientBLL = new ProductBLL();
        List<Product> clients = clientBLL.getAllClients();
        TableView tableView = new TableView(clients);

    }

    private void addCreateProductListener() {
        productView.newProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewProduct();
            }
        });
    }

    private void addUpdateProductListener() {
        productView.editProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateExistingProduct();
            }
        });
    }

    private void addDeleteProductListener() {
        productView.deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteExistingProduct();
            }
        });
    }

    private void showProductListener() {
        productView.showProductTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProducts();
            }
        });
    }

    private void validateProductQuantity(Product product) {
        ProductQuantityValidator productQuantityValidator = new ProductQuantityValidator();
        try {
            productQuantityValidator.validate(product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
