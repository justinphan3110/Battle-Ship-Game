package Main;
import java.util.Scanner;

public class Human extends Player {
	Scanner scan = new Scanner(System.in);
	public Human(String[][] ship) {
		super(ship, Playername.HUMAN);
	}
	
	public void play(Player player) {
		int ansRow;
		int ansCol;
		while(true) {
		System.out.println("Enter row: ");
		ansRow = scan.nextInt();
		scan.nextLine();
		try {														//Test if ansRow in the range
			String test = this.playerGuess[ansRow][0];
		}
		catch(Exception e) {
			System.out.println("Please enter row from 0 to " + (this.playerGuess.length-1) + ".");
			continue;
		}
		break;
		}
		
		while(true) {
		System.out.println("Enter column: ");
		ansCol = scan.nextInt();
		scan.nextLine();
		try {														//Test if ansRow in the range
			String test = this.playerGuess[0][ansCol];
		}
		catch(Exception e) {
			System.out.println("Please enter Col from 0 to " + (this.playerGuess[0].length-1) + ".");
			continue;
		}
		break;
		}
		this.check(ansRow, ansCol, player);	
		
	}
}
