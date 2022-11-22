
package AST;

public abstract class DeclList implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof DeeclarationsDeclList) this.print();
		if (this instanceof EmptyDeclList) this.print();


	}
}
