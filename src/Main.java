import models.Admin;

import org.json.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		Admin admin = new Admin("Ademiro", "ademiro@gmail.com", "ademiro123");
		
		JSONArray jsonArray = new JSONArray();
		
		JSONObject obj = new JSONObject();
		JSONObject objItem = new JSONObject();
		
		objItem.put("name", admin.getName());
		objItem.put("email", admin.getEmail());
		objItem.put("password", admin.getPassword());
		
		obj.put("admins", objItem);
		
		jsonArray.put(obj);
		
		try (FileWriter file = new FileWriter("database.json")) {
			file.write(jsonArray.toString());
			
			System.out.println("Item adicionado com sucesso");
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
}
