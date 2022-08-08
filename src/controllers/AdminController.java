package controllers;

import java.util.ArrayList;

import database.Store;
import models.Admin;

public class AdminController {
  private Store database;

  public AdminController(Store database) {
    this.database = database;
  }

  public void Create(String name, String email, String password) {
    Admin admin = new Admin(name, email, password);
    this.database.addAdmin(admin);
  }

  public ArrayList<Admin> ReadAll() {
    return this.database.getAdmins();
  }

  public Admin ReadOne(String email) {
    return this.database.getAdmin(email);
  }

  public void Update(Admin admin) {
    this.database.updateAdmin(admin);
  }

  public void Delete(Admin admin) {
    this.database.deleteAdmin(admin);
  }
}
