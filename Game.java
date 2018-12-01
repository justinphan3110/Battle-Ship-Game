// Author: Long Phan		lnp26
package Main;
import java.util.Scanner;

import Main.Player.Playername;
public class Game {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int ROW = 5;
		final int COL = 5;
		int[][] humanShip = new int[ROW][COL];
		int[][] AIShip = new int[ROW][COL];
		
		Human human = new Human(declareShip(humanShip) );
		AI ai = new AI(declareShip(AIShip));
		//Initialize the ship pos
		humanShip[1][0] = 1;
		humanShip[0][1] = 1;
		AIShip[0][0] =  1;
		AIShip[1][0] = 1;
		
		boolean flag = true;
		while(flag) {
			
			human.printGuess();
			ai.printGuess();
			
			System.out.println("Play (3= load, 2= save,1=yes, 0=no): ");
			int ansPlay = scan.nextInt();
			scan.nextLine();
			switch (ansPlay) {
			case 0:
				System.out.println("Bye");
				flag = false;
				return;
			case 1:
				human.play(ai);
				ai.play(human);
				break;
			case 2:
				human.save(human.getPlayerType());			//The file name is the type of Enum
				ai.save(ai.getPlayerType());
				continue;
			case 3:
				human.read(human.getPlayerType());			//The file name is the type of Enum
				ai.read(ai.getPlayerType());
				continue;
			default:
				System.out.println("wrong command");
				continue;
			}
			
			
			if(human.win(ai) == true) {
				System.out.println("===========================");
				human.printGuess();
				ai.printGuess();
				System.out.println(human.playerType + " win!");
				break;
			}
			if(ai.win(human) == true) {
				System.out.println("===========================");
				human.printGuess();
				ai.printGuess();
				System.out.println(ai.playerType + " win!");
				break;
			}
			System.out.println("===========================");
		}
}
	public static int[][] declareShip(int[][] list){
		for(int row = 0; row <list.length; row++) {
			for(int col = 0; col < list[row].length; col++) {
				list[row][col] = -1;
			}
		}
		return list;
	}
}
