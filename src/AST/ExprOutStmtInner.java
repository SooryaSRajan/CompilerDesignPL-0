
package AST;

public class ExprOutStmtInner extends OutStmtInner implements ASTNode{
	ASTNode t1;

	public ExprOutStmtInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ExprOutStmtInner( " );
        t1.print();
        System.out.println(")");

	}

}
