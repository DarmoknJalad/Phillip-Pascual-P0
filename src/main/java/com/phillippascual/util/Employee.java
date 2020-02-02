package com.phillippascual.util;

import java.util.Scanner;

import com.phillippascual.data.UserData;

public class Employee {
	private static Scanner scan = new Scanner(System.in);
	private static String input;
	static String username;
	static String password;

	public static void adminMenu() {
		System.out.println("ADMINISTRATOR MENU");
		System.out.println("Add (e)mployee.");
		System.out.println("Add (c)ustomer.");
//		System.out.println("List (u)sers.");
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");
		
		input = scan.next();
		
		if (input.equals("e")) {
			addEmployee();
		} else if (input.equals("c")) {
			addCustomer();
//		} else if (input.equals("u")) {
//			UserData.listUsers();
		} else if (input.equals("l")) {
			System.out.println("Logging out...");
			System.out.println("");
			Login.loginMenu();
		} else {
			System.out.println("Please enter a valid option.");
			adminMenu();
		}
	}
	
	public static void employeeMenu() {
		System.out.println("EMPLOYEE MENU");
		System.out.println("Add (c)ustomer.");
		System.out.println("Add (m)ovie.");
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");
		
		input = scan.next();
		
		if (input.equals("c")) {
			System.out.println("");
			addCustomer();
		} else if (input.equals("m")) {
			//Go to add movie functionality
		} else if (input.equals("l")) {
			System.out.println("Logging out...");
			System.out.println("");
			Login.loginMenu();
		} else {
			System.out.println("Please enter a valid option.");
			employeeMenu();
		}
		
	}
	
	public static void addEmployee() {
		System.out.print("Enter new employee's username: ");
		username = scan.next();
		System.out.print("Enter employee's password: ");
		password = scan.next();
		
		User newUser = new User(username, password, true);
		UserData.addUser(newUser);
		
		adminMenu();
	}
	
	public static void addCustomer() {
		System.out.print("Enter new customer's username: ");
		username = scan.next();
		System.out.print("Enter customer's password: ");
		password = scan.next();
		
		User newUser = new User(username, password, false);
		UserData.addUser(newUser);
		
		adminMenu();
	}
}
