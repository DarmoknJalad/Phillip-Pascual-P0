package com.phillippascual.util;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean isEmployee;
			
	/*
	 * Constructor for the User class.  Takes in two String parameters, username and password, and one boolean parameter,
	 * isEmployee.  The constructor then sets the fields for the newly-constructed User object to the values passed in.
	 */
	public User(String username, String password, boolean isEmployee) {
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}
	
	/*
	 * Getter for the username field.
	 */
	public String getUsername() {
		return username;
	}
	
	/*
	 * Setter for the username field.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/*
	 * Getter for the password field.
	 */
	public String getPassword() {
		return password;
	}
	
	/*
	 * Setter for the password field.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * Getter for the isEmployee flag.
	 */
	public boolean isEmployee() {
		return isEmployee;
	}
	
	/*
	 * Setter for the isEmployee flag.
	 */
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isEmployee=" + isEmployee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isEmployee ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (isEmployee != other.isEmployee)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}
