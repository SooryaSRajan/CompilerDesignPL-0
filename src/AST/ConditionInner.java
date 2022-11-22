
package AST;

public abstract class ConditionInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof AndConditionInner) this.print();
		if (this instanceof OrConditionInner) this.print();
		if (this instanceof EmptyConditionInner) this.print();


	}
}
