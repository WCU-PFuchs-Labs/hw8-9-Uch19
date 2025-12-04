package binary;

import java.util.Random;

public class terminalFactory {
  public Op getTerminal(Random rand){
    if(rand.nextBoolean()){
      return new Variable(rand.nextInt(10));
    } else {
        return new Const(rand.nextDouble() * 10); 
    }
  }
}
