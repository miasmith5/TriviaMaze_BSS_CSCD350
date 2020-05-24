import java.util.Scanner;

public class Maze {
	private Room[][] maze;
	private Room currentRoom;
	private Room entrance;
	private Room exit;
	private int currentRowPosition;
	private int currentColumnPosition;

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

	public void traverseMaze() {
		Scanner keyboard = new Scanner(System.in);
		boolean sucess = false;
		String input = "";

		while (!input.equals("w") && !input.equals("d")
				&& !input.equals("s") && !input.equals("a")) {

			System.out.println("Which Direction Do You Want To Travel?");
			System.out.println("______________________________________");
			System.out.println("W. North Door");
			System.out.println("D. East Door");
			System.out.println("S. South Door");
			System.out.println("A. West Door");
			System.out.print("--->");
			
			input = keyboard.next().toLowerCase();
		}
		
		if(input.equals("w") && this.currentRoom.hasNorthDoor()) {
			this.currentRowPosition -= 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];
			
		}else if(input.equals("d") && this.currentRoom.hasEastDoor()) {
			this.currentColumnPosition += 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];
			
		}else if(input.equals("s") && this.currentRoom.hasSouthDoor()) {
			this.currentRowPosition += 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];
			
		}else if(input.equals("a") && this.currentRoom.hasWestDoor()) {
			this.currentColumnPosition -= 1;
			this.currentRoom = this.maze[this.currentRowPosition][this.currentColumnPosition];
			
		}else {
			System.out.println("\n You cannot travel through a wall.");
			System.out.println(this.currentRoom.hasEastDoor());
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
