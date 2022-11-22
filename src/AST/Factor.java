
package AST;

public abstract class Factor implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof MinusFactor) this.print();
		if (this instanceof LValueFactor) this.print();
		if (this instanceof IntegerFactor) this.print();
		if (this instanceof InputFactor) this.print();
		if (this instanceof CallStatementFactor) this.print();


	}
}
