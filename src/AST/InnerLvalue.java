
package AST;

public class InnerLvalue extends Lvalue implements ASTNode{
	ASTNode t1;

	public InnerLvalue(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("InnerLvalue( " );
        t1.print();
        System.out.println(")");

	}

}
