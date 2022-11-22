
package AST;

public class SumExpr extends Expr implements ASTNode{
	ASTNode t1;

	public SumExpr(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("SumExpr( " );
        t1.print();
        System.out.println(")");

	}

}
