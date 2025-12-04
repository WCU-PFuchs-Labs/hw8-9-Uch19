package binary;
import java.util.Random;

public class NodeFactory {
    private OperatorFactory oFactory;
    private TerminalFactory tFactory;
    
    public NodeFactory(OperatorFactory oFactory, TerminalFactory tFactory) {
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
