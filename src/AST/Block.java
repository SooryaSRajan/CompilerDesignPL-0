
package AST;

public abstract class Block implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof StatementBlock) this.print();


	}
}
