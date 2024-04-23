package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.Validators.ClientAgeValidator;
import BusinessLogic.Validators.EmailValidator;
import Model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @Author: Gengiu Robert Constantin
 * @Since: Apr 20, 2024
 * The ClientController class manages user interactions and business logic related to creating clients.
 * It coordinates between the ClientView (user interface) and the ClientBLL (business logic layer).
 * This controller class provides methods for handling user actions, such as creating a new client
 * It ensures proper communication between the user interface and the underlying business logic, facilitating the creation and management of orders in the system. */

public class ClientController {
    public ClientView clientView;
    public String clientNameCreate;
    public String clientNameUpdate;
    public int clientIdCreate;
    public int clientIdUpdate;
    public int clientIdDelete;
    public String clientEmailCreate;
    public String clientEmailUpdate;
    public int clientAgeCreate;
    public int clientAgeUpdate;

    public ClientController(ClientView clientView) {
        this.clientView = clientView;
        addCreateClientListener();
        addUpdateClientListener();
        addDeleteClientListener();
        showClientsListener();
    }

    private void createNewClient() {
        clientNameCreate = clientView.getNewClientNameTextField();
        clientEmailCreate = clientView.getNewEmailTextField();
        clientAgeCreate = clientView.getNewClientAgeTextField();
        clientIdCreate = clientView.getNewClientIDTextField();
        Client client = new Client(clientIdCreate, clientNameCreate, clientEmailCreate, clientAgeCreate);
        validateClientAge(client);
        validateClientEmail(client);
        ClientBLL clientBLL = new ClientBLL();
        clientBLL.insertClient(client);
        System.out.println("Client created");
    }

    private void updateExistingClient() {
        clientNameUpdate = clientView.getEditClientNameTextField();
        clientEmailUpdate = clientView.getEditEmailTextField();
        clientAgeUpdate = clientView.getEditClientAgeTextField();
        clientIdUpdate = clientView.getEditClientIDTextField();
        Client client = new Client(clientIdUpdate, clientNameUpdate, clientEmailUpdate, clientAgeUpdate);
        validateClientAge(client);
        validateClientEmail(client);
        ClientBLL clientBLL = new ClientBLL();
        clientBLL.updateClient(client);
        System.out.println("Client updated");
    }

    private void deleteExistingClient() {
        ClientBLL clientBLL = new ClientBLL();
        clientIdDelete = clientView.getDeleteClientIDTextField();
        Client client = clientBLL.findClientById(clientIdDelete);
        clientBLL.deleteClientById(client);
        System.out.println("Client deleted");
    }

    private void showClients() {

        ClientBLL clientBLL = new ClientBLL();
        List<Client> clients = clientBLL.getAllClients();
        TableView tableView = new TableView(clients);

    }

    private void addCreateClientListener() {
        clientView.newClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewClient();
            }
        });
    }

    private void addUpdateClientListener() {
        clientView.editClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateExistingClient();
            }
        });
    }

    private void addDeleteClientListener() {
        clientView.deleteClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteExistingClient();
            }
        });
    }

    private void showClientsListener() {
        clientView.showClientsTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClients();
            }
        });
    }

    private void validateClientEmail(Client client) {
        EmailValidator emailValidator = new EmailValidator();
        try {
            emailValidator.validate(client);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateClientAge(Client client) {
        ClientAgeValidator ageValidator = new ClientAgeValidator();
        try {
            ageValidator.validate(client);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
