package binary;


import java.util.*;
/**
 * Code Template Author: David G. Cooper
 * Purpose: A Binary Tree class for Arithmetic evaluation
 */
public class Node implements Cloneable  {
    protected Node left;
    protected Node right;
    private Op operation;
    protected int depth;

    public Node(Op operation) {
        this.operation = operation;
    }

    public Node(Binop operation,Node left, Node right) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }
    public double eval(double[] values) {
        if (operation instanceof Unop) {
              return ((Unop)operation).eval(values);
        } else if (operation instanceof Binop) {
              return ((Binop)operation).eval(left.eval(values),right.eval(values));
        } else {
              System.err.println("Error operation is not a Unop or a Binop!");
              return 0.0;
        }
    }

    public Object clone() {
    Object o = null;
    try {
        o =  super.clone();
    }
    catch(CloneNotSupportedException e) {
        System.out.println("Op can't clone.");
    }
    Node b = (Node) o;
    if(left != null) {
        b.left = (Node) left.clone();
    }
    if(right != null) {
       b.right = (Node) right.clone();
    }
    if(operation != null) {
       b.operation = (Op) operation.clone();
    }
    return o;
  }
   
    public void addRandomKids(NodeFactory nf, int maxDepth, Random rand) 
   {
        
       if(depth == maxDepth){
           this.left = nf.getTerminal(rand);
           this.right = nf.getTerminal(rand);
           this.left.depth = depth + 1;
           this.right.depth = depth + 1;
           return;
       }

       int choice = rand.nextInt(f.numOps());
            if (choice < 1)
        {
            this.left = nf.getOperator(rand);
            this.left.depth = depth + 1;
            this.left.addRandomKids(nf, maxDepth, rand); 
        }else{
            this.left = nf.getTerminal(rand);
            this.left.depth = depth + 1;

        }

        choice = rand.nextInt(f.numOps());
            if (choice < 1)
        {
            this.right = nf.getOperator(rand);
            this.right.depth = depth + 1;
            this.right.addRandomKids(nf, maxDepth, rand); 
        }else{
            this.right = nf.getTerminal(rand);
            this.right.depth = depth + 1;

        }
   }
   
   public void traverse(Collector c) {
    // collect this
    c.collect(this);
    
    // traverse lChild
    if(this.left != null){
    this.left.traverse(c);
    }
   
    // traverse rChild
    if(this.right != null){
        this.right.traverse(c);
        }
    
}   

public void swapLeft(Node trunk) {
    Node temp = this.left;
    this.left = trunk.left;
    trunk.left = temp;


}  

public void swapRight(Node trunk) {
    Node temp = this.right;
    this.right = trunk.right;
    trunk.right = temp;

} 

public boolean isLeaf() {
    // return true if operation is a Unop
    return (operation instanceof Unop);
}  
         
                 

     @Override
    public String toString()
    {
     if(operation instanceof Unop)
     {
       return operation.toString();
     }else
     {
         return "(" + left.toString() + " " + operation.toString() + " " + right.toString() + ") "; 
     }
  }

    
}
