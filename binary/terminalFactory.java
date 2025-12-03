package binary;

import java.util.Random;

public class terminalFactory {
  public Node getTerminal(Random rand){
    if(rand.nextBoolean()){
      return new Variable();
    } else {
      double val = rand.nextDouble();
      return new Const(val);
    }
  }
}
