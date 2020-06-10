package triviamaze.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;
import triviamaze.room.Room;

public class Maze implements Serializable {
	private static final long SERIALVERSIONUID = 1L;
	private Room[][] maze;
	private Room currentRoom;
	private Room entrance;
	private Room exit;
	private int currentRowPosition;
	private int currentColumnPosition;
	private boolean quit = false;

	public Maze() {
		this.maze = new Room[7][7];
		this.createMaze();
		this.createMazeBoarder();
		this.createDoors();

		this.entrance = maze[1][1];
		this.entrance.setDiscoverable(null, ' ');

		this.exit = maze[5][5];
		this.exit.setDiscoverable(null, ' ');

		this.currentRoom = this.entrance;
		this.currentColumnPosition = 1;
		this.currentRowPosition = 1;
	}

	private void createMazeBoarder() {
		int i, j;

		for (i = 0; i < this.maze.length; i++) {
			for (j = 0; j < this.maze[i].length; j++) {
				if (i == 0 || i == 6 || j == 0 || j == 6)
					this.maze[i][j] = null;
			}
		}
	}

	private void createMaze() {
		int i, j;

		for (i = 0; i < this.maze.length; i++) {
			for (j = 0; j < this.maze[i].length; j++) {
				this.maze[i][j] = new Room();
			}
		}
	}

	private void createDoors() {
		int i, j;

		for (i = 1; i < this.maze.length - 1; i++) {
			for (j = 1; j < this.maze[i].length - 1; j++) {

				if (this.maze[i - 1][j] != null)
					this.maze[i][j].setNorthDoor();

				if (this.maze[i + 1][j] != null)
					this.maze[i][j].setSouthDoor();

				if (this.maze[i][j - 1] != null)
					this.maze[i][j].setWestDoor();

				if (this.maze[i][j + 1] != null)
					this.maze[i][j].setEastDoor();
			}
		}
	}

	public Room getCurrentRoom() {
		return this.currentRoom;
	}

	public Room getNorthRoom() {
		return this.maze[this.currentRowPosition - 1][this.currentColumnPosition];
	}

	public Room getSouthRoom() {
		return this.maze[this.currentRowPosition + 1][this.currentColumnPosition];
	}

	public Room getEastRoom() {
		return this.maze[this.currentRowPosition][this.currentColumnPosition + 1];
	}

	public Room getWestRoom() {
		return this.maze[this.currentRowPosition][this.currentColumnPosition - 1];
	}

	public Room[][] getMaze() {
		return this.maze;
	}

	public boolean isEndGame() {
		return this.currentRoom == this.exit;
	}

	public boolean getQuit() {
		return this.quit;
	}

	public void resetQuit() {
		this.quit = false;
	}

	public String traverseDirection() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String input = "";

		while (!input.equals("w") && !input.equals("d") && !input.equals("s") && !input.equals("a")
				&& !input.equals("q") && !input.equals("c") & !input.equals("v")) {

			System.out.println("Which Direction Do You Want To Travel?");
			System.out.println("______________________________________");
			System.out.println("W. North Door");
			System.out.println("D. East Door");
			System.out.println("S. South Door");
			System.out.println("A. West Door");
			System.out.println("Q. QUIT");
			System.out.print("--->");

			input = keyboard.next().toLowerCase();
		}
		return input;
	}

	public void traverseMove(String input) {

		if (input.equals("w") && this.currentRoom.hasNorthDoor()) {
			this.currentRowPosition -= 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];

		} else if (input.equals("d") && this.currentRoom.hasEastDoor()) {
			this.currentColumnPosition += 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];

		} else if (input.equals("s") && this.currentRoom.hasSouthDoor()) {
			this.currentRowPosition += 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];

		} else if (input.equals("a") && this.currentRoom.hasWestDoor()) {
			this.currentColumnPosition -= 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];

		} else if (input.equals("q")) {
			this.quit = true;

		} else if (input.equals("c")) {
			this.printMaze();

		} else if (input.equals("v")) {
			Scanner readFile;
			
			try {
				readFile = new Scanner(new File("database_questions.txt"));
				while (readFile.hasNext()) {
					System.out.println(readFile.nextLine());
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found" + e.getMessage());
			}

		} else {
			System.out.println("\nYou cannot travel through a wall.");
		}
	}

	public boolean isTrapped() {

		if (!this.currentRoom.hasNorthDoor() && !this.currentRoom.hasEastDoor() && !this.currentRoom.hasSouthDoor()
				&& !this.currentRoom.hasWestDoor())
			return true;

		else
			return false;
	}

	public void lockCurrentRoom() {
		if (this.currentRoom.hasNorthDoor()) {
			Room adjacentRoom = this.maze[this.currentRowPosition - 1][this.currentColumnPosition];
			adjacentRoom.closeSouthDoor();
			this.currentRoom.closeNorthDoor();
		}

		if (this.currentRoom.hasSouthDoor()) {
			Room adjacentRoom = this.maze[this.currentRowPosition + 1][this.currentColumnPosition];
			adjacentRoom.closeNorthDoor();
			this.currentRoom.closeSouthDoor();
		}

		if (this.currentRoom.hasEastDoor()) {
			Room adjacentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition + 1];
			adjacentRoom.closeWestDoor();
			this.currentRoom.closeEastDoor();
		}

		if (this.currentRoom.hasWestDoor()) {
			Room adjacentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition - 1];
			adjacentRoom.closeEastDoor();
			this.currentRoom.closeWestDoor();
		}

		this.currentRoom.lockRoom();
		this.moveToRoom();
	}

	public void moveToRoom() {

		if (this.getNorthRoom() != null && !this.getNorthRoom().isLocked()) {
			this.currentRoom = this.getNorthRoom();

		} else if (this.getSouthRoom() != null && !this.getSouthRoom().isLocked()) {
			this.currentRoom = this.getSouthRoom();

		} else if (this.getEastRoom() != null && !this.getEastRoom().isLocked()) {
			this.currentRoom = this.getEastRoom();

		} else if (this.getWestRoom() != null && !this.getWestRoom().isLocked()) {
			this.currentRoom = this.getWestRoom();

		} else {
			this.quit = true;
		}
	}

	public void printCurrentRoom() {
		this.currentRoom.printRoom();
	}

	public void printMaze() {
		int i, j;

		for (i = 1; i < this.maze.length - 1; i++) {
			for (j = 1; j < this.maze[i].length - 1; j++) {
				this.maze[i][j].printRoom();
			}
		}
	}

}
