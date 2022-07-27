package models;

public class Admin extends Person {

  private String password;

  public Admin(int id, String name, String email, String password) {
    super(id, name, email);

    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Admin {" +
        "id = " + super.getId() +
        ", name = '" + super.getName() + '\'' +
        ", email = '" + super.getEmail() + '\'' +
        ", password = '" + password + '\'' +
        '}';
  }
}
