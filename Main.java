// Author: Long Phan		lnp26
package Main;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int ROW = 3;
		final int COL = 3;
		String[][] humanShip = new String[ROW][COL];
		String[][] AIShip = new String[ROW][COL];
		
		for(int row = 0; row <humanShip.length; row++) {
			for(int col = 0; col < humanShip[row].length; col++) {
				humanShip[row][col] =" ";
				AIShip[row][col] = " ";
			}
		}
		
		//Initialize the ship pos
		humanShip[1][0] = "a";
		humanShip[0][1] = "a";
		AIShip[0][0] = "b" ;
		AIShip[1][0] = "b" ;
		Human human = new Human(humanShip );
		AI ai = new AI(AIShip);
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
}
