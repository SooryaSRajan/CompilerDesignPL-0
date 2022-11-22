
package AST;

public abstract class IfStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StmtListIfStmt) this.print();


	}
}
