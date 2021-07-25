package com.kcSoftware.driver;

import java.util.Scanner;
import com.kcSoftware.data.Item;
import com.kcSoftware.collection.ItemList;



public class Driver {
	
	private ItemList mainList;
	private Scanner input;

	/**
	 * Runs the main application
	 * @param args no arguments take by this application
	 */
	public static void main(String[] args) {
		
		new Driver();
	}
	
	/**
	 * Runs the methods needs to run the application
	 */
	public Driver() {
		
		initialize();

		listInput();
		verifyList();
		compareInputs();
		rankList();
	}
	
	/**
	 * initializes the data fields for the application to use
	 */
	public void initialize() {
		
		input = new Scanner(System.in);
		mainList = new ItemList();
	}
	
	/**
	 * Loop that takes the inputed names and adds them to the list
	 */
	public void listInput() {
		
		boolean continueLoop = true;
		
		while (continueLoop) {
		
			System.out.print("Please enter an item or type \"-end\" to move on to the next step:> ");
			String inputItem = input.nextLine();
		
			if (inputItem != null && !inputItem.equals("")) {
			
				System.out.println(inputItem);
			
				if (inputItem.equals("-end")) {
				
					return;
				}
				
				if (!inputItem.startsWith("-")) {
					
					mainList.addItem(new Item(inputItem));
				}
				else {
					
					System.out.println(inputItem + " is not a valid command");
				}
			}
		}
	}
	
	/**
	 * Compares the items that have been added to the list
	 */
	public void compareInputs() {
		
		for (int i = 0; i < mainList.getList().size(); i++) {
			
			for (int j = i + 1; j < mainList.getList().size(); j++) {
			
				System.out.println("Which is better? A. " + mainList.getList().get(i).getTitle() + " " + " or B. " 
					+ mainList.getList().get(j).getTitle());
			
				boolean isSelectionNeeded = true;
			
				while (isSelectionNeeded) {
					
					try {
						
						String userChoice = input.next();
						userChoice.toLowerCase();
						
						if (userChoice.equals("a")) {
							
							mainList.getList().get(i).addPointToScore();
							mainList.getList().get(i).addItemWonOver(mainList.getList().get(j));
							isSelectionNeeded = false;
						}
						else if (userChoice.equals("b")) {
							
							mainList.getList().get(j).addPointToScore();
							mainList.getList().get(j).addItemWonOver(mainList.getList().get(i));
							isSelectionNeeded = false;
						}
						else {
							
							System.out.println("Invalid input, use A or B");
						}
					}
					catch (Exception e) {
						
						System.out.println("Exception thrown, program has ended");
						break;
					}
				}
			}
		}

	}
	
	/**
	 * Asks if the list is correct. If not, runs loop that can change the list
	 */
	public void verifyList() {
		
		mainList.printList();
		System.out.println("Are all the items correct? Yes or No?");

		
		boolean verifying = true;
		
		while (verifying) {
			
			String yesOrNo = input.next();
			
			if (yesOrNo != null) {
			
				yesOrNo.toLowerCase();
				
				if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
					
					return;
				}
				else if (yesOrNo.equals("no") || yesOrNo.equals("n")) {
					
					changeList();
					return;
				}
				else {
					
					System.out.println("Sorry, invalid input");
				}
			}
		}
		
	}

	/**
	 * Sorts the list by item's scores and then prints out the list
	 */
	public void rankList() {
		
		mainList.sortItemsByScore();
		mainList.printList();
		
		System.out.println("Type \"scores\" to see list with score or type \"exit\"");
		String finalInput = input.next();
		
		
		if (finalInput != null && finalInput.equals("scores")) {
			
			mainList.printListWithScore();
		}
		else {
			
			return;
		}

	}
	/**
	 * The loop that allows the user to change the list
	 */
	public void changeList() {
		
		boolean isChanging = true;
		
		while (isChanging) {
			
			System.out.println("Which item would you like to change?");

			boolean isSelectingItem = true;
			int userChoice = 0;
			
			while (isSelectingItem) {
				
				userChoice = input.nextInt();
				userChoice--;
				
				if (userChoice < mainList.getList().size()) {
					
					isSelectingItem = false;
				}
				else {
					
					System.out.println("Invalid selection.");
				}
			}
			
			System.out.println("Please input the correct item or type -remove.");
			
				String itemChange = input.next();
				
				if (itemChange.equals("-remove")) {
					
					mainList.removeItem(userChoice);
				}
				else {
					
					mainList.getList().set(userChoice, new Item(itemChange));
					// test this
				}
			
			mainList.printList();
			System.out.print("Are there any other changes? ");
			System.out.println("Type \"yes\" to make more changes or \"no\" to proceed");
			
			boolean isConfirming = true;
			
			while (isConfirming) {
			
				String yesOrNo = input.next();
				
				if (yesOrNo != null) {
					
					yesOrNo.toLowerCase();
					
					if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
						
						isChanging = true;
						isConfirming = false;
						
					}
					else if (yesOrNo.equals("no") || yesOrNo.equals("n")) {
						
						return;
					}
					else {
						
						System.out.println("Sorry, invalid input");
					}
				}
			}
		}
	}
}
