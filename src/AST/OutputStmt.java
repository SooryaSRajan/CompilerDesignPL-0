
package AST;

public class OutputStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public OutputStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("OutputStmt( " );
        t1.print();
        System.out.println(")");

	}

}
