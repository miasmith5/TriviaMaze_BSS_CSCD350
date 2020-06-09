package SaveState;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import triviamaze.maze.Maze;

public class ResourceManager {
	
	public static void save(Serializable data, String fileName) throws Exception{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("fileName"));
		
		objectOutputStream.writeObject(data);
		objectOutputStream.close();
			
	}
	
//	public static SaveData load(String fileName) throws Exception{
//		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
//		maze = objectInputStream.readObject();
//
//
//	}
}
