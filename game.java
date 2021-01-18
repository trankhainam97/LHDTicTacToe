package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Submission for MLH's Local Hack Day: Build 2021
 * @author Nam Tran aka GluePretzel aka Bleh
 * January, 2021
 */
public class game {
	static Player player1;	// human player
	static Player bot;		// machine opponent

	public static void main(String[] arg) {
		texts.Logo();		// display an ASCII logo
		texts.Div();		// divider bar
		Scanner s = new Scanner(System.in);
		
		// menu starts here
		System.out.print("1) Single Player vs Computer\n" + "2) About\n" + "3) Quit\n" + ">_ ");
		char menu = s.next().charAt(0);
		while (!Character.isDigit(menu) || Character.getNumericValue(menu) <= 0
				|| Character.getNumericValue(menu) > 3) {
			System.out.print("Please choose a correct option again [1-3]: >_ ");
			menu = s.next().charAt(0);
		}
		texts.Div();

		switch (Character.getNumericValue(menu)) {
		case 1: {	// play the game, user can choose to play repeatedly
			do {
				run(s);	

				// play again?
				System.out.print("Do you want to play again (Y/N)? >_ ");
				String replay = s.next();
				
				if (replay.equalsIgnoreCase("yes") || replay.equalsIgnoreCase("y")) {
					texts.Div();
					continue;
				} else {
					texts.GoodBye();
					break;
				}
			} while (true);
		}
			break;
		case 2: texts.About();	// about section
			break;
		case 3:					// quit
			break;
		}
	}
	
	/**
	 * This method runs a game of Tic-Tac-Toe for the player to play against the computer
	 * @param s 	Scanner for input
	 */
	private static void run(Scanner s) {
		player1 = new Human();
		bot = new Bot();
		Board b = new Board();
		
		b.showBoard();
		while (true) {
			// get user input
			System.out.print("YOUR TURN: Where do you want to put the 'X'? Enter position [1-9] >_ ");
			int userin = s.nextInt();
			// validate user input
			while (!checkInput(userin) || !checkPost(userin)) {
				System.out.println("AGAIN!");
				userin = s.nextInt();
			}

			updateBoard(b, userin, player1);	// update board with user choices
			b.showBoard();					
			if (checkEnd())						// if the user wins, end the loop 
				break;
			
			// simulates bot input using rng
			Random rd = new Random();
			System.out.println("COMPUTER TURN: Waiting...");
			int botin = rd.nextInt(9) + 1;		// input will be from 1 to 9, no exception
			// validate bot input
			while (!checkPost(botin)) {
				System.out.println("Bot dum-dum, trying to play an illegal move.");
				botin = rd.nextInt(9) + 1;
			}

			updateBoard(b, botin, bot);
			b.showBoard();
			if (checkEnd())						// if the computer wins, end the loop 
				break;
		}
	}
	
	/**
	 * This method validate the user input to see if it is a number greater than 0 but less than 10
	 * @param choice 	User input
	 * @return 	if the user input is valid or not
	 */
	private static boolean checkInput(int choice) {
		if (choice <= 0 || choice > 9) {
			System.out.println("ERROR! Input must be between 1 and 9!");
			return false;
		} else
			return true;
	}
	
	/**
	 * This method checks the move being played to prevent overlapping on the board
	 * @param choice 	User input or bot input
	 * @return	if the move being play has not been played before
	 */
	private static boolean checkPost(int choice) {
		return !(player1.getPosition().contains(choice) || bot.getPosition().contains(choice));
	}
	
	/**
	 * This method update the game board with X and O according to choices made by the player or the bot 
	 * @param b			The board to be updated
	 * @param choice	The User choice or bot choice
	 * @param mode		Human player or Bot
	 */
	public static void updateBoard(Board b, int choice, Player mode) {
		char piece = ' ';
		if (!mode.getID().equals("BOT"))	// if human, piece is default to be "X"
			piece = 'X';
		else								// bot is "O"
			piece = 'O';

		mode.setPosition(choice);			// update list of moves played for a player
		b.setBoard(choice, piece);			// put an X or O onto the board
	}

	/**
	 * This method check to see if the a player has won the game or not
	 * @return if a win is detected
	 */
	private static boolean checkEnd() {
		// All possible win outcomes 
		List<Integer> r1 = Arrays.asList(1, 2, 3);
		List<Integer> r2 = Arrays.asList(4, 5, 6);
		List<Integer> r3 = Arrays.asList(7, 8, 9);
		List<Integer> c1 = Arrays.asList(1, 4, 7);
		List<Integer> c2 = Arrays.asList(2, 5, 8);
		List<Integer> c3 = Arrays.asList(3, 6, 9);
		List<Integer> d1 = Arrays.asList(1, 5, 9);
		List<Integer> d2 = Arrays.asList(3, 5, 7);

		List<List> win = new ArrayList<List>();
		win.add(r1);
		win.add(r2);
		win.add(r3);
		win.add(c1);
		win.add(c2);
		win.add(c3);
		win.add(d1);
		win.add(d2);
		
		// Cross examine between the list of all possible win outcomes versus 
		// the user's/bot's list of played move to determine a winner, if any
		for (List l : win) {
			if (player1.getPosition().containsAll(l)) {				// player win
				System.out.println("Congratualation! You win!");
				return true;
			} else if (bot.getPosition().containsAll(l)) {			// bot win
				System.out.println("Mission failed! We'll get 'em next time.");
				return true;
			} else if (player1.getPosition().size() + bot.getPosition().size() == 9) {	// draw
				System.out.println("It's a draw!");
				return true;
			}
		}

		return false;
	}
}