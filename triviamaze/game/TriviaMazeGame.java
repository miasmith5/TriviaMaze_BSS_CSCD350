package triviamaze.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.Scanner;
import SaveState.ResourceManager;
import SaveState.SaveData;
import triviamaze.database.SQLiteJDBC;
import triviamaze.maze.Maze;

public class TriviaMazeGame {
	private static SaveData data = new SaveData();
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		Maze maze = new Maze();
		SQLiteJDBC sql = SQLiteJDBC.getInstance();

		System.out.println("Would you like to load your previous game?");
		System.out.println("1. NO");
		System.out.println("2. YES");
		System.out.println("______");
		System.out.print("-->");
		String load = kb.next();

		if (load.equals("2"))
			maze = data.load();
		
		else
			gameRules();

//		sql.createTables();
//		sql.addQuestions();
//		sql.addAnswers();
//		sql.addCorrectAnswers();

		

		do {
			maze.getCurrentRoom().printRoom();
			maze.traverseMaze();

			if (maze.getCurrentRoom().getDiscoverSymbol() == 'Q') {
				sql.getQuestion();
				sql.getAnswers();

				Object playerAnswer = playerChoice();
				Object correctAnswer = sql.getCorrect();
				boolean correct = compareAnswers(playerAnswer, correctAnswer);

				if (!correct) {
					maze.lockCurrentRoom();
					System.out.println("\nYou answered incorrectly. That room is now locked.");
				}

			}

		} while (!maze.getQuit() && !maze.isEndGame() && !maze.isTrapped());

		if (maze.isEndGame()) {
			System.out.println("You have won!!!");
			
		}else if(maze.isTrapped()) {
			System.out.println("You have been trapped. Try again.");
			
		} else {
			System.out.println("Would you like to save your current game?");
			System.out.println("1. NO");
			System.out.println("2. YES");
			System.out.println("______");
			System.out.print("-->");

			String save = kb.next();

			if (save.equals("2"))
				data.save(maze);
			
		}

	}// end main

	// this records the player choice
	private static Object playerChoice() {

		Scanner inAnswer = new Scanner(System.in);
		Object playerAnswer = inAnswer.nextLine();

		return playerAnswer;

	}

	private static boolean compareAnswers(Object playerAnswer, Object correctAnswer) {
		boolean correct;

		if (playerAnswer.equals(correctAnswer)) {
			correct = true;
		} else {
			correct = false;
		}
		return correct;

	}

	private static void gameRules() {
		System.out.println("\n__________________________________________________________________________________");
		System.out.println("You are now playing Trivia Maze!");
		System.out.println("The rules are simple...");
		System.out.println("1) Traverse through the maze to find the exit.");
		System.out.println("2) Each room either has a question that you have to answer or a token to pick up.");
		System.out.println("3) Only when you answer a question wrong will that room be permanantly be locked. ");
		System.out.println("4) Tokens can grant you special abilities to help you through the maze.");
		System.out.println("__________________________________________________________________________________\n");

	}
	
	

}
