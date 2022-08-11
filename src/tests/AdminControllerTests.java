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
  }

  @Test
  void createAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");

    assertEquals("Admin de Teste", database.getAdmins().get(0).getName());
    database.clearDatabase();
  }

  @Test
  void readAllAdminsTest() {
    adminController.createAdmin("Admin de Teste 1", "test1@admin.com", "admin123");
    adminController.createAdmin("Admin de Teste 2", "test2@admin.com", "admin123");

    assertEquals(2, adminController.readAllAdmins().size());
    database.clearDatabase();
  }

  @Test
  void readOneAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");

    assertEquals("Admin de Teste", adminController.readOneAdmin("test@admin.com").getName());
    database.clearDatabase();
  }

  @Test
  void updateAdminTest() {
    adminController.createAdmin("Admin de Teste", "test@admin.com", "admin123");
    adminController.updateAdmin(new Admin("Admin de Teste Editado", "test@admin.com", "admin123"));

    assertEquals("Admin de Teste Editado", adminController.readOneAdmin("test@admin.com").getName());
    database.clearDatabase();
  }

  @Test
  void deleteAdminTest() {
    adminController.createAdmin("Admin de Teste", "test1@admin.com", "admin123");

    assertEquals(1, adminController.readAllAdmins().size());

    adminController.deleteAdmin(database.getAdmins().get(0));

    assertEquals(0, adminController.readAllAdmins().size());
    database.clearDatabase();
  }
}
