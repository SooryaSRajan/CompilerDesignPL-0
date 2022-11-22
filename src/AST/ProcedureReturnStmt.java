
package AST;

public class ProcedureReturnStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public ProcedureReturnStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ProcedureReturnStmt( " );
        t1.print();
        System.out.println(")");

	}

}
