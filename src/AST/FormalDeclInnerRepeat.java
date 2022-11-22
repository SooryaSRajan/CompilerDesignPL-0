
package AST;

public abstract class FormalDeclInnerRepeat implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof RepeatingFormalDeclInnerRepeat) this.print();
		if (this instanceof EmptyFormalDeclInnerRepeat) this.print();

	}
}
