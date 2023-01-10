package com.daniel.guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Random random = new Random();
	private int answer = random.nextInt(101);
	final static private int MAX_GUESSES = 5;

	public static void clearConsole() {
		for (int i = 0; i < 101; i++) {
			System.out.println();
		}
	}
	
	public int[] run() {
		clearConsole();
		
		// [1] = Win/Lose   [2] = answer   [3] = scanner error
		int[] result = new int[] { -1, answer, 0 };
		int guesses = MAX_GUESSES;
		Integer guess = null;
		
		// Scans terminal for input
		Scanner scanner = new Scanner(System.in);

		while (guesses > 0) {
			clearConsole();

			if (guess != null) {
				if (guess.intValue() > answer) {
					System.out.println(String.format("%d is too high.", guess.intValue()));
				} else {
					System.out.println(String.format("%d is too low.", guess.intValue()));
				}
				System.out.println();
			}
			
			if (guesses == 1) {
				System.out.print("Final Guess: ");
			} else if (guesses == MAX_GUESSES) {
				System.out.println("Guessing Game | You have 5 guesses left.");
				System.out.println("Welcome! I am thinking of a whole number between 1-100!");
				System.out.println();
				System.out.print(String.format("Guess(%d left): ",  guesses));
			} else {
				System.out.print(String.format("Guess %d: ", guesses));
			}
			
			try {
				guess = scanner.nextInt();
			} catch (Exception e) {
				scanner.close();
				result[2] = 1;
				break;
			} 
			
			if (guess == answer) {
				result[0] = 1;
				break;
			}
			
			guesses--;
		}
		
		// -1 or 1 (lose or win)
		return result;
	}
}
