package models;

import java.util.ArrayList;

public class Cart {
  private ArrayList<ProductAmount> products;
  private double totalPrice;

  public Cart(ArrayList<ProductAmount> products, double totalPrice) {
    this.products = products;
    this.totalPrice = totalPrice;
  }

  public ArrayList<ProductAmount> getProducts() {
    return products;
  }

  public void setProducts(ArrayList<ProductAmount> products) {
    this.products = products;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
