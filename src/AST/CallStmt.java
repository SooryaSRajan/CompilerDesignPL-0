
package AST;

public abstract class CallStmt implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprCallStmt) this.print();


	}
}
