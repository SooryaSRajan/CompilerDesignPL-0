
package AST;

public class IfBlockStmt extends Stmt implements ASTNode{
	ASTNode t1;

	public IfBlockStmt(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("IfBlockStmt( " );
        t1.print();
        System.out.println(")");

	}

}
