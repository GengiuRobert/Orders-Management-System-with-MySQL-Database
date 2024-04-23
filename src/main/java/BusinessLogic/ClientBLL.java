package BusinessLogic;

import BusinessLogic.Validators.ClientAgeValidator;
import BusinessLogic.Validators.EmailValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
The ClientBLL class manages the business logic for operations related to clients.
 * This class provides methods to perform operations such as finding, inserting, updating, and deleting clients from the database.
 * It also includes methods for validating client data before processing.
 * The class utilizes a ClientDAO object to interact with the database and execute the corresponding CRUD (Create, Read, Update, Delete) operations.
 * To use this class, initialize a ClientBLL object and then call its methods as needed.
 */

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
        clientDAO = new ClientDAO();
    }

    public List<Client> getAllClients() {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> allClients = clientDAO.findAll();
        if (allClients.isEmpty()) {
            System.out.println("No clients found!");
        } else {
            System.out.println("All clients retrieved successfully!");
        }
        return allClients;
    }

    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }else{
            System.out.println("Client with id " + id + " found");
        }
        return st;
    }

    public void insertClient(Client client) {
        clientDAO.insert(client);
    }
    public void updateClient(Client client) {
        clientDAO.update(client);
    }
    public void deleteClientById(Client client) {
        clientDAO.delete(client);
    }
}
