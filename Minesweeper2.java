import java.util.Scanner;
import java.util.Random;

public class Minesweeper2 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		Scanner myScanner2 = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter dimensions: ");
			int m = myScanner.nextInt();
			int n = myScanner.nextInt();
			
			String[][] array = new String[m][n];
			
			int mineLocationX = new Random().nextInt(m);
			int mineLocationY = new Random().nextInt(n);
			
			String mine = "*";
			String safe = ".";
			
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length; j++) {
					if(i == mineLocationX && j == mineLocationY) {
						array[i][j] = mine;
						System.out.print(array[i][j]);
					}
					
					else {
						array[i][j] = safe;
						System.out.print(array[i][j]);
					}
				}
				System.out.println();
			}// end for
			
			System.out.println("Hint? y/n");
			

				for(int i = 0; i < array.length; i++) {
					for(int j = 0; j < array[i].length; j++) {
						
						if(array[i][j] == mine) {
							array[i][j] = "X";
							//
							if((i + 1) <= array.length -1 && array[i + 1][j] == safe) {
                                array[i+1][j] = "1";
                            }
                            
                            //fliped the comparison sign
                            if((i - 1) <= array.length -1 && array[i - 1][j] == safe) {
                                array[i-1][j] = "1";
                            }
                            
                            //fliped the comparison sign
                            if((j - 1) <= array.length -1 && array[i][j-1] == safe) {
                                array[i][j-1] = "1";
                            }
                            
                            if((j + 1) <= array.length -1 && array[i][j+1] == safe) {
                                array[i][j+1] = "1";
                            }
						}
					
					}
					
				}
    
                //moved the print outside
                for(int i = 0; i < array.length; i++) {
                    
                    for(int j = 0; j < array[i].length; j++) {
                        System.out.print(array[i][j]);
                    }
                     System.out.println();
                    
                }
		}// end while
	}
}
