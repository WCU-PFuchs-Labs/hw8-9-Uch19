package binary;


/**
 * Code Template Author: David G. Cooper
 * Purpose: A base class for binary arithmetic operations
 */
public abstract class Binop extends Op {
     
     protected Node left;
     protected Node right;

     public Binop(Node left, Node right) {
         this.left = left;
         this.right = right;
     }
     
     
     public abstract double eval(double left, double right);
}
