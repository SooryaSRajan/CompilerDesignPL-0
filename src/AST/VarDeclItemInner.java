
package AST;

public abstract class VarDeclItemInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ItemsVarDeclItemInner) this.print();
		if (this instanceof EmptyVarDeclItemInner) this.print();


	}
}
