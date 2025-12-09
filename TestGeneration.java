import binary.*;

import java.util.*;

public class TestGeneration {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String filename = scanner.nextLine();

    Generation gen = new Generation(500,5,filename);

    gen.printBestTree();
    gen.printBestFitness();

    System.out.println("\nTop Ten Fitness Values: ");
    ArrayList<GPTree> topTen = gen.getTopTen();
    for(int i = 0; i < topTen.size(); i++) {
      System.out.printf("%.2f", topTen.get(i).getFitness());
      if(i < topTen.size() - 1)
      {
        System.out.print(", ");
      }
    }

    System.out.println();
    scanner.close();
 }
} 
