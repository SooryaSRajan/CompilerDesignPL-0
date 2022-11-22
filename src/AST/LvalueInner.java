
package AST;

public abstract class LvalueInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprLvalueInner) this.print();
		if (this instanceof EmptyLvalueInner) this.print();


	}
}
