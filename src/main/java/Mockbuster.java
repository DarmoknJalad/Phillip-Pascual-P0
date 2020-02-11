import java.io.IOException;

import com.phillippascual.data.MovieData;
import com.phillippascual.data.RentalData;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;

import com.phillippascual.data.UserData;
import com.phillippascual.util.Login;

public class Mockbuster {

	public static void main(String[] args) {
		//Loads existing user data from file 'logins.ser'.  Throws exception if file not found.
		try {
			UserData.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Loads movie data.
		try {
			MovieData.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			RentalData.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Welcome to Mockbuster Video!");
		System.out.println("Please login.");
		
		Login.loginMenu();
	}
	
	

	
}
