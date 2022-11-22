
package AST;

public class MinusFactor extends Factor implements ASTNode{
	ASTNode t1;

	public MinusFactor(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("MinusFactor( " );
        t1.print();
        System.out.println(")");

	}

}
