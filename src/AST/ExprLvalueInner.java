
package AST;

public class ExprLvalueInner extends LvalueInner implements ASTNode{
	ASTNode t1;

	public ExprLvalueInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ExprLvalueInner( " );
        t1.print();
        System.out.println(")");

	}

}
