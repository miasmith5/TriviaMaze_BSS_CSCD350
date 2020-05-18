import java.sql.*;
public class SQLiteJDBC {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		String dbName = "";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "CREATE TABLE QUESTIONS " +
						"(QUESTION varchar(400) NOT NULL, "
						+ "ID int)";
			String sql2 = "CREATE TABLE ANSWERS("
					+ "ANSWER varchar(100), "
					+ "QuestionID int)";
			String sql3 = "CREATE TABLE CORRECTANSWER("
					+ "QuestionID int, "
					+ "AnswerID int)";
			if(c != null){
				rs = c.getMetaData().getCatalogs();

				while(rs.next()){
					String catalogs = rs.getString(1);
					
					
					if(dbName.equals(catalogs)){
						System.out.println("the database "+dbName+" exists");
					}
				}
			
			}else {
				stmt.executeUpdate(sql);
				stmt.executeUpdate(sql2);
				stmt.executeUpdate(sql3);
			}
			String sqlQuestions = "INSERT INTO QUESTIONS (QUESTION, ID)"
					+ "VALUES "
					+ "(True or False hummingbirds cannot walk, 1),"
					+ "(What is the most known moon that orbits Saturn, 2),"
					+ "(Who is considered the first computer programmer, 3),"
					+ "(What is the largest known living organism, 4),"
					+ "(True or False Coca Cola was the first soft drink in space, 5),"
					+ "(What is the measurement of speed in a computer mouse called, 6),"
					+ "(What is the meaning to life, 7),"
					+ "(How many second until one must throw the holy hand grenade, 8),"
					+ "(What is the common phrase associated with May 4th, 9),"
					+ "(What are the 4 pillars of OO, 10),"
					+ "(What word refers to the right hand but will only ever be typed with the left, 11),"
					+ "(True or False There are 11 planets in our solar system, 12),"
					+ "(What is the fear of the number 13, 13),"
					+ "(True or False The children of identical twins are genetically siblings, not cousins, 14),"
					+ "(What is the offical bird of Redondo Beach, California, 15),"
					+ "(What year was the War of 1812, 16),"
					+ "(Who was King Henry VIIIs second wife, 17),"
					+ "(What can be blamed for most power outages in the US, 18),"
					+ "(Who owns all the swans in England, 19),"
					+ "(True or False You can only see a rainbow during the day, 20),"
					+ "(How much money were the rights for \"The Terminator\" sold for, 21),"
					+ "(Which Jamaican runner is an 11 time world champion and hold the record in the 100 and 200 meter race, 22),"
					+ "(Which hockey team did Wayne Gretzky play for in the 80s, 23),"
					+ "(True or False HTTP stands for Hippo TRex Triangle and Penguin, 24),"
					+ "(What is seen as the smallest unit of memory, 25),"
					+ "(How many bits in a byte, 26),"
					+ "(True or False Venus is the hottest planet in our solar system, 27),"
					+ "(The scientific term for \"brain freeze\", 28),"
					+ "(What letter does NOT make an appearance on the periodic table, 29),"
					+ "(True or Fasle a single strand of Spaghetti is called Spaghetto, 30)";
			
			stmt.executeUpdate(sqlQuestions);
			
			String sqlAnswers = "INSERT INTO ANSWERS(ANSWER, ID)"
					+ "Values"
					+ "(True, 1),"
					+ "(Titan, 2),"
					+ "(a John Backus, 3),"
					+ "(b John Mauchly, 4),"
					+ "(c Bill Gates, 5),"
					+ "(d Ada Lovelace, 6),"
					+ "(e none of the above, 7),"
					+ "(a Blue Whale, 8),"
					+ "(b Aspen Grove, 9),"
					+ "(c Elephant, 10)"
					+ "(True, 11),"
					+ "(Mickeys, 12),"
					+ "(42, 13),"
					+ "(a 3 I mean 5, 14),"
					+ "(b 5 I mean 3, 15),"
					+ "(a April showers bring May flowers, 16),"
					+ "(b Close only counts with horseshoes and hand grenades, 17),"
					+ "(c Life is a beach and you're here dude, 18),"
					+ "(d May the 4th be with you, 19),"
					+ "(a Abstraction Inheritance Polymorphism Encapsulation, 20),"
					+ "(b Coheasion Coupling Monlythic, 21),"
					+ "(c The cake is a lie, 22),"
					+ "(d All of the above, 23),"
					+ "(Dexter, 26),"
					+ "(False, 27),"
					+ "(a triskadekaphobia, 28),"
					+ "(b hexakosioihexekontahexaphobia, 29),"
					+ "(c trypophobia, 30),"
					+ "(d hippopotomonstrosesquippedaliophobia, 31),"
					+ "(e none of the above, 32),"
					+ "(True, 33),"
					+ "(a Hummingbird, 34),"
					+ "(b Alatros, 35),"
					+ "(c The Goodyear Blimb, 36),"
					+ "(1812, 37),"
					+ "(Anne Bolin, 38),"
					+ "(a cars, 39),"
					+ "(b snow, 40),"
					+ "(c wind, 41),"
					+ "(d squirrels, 42),"
					+ "(The Queen, 43),"
					+ "(False, 44),"
					+ "($1, 45),"
					+ "(Usain Bolt, 46),"
					+ "(a Toronto Maple Leafs, 47),"
					+ "(b Detroit Red Wings, 48),"
					+ "(c Edmonton Oilers, 49),"
					+ "(d San Jose Sharks, 50),"
					+ "(False, 51),"
					+ "(kilobytes, 52),"
					+ "(8, 53),"
					+ "(True, 54),"
					+ "(a sphenopalatine ganglioneuralgia, 55),"
					+ "(b brain freeze, 56),"
					+ "(c cerebrum rigescunt indutae, 57),"
					+ "(j, 58),"
					+ "(True, 59)";
			stmt.executeUpdate(sqlAnswers);
			System.out.println("Values added successfully into ANSWERS");
			
			String sqlCorrect = "INSERT INTO CORRECTANSWER(QuestionID, AnswerID)"
					+ "Values (1, 1)"
					+ "(2, 2)"
					+ "(3, 6)"
					+ "(4, 9)"
					+ "(5, 11)"
					+ "(6, 12)"
					+ "(7, 13)"
					+ "(8, 15)"
					+ "(9, 19)"
					+ "(10, 20)"
					+ "(11, 26)"
					+ "(12, 27)"
					+ "(13, 28)"
					+ "(14, 33)"
					+ "(15, 36)"
					+ "(16, 37)"
					+ "(17, 38)"
					+ "(18, 42)"
					+ "(19, 43)"
					+ "(20, 44)"
					+ "(21, 45)"
					+ "(22, 46)"
					+ "(23, 49)"
					+ "(24, 51)"
					+ "(25, 52)"
					+ "(26, 53)"
					+ "(27, 54)"
					+ "(28, 55)"
					+ "(29, 58)"
					+ "(30, 59)";			
			stmt.executeUpdate(sqlCorrect);
			
			System.out.println("All ID added successfully");
			
			stmt.close();
			c.close();
			
			}catch(Exception e){
			
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Table created successfully");
	}

}
