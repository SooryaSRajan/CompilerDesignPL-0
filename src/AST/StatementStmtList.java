
package AST;

public class StatementStmtList extends StmtList implements ASTNode{
	ASTNode t1, t2;

	public StatementStmtList(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		System.out.print(", ");
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("StatementStmtList( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
