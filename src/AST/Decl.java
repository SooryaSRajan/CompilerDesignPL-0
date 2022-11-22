
package AST;

public abstract class Decl implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ConstantDecl) this.print();
		if (this instanceof VariableDecl) this.print();
		if (this instanceof ProceduralDecl) this.print();


	}
}
