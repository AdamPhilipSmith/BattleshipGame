package battleship;

import java.util.ArrayList;

public class Game {

    ArrayList<String> shipLocations = new ArrayList<String>();

    public static void main(String[] args){

       String possibleCharacters =  "Ӿ ӿ Ө \t– — \t― • ‖ ‗ ₪ Ⅳ ⇆ ⇌ ⇼ ⇿";
       //Grid.printGrid();
       createBattleship();
    }

    public static void createBattleship(){
        //gets random starting cords for the ship for the column and row position between 0-10
        int xStartPosition = (int) (Math.random() * 10);
        int yStartPosition = (int) (Math.random() * 10);



        /*
        * Gets a random direction for the ship to be placed from Coords,
        * re-rolling until it can be placed on the board in that direction
        */

        while(true){
            //gives random number between 0-3 to correspond to cardinal directions.
            int direction = (int) (Math.random() * 4);

            //Checks to see if it's possible for the ship to be placed on the board in this direction
            if (direction == 0 && (yStartPosition-4) > 0 ){
                //place ship
            }
            if (direction == 1 && (xStartPosition+4) < 10 ){
                //place ship
            }
            if (direction == 2 && (yStartPosition+4) < 0 ){
                //place ship
            }
            if (xStartPosition-4 > 0){
                //place ship
            }
        }



    }
}
