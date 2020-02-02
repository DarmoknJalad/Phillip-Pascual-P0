package com.phillippascual.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.phillippascual.util.Movie;

public class MovieData {
	private static Logger log = Logger.getLogger(MovieData.class);
	static {
		BasicConfigurator.configure();
	}
	
	private static ArrayList<Movie> movies = new ArrayList<Movie>();
	
	public static void save() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("movies.ser");
		ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
		outputStream.writeObject(movies);
		outputStream.close();
		fileOut.close();
		log.debug("Movies saved.");
	}
	
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
	
	public static void addMovie(Movie movie) {
		movies.add(movie);
		log.debug("Movie added.");
		try {
			save();
		} catch (IOException e) {
			log.debug("Unable to save movie.");
		}
	}
}
