package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {

    private static ArrayList<String> hits = new ArrayList();
    private static ArrayList<String> misses = new ArrayList();
    private static ArrayList<String> shipCoords = new ArrayList();
    private static final char[] characters = new char[] {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static int guesses = 50;
    private static int shipLives = 13;
    private static boolean moveTaken = false;
    private static boolean hit = false;
    private static boolean gameOver = false;
    private static boolean duplicateEntry = false;

    public static void start(){

        // spawns 1x Battleship
        spawnShip(5);

        //spawns 2x Destroyers
        spawnShip(4);
        spawnShip(4);

        while(gameOver == false) {
            Grid.printGrid(hits, misses);

            if( moveTaken == true){
                if(duplicateEntry == true){
                    System.out.println("You have already checked this Coordinate.");
                }

                else if (hit == true){
                    System.out.println("DIRECT HIT!");
                }
                else{
                    System.out.println("You missed!");
                }
            }
            duplicateEntry = false;
            System.out.println("Guesses Left: " + guesses);
            String guess = getUserInput();

            if (shipCoords.contains(guess)){

                if (!hits.contains(guess)){//checks the hit is a new hit
                    hits.add(guess);
                    hit = true;
                    shipLives --;
                    guesses --;
                }
                else{
                    duplicateEntry = true;
                }

            }
            else{
                if (!misses.contains(guess)){
                    misses.add(guess);
                    hit = false;
                    guesses --;
                }
                else{
                    duplicateEntry = true;
                }

            }

            moveTaken = true;

            if (shipLives == 0){
                //Grid.printGrid(hits, misses);//TODO test this tomorrow
                System.out.println("Congratulations, you have sunk all the ships!");
                gameOver = true;
            }

            if (guesses == 0){
                System.out.println("You failed! You ran out of guesses");
                gameOver = true;
            }



        }
    }
    /*
     * Gets a random direction for the ship to be placed from random Coords,
     * re-rolling until it can be placed on the board in that direction
     * without going off the side of the board or on top of another ship
     */
    public static void spawnShip(int shipLength){

        boolean shipPlaced = false;

        while(!shipPlaced){
            ArrayList <String> tempCoords = new ArrayList();

            //gets random starting cords for the ship for the column and row position between 0-10
            int xStartPosition = (int) (Math.random() * 10);
            int yStartPosition = (int) (Math.random() * 10);

            //gets random number between 0-3 to correspond to cardinal directions.
            int direction = (int) (Math.random() * 4);

            //Following conditionals to see if it's possible for the ship to be placed on the board for each direction
            if (direction == 0 && (yStartPosition-(shipLength-1)) >= 0 ){

                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition] + String.valueOf(yStartPosition-i);
                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords and breaks the loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }

                }
                if(!tempCoords.isEmpty()){
                    shipCoords.addAll(tempCoords);
                    shipPlaced = true;
                }

            }
            if (direction == 1 && (xStartPosition+(shipLength-1)) < 10 ){

                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition+i] + String.valueOf(yStartPosition);
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
                }

            }
            if (direction == 2 && (yStartPosition+(shipLength-1)) < 10 ){

                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition] + String.valueOf(yStartPosition+i);
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
                }
            }
            if (direction == 3 && xStartPosition-(shipLength-1) >= 0){
                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition-i] +String.valueOf(xStartPosition);
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
                }
            }
        }



    }
    //TODO handle guesses outside coords or not letter+number
    public static String getUserInput() {
        String inputLine = null;
        System.out.print("Enter coordinates:" + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        //converts to uppercase in case user uses lowercase
        return inputLine.toUpperCase();
    }
}
