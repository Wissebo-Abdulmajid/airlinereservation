//WISSEBO ABDULMAJID 2218587
package com.airlinereservation;

public class Admin {
    private String username;
    private String password;
    private String email;

    public Admin(String username, String email, String password) {
        this.username = username;
        this.setEmail(email);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
