
package AST;

public abstract class SumInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof PlusSumInner) this.print();
		if (this instanceof MinusSumInner) this.print();
		if (this instanceof EmptySumInner) this.print();


	}
}
