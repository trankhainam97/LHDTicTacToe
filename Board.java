package tictactoe;
/**
 * Board object to display the game board
 * @author Nam Tran aka GluePretzel aka Bleh
 */
public class Board {
	// Layout of the board
	private final char[][] BOARD_LAYOUT = {{' ','|',' ','|',' '},
			  								{'-','+','-','+','-'},
			  								{' ','|',' ','|',' '},
			  								{'-','+','-','+','-'},
			  								{' ','|',' ','|',' '}};
	private char[][] board = new char[5][5];
	
	/*
	 * Constructor
	 */
	public Board() {
		this.board = BOARD_LAYOUT;
	}
	
	/**
	 * Getter
	 * @return 	the 2-dimension array that will act as the board
	 */
	public char[][] getBoard() {
		return this.board;
	}
	/**
	 * Setter
	 * @param choice 	User/bot move
	 * @param piece		Can be either X or O
	 */
	public void setBoard(int choice, char piece) {
		switch(choice) {
		case 1: this.board[0][0] = piece; 
			break;
		case 2: this.board[0][2] = piece;
			break;
		case 3: this.board[0][4] = piece;
			break;
		case 4: this.board[2][0] = piece;
			break;
		case 5: this.board[2][2] = piece;
			break;
		case 6: this.board[2][4] = piece;
			break;
		case 7: this.board[4][0] = piece;
			break;
		case 8: this.board[4][2] = piece;
			break;
		case 9: this.board[4][4] = piece;
		}
	}
	
	/**
	 * This method displays the board 
	 */
	public void showBoard() {
		for (int i = 0; i < 5; i++) {
			System.out.print("           ");
			for (int j = 0; j < 5; j++)
				System.out.print((this.getBoard())[i][j] + " ");
			
			System.out.println();
		}
	}
}
