
package AST;

public class ItemsProcFormalCallChoice extends ProcFormalCallChoice implements ASTNode{
	ASTNode t1, t2;

	public ItemsProcFormalCallChoice(ASTNode t1, ASTNode t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void print() {
        
		System.out.println("ItemsProcFormalCallChoice( " );
        t1.print();
		System.out.print(", ");
		t2.print();
        System.out.println(")");

	}

}
