package models;

/**
 * Classe abstrata que representa uma pessoa.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public abstract class Person {
  private String name;
  private String email;

  /**
   * Construtor da classe Person
   * 
   * @param name  Nome da pessoa
   * @param email Email da pessoa
   * 
   */
  public Person(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Método que sobrescreve o toString() e retorna uma representação em String do
   * objeto.
   * 
   * @return String representando o objeto.
   */
  @Override
  public String toString() {
    return "Person [name=" + name + ", email=" + email + "]";
  }
}
