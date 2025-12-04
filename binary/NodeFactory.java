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
        Op op =  oFactory.getOperator(rand,null,null);
        return new Node((Binop) op,null,null);
        }
        

    public int getNumOps() {
        return 4;
    }
    public Node getTerminal(Random rand) {
        Op op = tFactory.getTerminal(rand);
        return new Node(op);
    }
    public int getNumIndepVars() {
        return 1;
    }
}
