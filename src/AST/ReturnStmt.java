
package AST;

public abstract class ReturnStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprReturnStmt) this.print();


	}
}
