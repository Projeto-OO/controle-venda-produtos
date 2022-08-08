package models;

public class Cart {
  private int id;
  private ProductAmount[] products;
  private Client client;
  private double totalPrice;

  public Cart(int id, ProductAmount[] products, Client client, double totalPrice) {
    this.id = id;
    this.products = products;
    this.client = client;
    this.totalPrice = totalPrice;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ProductAmount[] getProducts() {
    return products;
  }

  public void setProducts(ProductAmount[] products) {
    this.products = products;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
