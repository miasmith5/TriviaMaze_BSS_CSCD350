import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	private static Connection c = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static void main(String[] args) {

		String dbName = "";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			createTables(); // check if the database exists first. if not then create it
			addQuestions();
			addAnswers();
			addCorrectAnswers();

			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Table created successfully");
	}

	// This method will create the tables
	private static void createTables() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS QUESTIONS " + "(QUESTION varchar(400) NOT NULL, " + "ID int)";
			String sql2 = "CREATE TABLE IF NOT EXISTS ANSWERS(" + "ANSWER varchar(100), " + "questionID int)";
			String sql3 = "CREATE TABLE IF NOT EXISTS CORRECTANSWER(" + "QuestionID int, " + "AnswerID int)";

			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// This method will add the questions into the correct table
	private static void addQuestions() {
		try {

			String sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('True or False hummingbirds cannot walk', 1)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the most known moon that orbits Saturn', 2)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('Who is considered the first computer programmer', 3)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the largest known living organism', 4)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('True or False Coca Cola was the first soft drink in space', 5)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the measurement of speed in a computer mouse called', 6)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the meaning to life', 7)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('How many second until one must throw the holy hand grenade', 8)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the common phrase associated with May 4th', 9)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What are the 4 pillars of OO', 10)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What word refers to the right hand but will only ever be typed with the left', 11)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('True or False There are 11 planets in our solar system', 12)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the fear of the number 13', 13)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('True or False The children of identical twins are genetically siblings, not cousins', 14)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What is the offical bird of Redondo Beach, California', 15)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('What year was the War of 1812', 16)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('Who was King Henry VIIIs second wife', 17)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('What can be blamed for most power outages in the US', 18)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('Who owns all the swans in England', 19)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('True or False You can only see a rainbow during the day', 20)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('How much money were the rights for The Terminator sold for', 21)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('Which Jamaican runner is an 11 time world champion and hold the record in the 100 and 200 meter race', 22)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('Which hockey team did Wayne Gretzky play for in the 80s', 23)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('True or False HTTP stands for Hippo TRex Triangle and Penguin', 24)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('What is seen as the smallest unit of memory', 25)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES " + "('How many bits in a byte', 26)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('True or False Venus is the hottest planet in our solar system', 27)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('The scientific term for \"brain freeze\"', 28)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('What letter does NOT make an appearance on the periodic table', 29)";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)" + "VALUES "
					+ "('True or Fasle a single strand of Spaghetti is called Spaghetto', 30)";
			stmt.executeUpdate(sqlQuestions);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Values added successfully into QUESTIONS");
	} // end addQuestions

	// This method will add ALL the available answers into the correct table
	private static void addAnswers() {
		try {

			String sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('True', 1)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('Titan', 2)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a John Backus', 3)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b John Mauchly', 4)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c Bill Gates', 5)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d Ada Lovelace', 6)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('e none of the above', 7)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a Blue Whale', 8)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b Aspen Grove', 9)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c Elephant', 10)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('True', 11)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('Mickeys', 12)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('42', 13)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a 3 I mean 5', 14)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b 5 I mean 3', 15)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a April showers bring May flowers', 16)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b Close only counts with horseshoes and hand grenades', 17)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c Life is a beach and you are here dude', 18)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d May the 4th be with you', 19)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a Abstraction Inheritance Polymorphism Encapsulation', 20)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b Coheasion Coupling Monlythic', 21)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c The cake is a lie', 22)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d All of the above', 23)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('Dexter', 26)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('False', 27)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a triskadekaphobia', 28)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b hexakosioihexekontahexaphobia', 29)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c trypophobia', 30)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d hippopotomonstrosesquippedaliophobia', 31)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('e none of the above', 32)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('True', 33)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a Hummingbird', 34)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b Alatros', 35)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c The Goodyear Blimb', 36)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('1812', 37)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('Anne Bolin', 38)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a cars', 39)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b snow', 40)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c wind', 41)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d squirrels', 42)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('The Queen', 43)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('False', 44)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('$1', 45)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('Usain Bolt', 46)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a Toronto Maple Leafs', 47)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b Detroit Red Wings', 48)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c Edmonton Oilers', 49)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('d San Jose Sharks', 50)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('False', 51)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('kilobytes', 52)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('8', 53)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('True', 54)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('a sphenopalatine ganglioneuralgia', 55)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('b brain freeze', 56)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('c cerebrum rigescunt indutae', 57)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('j', 58)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID)" + "Values" + "('True', 59)";
			stmt.executeUpdate(sqlAnswers);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Values added successfully into ANSWERS");
	}

	// This method will link the correct answer with the corresponding question
	private static void addCorrectAnswers() {
		try {

			String sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + "Values (1, 1)";
			stmt.executeUpdate(sqlCorrect);
			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (2, 2)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (3, 6)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (4, 9)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (5, 11)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (6, 12)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (7, 13)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (8, 15)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (9, 19)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (10, 20)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (11, 26)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (12, 27)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (13, 28)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (14, 33)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (15, 36)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (16, 37)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (17, 38)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (18, 42)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (19, 43)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (20, 44)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (21, 45)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (22, 46)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (23, 49)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (24, 51)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (25, 52)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (26, 53)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (27, 54)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (28, 55)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (29, 58)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (30, 59)";
			stmt.executeUpdate(sqlCorrect);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("All ID added successfully into CORRECTANSWER");
	}
}
