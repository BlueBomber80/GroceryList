package com.rickrodriguez;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();

	public static void main(String[] args) {

		boolean quit = false;
		int choice = 0;

		printInstructions();

		while (!quit) {
			System.out.println("Enter your choices:");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				printInstructions();
				break;
			case 1:
				groceryList.printGroceryList();
				break;
			case 2:
				addItem();
				break;
			case 3:
				modifyItem();
				break;
			case 4:
				removeItem();
				break;
			case 5:
				searchForItem();
				break;
			case 6:
				processArrayList();
				break;
			case 7:
				quit = true;
				break;
			}
		}
	}

	public static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To modify an item on the list.");
		System.out.println("\t 4 - To remove an item from the list.");
		System.out.println("\t 5 - To search for an item in the list.");
		System.out.println("\t 6 - To quit the application.");
	}

	public static void addItem() {
		System.out.print("Enter the grocery item: ");
		groceryList.addGroceryItem(scanner.nextLine());

	}

	public static void modifyItem() {
		System.out.print("Enter the name of the item to modify: ");
		String currentItem = scanner.nextLine();
		System.out.println("Enter replacement item: ");
		String newItem = scanner.nextLine();
		groceryList.modifyGroceryItem(currentItem, newItem);
	}

	public static void removeItem() {
		System.out.print("Enter item you want to remove: ");
		String itemName = scanner.nextLine();
		groceryList.removeGroceryItem(itemName);
	}

	public static void searchForItem() {

		System.out.println("Item to search for: ");
		String searchItem = scanner.nextLine();
		if (groceryList.onFile(searchItem)) {
			System.out.println("Found " + searchItem + " in our grocery list.");
		} else {
			System.out.println(searchItem + " not found in shopping list.");
		}
	}

	public static void processArrayList(){
		// 3 ways to copy arrays
		
		//1. using .addAll()
		ArrayList<String> newArray = new ArrayList<String>();
		newArray.addAll(groceryList.getGroceryList());
		
		//2. constructing a new ArrayList with a method 
		ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());
		
		
		//3. copying an ArrayList into a regular array
		String[] myArray = new String[groceryList.getGroceryList().size()];
		myArray = groceryList.getGroceryList().toArray(myArray);
				
	}
	
}
