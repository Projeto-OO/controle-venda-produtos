package controllers;

import java.util.ArrayList;

import models.Admin;
import models.Store;

/**
 * Classe que controla as regras de negócio do administrador.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class AdminController {
  private Store database;

  /**
   * Construtor da classe AdminController
   * 
   */
  public AdminController() {
    this.database = Store.getInstance();
  }

  /**
   * Adiciona um administrador ao banco de dados.
   * 
   * @param name     Nome do administrador
   * @param email    Email do administrador
   * @param password Senha do administrador
   */
  public void createAdmin(String name, String email, String password) {
    Admin admin = new Admin(name, email, password);
    this.database.getAdmins().add(admin);
  }

  /**
   * Lista todos os administradores do banco de dados.
   * 
   * @return ArrayList de administradores
   */
  public ArrayList<Admin> readAllAdmins() {
    return this.database.getAdmins();
  }

  /**
   * Lista um administrador em específico do banco de dados, a partir de seu
   * e-mail.
   * 
   * @param email Email do administrador
   * @return Administrador
   */
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

  /**
   * Atualiza um administrador do banco de dados.
   * 
   * @param Admin Administrador já atualizado
   */
  public void updateAdmin(Admin admin) {
    for (int i = 0; i < this.database.getAdmins().size(); i++) {
      if (this.database.getAdmins().get(i).getEmail().equals(admin.getEmail())) {
        this.database.getAdmins().set(i, admin);
        break;
      }
    }
  }

  /**
   * Remove um administrador do banco de dados.
   * 
   * @param email Email do administrador a ser removido
   */
  public void deleteAdmin(Admin admin) {
    this.database.getAdmins().remove(admin);
  }

  /**
   * Verifica se um administrador existe no banco de dados e se a senha
   * corresponde ao e-mail do administrador.
   * 
   * @param email    Email do administrador
   * @param password Senha do administrador
   * @return true se o login for bem sucedido, false caso contrário
   */
  public boolean login(String email, String password) {
    for (Admin admin : this.database.getAdmins()) {
      if (admin.getEmail().equals(email) && password.equals(admin.getPassword())) {
        return true;
      }
    }
    return false;
  }
}
