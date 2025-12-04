package binary;

/**
 * File Name: Mult.java
/**
 * Code Template Author: David G. Cooper
 * Purpose: A binary operator for Addition
 */
 public class Mult extends Binop {
     /**
      * @param left the left value
      * @param right the right value
      * @return the result of adding
      * left to right 
      */
  
      public Mult(Node left, Node right) {
          super(left, right);
      }    
  
     public double eval(double left, double right) {
        return left * right;
    }

   
    public String toString()
    {
      return "*";  
    } 
 }  
  

  
