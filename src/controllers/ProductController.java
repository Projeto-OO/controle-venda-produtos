package controllers;

import java.util.ArrayList;

import database.Store;
import models.Product;

public class ProductController {
  private Store database;

  public ProductController() {
    this.database = Store.getInstance();
  }

  public void createProduct(
      String name, double salePrice, double factoryPrice, int stock, String category) {
    Product product = new Product(name, salePrice, factoryPrice, stock, category);
    this.database.getProducts().add(product);
  }

  public Product readOneProduct(String name) {
    Product productFound = null;

    for (Product product : this.database.getProducts()) {
      if (product.getName().equals(name)) {
        productFound = product;
        break;
      }
    }

    return productFound;
  }

  public ArrayList<Product> readAllProducts() {
    return this.database.getProducts();
  }

  public void updateProduct(Product product) {
    for (int i = 0; i < this.database.getProducts().size(); i++) {
      if (this.database.getProducts().get(i).getName().equals(product.getName())) {
        this.database.getProducts().set(i, product);
        break;
      }
    }
  }

  public void deleteProduct(Product product) {
    this.database.getProducts().remove(product);
  }
}
