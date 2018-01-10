package com.robbi.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("name") && password.equals("password");
	}

}