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

	/*
	 * The adminMenu() method takes no parameters. It displays the Administrator
	 * menu to the user and takes in keyboard input. Based on the input it directs
	 * the user to the appropriate menu or method to perform Administrator actions.
	 */
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
			//Since Administrator logging out, sets administrator flag to false.
			Login.administrator = false;
			Login.loginMenu();
		} else {
			System.out.println("Please enter a valid option.");
			adminMenu();
		}
	}

	/*
	 * The employeeMenu() method takes no parameters. It displays the Employee menu
	 * to the user and takes in keyboard input. Based on the input, it directs the
	 * user to the appropriate menu or Employee action.
	 */
	public static void employeeMenu() {
		System.out.println("EMPLOYEE MENU");
		System.out.println("Add (c)ustomer.");
		System.out.println("Add (m)ovie.");
		System.out.println("(R)emove movie.");
		System.out.println("List movie(s).");
		System.out.println("(A)dd inventory.");
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");

		input = scan.next();

		if (input.equals("c")) {
			// Go to add customer functionality
			System.out.println("");
			addCustomer();
		} else if (input.equals("m")) {
			// Go to create movie functionality
			System.out.println("");
			addMovie();
		} else if (input.equals("r")) {
			removeMovie();
		} else if (input.equals("s")) {
			// Go to list movie method
			MovieData.listMovies();
		} else if (input.equals("a")) {
			// Go to add stock functionality
			addStock();
		} else if (input.equals("l")) {
			System.out.println("Logging out...");
			System.out.println("");
			Login.loginMenu();
		} else {
			System.out.println("Please enter a valid option.");
			employeeMenu();
		}

	}

	/*
	 * The addEmployee() method takes no parameters. It prompts the user for the new
	 * employee's username and password and takes in keyboard input. It saves the
	 * input to the 'username' and 'password' fields, then instantiates a new User
	 * object with the information. Once the User object is instantiated, it invokes
	 * the addUser() method to add the new User object to the 'users' ArrayList and
	 * 'logins.ser' file. Once completed, it returns the user to the Administrator
	 * menu.
	 */
	public static void addEmployee() {
		System.out.print("Enter new employee's username: ");
		username = scan.next();
		System.out.print("Enter employee's password: ");
		password = scan.next();

		User newUser = new User(username, password, true);
		UserData.addUser(newUser);

		adminMenu();
	}

	/*
	 * The addCustomer() takes in no parameters. It prompts the user for the
	 * username and password of the new customer. Once the required input has been
	 * received, it instantiates a new User object with the username and password
	 * information. It then invokes the addUser() method to add the new User object
	 * to the 'users' ArrayList and 'logins.ser' file. Once completed, if the User is 
	 * the administrator it returns the user to the Administrator menu. Otherwise, it
	 * returns the User to the employee menu.
	 */
	public static void addCustomer() {
		// Clears the buffer
		scan.nextLine();

		System.out.print("Enter new customer's username: ");
		username = scan.next();
		System.out.print("Enter customer's password: ");
		password = scan.next();

		User newUser = new User(username, password, false);
		UserData.addUser(newUser);
		if (Login.administrator) {
			adminMenu();
		} else {
			employeeMenu();
		}
	}

	/*
	 * The addMovie() method takes no parameters.  It prompts the user to enter the movie name, genre, and description of a
	 * new movie to add to the system.  Once the appropriate input has been received, it instantiates a new Movie object
	 * using the entered information.  It then invokes the addMovieData() method to add the new Movie object to the 'movies'
	 * ArrayList and 'movies.ser' file.  Once completed, it returns the user to the Employee menu since this is Employee-only
	 * functionality.
	 */
	public static void addMovie() {
		// Clears the buffer to take in new input
		scan.nextLine();
		System.out.print("Enter movie name: ");
		name = scan.nextLine();
		System.out.print("Enter movie genre: ");
		genre = scan.nextLine();
		System.out.print("Enter movie description: ");
		description = scan.nextLine();

		Movie newMovie = new Movie(name, genre, description);
		MovieData.addMovieData(newMovie);

		// Return to employee menu
		employeeMenu();
	}

	public static void removeMovie() {
		scan.nextLine();
		System.out.print("Enter movie name to remove: ");
		name = scan.nextLine();
		
		MovieData.deleteMovie(name);
		
		employeeMenu();
	}
	/*
	 * The addStock() method takes no parameters. It prompts the user for the name and number of additional copies of the
	 * movie whose inventory is to be modified.  Once the appropriate input is received, it invokes the addInventory() 
	 * method and passes in the name and number of new stock.  Once completed, it returns the user to the Employee menu
	 * since this is Employee-only functionality.
	 */
	public static void addStock() {
		scan.nextLine();
		System.out.print("Enter movie to add stock of: ");
		name = scan.nextLine();
		System.out.print("Add number of additional inventory (enter a negative number to lower inventory): ");
		newStock = scan.nextInt();

		MovieData.addInventory(name, newStock);

		employeeMenu();
	}
}
