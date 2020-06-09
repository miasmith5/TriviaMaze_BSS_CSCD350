package triviamaze.game;

import triviamaze.maze.Maze;

public class Tester {
	public static void main(String[] args) {
		Maze maze = new Maze();
		
		int i = 0;
		
		while(i == 0) {
			maze.printCurrentRoom();
			maze.traverseMaze();
		}
		
	}
}
