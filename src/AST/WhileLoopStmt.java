
package AST;

public class WhileLoopStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public WhileLoopStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("WhileLoopStmt( " );
        t1.print();
        System.out.println(")");

	}

}
