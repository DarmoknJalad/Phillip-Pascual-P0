package com.phillippascual.util;

import java.util.Scanner;

import com.phillippascual.data.MovieData;

public class Customer {
	static String input;
	static Scanner scan = new Scanner(System.in);
	
	public static void customerMenu() {
		System.out.println("CUSTOMER MENU:");
		System.out.println("--------------");
		System.out.println("List (M)ovies.");
		System.out.println("");
		System.out.print("Please enter option: ");
		input = scan.next();
		
		//TODO: write list movies function
		if (input.equals("m")) {
			MovieData.listMovies();
		}
	}
}
