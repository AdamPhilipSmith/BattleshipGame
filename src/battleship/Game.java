package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


class Game {

    private static ArrayList hits = new ArrayList();
    private static ArrayList misses = new ArrayList();
    private static ArrayList shipCoords = new ArrayList();
    private static ArrayList <Battleship> ships = new ArrayList();
    private static final char[] characters = new char[] {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static int guesses = 5;
    private static boolean moveTaken = false;
    private static boolean hit = false;
    private static boolean gameOver = false;
    private static boolean duplicateEntry = false;
    private static boolean illegalMove = false;


    static void start(){

        // spawns 1x Battleship
        //spawnShip(5);

        //spawns 2x Destroyers
        //spawnShip(4);
        spawnShip(4);

        int shipsLeft = ships.size();

        while(!gameOver) {


            //for testing
            for (Battleship ship : ships){
                System.out.println(ship.getCoords());
            }
            Grid.printGrid(hits, misses);

            if (moveTaken == true) {

                if (illegalMove == true) {
                    System.out.println("INVALID COORDINATE!");
                    System.out.println("Please enter a character between A-J followed by a number between 0-9, e.g J9");
                } else if (duplicateEntry == true) {
                    System.out.println("You have already checked this Coordinate.");
                } else if (hit == true) {
                    System.out.println("DIRECT HIT!");
                    for (Battleship ship : ships) {

                        if (!ship.killConfirmed() && ship.isDead()) {
                            System.out.println("YOU HAVE SUNK A " + ship.getType() + "!");
                            shipsLeft -= 1;
                        }
                    }
                } else {
                    System.out.println("You missed!");
                }
            }
            duplicateEntry = false;
            illegalMove = false;
            System.out.println("Guesses Left: " + guesses);
            System.out.println("Ships Left: " + shipsLeft);
            String guess = getUserInput();
            moveTaken = true;

            //Checks the users guess is a valid coordinate
            if (guess == null || guess.trim().isEmpty() || guess.length() != 2) {
                illegalMove = true;
                continue;
            }
            char c = guess.charAt(0);
            char d = guess.charAt(1);

            if (c < 'A' || c > 'J' || !Character.isDigit(d) ) {
                illegalMove = true;
                continue;
            }

            if (shipCoords.contains(guess)){

                //checks the hit is a new hit
                if (!hits.contains(guess)){
                    hits.add(guess);
                    hit = true;
                    guesses --;


                    for (Battleship ship : ships){
                            ship.removeCoord(guess);
                    }
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

            if (shipsLeft == 0){
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
    private static void spawnShip(int shipLength){

        boolean shipPlaced = false;

        while(!shipPlaced){
            ArrayList <String> tempCoords = new ArrayList();

            //gets random starting cords for the ship for the column and row position between 0-9
            int xStartPosition = (int) (Math.random() * 10);
            int yStartPosition = (int) (Math.random() * 10);

            //gets random number between 0-3 to correspond to cardinal directions.
            int direction = (int) (Math.random() * 4);

            //The following conditionals check to see if it's possible for the ship to be placed on the board for each direction
            // and without being placed on top of another ship
            if (direction == 2 && (yStartPosition-(shipLength-1)) >= 0 ){
                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition] + String.valueOf(yStartPosition-i);
                    tempCoords.add(stringCoords);
                    //checks to see if a ship is already placed at this coord. If so, clears tempcoords and breaks the loop.
                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }
                }
                shipPlaced = placeShip(tempCoords);
            }
            if (direction == 1 && (xStartPosition+(shipLength-1)) < 10 ){
                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition+i] + String.valueOf(yStartPosition);
                    tempCoords.add(stringCoords);

                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }
                }
                shipPlaced = placeShip(tempCoords);
            }
            if (direction == 0 && (yStartPosition+(shipLength-1)) < 10 ){
                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition] + String.valueOf(yStartPosition+i);
                    tempCoords.add(stringCoords);

                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }
                }
                shipPlaced = placeShip(tempCoords);
            }
            if (direction == 3 && xStartPosition-(shipLength-1) >= 0){
                for(int i=0; i<shipLength; i++){
                    String stringCoords = characters[xStartPosition-i] +String.valueOf(xStartPosition);
                    tempCoords.add(stringCoords);

                    if (shipCoords.contains(stringCoords)){
                        tempCoords.clear();
                        break;
                    }
                }
                shipPlaced = placeShip(tempCoords);
            }
        }
    }

    /**
     * Creates new ship and adding the coords to the other ship coords,
     * returning false if a ship had already been placed at that position
     * @param tempCoords
     * @return
     */
    private static boolean placeShip(ArrayList<String> tempCoords) {
        if(!tempCoords.isEmpty()){
            shipCoords.addAll(tempCoords);
            if (tempCoords.size() == 4) {
                Battleship ship = new Battleship("DESTROYER", tempCoords);
                ships.add(ship);
            }
            else{
                Battleship ship = new Battleship("BATTLESHIP", tempCoords);
                ships.add(ship);
            }
            return true;
        }
        return false;
    }

    /**
     * Gets the users input, converting all to
     * upper case.
     * @return
     */
    private static String getUserInput() {
        String inputLine = null;
        System.out.print("Enter coordinates:" + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0){
                return null;
            }
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toUpperCase();
    }
}
