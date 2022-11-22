
package AST;

public abstract class FormalDecl implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof TypeFormalDecl) this.print();


	}
}
