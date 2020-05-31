import static org.junit.Assert.*;

import org.junit.Test;

public class MazeUnitTester {
	private Maze maze = new Maze();
	
	@Test
	public void getRowSizeTest() {
		Room[][] roomArray = maze.getMaze();
		assertEquals(7, roomArray.length);
	}
	
	@Test
	public void getColumnSizeTest() {
		Room[][] roomArray = maze.getMaze();
		assertEquals(7, roomArray[0].length);
	}
	
	public void startingRoomNorthDoorTest() {
		Room room = this.maze.getCurrentRoom();
		assertEquals(false, room.hasNorthDoor());
	}
	
	@Test
	public void  startingRoomEastDoorTest() {
		Room room = this.maze.getCurrentRoom();
		assertEquals(true, room.hasEastDoor());
		
	}
	
	@Test
	public void startingRoomSouthDoorTest() {
		Room room = this.maze.getCurrentRoom();
		assertEquals(true,room.hasSouthDoor());
	}
	
	@Test
	public void startingRoomWestDoorTest() {
		Room room = this.maze.getCurrentRoom();
		assertEquals(false, room.hasWestDoor());
	}
	
	

}
