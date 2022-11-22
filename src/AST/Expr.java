
package AST;

public abstract class Expr implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof SumExpr) this.print();
		if (this instanceof CharacterExpr) this.print();


	}
}
