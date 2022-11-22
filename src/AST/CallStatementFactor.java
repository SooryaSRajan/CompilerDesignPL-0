
package AST;

public class CallStatementFactor extends Factor implements ASTNode{
	ASTNode t1;

	public CallStatementFactor(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("CallStatementFactor( " );
        t1.print();
        System.out.println(")");

	}

}
