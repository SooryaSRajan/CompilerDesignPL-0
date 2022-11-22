
package AST;

public class DivTermMultDivFactor extends TermMultDivFactor implements ASTNode{
	ASTNode t1, t2;

	public DivTermMultDivFactor(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("DivTermMultDivFactor( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
