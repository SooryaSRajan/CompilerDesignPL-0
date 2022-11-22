
package AST;

public abstract class ExprInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ExprsExprInner) this.print();
		if (this instanceof EmptyExprInner) this.print();


	}
}
