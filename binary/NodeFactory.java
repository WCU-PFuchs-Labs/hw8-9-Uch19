package binary;
import java.util.Random;

public class NodeFactory {
    private operatorFactory oFactory;
    private terminalFactory tFactory;
     private int numIndepVars;

    
    public NodeFactory(operatorFactory oFactory, terminalFactory tFactory, int numIndepVars) {
       this.oFactory = oFactory;
       this.tFactory = tFactory;
       this.numIndepVars = numIndepVars;

    }
    public Node getOperator(Random rand) {
        Op op =  oFactory.getOperator(rand,null,null);
        return new Node((Binop) op,null,null);
        }
        

    public int getNumOps() {
        return 4;
    }
    public Node getTerminal(Random rand) {
        if(rand.nextBoolean()){
            int index = rand.nextInt(numIndepVars);
            return new Node(new Variable(index));
        }else{
            double val = rand.nextDouble();
            return new Node(new Const(val));
        }
    }  
    public int getNumIndepVars() {
        return numIndepVars;
    }
}
