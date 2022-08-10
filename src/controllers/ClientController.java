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

  public void Create(
      String name,
      String email,
      Address address,
      String cpf,
      String rg,
      String cellphone,
      Payment payment) {
    Client client = new Client(name, email, cpf, rg, cellphone, address, payment);
    database.addClient(client);
  }

  public ArrayList<Client> ReadAll() {
    return this.database.getClients();
  }

  public Client ReadOne(String email) {
    return this.database.getClient(email);
  }

  public void Update(Client client) {
    this.database.updateClient(client);
  }

  public void Delete(Client client) {
    this.database.removeClient(client);
  }
}
