import DataAccess.OrderDAO;
import Model.Orderr;
import Presentation.*;
/**
 * The MainController class serves as the primary controller for managing the overall application flow.
 * It coordinates interactions between different components of the application, such as views, controllers, and business logic layers.
 * This controller class initializes the application, sets up the user interface, and handles high-level user actions.
 * It ensures proper communication between various parts of the application and facilitates the execution of business processes.
 * MainController acts as the central hub for controlling the behavior and functionality of the entire application.
 *
 * @author Gengiu Robert Constantin
 * @since April 20, 2024
 */
public class Main {
    public static void main(String[] args) {
      View view = new View();
      Controller controller = new Controller(view);

    }
}
