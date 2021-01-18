package tictactoe;

/**
 * Helper class to display some texts and logo
 * @author Nam Tran aka GluePretzel aka Bleh
 */
public class texts {
	public static void Logo() {
		System.out.println("(_______)                 | |                                 | |(_)              _            | |\r\n" + 
				" _     _ _   _ _____  ____| |_   _ _____ ____ ___  ____  ____ | | _  ____ _____ _| |_ _____  __| |\r\n" + 
				"| |   | | | | | ___ |/ ___) | | | (_____) ___) _ \\|    \\|  _ \\| || |/ ___|____ (_   _) ___ |/ _  |\r\n" + 
				"| |___| |\\ V /| ____| |   | | |_| |    ( (__| |_| | | | | |_| | || ( (___/ ___ | | |_| ____( (_| |\r\n" + 
				" \\_____/  \\_/ |_____)_|    \\_)__  |     \\____)___/|_|_|_|  __/ \\_)_|\\____)_____|  \\__)_____)\\____|\r\n" + 
				"                            (____/                      |_|                                       \r\n" + 
				"         _______ _          _______             _______                                           \r\n" + 
				"        (_______|_)        (_______)           (_______)                                          \r\n" + 
				"            _    _  ____ _____ _ _____  ____ _____ _  ___  _____                                  \r\n" + 
				"           | |  | |/ ___|_____) (____ |/ ___|_____) |/ _ \\| ___ |                                 \r\n" + 
				"           | |  | ( (___      | / ___ ( (___      | | |_| | ____|                                 \r\n" + 
				"           |_|  |_|\\____)     |_\\_____|\\____)     |_|\\___/|_____)                                ");
	}
	public static void About() {
		System.out.println("Hello, welcome to the Tic-Tac-Toe game made by me, Nam Tran from Sac State University!\n" +
							"This simple program that I decided to make uneccessarily bigger is for MLH's Local Hack Day: Build 2021.\n" +
							"This is yet another Tic-Tac-Toe game on a 3x3 grid.\n\n" +
							"Expect update whenever. Also, contact me if you have any question (pls no spam thanks).");
	}
	public static void Div() {
		System.out.println("===========================================================================\n");
	}
	public static void GoodBye() {
		System.out.println("Good bye! Thank you for playing!");
	}
}
