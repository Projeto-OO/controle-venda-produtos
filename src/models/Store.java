package models;

import java.util.ArrayList;

/**
 * Classe que representa um banco de dados em memória.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class Store {
  private String name;
  private ArrayList<Admin> admins;
  private ArrayList<Client> clients;
  private ArrayList<Product> products;

  private static Store instance = null;

  /**
   * Instancia um novo banco de dados se um banco de dados não existir. Caso
   * contrário, retorna o banco de dados existente.
   */
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

  /**
   * Preenche a base de dados com dados gerados em loop.
   */
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

  /**
   * Limpa a base de dados.
   * 
   */
  public void clearDatabase() {
    this.admins.clear();
    this.clients.clear();
    this.products.clear();
  }
}
