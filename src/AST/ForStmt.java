
package AST;

public abstract class ForStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StmtListForStmt) this.print();


	}
}
