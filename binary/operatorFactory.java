package binary;

public class operatorFactory {
  private Node[] operators;

  public operatorFactory() {
    operators = new Node[]{
        new Plus(),
        new Minus(),
        new Mult(),
        new Divide()
    };
  }
  public Node getOperator(Random rand, Node left, Node right) {
    int index = rand.nextInt(operators.length);
    Node op = operators[index];
    if(op instanceof Plus) {
      return new Plus(left, right);
    if(op instanceof Minus) {
      return new Minus(left, right);
    } else if(op instanceof Mult) {
      return new Mult(left, right);
    } else if(op instanceof Divide) {
      return new Divide(left, right);
      return null;
    } 
  }
}
