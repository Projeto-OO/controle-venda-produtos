import models.Admin;

public class Main {
  public static void main(String[] args) {
    Admin admin1 = new Admin(1, "admin1", "email@example.com", "senha123");

    System.out.println(admin1);
  }
}
