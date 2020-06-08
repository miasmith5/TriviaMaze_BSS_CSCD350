package SaveState;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import triviamaze.maze.Maze;

public class SaveData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Maze maze;
	private int currentRowPosition;
	private int currentColumnPosition;
	private String messageForTesting;
	
	public Maze getMaze() {
		return this.maze;
	}
	
	public int getColumnPosition() {
		return this.currentColumnPosition;
	}
	
	public int getRowPosition() {
		return this.currentRowPosition;
	}
	
	public void setMaze(Maze m) {
		if(m != null) {
			this.maze = m;
		
		}else {
			this.messageForTesting = "Exception Found: Null Maze Object In SaveData Class. Cannot Set Null Object.";
			System.out.println(this.messageForTesting);
		}
	}
	
	public void setColumnPosition(int c) {
		String re = "\\d";
		String text = String.valueOf(c);
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(text);
		
		if(mt.matches()) {
			this.currentColumnPosition = c;
		
		}else {
			this.messageForTesting = "Exception Found: Data type mismatch in SaveData class. Cannot set current column.";
			System.out.println(this.messageForTesting);
		}
	}
	
	public void setRowPosition(int r) {
		String re = "\\d";
		String text = String.valueOf(r);
		
		Pattern pt = Pattern.compile(re);
		Matcher mt = pt.matcher(text);
		
		if(mt.matches()) {
			this.currentColumnPosition = r;
		
		}else {
			this.messageForTesting = "Exception Found: Data type mismatch in SaveData class. Cannot set current row.";
			System.out.println(this.messageForTesting);
		}
	}
	
}
