package tictactoe;

import java.util.ArrayList;

/**
 * Player object to construct human player or bot player
 * @author Nam Tran aka GluePretzel aka Bleh
 */
public class Player {
	protected String ID;					// Identify Human or Bot
	private ArrayList<Integer> position;	// List of played moves
	
	/**
	 * Constructor
	 */
	public Player() {
		this.position = new ArrayList<Integer>();
	}
		
	/**
	 * Setter for list of played moves
	 * @param num	Player's played move
	 */
	public void setPosition(int num) {
		this.position.add(num);
	}
	
	/**
	 * Getter for list of played moves
	 * @return	The list of all played move by the current player
	 */
	public ArrayList<Integer> getPosition() {
		return position;
	}
	
	/**
	 * Getter for Player Identification
	 * @return Player Identity
	 */
	public String getID() {
		return this.ID;
	}
}
