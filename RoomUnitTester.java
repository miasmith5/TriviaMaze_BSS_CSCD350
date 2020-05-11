import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomUnitTester {
	private Room room = new Room();
	
	@Test
	public void setQuestionTest() {
		this.room.setQ(null);
		assertEquals("Exception Found: Null Question Object In Room Class. Cannot Set Null Object.", this.room.getMessageForTesting());
	}
	
	@Test
	public void setTokenTest() {
		this.room.setToken(null);
		assertEquals("Exception Found: Null Token Object In Room Class. Cannot Set Null Object.", this.room.getMessageForTesting());
	}
	
	@Test
	public void setRoomTypeTest() {
		this.room.setRoomType(2);
		assertEquals(2, this.room.getRoomType());
		
		this.room.setRoomType(12);
		assertEquals("Exception Found: Input Type Mismatch In Room Class. Cannot Set RoomType.", this.room.getMessageForTesting());
	}

}
