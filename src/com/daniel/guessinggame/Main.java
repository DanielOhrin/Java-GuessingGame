package com.daniel.guessinggame;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game guessingGame = new Game();
		
		int[] result = guessingGame.run();
		
		if (result[2] == 1) {
			System.out.println("An Error occured with the scanner. Restart the application.");
			return;
		}
		
		StringBuilder gameOverMsg = new StringBuilder("You ");
		gameOverMsg.append(result[0] == 1 ? "Win!" : "Lose.");
		gameOverMsg.append(String.format("\nThe answer was %d", result[1]));
		
		Game.clearConsole();
		System.out.println(gameOverMsg.toString());
	}

}
