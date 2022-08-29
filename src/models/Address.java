package models;

/**
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 *          Classe que representa o endereço de um usuário
 * 
 */
public class Address {
  private String state;
  private String city;
  private String cep;
  private int number;
  private String complement;

  /**
   * Construtor da classe Address
   * 
   * @param state      Estado do endereço
   * @param city       Cidade do endereço
   * @param cep        CEP do endereço
   * @param number     Número do endereço
   * @param complement Complemento do endereço
   */
  public Address(String state, String city, String cep, int number, String complement) {
    this.state = state;
    this.city = city;
    this.cep = cep;
    this.number = number;
    this.complement = complement;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }
}
