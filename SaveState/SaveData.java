package SaveState;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import triviamaze.database.SQLiteJDBC;
import triviamaze.maze.Maze;

public class SaveData implements Serializable{
	private static final long SERIALVERSIONUID = 1L;
	
	public void save(Maze maze) {
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("1.save"));

			objectOutputStream.writeObject(maze);
			objectOutputStream.close();

		} catch (Exception e) {
			System.out.println("Could'nt save: " + e.getMessage());

		}
	}
	
	public Maze load() {
		Maze maze = new Maze();
		
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("1.save"));
			
			maze = (Maze) objectInputStream.readObject();
			maze.resetQuit();
			objectInputStream.close();
			

		} catch (Exception e) {
			System.out.println("\nThere is no previous game to load.\n");
		}
		return maze;
	}
	
}
