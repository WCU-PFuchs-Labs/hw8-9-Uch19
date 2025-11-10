package binary;
import java.util.Random;

public class NodeFactory {
    private int numIndepVars;
    private Binop[] currentOps;
    
    public NodeFactory(Binop[] b, int numVars) {
        currentOps = b;
        numIndepVars = numVars;

    }
    public Node getOperator(Random rand) {
        int index = rand.nextInt(currentOps.length);
        Binop opCopy =  (Binop) currentOps[index].clone();
            return new Node(opCopy, null, null);
        }
        

    public int getNumOps() {
        return currentOps.length;
    }
    public Node getTerminal(Random rand) {
        int r = rand.nextInt(numIndepVars + 1);
        if(r < numIndepVars){
         return new Node(new Variable(r));
        }else{
            double val  = rand.nextDouble();
            return new Node(new Const(val));
        }
    }
    public int getNumIndepVars() {
        return numIndepVars;
    }
}
