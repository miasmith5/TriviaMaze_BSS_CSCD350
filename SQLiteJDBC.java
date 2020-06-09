import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLiteJDBC {
	private  Connection conn = null;
	private  Statement stmt = null;

	private  Scanner kb = new Scanner(System.in);	

	private int rand = (int) (Math.random()*31);
	private static final SQLiteJDBC sql = new SQLiteJDBC();
	
	private SQLiteJDBC() {
		String dbName = "";
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:maze.db");
			
			
			stmt = conn.createStatement();

			createTables();
			addQuestions();
			addAnswers();
			addCorrectAnswers();

			stmt.close();
			//c.close();

		} catch (Exception e) {

			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Table created successfully");
	}
	// This method will create the tables
	private void createTables() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS QUESTIONS " + "(QUESTION varchar(400) NOT NULL, " + "ID int, " + "QTYPE varchar(2))";
			String sql2 = "CREATE TABLE IF NOT EXISTS ANSWERS(" + "ANSWER varchar(100), " + "questionID int, answerID int)";
			String sql3 = "CREATE TABLE IF NOT EXISTS CORRECTANSWER(" + "QuestionID int, " + "AnswerID int)";

			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// This method will add the questions into the correct table
	private void addQuestions() {
		try {

			String sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False hummingbirds cannot walk', 1 , 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the most known moon that orbits Saturn', 2, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('Who is considered the first computer programmer', 3, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the largest known living organism', 4, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False Coca Cola was the first soft drink in space', 5, 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the measurement of speed in a computer mouse called', 6, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the meaning to life', 7, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('How many second until one must throw the holy hand grenade', 8, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the common phrase associated with May 4th', 9, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What are the 4 pillars of OO', 10, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What word refers to the right hand but will only ever be typed with the left', 11, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False There are 11 planets in our solar system', 12, 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the fear of the number 13', 13, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False The children of identical twins are genetically siblings, not cousins', 14, 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is the offical bird of Redondo Beach, California', 15, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What year was the War of 1812', 16, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('Who was King Henry VIIIs second wife', 17, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What can be blamed for most power outages in the US', 18, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('Who owns all the swans in England', 19, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False You can only see a rainbow during the day', 20, 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('How much money were the rights for The Terminator sold for', 21, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('Which Jamaican runner is an 11 time world champion and hold the record in the 100 and 200 meter race', 22, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('Which hockey team did Wayne Gretzky play for in the 80s', 23, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False HTTP stands for Hippo TRex Triangle and Penguin', 24, 'TF')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What is seen as the smallest unit of memory', 25, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('How many bits in a byte', 26, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or False Venus is the hottest planet in our solar system', 27, 'TA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('The scientific term for \"brain freeze\"', 28, 'MC')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('What letter does NOT make an appearance on the periodic table', 29, 'UA')";
			stmt.executeUpdate(sqlQuestions);

			sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID, QTYPE)" + "VALUES " + "('True or Fasle a single strand of Spaghetti is called Spaghetto', 30, 'TF')";
			stmt.executeUpdate(sqlQuestions);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Values added successfully into QUESTIONS");
	} // end addQuestions

	// This method will add ALL the available answers into the correct table
	private void addAnswers() {
		try {

			String sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 1, 1)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('Titan', 2, 2)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a John Backus', 3, 3)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b John Mauchly', 3, 4)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c Bill Gates', 3, 5)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d Ada Lovelace', 3, 6)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('e none of the above', 3, 7)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a Blue Whale', 4, 8)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b Aspen Grove', 4, 9)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c Elephant', 4, 10)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 5, 11)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 5, 12)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('Mickeys', 6, 13)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('42', 7, 14)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a 3 I mean 5', 8, 15)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b 5 I mean 3', 8, 16)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a April showers bring May flowers', 9, 17)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b Close only counts with horseshoes and hand grenades', 9, 18)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c Life is a beach and you are here dude', 9, 19)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d May the 4th be with you', 9, 20)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a Abstraction Inheritance Polymorphism Encapsulation', 10, 21)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b Coheasion Coupling Monlythic', 10, 22)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c The cake is a lie', 10, 23)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d All of the above', 10, 24)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('Dexter', 11, 25)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 12, 26)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 12, 27)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a triskadekaphobia', 13, 28)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b hexakosioihexekontahexaphobia', 13, 29)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c trypophobia', 13, 30)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d hippopotomonstrosesquippedaliophobia', 13, 31)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('e none of the above', 13, 32)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 14, 33)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 14, 34)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a Hummingbird', 15, 35)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b Alatros', 15, 36)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c The Goodyear Blimb', 15, 37)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('1812', 16, 38)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('Anne Bolin', 17, 39)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a cars', 18, 40)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b snow', 18, 41)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c wind', 18, 42)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d squirrels', 18, 43)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('The Queen', 19, 44)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 20, 45)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 20, 46)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('$1', 21, 47)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('Usain Bolt', 22, 48)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a Toronto Maple Leafs', 23, 49)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b Detroit Red Wings', 23, 50)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c Edmonton Oilers', 23, 51)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('d San Jose Sharks', 23, 52)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 24, 53)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 24, 54)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('kilobytes', 25, 55)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('8', 26, 56)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 27, 57)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 27, 58)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('a sphenopalatine ganglioneuralgia', 28, 59)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('b brain freeze', 28, 60)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('c cerebrum rigescunt indutae', 28, 61)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('j', 29, 62)";
			stmt.executeUpdate(sqlAnswers);

			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('True', 30, 63)";
			stmt.executeUpdate(sqlAnswers);
			
			sqlAnswers = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "Values" + "('False', 30, 64)";
			stmt.executeUpdate(sqlAnswers);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Values added successfully into ANSWERS");
	}

	// This method will link the correct answer with the corresponding question
	private void addCorrectAnswers() {
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

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (6, 13)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (7, 14)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (8, 16)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (9, 20)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (10, 21)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (11, 25)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (12, 27)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (13, 28)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (14, 33)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (15, 36)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (16, 38)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (17, 39)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (18, 43)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (19, 44)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (20, 46)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (21, 47)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (22, 48)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (23, 51)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (24, 54)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (25, 55)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (26, 56)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (27, 57)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (28, 59)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (29, 62)";
			stmt.executeUpdate(sqlCorrect);

			sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + " Values (30, 63)";
			stmt.executeUpdate(sqlCorrect);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("All ID added successfully into CORRECTANSWER");
	}

	// This method allows the user to add their own questions
	protected void addNewQuestion() {
		
		int count= 30; 
		String question;
		System.out.println("Please note that the numbers 1-"+ count + " are taken for table QUESTIONS");
		System.out.println("Enter the new question: ");
		question = kb.nextLine();
		System.out.println("Enter the question type: ");
		System.out.println("Multiple Choice: MC | User Answer: UA | True or False: TF");
		String qtype = kb.nextLine();
		
		try {
			
			String addNew = "INSERT INTO QUESTIONS(QUESTION, ID, QTYPE)" + "VALES (" + question+ "," + (count + 1) + qtype + ")";
			stmt.executeUpdate(addNew);
			count++;
			System.out.println("Your question has been added to QUESTIONS");
		}catch(SQLException e) {
			
			System.out.println("Question not added to table.");
			e.printStackTrace();
		}
	}
	
	// This method allows for user to add answers for their question
	protected void addNewAnswers() {
		int count = 63;
		String answers;
		System.out.println("Please note the answers have 3 input parameters and numbers 1 -" + count + " are taken for ANSWERS");
		
		System.out.println("Enter the question number: ");
		int questionID = kb.nextInt();
		
		System.out.println("Enter the new answer(s): ");
		answers = kb.nextLine();
		
		try {
			String addNewA = "INSERT INTO ANSWERS(ANSWER, questionID, answerID)" + "VALUES("+ answers + ", " + questionID + ", " + (count+1) +")";
			stmt.executeUpdate(addNewA);
			count++;
			System.out.println("Answers have been added to table ANSWERS");
		}catch(SQLException e){
			
			System.out.println("Answers not added to table.");
			e.printStackTrace();
		}
		
	}
	
	// This method allows for user to link the correct answer with the question
	protected void addNewCorrect() {
		
		System.out.println("Please note the order of questionID and answerID are in specific order. Enter in values EXACTLY as shown:"
				+ "CORRECTANSWERS(QuestionID, AnswerID)");
		System.out.println("Enter the questionID: ");
		int qID = kb.nextInt();
		
		System.out.println("Enter the answerID: ");
		int aID = kb.nextInt();
		
		try {
			
			String addNewCA = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)" + "VALUES(" + qID + ", " + aID +")";
			stmt.executeQuery(addNewCA);
			System.out.println("Correct answer has been added.");
			
		}catch(SQLException e) {
			
			System.out.println("Correct answers not added to table");
			e.printStackTrace();	
		}
		
		
	}

	protected void getQuestion() {
		
		try {
			Statement stmt1 = conn.createStatement();
			
			
			String query = "select QUESTION , TYPE from QUESTIONS where ID = " + rand + ";";
			
			ResultSet resultSet = stmt1.executeQuery(query);
			
			
			if(resultSet != null) {
				String question = "";
				String type = "";
				while(resultSet.next()) {
				
					question = resultSet.getString(1);
					type = resultSet.getString(2);
					System.out.println(question + "?");
					System.out.println(type);
			
				}
			
				stmt1.close();
				resultSet.close();
			
	
			//	return rand; // need the random number
			}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
	//	return 1;
	}
	
	protected void getAnswers() { 
		try {
			Statement stmt2 = conn.createStatement();
			
//gets the question number that is returned by the question method
			int questionID = rand;
			
			String query = "select ANSWER from ANSWERS where questionID = " + questionID;		
			
			
			ResultSet resultSet = stmt2.executeQuery(query);
			while(resultSet.next()) {
				
				String answer = resultSet.getString(1);
				System.out.println(answer);
			}
		stmt2.close();
		resultSet.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}

	protected void getCorrect() {
		
		int questionID = rand;
		
		String query = "select ANSWER from ANSWERS where answerID = (select answerID from CORRECTANSWER where questionID = " + questionID + ")";		
		
		try {
			Statement stmt3 = conn.createStatement();
			ResultSet resultSet = stmt3.executeQuery(query);
			while(resultSet.next()) {
				
				String CA = resultSet.getString(1);
				System.out.println(CA);
			}
			stmt3.close();
			resultSet.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}

// This method should only allow one database to exist
	public static SQLiteJDBC getInstance() {
		return sql;
	}
}
