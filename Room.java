import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Room {
	private String messageForTesting;
	private int roomType;
	private Token token;
	private Door door;
	private String question;
	private Question q;
	
	public Room() {
		this.roomType = new Random().nextInt(2);
		
		if(roomType == 0) {
			q = new Question();
			this.question = q.generateQuestion(new Random().nextInt(3));
		}
		
		else {
			this.token = TokenCreator.createToken(new Random().nextInt(2));
		}
		
		this.door = new Door();
	}
	
	public void printInfo() { 
		if(this.roomType == 0) {
			System.out.println("This room has a question!");
			System.out.println(question);
		}
		
		else {
			System.out.println("This room has a token!");
			System.out.println(this.token.getDescription());
		}
	}
	
	
	public String toString() {
		if(this.roomType == 0) {
			return "" + 0;
		}
		
		else {
			return "" + 1;
		}
	}
	
	public Question getQ() {
		return q;
	}

	public void setQ(Question q) {
		if(q != null)
			this.q = q;
		
		else
			this.messageForTesting = "Exception Found: Null Question Object In Room Class. Cannot Set Null Object.";
			System.out.println(this.messageForTesting);
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		if(token != null)
			this.token = token;
		
		else
			this.messageForTesting = "Exception Found: Null Token Object In Room Class. Cannot Set Null Object.";
			System.out.println(this.messageForTesting);
		
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		Pattern pattern = Pattern.compile("\\d");
		String number = String.valueOf(roomType);
		
		if(pattern.matcher(number).matches())
			this.roomType = roomType;
		
		else
			this.messageForTesting = "Exception Found: Input Type Mismatch In Room Class. Cannot Set RoomType.";
			System.out.println(this.messageForTesting);
	}
	
	public String getMessageForTesting() {
		return this.messageForTesting;
	}
	
}
