package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ProductController;
import database.Store;
import models.Product;

public class ProductControllerTests {
  Store database;
  ProductController productController;

  @BeforeEach
  void setUp() {
    this.database = Store.getInstance();
    this.productController = new ProductController();
    this.database.clearDatabase();
  }

  // Deve ser possível criar um produto
  @Test
  void createProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");

    assertEquals("Pão", database.getProducts().get(0).getName());
  }

  // Deve ser possível ler um produto
  @Test
  void readOneProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");

    assertEquals("Pão", productController.readOneProduct("Pão").getName());
  }

  // Deve ser possível ler todos os produtos
  @Test
  void readAllProductsTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.createProduct("Pão 2", 2, 1, 100, "Alimento 2");

    assertEquals(2, productController.readAllProducts().size());
  }

  // Deve ser possível atualizar um produto
  @Test
  void updateProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.updateProduct(new Product("Pão", 2, 1, 100, "Alimento Editado"));

    assertEquals("Alimento Editado", productController.readOneProduct("Pão").getCategory());
  }

  // Deve ser possível deletar um produto
  @Test
  void deleteProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.deleteProduct(productController.readOneProduct("Pão"));

    assertEquals(0, productController.readAllProducts().size());
  }
}
