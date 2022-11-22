
package AST;

public class OrConditionInner extends ConditionInner implements ASTNode{
	ASTNode t1;

	public OrConditionInner(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("OrConditionInner( " );
        t1.print();
        System.out.println(")");

	}

}
