package com.phillippascual.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.phillippascual.util.Rental;

public class RentalData {
	private static Logger log = Logger.getLogger(RentalData.class);
	
	private static ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	/*
	 * The save() method saves all Rental objects in the ArrayList 'rentals' to the file 'rentals.ser'.
	 */
	public static void save() throws IOException {
		FileOutputStream rentalsOut = new FileOutputStream("rentals.ser");
		ObjectOutputStream rentalOutputStream = new ObjectOutputStream(rentalsOut);
		rentalOutputStream.writeObject(rentals);
		rentalOutputStream.close();
		rentalsOut.close();
		log.debug("Rentals saved.");
	}
	
	/*
	 * The load() method reads through the file 'rentals.ser' and loads all Rental objects in that file to
	 * the ArrayList 'rentals'.
	 */
	@SuppressWarnings("unchecked")
	public static void load() throws IOException {
		FileInputStream rentalsIn = new FileInputStream("rentals.ser");
		ObjectInputStream rentalInputStream = new ObjectInputStream(rentalsIn);
		try {
			rentals = (ArrayList<Rental>) rentalInputStream.readObject();
			log.debug("Rentals file loaded.");
		} catch (ClassNotFoundException e) {
			log.debug("Movies file not found!");
			e.printStackTrace();
		}
		rentalInputStream.close();
		rentalsIn.close();
	}
	
	/*
	 * The listAllRentals() method takes no parameters.  It iterates through the 'rentals' ArrayList and
	 * prints all field data of each Rental object to the console.
	 */
	public static void listAllRentals() {
		for (Rental r : rentals) {
			System.out.println(r.toString());
		}
		
	}
	
	/*
	 * The addRental() method takes in two parameters, a String 'movieName' and String 'userName'.  It creates
	 * a new Rental object using the passed in String parameters and adds that object to the 'rentals'
	 * ArrayList.  Since a movie is leaving the store's inventory, it then decrements the available inventory of
	 * the movie being checked out using the addInventory() method in the MovieData class.  Once completed, it
	 * saves the ArrayList 'rentals' by invoking the save() method.
	 */
	public static void addRental(String movieName, String userName) {
		Rental newRental = new Rental(movieName, userName);
		rentals.add(newRental);
		MovieData.addInventory(movieName, -1);
		log.debug(movieName + " checked out to " + userName);
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * The checkInRental() method takes in two parameters, a String 'movieName' and String 'userName'.  It
	 * iterates through the 'rental' ArrayList, and if a Rental object with fields matching both passed-in
	 * parameters is found, it increments the available inventory of the Movie by 1 (since the Movie is 
	 * being returned to the store's inventory) and removes that Rental object from the 'rentals' ArrayList.
	 * Once completed, it saves the ArrayList of current rentals by invoking the save() method.
	 */
	public static void checkInRental(String movieName, String userName) {
		Iterator<Rental> itr = rentals.iterator();
		while (itr.hasNext()) {
			Rental next = itr.next();
			if (next.getMovieName().equals(movieName) && next.getRenterName().equals(userName)) {
				MovieData.addInventory(movieName, 1);
				itr.remove();
				log.debug(movieName + " rented by " + userName + " returned.");
				try {
					save();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			System.out.println("Rental not found.");
		}
	}
}
