import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Room {
	private String messageForTesting;
	private Token token;
	private Question question;
	private char discoverSymbol;
	private Object discoverable;

	private char northDoor;
	private char southDoor;
	private char eastDoor;
	private char westDoor;

	private char[][] room;

	public Room() {
		this.room = new char[3][3];
		this.createWalls();
		this.setDiscoverable();

		this.northDoor = this.room[0][1];
		this.southDoor = this.room[2][1];
		this.eastDoor = this.room[1][2];
		this.westDoor = this.room[1][0];
		this.discoverSymbol = this.room[1][1];
		

	}

	private void createWalls() {
		int i, j;

		for (i = 0; i < this.room.length; i++) {
			for (j = 0; j < this.room[i].length; j++) {
				this.room[i][j] = '*';
			}
		}
	}

	public void printRoom() {
		int i, j;

		for (i = 0; i < this.room.length; i++) {
			for (j = 0; j < this.room[i].length; j++) {
				System.out.print(this.room[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void setNorthDoor() {
		this.northDoor = '-';
		this.room[0][1] = this.northDoor;
	}

	public void setSouthDoor() {
		this.southDoor = '-';
		this.room[2][1] = this.southDoor;
	}

	public void setEastDoor() {
		this.eastDoor = '|';
		this.room[1][2] = this.eastDoor;
	}

	public void setWestDoor() {
		this.westDoor = '|';
		this.room[1][0] = this.westDoor;
	}
	
	public boolean hasNorthDoor() {
		return this.northDoor == '-';
	}
	
	public boolean hasSouthDoor() {
		return this.southDoor == '-';
	}
	
	public boolean hasEastDoor() {
		return this.eastDoor == '|';
	}
	
	public boolean hasWestDoor() {
		return this.westDoor == '|';
	}

	public Object getDiscoverable() {
		return this.discoverable;
	}

	public char getDiscoverSymbol() {
		return this.discoverSymbol;
	}

	public void setDiscoverable() {
		Random randomNumber = new Random();
		int num = randomNumber.nextInt(7);

		if (num == 0 || num == 1 || num == 2 || num == 3) {
			this.discoverable = new Question();
			this.discoverSymbol = 'Q';
			this.room[1][1] = 'Q';
			
		} else {
			Token token = TokenCreator.createToken(num);
			
			if(token.getDescription().equals("A chance")) {
				this.discoverable = token;
				this.discoverSymbol = 'A';
				this.room[1][1] = 'A';
			}
			
			else if(token.getDescription().equals("A token for an extra chance")) {
				this.discoverable = token;
				this.discoverSymbol = 'E';
				this.room[1][1] = 'E';
			}
			
			else if(token.getDescription().equals("A token to skip a question")) {
				this.discoverable = token;
				this.discoverSymbol = 'S';
				this.room[1][1] = 'S';
			}
		}
	}
	
	public void setDiscoverable(Object discover, char symbol) {
		this.discoverable = discover;
		this.discoverSymbol = symbol;
		this.room[1][1] = ' ';
	}

	public Question getQ() {
		return question;
	}

	public void setQ(Question q) {
		if (q != null)
			this.question = q;

		else
			this.messageForTesting = "Exception Found: Null Question Object In Room Class. Cannot Set Null Object.";
		System.out.println(this.messageForTesting);
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		if (token != null)
			this.token = token;

		else
			this.messageForTesting = "Exception Found: Null Token Object In Room Class. Cannot Set Null Object.";
		System.out.println(this.messageForTesting);

	}
	
	public String getMessageForTesting() {
		return this.messageForTesting;
	}

}
