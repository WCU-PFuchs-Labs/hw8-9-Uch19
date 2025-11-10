package binary;


public class Variable extends Unop {

   private final int index;
  
  public Variable(int index){
    
    this.index = index;
  }
   
   
   @Override
   public double eval(double[] values){

     return values[this.index];     
   }

  @Override
  public String toString(){
      return "X" + this.index;
  }

}   
   

   
