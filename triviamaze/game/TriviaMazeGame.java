package triviamaze.game;

import triviamaze.maze.Maze;

public class TriviaMazeGame {

	public static void main(String[] args) {

		Maze maze = new Maze();

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
			System.out.println("Could'nt load saved data: " + e.getMessage());
		}
		
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
	}
}
