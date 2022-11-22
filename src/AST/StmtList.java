
package AST;

public abstract class StmtList implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof DeclarationStmtList) this.print();
		if (this instanceof StatementStmtList) this.print();
		if (this instanceof EmptyStmtList) this.print();


	}
}
