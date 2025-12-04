package binary;
import java.util.Random;

public class NodeFactory {
    private operatorFactory oFactory;
    private terminalFactory tFactory;
    
    public NodeFactory(operatorFactory oFactory, terminalFactory tFactory) {
       this.oFactory = oFactory;
        this.tFactory = tFactory;

    }
    public Node getOperator(Random rand) {
        return oFactory.getOperator(rand,null,null);
        }
        

    public int getNumOps() {
        return 4;
    }
    public Node getTerminal(Random rand) {
        return tFactory.getTerminal(rand);
    }
    public int getNumIndepVars() {
        return 1;
    }
}
