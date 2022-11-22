
package AST;

public class ExprCallStmt extends CallStmt implements ASTNode{
	ASTNode t1;

	public ExprCallStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ExprCallStmt( " );
        t1.print();
        System.out.println(")");

	}

}
