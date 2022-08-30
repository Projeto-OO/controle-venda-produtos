package models;

import java.util.ArrayList;

/**
 * Classe que herda de Person e representa um cliente do sistema.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 * @see Person
 */
public class Client extends Person {
  private Address address;
  private String cpf;
  private String rg;
  private String cellphone;
  private Payment payment;
  private ArrayList<Cart> pastOrders;
  private Cart currentOrder;

  /**
   * Construtor da classe Client
   * 
   * @param name      Nome do cliente
   * @param email     Email do cliente
   * @param address   Endereço do cliente
   * @param cpf       CPF do cliente
   * @param rg        RG do cliente
   * @param cellphone Celular do cliente
   * @param payment   Forma de pagamento do cliente
   * 
   */
  public Client(String name, String email, String cpf, String rg, String cellphone,
      Address address,
      Payment payment) {
    super(name, email);
    this.cpf = cpf;
    this.rg = rg;
    this.cellphone = cellphone;
    this.address = address;
    this.payment = payment;
    this.pastOrders = new ArrayList<Cart>();
    this.currentOrder = new Cart(new ArrayList<ProductAmount>(), 0);
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getCellphone() {
    return cellphone;
  }

  public void setCellphone(String cellphone) {
    this.cellphone = cellphone;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public ArrayList<Cart> getPastOrders() {
    return pastOrders;
  }

  public void setPastOrders(ArrayList<Cart> pastOrders) {
    this.pastOrders = pastOrders;
  }

  public Cart getCurrentOrder() {
    return currentOrder;
  }

  public void setCurrentOrder(Cart currentOrder) {
    this.currentOrder = currentOrder;
  }

  /**
   * Adiciona carrinho atual na lista de carrinhos anteriores e limpa o carrinho
   * atual.
   * 
   */
  public void checkout() {
    this.pastOrders.add(currentOrder);

    this.currentOrder = new Cart(new ArrayList<ProductAmount>(), 0);
  }

  /**
   * Sobrescreve o método toString para exibir os dados do cliente.
   * 
   */
  @Override
  public String toString() {
    return "Client " + super.toString() + " " + this.address + " " + this.cpf + " " + this.rg + " "
        + this.cellphone + " " + this.payment;
  }
}
