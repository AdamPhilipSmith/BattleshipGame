package battleship;

public class Grid {

    public static void printGrid(){
        System.out.println("╔════╦════╦════╦════╦════╦════╦════╦════╦════╦════╗");

        for(int i=0; i<10; i++){
            System.out.println("║    ║    ║    ║    ║    ║    ║    ║    ║    ║    ║ ");
            System.out.println("╠════╬════╬════╬════╬════╬════╬════╬════╬════╬════╣ ");
        }
        System.out.println("║    ║    ║    ║    ║    ║    ║    ║    ║    ║    ║ ");
        System.out.println("╚════╩════╩════╩════╩════╩════╩════╩════╩════╩════╝");
    }
}
