package triviamaze.room;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomUnitTester {
	private Room room = new Room();
	
	@Test
	public void setTokenTest() {
		this.room.setToken(null);
		assertEquals("Exception Found: Null Token Object In Room Class. Cannot Set Null Object.", this.room.getMessageForTesting());
	}

}
