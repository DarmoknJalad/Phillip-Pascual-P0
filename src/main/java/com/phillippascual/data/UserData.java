package com.phillippascual.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.phillippascual.util.Employee;
import com.phillippascual.util.Login;
import com.phillippascual.util.User;

public class UserData {
	private static Logger log = Logger.getLogger(UserData.class);
	static {
		BasicConfigurator.configure();
	}

	private static ArrayList<User> users = new ArrayList<User>();

	/*
	 * The save() method takes in no parameters.  It instantiates a FileOutputStream and ObjectOutputStream object, and uses
	 * these objects to write all User objects in ArrayList 'user' to the 'logins.ser' file.  Once all objects are written
	 * it closes both streams.  Any IOExceptions are thrown to the calling method/class for handling.
	 */
	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("logins.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
		outputStream.writeObject(users);
		outputStream.close();
		fileOut.close();
		log.debug("Users saved.");
	}

	/*
	 * The load() method takes in no parameters.  It instantiates a FileInputStream and ObjectInputStream, and uses these
	 * objects to load all User objects in file 'logins.ser' and add them to the 'users' ArrayList.  Once all User objects
	 * are read from the file and added to 'users', it closes both stream objects.  Any IOExceptions are thrown to the
	 * calling method/class for handling.
	 */
	@SuppressWarnings("unchecked")
	public static void load() throws IOException {
		FileInputStream fileIn = new FileInputStream("logins.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fileIn);
		try {
			users = (ArrayList<User>) inputStream.readObject();
			log.debug("Users file loaded.");
		} catch (ClassNotFoundException e) {
			log.debug("Users file not found!");
			e.printStackTrace();
		}
		inputStream.close();
		fileIn.close();
	}

	/*
	 * The addUser() method takes in a User object as a parameter.  It adds the passed-in User object to the 'users'
	 * ArrayList, and then invokes the save() method to save the ArrayList to the 'logins.ser' file.  Any IOException
	 * thrown by the save() method is caught and handled in this method.
	 */
	public static void addUser(User user) {
		users.add(user);
		log.debug("User added.");
		try {
			save();
		} catch (IOException e) {
			log.debug("Unable to save users.");
		}
	}

	/*
	 * The validateLogin() method takes in two parameters, username and password both of type String.  It iterates through 
	 * the 'users' ArrayList, and if it finds a User object with username matching the passed-in username, password 
	 * matching the passed-in password.  If the employee field is true, the method returns true.  If false, the method
	 * returns false.  If no user with matching username and/or password is found in the 'users' ArrayList, it notifies
	 * the user and returns them to the login menu.
	 */
	public static boolean validateLogin(String username, String password) {
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password) && u.isEmployee()) {
//				Employee.employeeMenu();
				return true;
			} if (u.getUsername().equals(username) && u.getPassword().equals(password) && !u.isEmployee()) {
				return false;
			}
		}
		//User not found
		System.out.println("User not found!");
		Login.loginMenu();	//Throw user back to the login menu to try again.
		return false;

	}

	/*
	 * The listUsers() method takes in no parameters.  It iterates through the 'users' ArrayList and prints the fields
	 * of each User object in the ArrayList to the user.  Since this is admin-only functionality, once the iteration is
	 * complete it returns the user to the Administrator menu.
	 */
	public static void listUsers() {
		System.out.println("User list:");
		System.out.println("----------");
		for (User u : users) {
			System.out.println(u.toString());
		}
		System.out.println("");
		// Return user back to administrator menu once done listing users
		Employee.adminMenu();
	}
	
	/*
	 * The getUsers() function takes no parameters.  It returns ArrayList 'users'.
	 */
	public static ArrayList<User> getUsers() {
		return users;
	}

}
