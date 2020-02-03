package com.phillippascual.util;

import java.util.Scanner;

import com.phillippascual.data.MovieData;
import com.phillippascual.data.UserData;

public class Employee {
	private static Scanner scan = new Scanner(System.in);
	private static String input;
	static String username;
	static String password;
	static String name;
	static String genre;
	static String description;
	static int newStock;

	public static void adminMenu() {
		System.out.println("ADMINISTRATOR MENU");
		System.out.println("Add (e)mployee.");
		System.out.println("Add (c)ustomer.");
		System.out.println("List u(s)ers.");
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");
		
		input = scan.next();
		
		if (input.equals("e")) {
			addEmployee();
		} else if (input.equals("c")) {
			addCustomer();
		} else if (input.equals("s")) {
			UserData.listUsers();
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
		System.out.println("List movie(s).");
		System.out.println("(A)dd inventory.");
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");
		
		input = scan.next();
		
		if (input.equals("c")) {
			//Go to add customer functionality
			System.out.println("");
			addCustomer();
		} else if (input.equals("m")) {
			//Go to create movie functionality
			System.out.println("");
			addMovie();
		} else if (input.equals("s")) {
			//Go to list movie method
			MovieData.listMovies();
		} else if (input.equals("a")) {
			//Go to add stock functionality
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
		//Clears the buffer
		scan.nextLine();
		
		System.out.print("Enter new customer's username: ");
		username = scan.next();
		System.out.print("Enter customer's password: ");
		password = scan.next();
		
		User newUser = new User(username, password, false);
		UserData.addUser(newUser);
		
		adminMenu();
	}
	
	public static void addMovie() {
		//Clears the buffer to take in new input
		scan.nextLine();
		System.out.print("Enter movie name: ");
		name = scan.nextLine();
		System.out.print("Enter movie genre: ");
		genre = scan.nextLine();
		System.out.print("Enter movie description: ");
		description = scan.nextLine();
		
		Movie newMovie = new Movie(name, genre, description);
		MovieData.addMovieData(newMovie);
		
		//Return to employee menu
		employeeMenu();	
	}
	
	public void addStock() {
		scan.nextLine();
		System.out.print("Enter movie to add stock of: ");
		name = scan.nextLine();
		System.out.print("Add amount of additional copies: ");
		newStock = scan.nextInt();
		
		MovieData.addInventory(name, newStock);
		
		employeeMenu();
	}
}
