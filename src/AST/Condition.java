
package AST;

public abstract class Condition implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof InnerCondition) this.print();
		if (this instanceof NotCondition) this.print();


	}
}
