import binary.*;

import java.util.*;

public class TestGeneration {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String filename = scanner.nextLine();

    Generation gen = new Generation(500,5,filename);

    gen.printBesTree();
    gen.printBestFitness();

    System.out.println("\nTop Ten Fitness Values;");
    for(GPTree tree : gen.getTopTen()) {
      System.out.println(tree.getFitness());
    }
    scanner.close();
 }
} 

