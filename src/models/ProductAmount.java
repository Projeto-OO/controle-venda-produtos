package models;

/**
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 *         Classe que representa a quantidade de um produto a ser adicionado no
 *         carrinho.
 * 
 */
public class ProductAmount {
  private Product product;
  private int amount;

  /**
   * Construtor da classe ProductAmount
   * 
   * @param product Produto a ser adicionado no carrinho
   * @param amount  Quantidade a ser adicionada no carrinho
   * 
   */
  public ProductAmount(Product product, int amount) {
    this.product = product;
    this.amount = amount;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
