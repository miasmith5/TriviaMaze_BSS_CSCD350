import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Answers {
	private static Statement stmt = null;
	private ResultSet resultSet = null;
	private String query = "";
	
	
	public Answers() {
		//constructor
		
	}
	
	private void getAnswers(int answerID) {
		
		query = "select ANSWER from ANSWERS where answerID = " + answerID;		
		
		try {
			resultSet = stmt.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	 private void printAnswer() {
			String answer = null;
			try {
				while(resultSet.next()) {
				
					answer = resultSet.getString(1);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			System.out.println(answer);
		}

}
