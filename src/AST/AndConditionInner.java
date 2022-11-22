
package AST;

public class AndConditionInner extends ConditionInner implements ASTNode{
	ASTNode t1;

	public AndConditionInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("AndConditionInner( " );
        t1.print();
        System.out.println(")");

	}

}
