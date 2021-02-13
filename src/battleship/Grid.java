package battleship;

import java.util.ArrayList;

public class Grid {

    public static void printGrid(ArrayList<String> hits, ArrayList<String> misses){

        String[] columnLetters= new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println(" ╔═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╗");

        for(int i=0; i<10; i++){
            System.out.print(i);
            for(int k =0; k<11; k++) {
                String coords = "";
                if(k<10) {
                    coords = columnLetters[k] + i;
                }
                //prints character on grid to show ship has been hit or it's a miss
                if (hits.contains(coords)){
                    System.out.print("║  Ӿ  ");
                }
                else if (misses.contains(coords)){
                    System.out.print("║  •  ");
                }
                else{
                    System.out.print("║     ");
                }
            }
            if (i<9) {
                System.out.println("\n" + " ╠═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╣ ");
            }
        }

        System.out.println("\n" + " ╚═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╝");
        System.out.println("    A     B     C     D     E     F     G     H     I     J");
    }
}
