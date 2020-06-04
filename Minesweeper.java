
import java.util.LinkedList;
import java.util.Scanner;

public class Minesweeper {
	
	/*Minesweeper.java 
	 *Author: Yousef Baghlaf
	 *Revision: 3
	 *Description: Minesweeper class will read in n arrays sized N x M from a text file,
	 *then creates a 2D char array of N+2 x M+2 then each safe spot will count mines 
	 *starting at [1][1] and ending at [N-1][M-1] then increment the value of the spot by 1 which will
	 *be the result of the total mines in that square. 
	 */ 
	 

	// Class to store the arrays of the output
	
	private class Cell {	
		public int num;
		public char[][] array;
		
		// Constructor that takes in a char array that would be the 
		// minefield that is read in the input
		
		public Cell(char[][] array) {
			this.num = 0;
			this.array = array;
		}		
	}
	
	// A LinkedList will be used to hold the each array 
	
	private LinkedList<Cell> fields;;

	//If the Minesweeper was instantiated properly the LinkedList 
	// will be created
	
	public Minesweeper() {
		this.fields = new LinkedList<Cell>();
	}
	
	
	
	// Adds the Cells to the ArrayList 
	
	public void fieldCount() {
		while(this.fields.peek().num <= 20) {
			this.fields.addLast(this.cellCount(this.fields.poll()));
		}
	}
	
	// Method to count the mines surrounding each safe spot. 
	
	private Cell cellCount(Cell cell) {
		char[][] array = cell.array;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] != '*') {
					array[i][j] = this.countMines(array, i, j);
				}// end if
			}//end for loop j
		}// end for loop i
		
		cell.array = array;
		cell.num++;
		return cell;
	}
	
	// Reads the arrays of the minefields from a text file that is read
	// by the scanner then
	// store it in a char array
	
	public void readArray(Scanner myScanner) {
		while(myScanner.hasNextLine()) {
			String fl = myScanner.nextLine();
			String[] nm = fl.split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			if(n != 0 && m != 0) {
				char[][] field = new char[n+2][m+2];
				for(int x = 0; x < n && myScanner.hasNextLine(); x++) {
					String line = myScanner.nextLine();
					for(int y = 0; y < line.length(); y++) {
						field[x][y] = line.charAt(y);
					}
				}
				this.fields.add(new Cell(field));
			} 
		}
	}

	// helper method to count the mines of the passed in char array
	// at the positions of i, j
	
	private char countMines(char[][] arr, int i, int j) {
		int mines = 0;
		if((i-1) >= 0 && (j-1) >= 0 && arr[i-1][j-1] == '*')
			mines++;
		if((i-1) >= 0 && arr[i-1][j] == '*')
			mines++;
		if((i-1) >= 0 && (j+1) < arr[0].length && arr[i-1][j+1] == '*')
			mines++;
		if((j-1) >= 0 && arr[i][j-1] == '*')
			mines++;
		if((j+1) < arr[0].length && arr[i][j+1] == '*')
			mines++;
		if((i+1) < arr.length && (j-1) >= 0 && arr[i+1][j-1] == '*')
			mines++;
		if((i+1) < arr.length && arr[i+1][j] == '*')
			mines++;
		if((i+1) < arr.length && (j+1) < arr[0].length && arr[i+1][j+1] == '*')
			mines++;
		String s = "" + mines;
		return s.charAt(0);
	} // Ian Case

	// This method prints out the hint of each minefield
	
	public String printFields() {
		String result = "";	
		for(int i = 0; i < this.fields.size(); i++) {
			result += "Field #" + (i + 1) + ":\r\n";
			char[][] arr = this.fields.get(i).array;
			
				for(int row = 0; row < arr.length - 2; row++) {
					for(int col = 0; col < arr[0].length - 2; col++) {
						result += arr[row][col];
					}
					result += "\r\n";
				}
				result += "\r\n";
			}
		return result;
	} // Ian Case
	
}
