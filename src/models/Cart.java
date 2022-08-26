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
    double totalPrice = 0;

    for (ProductAmount productAmount : products) {
      totalPrice += productAmount.getProduct().getSalePrice() * productAmount.getAmount();
    }

    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String toString() {
    return "Total de Produtos Comprados: " + this.getProducts().size() + ", Valor Total: " + this.getTotalPrice();
  }
}
