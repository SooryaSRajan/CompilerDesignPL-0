
package AST;

public abstract class ColonTypeChoice implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof TypeColonTypeChoice) this.print();
		if (this instanceof EmptyColonTypeChoice) this.print();


	}
}
