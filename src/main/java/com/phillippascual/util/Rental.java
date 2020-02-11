package com.phillippascual.util;

public class Rental {
	private String movieName;
	private String renter;
	
	public Rental(String movieName, String renter) {
		this.movieName = movieName;
		this.renter = renter;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((renter == null) ? 0 : renter.hashCode());
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
		if (renter == null) {
			if (other.renter != null)
				return false;
		} else if (!renter.equals(other.renter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rentals [movieName=" + movieName + ", renter=" + renter + "]";
	}
	
	
}
