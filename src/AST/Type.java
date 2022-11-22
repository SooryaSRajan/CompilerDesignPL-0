
package AST;

public abstract class Type implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof IntType) this.print();
		if (this instanceof CharType) this.print();
		if (this instanceof ArrayType) this.print();


	}
}
