import java.sql.SQLException;
import java.util.Scanner;

import SaveState.ResourceManager;
import SaveState.SaveData;
import triviamaze.maze.Maze;

public class TriviaMazeGame {

	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {

		Maze maze = new Maze();
		SQLiteJDBC sql = SQLiteJDBC.getInstance();
		SaveData sData = new SaveData();
		sData.setMaze(maze);
		sData.setColumnPosition(1);
		sData.setRowPosition(1);

		try {
			ResourceManager.save(sData, "1.save");

		} catch (Exception e) {
			System.out.println("Could'nt save: " + e.getMessage());
		}

		try {
			SaveData lData = (SaveData) ResourceManager.load("1.save");
			maze = lData.getMaze();
			int row = lData.getRowPosition();
			int col = lData.getColumnPosition();

		} catch (Exception e) {
			System.out.println("Couldn't load saved data: " + e.getMessage());
		}
		
		//Create the database and add everything once. If questions are added again then the table will have duplicates
		//Put in Load Try Catch
			sql.createTables();
			sql.addQuestions();
			sql.addAnswers();
			sql.addCorrectAnswers();
		
		
		//Start of TriviaMazeGame
		
		System.out.println("You are now playing Trivia Maze!");
		System.out.println("The rules are simple...");
		System.out.println("1) Traverse through the maze to find the exit.");
		System.out.println("2) Each room either has a question that you have to answer or a token to pick up.");
		System.out.println("3) Only when you answer a question wrong will that room be permanantly be locked. ");
		System.out.println("4) Tokens can grant you special abilities to help you through the maze.");
		System.out.println("5) Enter 'S' to save your current game");
		System.out.println("6) Enter 'L' to load a previous game");
		System.out.println("7) Enter 0 to quit");
		
		do {
			// this is the game loop inside there will be method calls for everything
			Object correctAnswer = sql.getCorrect();
		}while(kb.nextLine() != "0");
		
	}// end main
	
	// this records the player choice 
	private static Object playerChoice() {
		
		Scanner inAnswer = new Scanner(System.in);
		Object playerAnswer = inAnswer.nextLine();
		
		return playerAnswer;
		
	}
	
	private static boolean compareAnswers(Object playerAnswer, Object correctAnswer) {
		boolean correct;
		
		if(playerAnswer.equals(correctAnswer)){
			correct = true;
		}
		else {
			correct = false;
		}
		return correct;
		
	}
	
}

