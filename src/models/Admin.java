package models;

/**
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 *         Classe que herda de Person e representa um administrador do sistema.
 * 
 */
public class Admin extends Person {

  private String password;

  /**
   * Construtor da classe Admin
   * 
   * @param name     Nome do administrador
   * @param email    Email do administrador
   * @param password Senha do administrador
   * 
   */
  public Admin(String name, String email, String password) {
    super(name, email);

    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
