# BattleShipGame
Stimulate the battleship game between human and computer(random coordinate) in java

You can run the Game on cmd by typing java -jar link-to-jar\BatteShipFinal.jar 
When run the file, you should see

![image](https://user-images.githubusercontent.com/44376091/49333417-7b708b80-f58c-11e8-913f-b40e856429e1.png)


You will have 3 option: 3. will load the the file of your own game which has been saved by 2.

![image](https://user-images.githubusercontent.com/44376091/49333423-9c38e100-f58c-11e8-8c28-560f01f2121c.png)


The code for the Loading (I used BufferedWriter and BufferedReader to make the load/save process more efficient): 

![image](https://user-images.githubusercontent.com/44376091/49333429-b4106500-f58c-11e8-968e-55c00ade048a.png)

The code for the save


![image](https://user-images.githubusercontent.com/44376091/49333438-d1453380-f58c-11e8-9259-27559e3ef6bc.png)


### Setting Up:
  1.you will initialize the final ROW and COL of the game play
  2. you will intialize the coordinate of the 2 side ship (can put it random using Math.random()):
  
  
  
  ![image](https://user-images.githubusercontent.com/44376091/49333440-eb7f1180-f58c-11e8-9627-9f281d76ef76.png)


  the check method in Player.java to check if who win
  
  ![image](https://user-images.githubusercontent.com/44376091/49333456-24b78180-f58d-11e8-91fd-144847df744e.png)
