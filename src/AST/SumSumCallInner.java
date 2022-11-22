
package AST;

public class SumSumCallInner extends SumCallInner implements ASTNode{
	ASTNode t1;

	public SumSumCallInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("SumSumCallInner( " );
        t1.print();
        System.out.println(")");

	}

}
