package models;

import java.util.ArrayList;

/**
 * Classe que guarda um conjunto de produtos e o preço total da compra.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 */
public class Cart {
  private ArrayList<ProductAmount> products;
  private double totalPrice;

  /**
   * Construtor da classe Cart
   * 
   * @param products   Conjunto de produtos do carrinho
   * @param totalPrice Preço total da compra
   * 
   */
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
    for (ProductAmount productAmount : products) {
      totalPrice += productAmount.getProduct().getSalePrice() * productAmount.getAmount();
    }

    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Sobrescreve o método toString da classe Object
   * para exibir um resumo do carrinho.
   */
  @Override
  public String toString() {
    int totalProductsBought = 0;
    double totalPrice = 0;

    for (int i = 0; i < products.size(); i++) {
      totalProductsBought += products.get(i).getAmount();
      totalPrice += products.get(i).getProduct().getSalePrice() * products.get(i).getAmount();
    }

    return "Total de Produtos Comprados: " + totalProductsBought + " - Valor Total: " + totalPrice;
  }
}
