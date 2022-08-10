package database;

import java.util.ArrayList;

import models.Admin;
import models.Client;
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
}
