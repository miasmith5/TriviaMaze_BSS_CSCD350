import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CorrectAnswers {
	
	private static Statement stmt = null;
	private ResultSet resultSet = null;
	private String query = "";
	
	public CorrectAnswers() {
		//constructor
		
	}
	
	
	private void getCorrectAnswer(int questionID, int answerID) {
	
			query = "select ANSWER from ANSWERS where answerID = (select answerID from CORRECTANSWERS where questionID = " + questionID + "and answerID = " + answerID + ")";		
			
			try {
				resultSet = stmt.executeQuery(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	
private void printCorrectAnswer() {
		
		String CA = null;
		
		try {
			
			while(resultSet.next()) {
				
				CA = resultSet.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(CA);
	}
	
}
