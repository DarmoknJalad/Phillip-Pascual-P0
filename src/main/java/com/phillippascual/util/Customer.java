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
		System.out.println("(L)ogout.");
		System.out.println("");
		System.out.print("Please enter option: ");
		input = scan.next();
		
		if (input.equals("m")) {
			MovieData.listMovies();
		} else if (input.equals("l")) {
			System.out.println("Logging out...");
			Login.loginMenu();
		}
	}
}
