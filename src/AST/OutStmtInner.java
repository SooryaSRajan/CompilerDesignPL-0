
package AST;

public abstract class OutStmtInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprOutStmtInner) this.print();
		if (this instanceof StringOutStmtInner) this.print();


	}
}
