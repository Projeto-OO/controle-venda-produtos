package controllers;

import database.Store;
import models.Address;
import models.Cart;
import models.Client;
import models.Payment;

public class ClientController {
  private Store database;

  public void Create(
      String name,
      String email,
      String password,
      Address address,
      String cpf,
      String rg,
      String cellphone,
      Payment payment,
      Cart[] pastOrders,
      Cart currentOrder) {
    Client client = new Client(name, email, password, cpf, rg, cellphone, address, payment);
    database.addClient(client);
  }
}
