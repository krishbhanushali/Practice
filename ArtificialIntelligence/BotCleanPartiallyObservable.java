package ArtificialIntelligence;

import java.util.Random;
import java.util.Scanner;

public class BotCleanPartiallyObservable {
	static void next_move(int posY, int posX, String[] board){
        //add logic here
		char[][] grid = new char[board.length][board.length];
		for(int i = 0 ; i < board.length;i++){
			String s = board[i];
			for(int j = 0 ; j < s.length();j++){
				grid[j][i] = s.charAt(j);
			}
		}
		System.out.println(grid.length);
		if(grid[posX][posY]=='d')
			System.out.println("CLEAN");
		//check north
		else if(posY-1>=0 && grid[posX][posY-1]=='d') System.out.println("UP");
		//check northEast
		else if(posY-1>=0 && posX+1<=grid.length-1 && grid[posX+1][posY-1]=='d') System.out.println("UP");
		//check east
		else if(posX+1<=grid.length-1 && posY-1>=0 && grid[posX+1][posY-1]=='d') System.out.println("RIGHT");
		//check southeast
		else if(posY+1<=grid.length-1 && posX+1<=grid.length-1 && grid[posX+1][posY+1]=='d') System.out.println("RIGHT");
		//check south
		else if(posY+1<=grid.length-1 && grid[posX][posY+1]=='d') System.out.println("DOWN");
		//check southWest
		else if(posY+1<=grid.length-1 && posX-1>=0 && grid[posX-1][posY+1]=='d') System.out.println("DOWN");
		//check west
		else if(posX-1>=0 && grid[posX-1][posY]=='d') System.out.println("LEFT");
		//check northwest
		else if(posY-1>=0 && posX-1>=0 && grid[posX-1][posY-1]=='d') System.out.println("LEFT");
		else{
			String[] openPositions = getOpenPositions(grid,posX,posY);
			int count = 0;
			for(String str:openPositions){
				if(str!=null) count++;
			}
			Random rand = new Random();
			int n = rand.nextInt(count);
			System.out.println(openPositions[n]);
		}
		
    }
	private static String[] getOpenPositions(char[][] grid, int posX, int posY) {
		// TODO Auto-generated method stub
		String[] openPositions = new String[4];
		int i = 0;
		if(posY-1>=0 && grid[posX][posY-1]=='-'){
			openPositions[i] = "UP";
			i++;
		}
		if(posX+1<=grid.length-1 && grid[posX+1][posY]=='-'){
			openPositions[i] = "RIGHT";
			i++;
		}
		if(posY+1<=grid.length-1 && grid[posX][posY+1]=='-'){
			openPositions[i] = "DOWN";
			i++;
		}
		if(posX-1>=0 && grid[posX-1][posY]=='-'){
			openPositions[i] = "LEFT";
			i++;
		}
		return openPositions;
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}

