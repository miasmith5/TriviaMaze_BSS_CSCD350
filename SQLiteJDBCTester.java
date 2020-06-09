import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBCTester {

	public static void main(String[] args) throws SQLException, IOException {
		
		SQLiteJDBC sql = SQLiteJDBC.getInstance();

		System.out.println("question: ");

		sql.getQuestion();
		//sql.printQuestion();

		System.out.println("answers: ");

		sql.getAnswers();
		//sql.printAnswer();

		System.out.println("correct answer: ");
		sql.getCorrect();
		//sql.printCorrect();
		System.out.println("end test");
		
	}
                  
	/*private static Connection getConnection() {
		Connection connect;
		try {
			Class.forName("org.sqlite.JDBC").newInstance();
		}catch (InstantiationException e1) {
            e1.printStackTrace();
		} catch (IllegalAccessException e1) {
            e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
            e1.printStackTrace();
    }
		try {
			connect = DriverManager.getConnection("dbc:sqlite:maze.db");
			System.out.println("Opened database successfully");
			return connect;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}*/

}
