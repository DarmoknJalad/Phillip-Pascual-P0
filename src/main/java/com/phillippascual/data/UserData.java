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

	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("logins.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
		outputStream.writeObject(users);
		outputStream.close();
		fileOut.close();
		log.debug("Users saved.");
	}

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

	public static void addUser(User user) {
		users.add(user);
		log.debug("User added.");
		try {
			save();e
		} catch (IOException e) {
			log.debug("Unable to save users.");
		}
	}

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

}
