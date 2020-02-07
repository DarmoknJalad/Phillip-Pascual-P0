package com.phillippascual.util;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.phillippascual.data.UserData;

public class Login {
	private static Logger log = Logger.getLogger(Login.class);
	static {
		BasicConfigurator.configure();
	}

	static String username;
	static String password;
	static Scanner scan = new Scanner(System.in);
	static boolean employee;
	static boolean administrator;

	public static void loginMenu() {

		System.out.print("Username: ");
		username = scan.nextLine();
		System.out.print("Password: ");
		password = scan.nextLine();
		System.out.println("");

		loginCheck(username, password);
	}

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
			Employee.employeeMenu();
		} else {
			Customer.customerMenu();
		}
	}

	public static boolean isEmployee() {
		return employee;
	}

	public static void setEmployee(boolean employee) {
		Login.employee = employee;
	}
	
	

}
