
package AST;

public class InnerSum extends Sum implements ASTNode{
	ASTNode t1, t2;

	public InnerSum(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("InnerSum( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
