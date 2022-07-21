import models.Admin;

public class Main {
	
	public static void main(String[] args) {
		
		Admin admin = new Admin("senha");
		admin.setEmail("email@email.com");
		admin.setId(0);
		admin.setName("Administrador");
		
		System.out.println(admin.toString());
	}
	
}
