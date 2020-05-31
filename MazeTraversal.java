package TriviaMaze_BSS_CSCD350;
import java.util.Scanner;
import java.util.Random;

public class MazeTraversal {
	public static void main(String[] args) {		
		Scanner s = new Scanner(System.in);
		while(true) {
			try {
				
				int[][] array = new int[10][10];
				array = initilize(array);
				
				generateMines(array, new Random().nextInt(10) + 3);
				
				printArray(array);
				System.out.println();
				
				
				System.out.println("Welcome! this maze is randomly generated, try to escape\n"
						+ "it before time runs out or you will die. You will\nstart at"
						+ "position 0, 0. Enter the\ndimensions of adjacent cells"
						+ " to visit them.\nGood luck!");
				
				System.out.println();
				
				while(array[array.length - 1][array.length - 1] != 7) {
					System.out.println("Enter the dimensions: ");
					String dimensions =  s.nextLine();
					
					String[] dims = dimensions.split(" ");
					
					//System.out.println(validPosition(array, Integer.parseInt(dims[0]), Integer.parseInt(dims[1])));
					
					if(validPosition(array, Integer.parseInt(dims[0]), Integer.parseInt(dims[1]))) {
						array[Integer.parseInt(dims[0])][Integer.parseInt(dims[1])] = 7;
						swap(array, Integer.parseInt(dims[0]), Integer.parseInt(dims[1]));
						printArray(array);
					}
					
					else {
						System.out.println("Invalid position!");
					}
				}
				break;
			}
			
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			break;
		}
		
		System.out.println("Congratulations! you have successfully traversed the maze!");
	}
	
	private static int[][] initilize(int[][] array){
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = 1;
			}
		}
		array[0][0] = 7;
		array[array.length-1][array.length -1] = 1;
		return array;
	}
	
	private static void generateMines(int[][] array, int numMines) {
		while(numMines > 0) {
			int x = new Random().nextInt(8) + 1;
			int y = new Random().nextInt(8) + 1;
			
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length; j++) {
					if(i == x && j == y) {
						array[i][j] = 0;
					}
				}
			}
			numMines--;
			
		}
	}
	
	private static void printArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean validPosition(int[][] array, int x, int y) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				
				if(array[i][j] == 7) {
				if(x - i == 1 && y - j == 1) {
					return false;
				}
				
				else if(x - i <= 1 && y == j && array[x][y] != 0) {
					return true;
				}
						
				else if(x == i && y - j <= 1 && array[x][y] != 0) {
					return true;
				}
				
				}
				
			}
		}
		return false;
	}
	
	private static void swap(int[][] array, int x, int y) {
		for(int i = 0; i < array.length; i ++) {
			for(int j = 0; j < array.length; j++) {
				if(array[i][j] == 7) {
					array[i][j] = 1;
					array[x][y] = 7;
				}
			}
		}
	}
}