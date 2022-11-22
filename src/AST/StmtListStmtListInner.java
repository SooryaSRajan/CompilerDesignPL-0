
package AST;

public class StmtListStmtListInner extends StmtListStmtInner implements ASTNode{
	ASTNode t1;

	public StmtListStmtListInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("StmtListStmtListInner( " );
        t1.print();
        System.out.println(")");

	}

}
