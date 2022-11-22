
package AST;

public abstract class InnerStatement implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof OddInnerStatement) this.print();
		if (this instanceof RelopInnerStatement) this.print();


	}
}
