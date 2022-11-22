
package AST;

public abstract class Lvalue implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof InnerLvalue) this.print();


	}
}
