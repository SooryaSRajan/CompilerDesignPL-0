
package AST;

public abstract class Relop implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof LtRelop) this.print();
		if (this instanceof LTERelop) this.print();
		if (this instanceof EqualRelop) this.print();
		if (this instanceof GTERelop) this.print();
		if (this instanceof GtRelop) this.print();
		if (this instanceof NotEqualRelop) this.print();


	}
}
