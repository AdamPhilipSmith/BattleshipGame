package battleship;

import java.util.ArrayList;

class Grid {

  /**
   * Prints a grid to console, showing the hits and misses
   * made by the player.
   *
   * @param hits   direct hits the player has achieved
   * @param misses misses the player has made
   */
  static void printGrid(ArrayList<String> hits, ArrayList<String> misses) {

    String[] columnLetters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    System.out.println(" ╔═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╦═════╗");

    for (int i = 9; i >= 0; i--) {
      System.out.print(i);
      for (int k = 0; k < 11; k++) {
        String coords = "";
        if (k < 10) {
          coords = columnLetters[k] + i;
        }
        //prints character on grid to show ship has been hit or it's a miss
        if (hits.contains(coords)) {
          System.out.print("║  Ӿ  ");
        } else if (misses.contains(coords)) {
          System.out.print("║  •  ");
        } else {
          System.out.print("║     ");
        }
      }
      if (i > 0) {
        System.out.println("\n" + " ╠═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╬═════╣ ");
      }
    }

    System.out.println("\n" + " ╚═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╩═════╝");
    System.out.println("    A     B     C     D     E     F     G     H     I     J");
    System.out.println("Ӿ = Hit \n• = Miss\n");
  }
}
