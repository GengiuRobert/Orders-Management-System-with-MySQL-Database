package BusinessLogic.Validators;

/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * validator interface
 */
public interface Validator<T> {

    public void validate(T t);
}
