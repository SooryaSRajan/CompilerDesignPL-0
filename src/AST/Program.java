
package AST;

public abstract class Program implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof BlockProgram) this.print();


	}
}
