package models;

/**
 * Classe que representa o meio de pagamento de um cliente.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class Payment {
  private String type;
  private String number;
  private int cvv;
  private String expiresAt;

  /**
   * Construtor da classe Payment
   * 
   * @param type      Tipo de pagamento
   * @param number    Número do cartão de crédito
   * @param cvv       CVV do cartão de crédito
   * @param expiresAt Data de expiração do cartão de crédito
   * 
   */
  public Payment(String type, String number, int cvv, String expiresAt) {
    this.type = type;
    this.number = number;
    this.cvv = cvv;
    this.expiresAt = expiresAt;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public int getCvv() {
    return cvv;
  }

  public void setCvv(int cvv) {
    this.cvv = cvv;
  }

  public String getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(String expiresAt) {
    this.expiresAt = expiresAt;
  }
}
