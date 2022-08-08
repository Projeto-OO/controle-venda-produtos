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

  public Store(String name) {
    this.name = name;
    this.admins = new ArrayList<Admin>();
    this.clients = new ArrayList<Client>();
    this.products = new ArrayList<Product>();
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

  public void addProduct(Product product) {
    this.products.add(product);
  }

  public void removeProduct(Product product) {
    this.products.remove(product);
  }

  public void addClient(Client client) {
    this.clients.add(client);
  }

  public void removeClient(Client client) {
    this.clients.remove(client);
  }

  public void addAdmin(Admin admin) {
    this.admins.add(admin);
  }

  public void removeAdmin(Admin admin) {
    this.admins.remove(admin);
  }

  public Client getClient(String email) {
    Client clientFound = null;

    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getEmail().equals(email)) {
        clientFound = clients.get(i);
        return clientFound;
      }
    }

    return clientFound;
  }

  public void updateClient(Client client) {
    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getEmail().equals(client.getEmail())) {
        clients.set(i, client);
      }
    }
  }

  public void deleteClient(Client client) {
    for (int i = 0; i < clients.size(); i++) {
      if (clients.get(i).getEmail().equals(client.getEmail())) {
        clients.remove(i);
      }
    }
  }
}
