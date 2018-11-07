package Main;
public abstract class Player {
  protected String[][] playerGuess;
  protected String[][] ship;
  protected Playername playerType;
  public enum Playername{
	  	HUMAN,
	  	AI
  }
  public Player(String[][] ship, Playername playerType) {
	  this.playerType = playerType;
	  this.ship = ship;
	  playerGuess = new String[ship.length][ship[0].length];
	  for(int row = 0; row<playerGuess.length; row++) {
		  for(int col = 0; col < playerGuess[row].length; col++) {
			  playerGuess[row][col] = " ";
		  }
	  }
  }
  

public String[][] getPlayerGuess() {
	return playerGuess;
}

public void setPlayerGuess(String[][] playerGuess) {
	this.playerGuess = playerGuess;
}

public void setShip(String[][] ship) {
	this.ship = ship;
}

public String[][] getShip() {
	  return ship;
  }

public void check(int row, int col, Player player) {
	  String[][] target = player.getShip();
	  if(!target[row][col].equals(" ")) {
		  this.playerGuess[row][col] = "O";
		  System.out.println(playerType + " Hit!");
	  }
	  else {
		  this.playerGuess[row][col] = "X";
		  System.out.println(playerType + " Miss");
		  
	  }
  }
  
public void printGuess() {
	System.out.println(playerType);
	System.out.print(" ");
	for(int i = 0; i < ship.length; i++) {
		System.out.print(i);
	}
	System.out.println();
	for(int row = 0; row < playerGuess.length; row++){
		System.out.print(row);
		for(int col =0; col < playerGuess[row].length; col++) {
			System.out.print(playerGuess[row][col]);
			}
		System.out.println();
}
System.out.println("===========================");
}
	


public boolean win(Player player) {
	String[][] target = player.getShip();
	int numTarget = 0;															//get the enemy ships number
	int hit = 0;
	for(int row = 0; row < target.length; row++) {
		for(int col = 0; col < target[row].length; col++) {
			if(!target[row][col].equals(" ")) {
				numTarget++;
			}
		}
	}
	
	for(int row = 0; row < playerGuess.length; row++) {							// check how many was hit
		for(int col = 0; col < playerGuess[row].length; col++) {
			if(playerGuess[row][col].equals("O")) {
				hit++;
			}
		}
	}
	if(hit == numTarget) {														// if hit all the target => true;
		return true;
	}
	return false;
}	
}
  
