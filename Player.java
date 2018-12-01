package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Player {
	protected String[][] playerGuess;
	protected int[][] ship;
	protected Playername playerType;

	public enum Playername {
		HUMAN, AI;
	}

	public Player(int[][] ship, Playername playerType) {
		this.playerType = playerType;
		this.ship = ship;
		playerGuess = new String[ship.length][ship[0].length];
		for (int row = 0; row < playerGuess.length; row++) {
			for (int col = 0; col < playerGuess[row].length; col++) {
				playerGuess[row][col] = " ";
			}
		}
	}

	public String getPlayerType() {
		return playerType.toString();
	}

	public String[][] getPlayerGuess() {
		return playerGuess;
	}

	public void setPlayerGuess(String[][] playerGuess) {
		this.playerGuess = playerGuess;
	}

	public void setShip(int[][] ship) {
		this.ship = ship;
	}

	public int[][] getShip() {
		return ship;
	}

	public void check(int row, int col, Player player) {
		int[][] target = player.getShip();
		if (target[row][col] == 1) {
			this.playerGuess[row][col] = "O";
			System.out.println(playerType + " Hit!");
		} else {
			this.playerGuess[row][col] = "X";
			System.out.println(playerType + " Miss");

		}
	}

	public void printGuess() {
		System.out.println(playerType);
		System.out.print(" ");
		for (int i = 0; i < ship.length; i++) {
			System.out.print(i);
		}
		System.out.println();
		for (int row = 0; row < playerGuess.length; row++) {
			System.out.print(row);
			for (int col = 0; col < playerGuess[row].length; col++) {
				System.out.print(playerGuess[row][col]);
			}
			System.out.println();
		}
		System.out.println("===========================");
	}

	public boolean win(Player player) {
		int[][] target = player.getShip();
		int numTarget = 0; // get the enemy ships number
		int hit = 0;
		for (int row = 0; row < target.length; row++) {
			for (int col = 0; col < target[row].length; col++) {
				if (target[row][col] == 1) {
					numTarget++;
				}
			}
		}

		for (int row = 0; row < playerGuess.length; row++) { // check how many was hit
			for (int col = 0; col < playerGuess[row].length; col++) {
				if (playerGuess[row][col].equals("O")) {
					hit++;
				}
			}
		}
		if (hit == numTarget) { // if hit all the target => true;
			return true;
		}
		return false;
	}

	public void save(String fileName) {
		String playerGuessFile = fileName + ".txt";
		String shipFile = fileName + "ans.txt";

		try (BufferedWriter guessFile = new BufferedWriter(new FileWriter(playerGuessFile));
				BufferedWriter shipfile = new BufferedWriter(new FileWriter(shipFile))) {
			// Write playerGuess
			for (String[] a : playerGuess) {
				for (String b : a) {
					guessFile.write(b + "\r\n");
				}
			}
			// WriteShip
			for (int[] i : ship) {
				for (int j : i) {
					shipfile.write(j + "\r\n");
				}
			}
			System.out.println("Save successfull at" + playerGuessFile + ", and " + shipFile);
		} catch (IOException e) {
			System.out.println("Error save");
		}
	}

	public void read(String fileName) {
		String playerGuessFile = fileName + ".txt";
		String shipFile = fileName + "ans.txt";
		List<String> guessFileData = new ArrayList<String>();
		List<Integer> shipFileData = new ArrayList<Integer>();
		try (Scanner scan1 = new Scanner(new BufferedReader(new FileReader(playerGuessFile)));
				Scanner scan2 = new Scanner(new BufferedReader(new FileReader(shipFile)))) {
			scan1.useDelimiter(",");
			scan2.useDelimiter(",");
			while (scan1.hasNextLine()) {										//Read from the file into a temp GuessData List
				String input = scan1.nextLine();
//				System.out.println("Adding '" +  input +"'");
				guessFileData.add(input);
			}
			
			while (scan2.hasNextLine()) {										//Read from the file into a temp ShipData List
				int z = Integer.parseInt(scan2.nextLine());
//				System.out.println("adding " + z );
				shipFileData.add(z);
			}
		int i =0;
		for(int row = 0; row < playerGuess.length; row++) {							//write file ship back into the playerGuess[][] and ship[][]		
			for(int col = 0; col <playerGuess[0].length; col++) {
				playerGuess[row][col] = guessFileData.get(i);
				ship[row][col] = shipFileData.get(i);
				i++;
			}
		}
//		for(int row = 0; row < playerGuess.length; row++) {							//write file ship back into the playerGuess[][] and ship[][]
//			for(int col = 0; col <playerGuess[0].length; col++) {
//				System.out.print(playerGuess[row][col]);
//				
//			}
//		}
//			System.out.println();
			System.out.println("Read successfull at " + playerGuessFile +", and " + shipFile);

		} catch (IOException e) {
			System.out.println("Error load");
		}
	}

}
