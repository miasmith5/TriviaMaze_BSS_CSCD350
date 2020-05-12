import java.util.Random;
import java.util.Scanner;

public class Room {
	
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
		this.q = q;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
}
