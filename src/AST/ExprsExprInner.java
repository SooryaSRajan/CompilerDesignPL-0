
package AST;

public class ExprsExprInner extends ExprInner implements ASTNode{
	ASTNode t1;

	public ExprsExprInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ExprsExprInner( " );
        t1.print();
        System.out.println(")");

	}

}
