
package AST;

public class MultTermMultDivFactor extends TermMultDivFactor implements ASTNode{
	ASTNode t1, t2;

	public MultTermMultDivFactor(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("MultTermMultDivFactor( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
