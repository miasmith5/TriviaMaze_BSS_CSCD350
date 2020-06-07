import java.io.Serializable;

public class SaveData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Maze maze;
	private int currentRowPosition;
	private int currentColumnPosition;
	
	public Maze getMaze() {
		return this.maze;
	}
	
	public int getRowPosition() {
		return this.currentRowPosition;
	}
	
	public int getColumnPosition() {
		return this.currentColumnPosition;
	}
	
	public void setMaze(Maze m) {
		this.maze = m;
	}
	
	public void setRowPosition(int r) {
		this.currentRowPosition = r;
	}
	
	public void setColumnPosition(int c) {
		this.currentColumnPosition = c;
	}
}
