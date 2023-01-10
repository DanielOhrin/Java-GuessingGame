package com.daniel.guessinggame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Boolean> gameHistory = new ArrayList<Boolean>();
		String isPlaying = "y";

		// Open a scanner
		Scanner scanner = new Scanner(System.in);

		while (isPlaying.equalsIgnoreCase("Y")) {
			Game guessingGame = new Game();

			final int[] RESULT = guessingGame.run();

			if (RESULT[2] == 1) {
				scanner.close();
				System.out.println("An Error occured with the scanner. Restart the application.");
				return;
			}

			StringBuilder gameOverMsg = new StringBuilder("You ");
			gameOverMsg.append(RESULT[0] == 1 ? "Win!" : "Lose.");
			gameOverMsg.append(String.format("\nThe answer was %d", RESULT[1]));
			gameOverMsg.append("\n\nPlay again? (Y/n): ");

			Game.clearConsole();
			System.out.println(gameOverMsg.toString());

			// Always want this to run once, because the default value will be some form of
			// "Y"
			do {
				try {
					isPlaying = scanner.next();
				} catch (Exception e) {
					scanner.close();
					System.out.println("An Error occured with the scanner. Restart the application.");
					return;
				}

				if (isPlaying.equalsIgnoreCase("N")) {
					break;
				}
			} while (!isPlaying.equalsIgnoreCase("Y") && !isPlaying.equalsIgnoreCase("N"));
		}

		// Close the scanner
		scanner.close();
	}

}
