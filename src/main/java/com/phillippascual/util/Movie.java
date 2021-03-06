package com.phillippascual.util;

import java.io.Serializable;

public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String genre;
	private String description;
	private int numberInStock;
	
	/*
	 * Constructor for the Movie class.  Takes in three Strings, name, genre, and description and assigns them to the
	 * fields of the newly-constructed Movie object.
	 */
	public Movie(String name, String genre, String description) {
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.numberInStock = 1;	//Setting default in inventory when movie added to 1
	}

	/*
	 * Getter for the name field.
	 */
	public String getName() {
		return name;
	}

	/*
	 * Setter for the name field.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Getter for the genre field.
	 */
	public String getGenre() {
		return genre;
	}

	/*
	 * Setter for the genre field.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/*
	 * Getter for the description field.
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Setter for the description field.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * Getter for the numberInStock field.
	 */
	public int getNumberInStock() {
		return numberInStock;
	}

	/*
	 * Setter for the numberInStock field.
	 */
	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberInStock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberInStock != other.numberInStock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name = " + name + ", Genre = " + genre + ", Description = " + description + ", Number Available = "
				+ numberInStock + "]";
	}
	/*
	 * The printMovie() method takes in no parameters.  It returns a string filled with the value of the fields of the
	 * object that the method is called on.
	 */
	public String printMovie() {
		return "Name = " + name + "; Genre = " + genre + "; Description = " + description + "; Number Available = "
				+ numberInStock;
	}

	
	
	
	
	
}
