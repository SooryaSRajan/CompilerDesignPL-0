
package AST;

public abstract class Start implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ProgramStart) this.print();


	}
}
