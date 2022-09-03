package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.AdminController;
import database.Store;
import models.Admin;

public class AdminControllerTests {
  Store database;
  AdminController adminController;

  @BeforeEach
  void setUp() {
    this.database = Store.getInstance();
    this.adminController = new AdminController();
    this.database.clearDatabase();
  }

  // Deve ser possível criar um administrador
  @Test
  void createAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");

    assertEquals("Admin de Teste", database.getAdmins().get(0).getName());
  }

  // Deve ser possível ler todos os administradores
  @Test
  void readAllAdminsTest() {
    adminController.createAdmin("Admin de Teste 1", "test1@admin.com", "admin123");
    adminController.createAdmin("Admin de Teste 2", "test2@admin.com", "admin123");

    assertEquals(2, adminController.readAllAdmins().size());
  }

  // Deve ser possível ler um administrador
  @Test
  void readOneAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");

    assertEquals("Admin de Teste", adminController.readOneAdmin("test@admin.com").getName());
  }

  // Deve ser possível atualizar um administrador
  @Test
  void updateAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");
    adminController.updateAdmin(new Admin("Admin de Teste Editado", "test@admin.com", "admin123"));

    assertEquals("Admin de Teste Editado", adminController.readOneAdmin("test@admin.com").getName());
  }

  // Deve ser possível deletar um administrador
  @Test
  void deleteAdminTest() {
    adminController.createAdmin("Admin de Teste", "test1@admin.com", "admin123");

    assertEquals(1, adminController.readAllAdmins().size());

    adminController.deleteAdmin(database.getAdmins().get(0));

    assertEquals(0, adminController.readAllAdmins().size());
  }
}
