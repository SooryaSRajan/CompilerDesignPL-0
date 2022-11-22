
package AST;

public class LValueFactor extends Factor implements ASTNode{
	ASTNode t1;

	public LValueFactor(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("LValueFactor( " );
        t1.print();
        System.out.println(")");

	}

}
