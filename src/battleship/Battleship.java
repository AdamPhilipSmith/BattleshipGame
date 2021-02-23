package battleship;


import java.util.ArrayList;

/**
 * Creates a battleship storing the coordinates
 * and ship type
 */
class Battleship {
    private ArrayList<String> coords;
    private String shipType;
    private boolean killConfirmed = false;

    Battleship(String shipType, ArrayList<String> coords){
        this.coords = coords;
        this.shipType = shipType;
    }

    void removeCoord(String coord){
        this.coords.remove(coord);
    }

    boolean isDead(){
        if (this.coords.isEmpty()){
            killConfirmed = true;
            return true;
        }
        return false;
    }

    String getType(){
        return this.shipType;
    }


    boolean killConfirmed(){
        return killConfirmed;
    }

    ArrayList<String> getCoords(){
        return this.coords;
    }
}
