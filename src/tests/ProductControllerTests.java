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
  }

  @Test
  void createProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");

    assertEquals("Pão", database.getProducts().get(0).getName());
    this.database.clearDatabase();
  }

  @Test
  void readOneProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");

    assertEquals("Pão", productController.readOneProduct("Pão").getName());
    this.database.clearDatabase();
  }

  @Test
  void readAllProductsTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.createProduct("Pão 2", 2, 1, 100, "Alimento 2");

    assertEquals(2, productController.readAllProducts().size());
    this.database.clearDatabase();
  }

  @Test
  void updateProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.updateProduct(new Product("Pão", 2, 1, 100, "Alimento Editado"));

    assertEquals("Alimento Editado", productController.readOneProduct("Pão").getCategory());
    this.database.clearDatabase();
  }

  @Test
  void deleteProductTest() {
    productController.createProduct("Pão", 2, 1, 100, "Alimento");
    productController.deleteProduct(productController.readOneProduct("Pão"));

    assertEquals(0, productController.readAllProducts().size());
    this.database.clearDatabase();
  }
}
