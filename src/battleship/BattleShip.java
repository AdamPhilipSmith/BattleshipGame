package battleship;


import java.util.ArrayList;

public class BattleShip {
    private ArrayList<String> coords;
    private String shipType;
    private boolean killConfirmed = false;

    public BattleShip (String shipType, ArrayList<String> coords){
        this.coords = coords;
        this.shipType = shipType;
    }

    public void removeCoord(String coord){

        this.coords.remove(coord);

    }

    public boolean isDead(){
        if (this.coords.isEmpty()){
            killConfirmed = true;
            return true;
        }
        return false;
    }

    public String getType(){

        return this.shipType;
    }

    public boolean containsCoords(String coord){
        if (this.coords.contains(coord)){
            return true;
        }
        return false;
    }

    public ArrayList <String> getCoords(){
        return this.coords;
    }

    public boolean killConfirmed(){
        return killConfirmed;
    }
}
