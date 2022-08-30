package models;

/**
 * Classe que representa um produto.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class Product {
  private String name;
  private double salePrice;
  private double factoryPrice;
  private int stock;
  private String category;

  /**
   * Construtor da classe Product
   * 
   * @param name         Nome do produto
   * @param salePrice    Preço de venda do produto
   * @param factoryPrice Preço de fábrica do produto
   * @param stock        Quantidade em estoque do produto
   * @param category     Categoria do produto
   * 
   */
  public Product(String name, double salePrice, double factoryPrice, int stock, String category) {
    this.name = name;
    this.salePrice = salePrice;
    this.factoryPrice = factoryPrice;
    this.stock = stock;
    this.category = category;
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
}
