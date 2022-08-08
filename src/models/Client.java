package models;

public class Client extends Person {
  private Address address;
  private String cpf;
  private String rg;
  private String cellphone;
  private Payment payment;
  private Cart[] pastOrders;
  private Cart currentOrder;

  public Client(String name, String email, String password, String cpf, String rg, String cellphone,
      Address address,
      Payment payment) {
    super(email, password);
    this.cpf = cpf;
    this.rg = rg;
    this.cellphone = cellphone;
    this.address = address;
    this.payment = payment;
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

  public Cart[] getPastOrders() {
    return pastOrders;
  }

  public void setPastOrders(Cart[] pastOrders) {
    this.pastOrders = pastOrders;
  }

  public Cart getCurrentOrder() {
    return currentOrder;
  }

  public void setCurrentOrder(Cart currentOrder) {
    this.currentOrder = currentOrder;
  }
}
