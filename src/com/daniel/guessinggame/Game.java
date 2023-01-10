package com.daniel.guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private Random random = new Random();
	private int answer = random.nextInt(101);
	private int maxGuesses = 10;
	private Scanner scanner = new Scanner(System.in);
	
	public static void clearConsole() {
		for (int i = 0; i < 101; i++) {
			System.out.println();
		}
	}
	
	public void closeScanner() {
		scanner.close();
	}
	
	public void chooseDifficulty() {
		clearConsole();

		System.out.println("Choose Difficulty:");
		System.out.println();
		System.out.println("1. Easy\n2. Medium\n3. Hard\n4. Impossible");

		System.out.println();
		System.out.print("Choice: ");

		String difficulty = scanner.next();

		if (difficulty.equalsIgnoreCase("Hacker")) {
			maxGuesses = -1;
		}

		switch (difficulty) {
		case "1":
			maxGuesses = 20;
			break;
		case "2":
			maxGuesses = 10;
			break;
		case "3":
			maxGuesses = 5;
			break;
		case "4":
			maxGuesses = 2;
			break;
		default:
			break;
		}

	}

	public int[] run() {
		clearConsole();

		// [1] = Win/Lose [2] = answer [3] = scanner error
		int[] result = new int[] { -1, answer, 0 };
		int guesses = maxGuesses;
		Integer guess = null;

		while (maxGuesses == -1 ? true : guesses > 0) {
			clearConsole();

			if (guess != null) {
				if (guess.intValue() > answer) {
					System.out.println(String.format("%d is too high.", guess.intValue()));
				} else {
					System.out.println(String.format("%d is too low.", guess.intValue()));
				}
				System.out.println();
			}

			if (maxGuesses != -1) {
				if (guesses == 1) {
					System.out.print("Final Guess: ");
				} else if (guesses == maxGuesses) {
					System.out.println(String.format("Guessing Game | You have %d attempts", guesses));
					System.out.println("Welcome! I am thinking of a whole number between 1-100!");
					System.out.println();
					System.out.print(String.format("Guess(%d left): ", guesses));
				} else {
					System.out.print(String.format("Guess %d: ", guesses));
				}
			} else {
				System.out.println("You have infinite guesses!");
				System.out.print("Guess: ");
			}

			try {
				guess = scanner.nextInt();
			} catch (Exception e) {
				result[2] = 1;
				break;
			}

			if (guess == answer) {
				result[0] = 1;
				break;
			}

			if (maxGuesses != -1) {
				guesses--;
			}
		}

		// -1 or 1 (lose or win)
		return result;
	}
}
