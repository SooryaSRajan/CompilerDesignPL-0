
package AST;

public class ExprConstDeclItem extends ConstDeclItem implements ASTNode{
	ASTNode t1, t2;

	public ExprConstDeclItem(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("ExprConstDeclItem( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
