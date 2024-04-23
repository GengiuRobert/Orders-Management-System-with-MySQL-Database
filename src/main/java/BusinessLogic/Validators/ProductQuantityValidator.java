package BusinessLogic.Validators;

import Model.Product;
/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * Class to validate the quantity  of the product
 */
public class ProductQuantityValidator implements Validator<Product>{
    private static final int MIN_QUANTITY = 5;

    public void validate(Product t) {

        if (t.getQuantity() < MIN_QUANTITY) {
            throw new IllegalArgumentException("The Product quantity minimum limit is not respected!");
        }

    }
}
