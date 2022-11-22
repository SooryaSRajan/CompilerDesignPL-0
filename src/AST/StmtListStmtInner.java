
package AST;

public abstract class StmtListStmtInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StmtListStmtListInner) this.print();
		if (this instanceof EmptyStmtListInner) this.print();


	}
}
