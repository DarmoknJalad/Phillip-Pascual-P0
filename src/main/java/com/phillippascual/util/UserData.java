package com.phillippascual.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UserData {
	private static Logger log = Logger.getLogger(UserData.class);
	static {
		BasicConfigurator.configure();
	}
	
	private static ArrayList<User> users = new ArrayList<User>();
	
	public UserData() {

	}

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
		} catch (ClassNotFoundException e) {
			log.debug("Users file not found!");
			e.printStackTrace();
		}
		inputStream.close();
		fileIn.close();
	}
	
	public void addUser(User user) {
		users.add(user);
		log.debug("User added.");
	}

}
