package BusinessLogic.Validators;

import Model.Client;
/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * Class to validate the age of the client
 */
public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 50;

    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Student Age limit is not respected!");
        }

    }

}
