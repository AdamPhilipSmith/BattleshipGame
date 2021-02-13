package battleship;

import java.util.ArrayList;

public class Game {

    private ArrayList<String> shipLocations = new ArrayList<String>();
    private static final char[] characters = new char[] {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static ArrayList <String> shipCoords = new ArrayList();
    private static boolean coordsTaken = false;
    private static ArrayList <String> hits = new ArrayList();
    private static ArrayList <String> misses = new ArrayList();

    public static void main(String[] args){
       String possibleCharacters =  "Ӿ ӿ Ө \t– — \t― • ‖ ‗ ₪ Ⅳ ⇆ ⇌ ⇼ ⇿";
       //Grid.printGrid();
       spawnShip(5);
       spawnShip(4);
       spawnShip(4);
       System.out.println(shipCoords);

    }

    public static void spawnShip(int shipLength){

        boolean shipPlaced = false;

        /*
        * Gets a random direction for the ship to be placed from Coords,
        * re-rolling until it can be placed on the board in that direction
        * without going off the side of the board or on top of another ship
        */

        while(!shipPlaced){

            //gets random starting cords for the ship for the column and row position between 0-10
            int xStartPosition = (int) (Math.random() * 10);
            int yStartPosition = (int) (Math.random() * 10);
            //gives random number between 0-3 to correspond to cardinal directions.
            int direction = (int) (Math.random() * 4);

            ArrayList <String> tempCoords = new ArrayList();
            //Checks to see if it's possible for the ship to be placed on the board in this direction
            if (direction == 0 && (yStartPosition-(shipLength-1)) >= 0 ){

                for(int i=0; i<shipLength; i++){
                    coordsTaken=false;
                    String stringCoords = String.valueOf(characters[xStartPosition]);
                    stringCoords += String.valueOf(yStartPosition-i);

                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords it and breaks loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }


                }
                if(!tempCoords.isEmpty()){
                    shipCoords.addAll(tempCoords);
                    shipPlaced = true;
                    System.out.println("n" + direction);
                }

            }
            if (direction == 1 && (xStartPosition+(shipLength-1)) < 10 ){

                for(int i=0; i<shipLength; i++){
                    coordsTaken=false;
                    String stringCoords = String.valueOf(characters[xStartPosition+i]);
                    stringCoords += String.valueOf(yStartPosition);

                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords it and breaks loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }


                }
                if(!tempCoords.isEmpty()){
                    shipCoords.addAll(tempCoords);
                    shipPlaced = true;
                    System.out.println("e" + direction);
                }

            }
            if (direction == 2 && (yStartPosition+(shipLength-1)) < 10 ){

                for(int i=0; i<shipLength; i++){
                    coordsTaken=false;
                    String stringCoords = String.valueOf(characters[xStartPosition]);
                    stringCoords += String.valueOf(yStartPosition+i);

                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords it and breaks loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }


                }
                if(!tempCoords.isEmpty()){
                    shipCoords.addAll(tempCoords);
                    shipPlaced = true;
                    System.out.println("s" + direction);
                }
            }
            if (direction == 3 && xStartPosition-(shipLength-1) >= 0){
                for(int i=0; i<shipLength; i++){
                    coordsTaken=false;
                    String stringCoords = String.valueOf(characters[xStartPosition-i]);
                    stringCoords += String.valueOf(xStartPosition);

                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords it and breaks loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }


                }
                if(!tempCoords.isEmpty()){
                    shipCoords.addAll(tempCoords);
                    shipPlaced = true;
                    System.out.println("w" + direction);
                }
            }
        }



    }


}
