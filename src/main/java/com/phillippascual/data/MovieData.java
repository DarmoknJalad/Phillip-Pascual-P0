package com.phillippascual.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.phillippascual.util.Customer;
import com.phillippascual.util.Employee;
import com.phillippascual.util.Login;
import com.phillippascual.util.Movie;

public class MovieData {
	private static Logger log = Logger.getLogger(MovieData.class);
	
	private static ArrayList<Movie> movies = new ArrayList<Movie>();
	
	/*
	 * The save() function adds all elements in ArrayList 'movies' to the file 'movies.ser'.  Any IOException is thrown
	 * to the calling class/method for handling.
	 */
	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("movies.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
		outputStream.writeObject(movies);
		outputStream.close();
		fileOut.close();
		log.debug("Movies saved.");
	}
	
	/*
	 * The load() function instantiates a FileInputStream and ObjectInputStream to work on data stored in the file
	 * 'movies.ser'.  It takes in all objects saved to this file and adds them to the ArrayList 'movies'.  Any IOException
	 * is thrown to the calling method/class for handling.
	 */
	@SuppressWarnings("unchecked")
	public static void load() throws IOException {
		FileInputStream fileIn = new FileInputStream("movies.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fileIn);
		try {
			movies = (ArrayList<Movie>) inputStream.readObject();
			log.debug("Movies file loaded.");
		} catch (ClassNotFoundException e) {
			log.debug("Movies file not found!");
			e.printStackTrace();
		}
		inputStream.close();
		fileIn.close();
	}
	
	/*
	 * The addMovieData() method takes in one parameter of type Movie.  It adds the passed in Movie object to the ArrayList
	 * 'movies' and then immediately calls the save() method to save the now-larger ArrayList to the data file.  This
	 * function will catch and handle any IOException thrown by the save() method.
	 */
	public static void addMovieData(Movie movie) {
		movies.add(movie);
		log.debug("Movie added.");
		try {
			save();
		} catch (IOException e) {
			log.debug("Unable to save movie.");
		}
	}
	
	/*
	 * The listMovies() method takes in no parameters, and is used to the list all the Movie objects in ArrayList 'movies'.
	 * It iterates through 'movies' and for each element calls the printMovie() method to display the field data of each
	 * Movie object.  Once completed, depending on the type of User that called the method, it returns to either the
	 * Employee or Customer menu.
	 */
	public static void listMovies() {
		System.out.println("Movie list:");
		System.out.println("-----------");
		System.out.println("");
		for (Movie m : movies) {
			System.out.println(m.printMovie());
		}
		System.out.println();
		
		if (Login.isEmployee()) {
			Employee.employeeMenu();
		} else {
			Customer.customerMenu();
		}
	}
	
	public static void deleteMovie(String movieName) {
		for (Movie m : movies) {
			if (m.getName().equals(movieName)) {
				movies.remove(m);
				log.debug("Movie deleted.");
				try {
					save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Movie not found.");
	}
	
	/*
	 * The addInventory() method takes in two parameters, one of type String and one of type int.  The method iterates
	 * over each element in ArrayList 'movies' and searches for any Movie object with name field matching the passed-in
	 * String parameter.  Once found, it adds the int passed in to the numberInStock field in the found Movie object.  If
	 * no Movie object with name field matching the passed-in String is found, it advises the user that the movie has not
	 * been found.
	 */
	public static void addInventory(String movie, int num) {
		for (Movie m : movies) {
			if (m.getName().equals(movie)) {
				m.setNumberInStock(m.getNumberInStock() + num);
				try {
					save();
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}
		System.out.println("Movie not found.");
	}
	
	/*
	 * The getMovies() method takes in no parameters, and simply returns the movies ArrayList.
	 */
	public static ArrayList<Movie> getMovies() {
		return movies;
		
	}
}
