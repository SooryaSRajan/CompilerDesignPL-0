
package AST;

public abstract class Term implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof MultDivFactorTerm) this.print();


	}
}
