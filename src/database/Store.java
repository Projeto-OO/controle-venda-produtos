package database;

import java.util.ArrayList;

import models.Address;
import models.Admin;
import models.Client;
import models.Payment;
import models.Product;

public class Store {
  private String name;
  private ArrayList<Admin> admins;
  private ArrayList<Client> clients;
  private ArrayList<Product> products;

  private static Store instance = null;

  // Singleton to avoid multiple instances of the database
  public static Store getInstance() {
    if (instance == null) {
      instance = new Store();
      instance.admins = new ArrayList<Admin>();
      instance.clients = new ArrayList<Client>();
      instance.products = new ArrayList<Product>();
    }
    return instance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Admin> getAdmins() {
    return admins;
  }

  public void setAdmins(ArrayList<Admin> admins) {
    this.admins = admins;
  }

  public ArrayList<Client> getClients() {
    return clients;
  }

  public void setClients(ArrayList<Client> clients) {
    this.clients = clients;
  }

  public ArrayList<Product> getProducts() {
    return products;
  }

  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }

  public static void fillDatabase() {
    instance.admins.add(new Admin("admin", "admin@admin.com", "admin"));

    for (int i = 1; i <= 100; i++) {
      instance.products.add(new Product("Product " + i, i * 2, i, i, "Category " + i));
    }

    for (int i = 1; i <= 100; i++) {
      Address address = new Address("Distrito " + i, "Cidade " + i, String.valueOf(i * i * i), i, "Casa " + i);
      Payment payment = new Payment("Débito", String.valueOf(i * i * i * i), i * i, String.valueOf(i + '/' + i));

      instance.clients.add(new Client("Cliente " + i, "cliente" + i + "@unb.br", String.valueOf(i * i * i * i),
          String.valueOf(i * i * i), String.valueOf(i * i * i * i * 2), address, payment));
    }
  }

  public void clearDatabase() {
    this.admins.clear();
    this.clients.clear();
    this.products.clear();
  }
}
