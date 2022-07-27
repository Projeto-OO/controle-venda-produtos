package models;

public class Product {
  private int id;
  private String name;
  private double salePrice;
  private double factoryPrice;
  private int stock;
  private String category;

  public Product(int id, String name, double salePrice, double factoryPrice, int stock, String category) {
    this.id = id;
    this.name = name;
    this.salePrice = salePrice;
    this.factoryPrice = factoryPrice;
    this.stock = stock;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getSalePrice() {
    return salePrice;
  }

  public double getFactoryPrice() {
    return factoryPrice;
  }

  public int getStock() {
    return stock;
  }

  public String getCategory() {
    return category;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSalePrice(double salePrice) {
    this.salePrice = salePrice;
  }

  public void setFactoryPrice(double factoryPrice) {
    this.factoryPrice = factoryPrice;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Product {" +
        "id = " + id +
        ", name = '" + name + '\'' +
        ", salePrice = " + salePrice +
        ", factoryPrice = " + factoryPrice +
        ", stock = " + stock +
        ", category = '" + category + '\'' +
        '}';
  }
}
