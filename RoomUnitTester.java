package TriviaMaze_BSS_CSCD350;
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

}
