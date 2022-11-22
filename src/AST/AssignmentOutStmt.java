
package AST;

public class AssignmentOutStmt extends OutStmt implements ASTNode{
	ASTNode t1;

	public AssignmentOutStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("AssignmentOutStmt( " );
        t1.print();
        System.out.println(")");

	}

}
