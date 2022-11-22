
package AST;

public abstract class ProcFormalCallChoice implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof ItemsProcFormalCallChoice) this.print();
		if (this instanceof EmptyProcFormalCallChoice) this.print();


	}
}
