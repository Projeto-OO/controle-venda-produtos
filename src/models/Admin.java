package models;

public class Admin extends Person {
	private String password;
	
	public Admin(String name, String email, String password) {
		super.setName(name);
		super.setEmail(email);
		
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
