/**
 * A collection of Items that can be compared to each other
 */

package com.kcSoftware.collection;

import java.util.ArrayList;
import com.kcSoftware.data.Item;
import java.util.Collections;


/**
 * @author kc
 * Version 1.0
 */
public class ItemList {

	private ArrayList<Item> theList;

	/**
	 * Initializes the array list for this collection
	 */
	public ItemList() {
		
		theList = new ArrayList<Item>();
	}
	
	/**
	 * Adds an item to the Array List collection
	 * @param newItem the item to be added to the array list
	 */
	public void addItem(Item newItem) {
		
		if (newItem != null && !newItem.getTitle().equals(null)) {
			
			theList.add(newItem);
		}
	}
	
	/**
	 * Removes the selected item from the array list
	 * @param removedItem the index of the item being removed
	 */
	public void removeItem(int removedItem) {
		
		System.out.println(theList.get(removedItem).getTitle() + " has been removed.");
		theList.remove(removedItem);
		return;
	}
	
	/**
	 * Prints out the array list of the collection in a formated list
	 */
	public void printList() {
		
		int listNumber = 1;
		
		for (int i = 0; i < theList.size(); i++) {
					
			if (theList.get(i) != null) {
			
				System.out.println(listNumber + ". " + theList.get(i).getTitle());
				
				listNumber++;
			}
			
		}
		
		if (theList.size() == 0) {
			
			System.out.println("This list is empty");
		}
	}
	
	/**
	 * Prints out the array list of the collection in a formated list with the scores of the items
	 */
	public void printListWithScore() {
		
		int listNumber = 1;
		
		for (int i = 0; i < theList.size(); i++) {
					
			if (theList.get(i) != null) {
			
				System.out.print(listNumber + ". " + theList.get(i).getTitle());
				System.out.println(" Score: " + theList.get(i).getScore());
				
				listNumber++;
			}
		}
		
		if (theList.size() == 0) {
			
			System.out.println("This list is empty");
		}
	}
	
	/**
	 * Gets the array list in the collection
	 * @return ArrayList<Item> the entire arraylist so it can access arraylist methods
	 */
	public ArrayList<Item> getList() {
		
		return theList;
	}
	
	/**
	 * Sorts the list according to score
	 */
	public void sortItemsByScore() {
		
		Collections.sort(theList);
	}
	
}
