// Author: Long Phan		lnp26
package Main;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int ROW = 2;
		final int COL = 2;
		boolean[][] humanShip = new boolean[ROW][COL];
		boolean[][] AIShip = new boolean[ROW][COL];
		
		Human human = new Human(declare(humanShip) );
		AI ai = new AI(declare(AIShip));
		//Initialize the ship pos
		humanShip[1][0] = true;
		humanShip[0][1] = true;
		AIShip[0][0] =  true;
		AIShip[1][0] = true;
		
		boolean flag = true;
		while(flag) {
			
			human.printGuess();
			ai.printGuess();
			
			System.out.println("Play (1=yes, 0=no): ");
			int ansPlay = scan.nextInt();
			scan.nextLine();
			switch (ansPlay) {
			case 0:
				System.out.println("Bye");
				flag = false;
				return;
			case 1:
				break;
			default:
				System.out.println("wrong command");
				continue;
			}
			human.play(ai);
			ai.play(human);
			
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
	public static boolean[][] declare(boolean[][] list){
		for(int row = 0; row <list.length; row++) {
			for(int col = 0; col < list[row].length; col++) {
				list[row][col] =false;
			}
		}
		return list;
	}
}
