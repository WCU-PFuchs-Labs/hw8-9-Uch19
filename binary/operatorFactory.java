package binary;
import java.util.*;

public class operatorFactory {
  private Binop[] operators;

  public operatorFactory() {
    operators = new Binop[]{
        new Plus(null, null),
        new Minus(null, null),
        new Mult(null, null),
        new Divide(null, null)
    };
  }
  public Op getOperator(Random rand, Node left, Node right) {
    int index = rand.nextInt(operators.length);
    Binop op = operators[index];
    if(op instanceof Plus) {
        return new Plus(left, right);
    } else if(op instanceof Minus) {
        return new Minus(left, right);
    } else if(op instanceof Mult) {
        return new Mult(left, right);
    } else if(op instanceof Divide) {
        return new Divide(left, right);
      
    } 
    return null;
  }
}

