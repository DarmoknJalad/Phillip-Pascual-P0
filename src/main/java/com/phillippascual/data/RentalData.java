package com.phillippascual.data;

import java.io.EOFException;
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
	
	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("rentals.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
		outputStream.writeObject(rentals);
		outputStream.close();
		fileOut.close();
		log.debug("Rentals saved.");
	}
	
	@SuppressWarnings("unchecked")
	public static void load() throws IOException {
		FileInputStream fileIn = new FileInputStream("rentals.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fileIn);
		try {
			rentals = (ArrayList<Rental>) inputStream.readObject();
			log.debug("Rentals file loaded.");
		} catch (ClassNotFoundException e) {
			log.debug("Rentals file not found!");
			e.printStackTrace();
		} catch (EOFException e) {
			log.debug("Rentals file empty.");
		}
		inputStream.close();
		fileIn.close();
	}
	
	public static void addRental(String movieName, String username) {
		Rental newRental = new Rental(movieName, username);
		MovieData.addInventory(movieName, -1);
		rentals.add(newRental);
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.debug(movieName + " rented to " + username);
	}
	
	public static void checkInRental(String movieName, String renterName) {
		Iterator<Rental> itr = rentals.iterator();
		while (itr.hasNext()) {
			Rental next = itr.next();
			if (next.getMovieName().equals(movieName) && next.getRenter().equals(renterName)) {
				itr.remove();
				log.debug("Rental checked in.");
				MovieData.addInventory(movieName, 1);
				try {
					save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Rental not found.");
	}
	
	public static ArrayList<Rental> listAllRentals() {
		return rentals;
	}
	
	public static void listRentals(String renterName) {
		Iterator<Rental> itr = rentals.iterator();
		while (itr.hasNext()) {
			Rental next = itr.next();
			if (next.getRenter().equals(renterName)) {
				System.out.println(next.toString());
			}
		}
	}
}
