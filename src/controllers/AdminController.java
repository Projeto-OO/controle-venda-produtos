package controllers;

import java.util.ArrayList;

import database.Store;
import models.Admin;

public class AdminController {
  private Store database;

  public AdminController() {
    this.database = Store.getInstance();
  }

  public void createAdmin(String name, String email, String password) {
    Admin admin = new Admin(name, email, password);
    this.database.getAdmins().add(admin);
  }

  public ArrayList<Admin> readAllAdmins() {
    return this.database.getAdmins();
  }

  public Admin readOneAdmin(String email) {
    Admin adminFound = null;

    for (Admin admin : this.database.getAdmins()) {
      if (admin.getEmail().equals(email)) {
        adminFound = admin;
        break;
      }
    }

    return adminFound;
  }

  public void updateAdmin(Admin admin) {
    for (int i = 0; i < this.database.getAdmins().size(); i++) {
      if (this.database.getAdmins().get(i).getEmail().equals(admin.getEmail())) {
        this.database.getAdmins().set(i, admin);
        break;
      }
    }
  }

  public void deleteAdmin(Admin admin) {
    this.database.getAdmins().remove(admin);
  }

  public boolean login(String email, String password) {

    for (Admin admin : this.database.getAdmins()) {
      if (admin.getEmail().equals(email) && password.equals(admin.getPassword())) {
        return true;
      }
    }

    return false;
  }
}
