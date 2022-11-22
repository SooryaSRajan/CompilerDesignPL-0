
package AST;

public abstract class Exprs implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof InnerExprs) this.print();


	}
}
