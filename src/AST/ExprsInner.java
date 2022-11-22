
package AST;

public abstract class ExprsInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof InnerExprsInner) this.print();
		if (this instanceof EmptyExprsInner) this.print();


	}
}
