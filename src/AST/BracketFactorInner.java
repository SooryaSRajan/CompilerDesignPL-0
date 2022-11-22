
package AST;

public class BracketFactorInner extends FactorInner implements ASTNode{
	ASTNode t1;

	public BracketFactorInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("BracketFactorInner( " );
        t1.print();
        System.out.println(")");

	}

}
