
package AST;

public abstract class IfStmtInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StmtListIfStmtInner) this.print();
		if (this instanceof EmptyIfStmtInner) this.print();


	}
}
