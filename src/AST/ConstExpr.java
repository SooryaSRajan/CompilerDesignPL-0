
package AST;

public abstract class ConstExpr implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof IDConstExpr) this.print();
		if (this instanceof IntegerConstExpr) this.print();
		if (this instanceof CharacterConstExpr) this.print();


	}
}
