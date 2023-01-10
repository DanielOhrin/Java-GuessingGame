package com.daniel.guessinggame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Map<String, Integer> gameHistory = new HashMap<String, Integer>(); 
		gameHistory.put("Wins", Integer.valueOf(0));
		gameHistory.put("Losses", Integer.valueOf(0));

		String isPlaying = "y";

		// Open a scanner
		Scanner scanner = new Scanner(System.in);

		while (isPlaying.equalsIgnoreCase("Y")) {
			Game guessingGame = new Game();

			guessingGame.chooseDifficulty();
			final int[] RESULT = guessingGame.run();

			if (RESULT[2] == 1) {
				scanner.close();
				System.out.println("An Error occured with the scanner. Restart the application.");
				return;
			}

			// Add the game's result to the gameHistory HashMap
			String lastGameResult = RESULT[0] == 1 ? "Wins" : "Losses";
			gameHistory.replace(lastGameResult, gameHistory.get(lastGameResult) + 1);

			// Build a message to display to the user
			StringBuilder gameOverMsg = new StringBuilder("You ");
			gameOverMsg.append(RESULT[0] == 1 ? "Win!" : "Lose.");
			gameOverMsg.append(String.format("\nThe answer was %d", RESULT[1]));
			gameOverMsg.append("\n\nPlay again? (Y/n): ");

			Game.clearConsole();
			System.out.println(gameOverMsg.toString());

			// Always want this to run once, because the default value will be some form of "Y"
			do {
				try {
					isPlaying = scanner.next();
				} catch (Exception e) {
					scanner.close();
					System.out.println("An Error occured with the scanner. Restart the application.");
					return;
				}

			} while (!isPlaying.equalsIgnoreCase("Y") && !isPlaying.equalsIgnoreCase("N"));
			
			if (isPlaying.equalsIgnoreCase("N")) {
				break;
			}
		}

		// Close the scanner
		scanner.close();

		// Build final message
		StringBuilder finalMessage = new StringBuilder(ASCII());
		finalMessage.append(String.format("\n\nFinal Score:  %d WINS | %d LOSSES\n", gameHistory.get("Wins"),
				gameHistory.get("Losses")));

		// Line changes depending on W/L ratio
		finalMessage.append(
				gameHistory.get("Wins") > gameHistory.get("Losses") 
					? "Amazing work! You're a prodigy!"
					: gameHistory.get("Wins") == gameHistory.get("Losses")
						? "Great job. You're improving!"
						: "Rome wasn't built in a day!");

		finalMessage.append("\n\nThanks for playing!");
		finalMessage.append("\n\n    Made by Daniel Ohrin");
		
		Game.clearConsole();
		System.out.println(finalMessage.toString());
	}
	
	private static String ASCII() {
		StringBuilder sb = new StringBuilder(" ## ##   ##  ###  ### ###   ## ##    ## ##     ####   ###  ##   ## ##             ## ##     ##     ##   ##  ### ### ");
		sb.append("\n##   ##  ##   ##   ##  ##  ##   ##  ##   ##     ##      ## ##  ##   ##           ##   ##     ##     ## ##    ##  ## ");
		sb.append("\n##       ##   ##   ##      ####     ####        ##     # ## #  ##                ##        ## ##   # ### #   ##      ");
		sb.append("\n##  ###  ##   ##   ## ##    #####    #####      ##     ## ##   ##  ###           ##  ###   ##  ##  ## # ##   ## ##   ");
		sb.append("\n##   ##  ##   ##   ##          ###      ###     ##     ##  ##  ##   ##           ##   ##   ## ###  ##   ##   ##      ");
		sb.append("\n##   ##  ##   ##   ##  ##  ##   ##  ##   ##     ##     ##  ##  ##   ##           ##   ##   ##  ##  ##   ##   ##  ##  ");
		sb.append("\n ## ##    ## ##   ### ###   ## ##    ## ##     ####   ###  ##   ## ##             ## ##   ###  ##  ##   ##  ### ###  ");
		
		return sb.toString();
	}
}
