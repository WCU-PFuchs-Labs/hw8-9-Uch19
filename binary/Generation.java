package binary;

import java.util.*;

public class Generation {
  private int depth;
  private GPTree[] population;
  private DataSet dataSet;


public Generation(int size, int maxDepth, String fileName) {
   dataSet = new DataSet(fileName);

   terminalFactory tFactory= new terminalFactory();
   operatorFactory oFactory= new operatorFactory();
   NodeFactory nFactory = new NodeFactory(oFactory, tFactory);
   Random rand = new Random();

   population = new GPTree[size];
   for(int i=0; i<size; i++) {
        population[i] = new GPTree(nFactory, maxDepth, rand);
        population[i].evalFitness(dataSet);
    }

  }

  public void evalAll() {
    for(int i=0; i<population.length; i++) {
        population[i].evalFitness(dataSet);
        Arrays.sort(population);
    }
  }

  public ArrayList<GPTree> getTopTen(){
    ArrayList<GPTree> topTen = new ArrayList<>();
    for(int i=0; i<10 && i < population.length; i++) {
        topTen.add(population[i]);
            return topTen;

    }
  }

  public void printBestFitness(){
    System.out.println("Best fitness: " + population[0].getFitness());
  }

public void printBestTree(){
    System.out.println("Best Tree: " + population[0]);
  }

public void evolve(){
    Random rand = new Random();
    GPTree[] newPopulation = new GPTree[population.length];
    for(int i=0; i<population.length; i+=2) {
        GPTree parent1 = population[rand.nextInt(population.length/2)];
        GPTree parent2 = population[rand.nextInt(population.length/2)];
        GPTree child1 = (GPTree) parent1.clone();
        GPTree child2 = (GPTree) parent2.clone();
        child1.crossover(child2, rand);
        child1.mutate(rand);
        child2.mutate(rand);
        newPopulation[i] = child1;
        newPopulation[i+1] = child2;
    }
    population = newPopulation;
    depth++;
  }
}




