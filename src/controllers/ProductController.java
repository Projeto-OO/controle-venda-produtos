package controllers;

import java.util.ArrayList;

import models.Product;
import models.Store;

/**
 * Classe que controla as regras de negócio do produto.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class ProductController {
  private Store database;

  /**
   * Construtor da classe ProductController
   * 
   */
  public ProductController() {
    this.database = Store.getInstance();
  }

  /**
   * Adiciona um produto ao banco de dados.
   * 
   * @param name         Nome do produto
   * @param salePrice    Preço de venda do produto
   * @param factoryPrice Preço de fábrica do produto
   * @param stock        Quantidade do produto
   * @param category     Categoria do produto
   */
  public void createProduct(
      String name, double salePrice, double factoryPrice, int stock, String category) {
    Product product = new Product(name, salePrice, factoryPrice, stock, category);
    this.database.getProducts().add(product);
  }

  /**
   * Lista um produto do banco de dados a partir de seu nome.
   * 
   * @param name Nome do produto
   * @return Produto
   */
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

  /**
   * Lista todos os produtos do banco de dados.
   * 
   * @return ArrayList de produtos
   */
  public ArrayList<Product> readAllProducts() {
    return this.database.getProducts();
  }

  /**
   * Atualiza um produto do banco de dados.
   * 
   * @param Product produto a ser atualizado
   */
  public void updateProduct(Product product) {
    for (int i = 0; i < this.database.getProducts().size(); i++) {
      if (this.database.getProducts().get(i).getName().equals(product.getName())) {
        this.database.getProducts().set(i, product);
        break;
      }
    }
  }

  /**
   * Remove um produto do banco de dados.
   * 
   * @param Product produto a ser removido
   */
  public void deleteProduct(Product product) {
    this.database.getProducts().remove(product);
  }
}
