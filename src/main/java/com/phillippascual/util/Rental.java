package com.phillippascual.util;

import java.io.Serializable;
import java.util.ArrayList;

public class Rental implements Serializable {
	private String movieName;
	private String renterName;
	
	public Rental(String movieName, String renterName) {
		this.movieName = movieName;
		this.renterName = renterName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getRenterName() {
		return renterName;
	}
	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((renterName == null) ? 0 : renterName.hashCode());
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
		Rental other = (Rental) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (renterName == null) {
			if (other.renterName != null)
				return false;
		} else if (!renterName.equals(other.renterName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie Name: " + movieName + "; Rented to: " + renterName;
	}
	
}
