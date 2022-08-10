import controllers.ClientController;
import database.Store;
import models.Address;
import models.Payment;
import views.MainView;

public class Main {
  public static void main(String[] args) {
    new MainView();

    Store database = Store.getInstance();

    ClientController clientController = new ClientController(database);

    Payment brunoPayment = new Payment("débito", "1234567", 123, "12/2025");
    Address brunoAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");
    clientController.Create("bruno", "brunão@gmail.com", brunoAddress, "123.456.789-10", "1234",
        "6199999999", brunoPayment);

    System.out.println(database.getClients());
  }
}
