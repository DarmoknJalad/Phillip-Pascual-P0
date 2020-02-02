import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.phillippascual.util.UserData;

public class Mockbuster {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Mockbuster.class);
		BasicConfigurator.configure();
		
		//Loads existing user data from file 'logins.ser'.  Throws exception if file not found.
		try {
			UserData.load();
		} catch (IOException e) {
			log.debug("Unable to load user data.");
		}
		
		System.out.println("Welcome to Mockbuster Video!");
		System.out.println("Please login.");
		
		String username;
		String password;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Username: ");
		username = scan.nextLine();
		System.out.println("Password: ");
		username = scan.nextLine();
		
		
	}
	
	
	

	
}
