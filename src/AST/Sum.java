
package AST;

public abstract class Sum implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof InnerSum) this.print();


	}
}
