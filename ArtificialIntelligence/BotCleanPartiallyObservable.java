package ArtificialIntelligence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BotCleanPartiallyObservable {
	static boolean wentRight = false;
	static boolean wentLeft = false;
	static void next_move(int posY, int posX, String[] board){
        //add logic here
		
		char[][] grid = new char[board.length][board.length];
		for(int i = 0 ; i < board.length;i++){
			String s = board[i];
			for(int j = 0 ; j < s.length();j++){
				grid[j][i] = s.charAt(j);
			}
		}
		System.err.println(wentRight);
		if(grid[posX][posY]=='d')
			System.out.println("CLEAN");
		else if((posY%grid.length)%2==0 && posX<grid.length-1)
			System.out.println("RIGHT");
		else if((posY%grid.length)%2==0 && posX==grid.length-1)
			System.out.println("DOWN");
		else if((posY%grid.length)%2==1 && posX>0 )
			System.out.println("LEFT");
		else if((posY%grid.length)%2==1 && posX==0)
			System.out.println("DOWN");
		//check north
		
		
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

