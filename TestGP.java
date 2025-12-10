import binary.*;

import java.util.*;

public class TestGP {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String filename = scanner.nextLine();

    Generation gen = new Generation(500,5,filename);

    for(int i = 0; i < 50; i++)
      {
        System.out.println("\nGeneration" + i + ":");

      gen.printBestTree();
      gen.printBestFitness();

      gen.evolve();
        
      }
       
  }
  scanner.close();
}  
