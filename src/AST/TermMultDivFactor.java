
package AST;

public abstract class TermMultDivFactor implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof MultTermMultDivFactor) this.print();
		if (this instanceof DivTermMultDivFactor) this.print();
		if (this instanceof EmptyTermMultDivFactor) this.print();


	}
}
