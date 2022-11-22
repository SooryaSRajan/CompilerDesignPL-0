
package AST;

public class OddInnerStatement extends InnerStatement implements ASTNode{
	ASTNode t1;

	public OddInnerStatement(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("OddInnerStatement( " );
        t1.print();
        System.out.println(")");

	}

}
