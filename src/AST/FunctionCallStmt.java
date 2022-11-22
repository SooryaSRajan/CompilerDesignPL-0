
package AST;

public class FunctionCallStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public FunctionCallStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("FunctionCallStmt( " );
        t1.print();
        System.out.println(")");

	}

}
