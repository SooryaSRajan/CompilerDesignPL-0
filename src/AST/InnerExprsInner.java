
package AST;

public class InnerExprsInner extends ExprsInner implements ASTNode{
	ASTNode t1, t2;

	public InnerExprsInner(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("InnerExprsInner( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
