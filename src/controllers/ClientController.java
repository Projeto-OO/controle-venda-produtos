package controllers;

import java.util.ArrayList;

import database.Store;
import models.Address;
import models.Client;
import models.Payment;

public class ClientController {
  private Store database;

  public ClientController() {
    this.database = Store.getInstance();
  }

  public void createClient(
      String name,
      String email,
      Address address,
      String cpf,
      String rg,
      String cellphone,
      Payment payment) {
    Client client = new Client(name, email, cpf, rg, cellphone, address, payment);
    database.getClients().add(client);
  }

  public ArrayList<Client> readAllClients() {
    return this.database.getClients();
  }

  public Client readOneClient(String email) {
    Client clientFound = null;

    for (Client client : this.database.getClients()) {
      if (client.getEmail().equals(email)) {
        clientFound = client;
      }
    }

    return clientFound;
  }

  public void updateClient(Client client) {
    for (int i = 0; i < this.database.getClients().size(); i++) {
      if (this.database.getClients().get(i).getEmail().equals(client.getEmail())) {
        this.database.getClients().set(i, client);
      }
    }
  }

  public void deleteClient(Client client) {
    this.database.getClients().remove(client);
  }
}
