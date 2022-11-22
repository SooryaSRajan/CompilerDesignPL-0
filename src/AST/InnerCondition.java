
package AST;

public class InnerCondition extends Condition implements ASTNode{
	ASTNode t1, t2;

	public InnerCondition(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("InnerCondition( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
