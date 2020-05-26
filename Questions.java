import java.util.*;
import java.sql.*;
public class Questions {
	//This class allows for the selection of questions and answers
	
	private int rand = (int) (Math.random()*100);
	private ResultSet resultSet;
	private Connection conn = null;
	private static Statement stmt = null;
	private String query = "";
	
	public Questions() {
		
		//constructor
		
	}
	
	protected void getQuestion() throws SQLException {
		
		while (rand <= 30 && rand >= 1) {
			query = "select QUESTION from QUESTIONS where ID = " + rand;		
		}
		resultSet = stmt.executeQuery(query);
		
	}

	
	private void printQuestion() {
		String quest = null;
		try {
			while(resultSet.next()) {
				
				quest = resultSet.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(quest);
	}
	
	
	 

}
