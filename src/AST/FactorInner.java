
package AST;

public abstract class FactorInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof BracketFactorInner) this.print();


	}
}
