package triviamaze.game;

import java.util.Scanner;
import SaveState.SaveData;
import triviamaze.database.SQLiteJDBC;
import triviamaze.maze.Maze;

public class TriviaMazeGame {
	private static SaveData data = new SaveData();
	private static Scanner kb = new Scanner(System.in);
	private static Maze maze;
	private static SQLiteJDBC sql;

	public static void main(String[] args) {
		
		menu();

		do {
			maze.getCurrentRoom().printRoom();
			maze.traverseMove(maze.traverseDirection());

			if (maze.getCurrentRoom().getDiscoverSymbol() == 'Q' && !maze.getQuit()) {
				sql.getQuestion();

				String playerAnswer = playerChoice();
				String correctAnswer = sql.getCorrect();
				boolean correct = compareAnswers(playerAnswer, correctAnswer);

				if (!correct) {
					maze.lockCurrentRoom();
					System.out.println("\nYou answered incorrectly. That room is now locked.");
				}
			}

		} while (!maze.getQuit() && !maze.isEndGame() && !maze.isTrapped());

		if (maze.isEndGame()) {
			System.out.println("You have won!!!");

		} else if (maze.isTrapped()) {
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

	private static String playerChoice() {

		@SuppressWarnings("resource")
		Scanner inAnswer = new Scanner(System.in);
		String playerAnswer = inAnswer.nextLine();

		return playerAnswer;
	}

	private static boolean compareAnswers(String playerAnswer, String correctAnswer) {
		boolean correct;

		if (playerAnswer.equals(correctAnswer))
			correct = true;
			
		 else 
			correct = false;
			
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
	
	private static void menu() {
		System.out.println("MENU");
		System.out.println("____");
		System.out.println("1. Start A New Game");
		System.out.println("2. Load A Previous Game");
		System.out.println("3. Add Questions To Game");
		System.out.println("________________________");
		System.out.println("--->");
		String option = kb.next();

		if (option.equals("1")) {
			maze = new Maze();
			sql = SQLiteJDBC.getInstance();
			sql.dropTables();
			sql.createTables();
			sql.addQuestions();
			sql.addAnswers();
			sql.addCorrectAnswers();
			sql = SQLiteJDBC.getInstance();
			gameRules();
		
		}if (option.equals("2")) {
			maze = data.load();
			maze.resetQuit();
			sql = SQLiteJDBC.getInstance();
			
		}if(option.equals("3")) {
			sql = SQLiteJDBC.getInstance();
			sql.addNewQuestion();
			sql.addNewAnswers();			
			maze = new Maze();

		}
	}

}
