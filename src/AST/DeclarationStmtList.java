
package AST;

public class DeclarationStmtList extends StmtList implements ASTNode{
	ASTNode t1, t2;

	public DeclarationStmtList(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("DeclarationStmtList( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
