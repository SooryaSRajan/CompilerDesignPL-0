
package AST;

public abstract class SumCallInner implements ASTNode{
	@Override
	public void print() {
        
		if (this instanceof SumSumCallInner) this.print();
		if (this instanceof EmptySumCallInner) this.print();


	}
}
