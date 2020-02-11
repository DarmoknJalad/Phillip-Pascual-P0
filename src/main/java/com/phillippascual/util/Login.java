package com.phillippascual.util;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.phillippascual.data.UserData;

public class Login {
	private static Logger log = Logger.getLogger(Login.class);

	static String username;
	static String password;
	static Scanner scan = new Scanner(System.in);
	static boolean employee;
	static boolean administrator;

	/*
	 * The loginMenu() method takes no parameters.  It prompts the user for a username and password and takes in keyboard
	 * input.  Once the appropriate input has been received, it invokes the loginCheck() method and passes in the received
	 * username and password.
	 */
	public static void loginMenu() {
		System.out.print("Username: ");
		username = scan.nextLine();
		System.out.print("Password: ");
		password = scan.nextLine();
		System.out.println("");

		loginCheck(username, password);
	}

	/*
	 * The loginCheck() method takes in two parameters, username and password, both Strings.  If the Administrator username
	 * and password is received, it sets the 'administrator' field to true and directs the user to the Administrator menu.
	 * If the Administrator username and password were not entered, it invokes the validateLogin() method and passes in the
	 * entered username and password.
	 */
	public static void loginCheck(String username, String password) {
		if (username.equals("admin") && password.equals("admin")) {
			log.debug("Administrator logged in.");
			System.out.println("Administrator access granted!");
			System.out.println("");
			administrator = true;
			// Shows the administrator menu
			Employee.adminMenu();
		} else {
			employee = UserData.validateLogin(username, password);
		}
		
		if (employee) {
			log.debug("Employee " + username + " logged in.");
			Employee.employeeMenu();
		} else {
			log.debug("Customer " + username + " logged in.");
			Customer.customerMenu();
		}
	}

	/*
	 * Returns if the employee is an employee or not.
	 */
	public static boolean isEmployee() {
		return employee;
	}

	/*
	 * Sets the employee flag.
	 */
	public static void setEmployee(boolean employee) {
		Login.employee = employee;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Login.username = username;
	}
	
	

}
