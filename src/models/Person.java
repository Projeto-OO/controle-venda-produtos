package models;

public abstract class Person {
  private int id;
  private String name;
  private String email;

  public Person(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Person {" +
        "id = " + id +
        ", name = '" + name + '\'' +
        ", email = '" + email + '\'' +
        '}';
  }
}
