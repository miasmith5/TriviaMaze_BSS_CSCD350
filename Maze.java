import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maze {
	private Room[][] maze;
	private Room currentRoom;
	private Room entrance;
	private Room exit;
	private int currentRowPosition;
	private int currentColumnPosition;
	private int attempts = 3;
	private ArrayList<String> inventoryOfTokens = new ArrayList<>();
	private String usedToken = "";

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
		
		System.out.println("This is room [" + currentRowPosition + "][" + currentColumnPosition + "]");
		while (!input.equals("w") && !input.equals("d")
				&& !input.equals("s") && !input.equals("a")) {
			
			if(roomHasAQuestion()) {
				Question q = askQuestion();
				checkAnswer(keyboard, q);
				this.usedToken = "";
			}
			
			else if(roomHasAToken())
				addTokenToInventory();
			

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
			System.out.println("\nYou cannot travel through a wall.");
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
	
	public void useToken(ArrayList<String> inventoryOfTokens, Scanner keyboard) {
			if(inventoryOfTokens.size() == 0) {
				System.out.println("You have no tokens to use!");
				return;
			}
			
			else {
				System.out.println("Enter the symbol of the token to use it: ");
				
				for(int i = 0 ; i < inventoryOfTokens.size(); i ++) {
					if(inventoryOfTokens.get(i).equals("A token to skip a question")) {
						System.out.print(inventoryOfTokens.get(i) + " (S)\n");
					}
					
					else if(inventoryOfTokens.get(i).equals("A token to remove two choices")){
						System.out.print(inventoryOfTokens.get(i) + " (R)\n");
					}
					
					else if(inventoryOfTokens.get(i).equals("A token for an extra chance")) {
						System.out.print(inventoryOfTokens.get(i) + " (E)\n");
					}
					
				}		
				
			}
			
			keyboard.nextLine();
			this.usedToken = keyboard.nextLine().toLowerCase();
			
			
			if(this.usedToken.equals("s")) {
				System.out.println("You used a token to skip a question!");
				inventoryOfTokens.remove("A token to skip a question");
			}
			
			
			else if(this.usedToken.equals("r")) {
				System.out.println("You used a token to remove two choices!");
				inventoryOfTokens.remove("A token to remove two choices");
			}
				
			else if(this.usedToken.equals("e")) {
				System.out.println("You used a token for an extra chance!");
				this.attempts++;
				inventoryOfTokens.remove("A token for an extra chance");
			}
	}
	
	public boolean roomHasAQuestion() {
		if(this.maze[currentRowPosition][currentColumnPosition].getDiscoverSymbol() == 'Q') 
			return true;
		else
			return false;
	}
	
	public boolean roomHasAToken() {
		if(this.maze[currentRowPosition][currentColumnPosition].getDiscoverSymbol() == 'R')
			return true;
		else if(this.maze[currentRowPosition][currentColumnPosition].getDiscoverSymbol() == 'S')
			return true;
		else if(this.maze[currentRowPosition][currentColumnPosition].getDiscoverSymbol() == 'A')
			return true;
		else if (this.maze[currentRowPosition][currentColumnPosition].getDiscoverSymbol() == 'E')
			return true;
		
		else return false;
	}
	
	public Question askQuestion() {
		Question q = new Question();
		q.generateQuestion(new Random().nextInt());
		System.out.println(q);
		
		return q;
	}
	
	
	public void checkAnswer(Scanner keyboard, Question q) {
		boolean asnwered = false;
		
		System.out.println("You have " + attempts + " attempts left, enter 0 use a token");
		System.out.println(inventoryOfTokens);
		System.out.println("Your answer is: ");
		int answer = keyboard.nextInt();
		
		if(answer == 0)
			useToken(inventoryOfTokens, keyboard);
		
		
		while(!q.hasBeenAnswered(answer) && !this.usedToken.equals("s")) {
			this.attempts--;
			System.out.println("Wrong answer!");
			System.out.println("You have " + attempts + " attempts left, enter 0 use a token");
			
			if(attempts == 0)
				break;
			
			System.out.println("Your answer is: ");
			answer = keyboard.nextInt();	
			
			if(answer == 0) // using a token
				useToken(inventoryOfTokens, keyboard);
		}
		
		if(attempts == 0 && !q.hasBeenAnswered(answer)) {
			if(inventoryOfTokens.contains("A token for an extra chance")) {
				System.out.println("You are out of attempts, but you have \n" +
									"an extra chance token, would you like to use it? (y/n)");
				
				keyboard.nextLine();
				String choice = keyboard.nextLine().toLowerCase();
				
				if(choice.equals("y")) {
					this.attempts++;
					inventoryOfTokens.remove("A token for an extra chance");
					return;
				}
				
				else {
					System.out.println("You lost!");
					System.exit(0);
				}
			}
			
			else {
				System.out.println("You lost!");
				System.exit(0);
			}
		}	
	}
	
	public void addTokenToInventory() {
		if(roomHasAToken()) {
			System.out.println(((Token) this.maze[currentRowPosition][currentColumnPosition].getDiscoverable()).getDescription() + " added!");
			inventoryOfTokens.add(((Token) this.maze[currentRowPosition][currentColumnPosition].getDiscoverable()).getDescription());
		}
	}
}
