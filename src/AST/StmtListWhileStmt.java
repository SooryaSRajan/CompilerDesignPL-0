
package AST;

public class StmtListWhileStmt extends WhileStmt implements ASTNode{
	ASTNode t1, t2;

	public StmtListWhileStmt(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		System.out.print(", ");
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("StmtListWhileStmt( " );
        t1.print();
		t2.print();
        System.out.println(")");

	}

}
