
package AST;

public class StmtListIfStmtInner extends IfStmtInner implements ASTNode{
	ASTNode t1;

	public StmtListIfStmtInner(ASTNode astNode) {
		this.t1 = astNode;
	}

	@Override
	public void print() {
        
		System.out.println("StmtListIfStmtInner( " );
        t1.print();
        System.out.println(")");

	}

}
