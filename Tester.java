
import java.util.Scanner;
import java.io.File;

public class Tester {

	public static void main(String args[]) {
		Room[][] maze = new Room[5][5];
		Scanner s = new Scanner(System.in);
		int attempts = 3;
		
		int answer = 0;
		boolean answered = false;
		
		// initial maze printing
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[i].length; j++) {
				maze[i][j] = new Room();
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		
		int i;
		int j;
		// traversing through the maze
		for(i = 0; i < maze.length; i++) {
			for(j = 0; j < maze[i].length; j++) {
				// print if the room has a question or a token
				System.out.println("Room [" + i + "][" + j + "]" );
				maze[i][j].printInfo();
				
				// if room has a question...
				if(maze[i][j].getRoomType() == 0) {
					System.out.println("Attempts: " + attempts);
					System.out.print("Your answer:");
					answer = s.nextInt();
					answered = maze[i][j].getQ().hasBeenAnswered(answer);
					
					
					// keep waiting for the correct answer or until the user is out of attempts
					while(!answered) {
						attempts--;
						System.out.println("Wrong answer! You have " + attempts + " attempts left!");
						if(attempts == 0)
							break;
						answer = s.nextInt();
						answered = maze[i][j].getQ().hasBeenAnswered(answer);
						
					}
					
					if(attempts == 0 && !answered) {
						break;
					}
					
					if(answered) {
						System.out.println("\nCorrect answer! proceeding to the next room...");
					}
				}// end if room has a question
				
				
				// if the room has a token, (for now only adding an attempt) the token gets used (automatically for now)
				else if(maze[i][j].getRoomType() == 1){
					if(maze[i][j].getToken().getClass().getSimpleName().equals("AddAChanceToken"))
						attempts++;
					
					// other tokens
				}
				
				s.nextLine();
			}// end for j
			
			if(attempts == 0 && !answered) {
				System.out.println("You lost!");
				System.out.println("You got stuck at Room [" + i + "][" + j + "]");
				break;
			}
			
			System.out.println();
			//s.nextLine();
		}// end for i
		
		// if the user reached the end of the maze without having 0 attempts
		if(attempts > 0) {
		System.out.println("Congratulations!");
		System.out.println("You have traversed through the maze successfully!");
		}
		
	}// end main


}
