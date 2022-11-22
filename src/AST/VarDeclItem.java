
package AST;

public abstract class VarDeclItem implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof TypeVarDeclItem) this.print();


	}
}
