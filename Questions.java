import java.util.*;
import java.sql.*;
public class Questions {
	//This class allows for the selection of questions and answers
	
	private int rand = (int) (Math.random()*100);
	private ResultSet resultSet;
	private Connection conn = null;
	private Statement statement = null;
	private String query = "";
	
	public static void main(String[] args) {
		
		
		System.out.println("Please answer all questions to the best of your ability."
				+" If you are unable to complete the room and get locked in a bonus question will open a door for you to try again.");
	}
	
	public Questions() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");
			statement = conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database not opened");
			e.printStackTrace();
		}
		
	}
	private void getQuestion() throws SQLException {
		
		while (rand <= 30 && rand >= 1) {
			query = "select QUESTION from QUESTIONS where ID = " + rand;		
		}
		resultSet = statement.executeQuery(query);
		
	}
	
	private void printQuestion() throws SQLException {
		String quest = null;
		while(resultSet.next()) {
			quest = resultSet.getString(1);
		}
		System.out.println(quest);
	}
	
	 private void getAnswers() {
		
		 while(rand > 1 && rand < 59) {
			 query = "select ANSWER from ANSWERS where ID = " + rand;
		 } 
		 try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 private void printAnswer() throws SQLException {
			String answer = null;
			while(resultSet.next()) {
				answer = resultSet.getString(1);
			}
			System.out.println(answer);
		}
	 
	private void getCorrectAnswers() throws SQLException {
		while(rand > 1 && rand < 59) {
			 query = "select QUESTIONID, ANSWERID from CORRECTANSWERS where QUESTIONID = " + rand + " and ANSWERID = " + rand;
		 } 
			resultSet = statement.executeQuery(query);
		
	}
	private void printCorrectAnswer() throws SQLException {
		String CA = null;
		while(resultSet.next()) {
			CA = resultSet.getString(1);
		}
		System.out.println(CA);
	}
	 

}
