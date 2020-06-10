package triviamaze.room;

import java.io.Serializable;

public class Room implements Serializable {
	private static final long SERIALVERSIONUID = 1L;
	private String messageForTesting;
	private char discoverSymbol;
	private Object discoverable;
	private boolean locked = false;
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

	public char[][] getRoom() {
		return this.room;
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

	public void setDiscoverable(Object o, char symbol) {
		this.discoverable = 0;
		this.discoverSymbol = symbol;
		this.room[1][1] = this.discoverSymbol;
	}

	public void setDiscoverable() {
		this.discoverSymbol = 'Q';
		this.room[1][1] = 'Q';
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

	public void closeNorthDoor() {
		this.northDoor = '*';
		this.room[0][1] = this.northDoor;
	}

	public void closeEastDoor() {
		this.eastDoor = '*';
		this.room[1][2] = this.eastDoor;
	}

	public void closeSouthDoor() {
		this.southDoor = '*';
		this.room[2][1] = this.southDoor;
	}

	public void closeWestDoor() {
		this.westDoor = '*';
		this.room[1][0] = this.westDoor;
	}

	public boolean isLocked() {
		return this.locked;
	}

	public void lockRoom() {
		this.locked = true;
	}

	public String getMessageForTesting() {
		return this.messageForTesting;
	}

}
