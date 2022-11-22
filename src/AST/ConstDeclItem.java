
package AST;

public abstract class ConstDeclItem implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprConstDeclItem) this.print();


	}
}
