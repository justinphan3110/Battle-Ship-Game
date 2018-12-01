package Main;
public class AI extends Player {
	private boolean[][] target;					//2d Array of the point the AI shot
	
	public AI(int[][] ship) {
		super(ship, Playername.AI);
		target = new boolean[getShip().length][getShip()[0].length];
		for(int row = 0; row < target.length; row++) {
			for(int col =0; col < target[row].length; col++) {
				target[row][col] = false;		//initialize all point as false ( will be true if shoot at this point)
			}
		}
	}
	
	
	public void play(Player player) {
		int AIRow = this.getShip().length;
		int AICol = this.getShip()[0].length;
		
		
		boolean flag = true;
		
		while(flag) {
		int ansRow = (int)	(Math.random()*(AIRow));
		int ansCol = (int) 	(Math.random()*(AICol));		
		if(target[ansRow][ansCol] == true) {		//Only shoot the false target
			continue;	
		}
		
		System.out.println("AI row: " + ansRow);
		System.out.println("AI col: " + ansCol);
		this.check(ansRow, ansCol, player);
		target[ansRow][ansCol] = true;				//Target is change to true if has been shot
		flag = false;	
		}
	}

}

