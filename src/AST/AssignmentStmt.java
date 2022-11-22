
package AST;

public class AssignmentStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public AssignmentStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("AssignmentStmt( " );
        t1.print();
        System.out.println(")");

	}

}
