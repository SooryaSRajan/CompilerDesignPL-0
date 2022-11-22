
package AST;

public abstract class ConstDeclItemInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ItemsConstDeclItemInner) this.print();
		if (this instanceof EmptyConstDeclItemInner) this.print();


	}
}
