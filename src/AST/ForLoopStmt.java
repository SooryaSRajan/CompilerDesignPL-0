
package AST;

public class ForLoopStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public ForLoopStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ForLoopStmt( " );
        t1.print();
        System.out.println(")");

	}

}
