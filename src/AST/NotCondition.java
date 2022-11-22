
package AST;

public class NotCondition extends Condition implements ASTNode{

	ASTNode t1;

	public NotCondition(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("NotCondition( " );
        t1.print();
        System.out.println(")");

	}

}
