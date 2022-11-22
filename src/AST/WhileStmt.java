
package AST;

public abstract class WhileStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StmtListWhileStmt) this.print();


	}
}
