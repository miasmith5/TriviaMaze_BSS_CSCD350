package triviamaze.room;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomUnitTester {
	private Room room = new Room();
	
	@Test
	public void roomDimensionTest() {
		char[][] r = this.room.getRoom();
		assertEquals(3, r.length);
		assertEquals(3, r[0].length);
	}
	
	@Test
	public void wallsTest() {
		char[][] r = this.room.getRoom();
		assertEquals('*', r[0][0]);
	}
	
	@Test
	public void discoverSymbolTest() {
		char[][] r = this.room.getRoom();
		assertEquals('Q', r[1][1]);
	}
	
	@Test
	public void discoverObjectTest() {
		this.room.setDiscoverable(null, ' ');
		assertEquals("Exception Found: Null Discover Object In Room Class. Cannot Set Null Object.", this.room.getMessageForTesting());
	}
}
