package com.phillippascual.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.phillippascual.util.Rental;

public class RentalData {
	private static Logger log = Logger.getLogger(RentalData.class);
	
	private static ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	public static void save() throws IOException {
		FileOutputStream rentalsOut = new FileOutputStream("rentals.ser");
		ObjectOutputStream rentalOutputStream = new ObjectOutputStream(rentalsOut);
		rentalOutputStream.writeObject(rentals);
		rentalOutputStream.close();
		rentalsOut.close();
		log.debug("Rentals saved.");
	}
	
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
	
	public static ArrayList<Rental> listAllRentals() {
		return rentals;
	}
	
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
}
