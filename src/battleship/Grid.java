package battleship;

public class Grid {

    public static void printGrid(){

        String[] rowLetters= new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println(" ╔═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╗");

        for(int i=0; i<10; i++){
            System.out.print(i);
            for(int k =0; k<11; k++) {
                //prints character to show ship has been hit
                if (rowLetters[i].contains("A") && k == 3){
                    System.out.print("║  Ӿ  ");
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
