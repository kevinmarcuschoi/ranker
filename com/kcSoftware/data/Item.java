/**
 * A general data file that takes a name and keeps track of the score and which items it wins over
 */
package com.kcSoftware.data;

import java.util.ArrayList;

/**
 * @author kc
 * Version 1.0
 */
public class Item implements Comparable<Item> {
	
	private String title;
	private int score;
	private ArrayList<Item> itemsWonOver;
	
	/**
	 * Initializes the Item object
	 * @param title the name given to the item object
	 */
	public Item(String title) {
		
		super();
		setTitle(title);
		itemsWonOver = new ArrayList<Item>();
	}

	/**
	 * Gets the title of the item
	 * @return String title
	 */
	public String getTitle() {
	
		return title;
	}
	
	/**
	 * Sets the title of the item
	 * @param title as a String, must be not null or blank
	 */
	public void setTitle(String title) {
	
		if (title != null  && !title.trim().equals("")) {
			
			this.title = title;
		}
	}
	
	/**
	 * Gets the score of the item
	 * @return int score of the item
	 */
	public int getScore() {
		
		return score;
	}
	
	/**
	 * Adds 1 point to the item's score
	 */
	public void addPointToScore() {
		
		score++;
	}
	
	/**
	 * Adds the items that are choose to be "better" when compared to this item
	 * @param itemWonOver adds an object item
	 */
	public void addItemWonOver(Item itemWonOver) {
		
		itemsWonOver.add(itemWonOver);
	}
	
	/**
	 * Prints all the items in the Items Won Over array list
	 */
	public void printItemsWonOver() {
		
		for (int i = 0; i < itemsWonOver.size(); i++) {
			
			System.out.println(itemsWonOver.get(i).getTitle());
		}
	}

	/**
	 * Overrides method in the Collections util
	 */
	@Override
	public int compareTo(Item item) {
		
		int rankMovement = 0;
		
		if (score > item.getScore()) {
			
			rankMovement = -1;
		}
		else if (score < item.getScore()) {
			
			rankMovement = 1;
		}
		else {
			
			if (itemsWonOver.contains(item)) {
				rankMovement = -1;
			}
			else {
				rankMovement = 1;
			}
		}
		
		return rankMovement;
	}
}
