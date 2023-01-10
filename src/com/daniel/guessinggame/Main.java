package com.daniel.guessinggame;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game guessingGame = new Game();
		
		final int[] RESULT = guessingGame.run();
		
		if (RESULT[2] == 1) {
			System.out.println("An Error occured with the scanner. Restart the application.");
			return;
		}
		
		StringBuilder gameOverMsg = new StringBuilder("You ");
		gameOverMsg.append(RESULT[0] == 1 ? "Win!" : "Lose.");
		gameOverMsg.append(String.format("\nThe answer was %d", RESULT[1]));
		
		Game.clearConsole();
		System.out.println(gameOverMsg.toString());
	}

}
