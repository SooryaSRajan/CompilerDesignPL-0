
package AST;

public class BlockProgram extends Program implements ASTNode{
	ASTNode t1;
	public BlockProgram(ASTNode t1) {
		this.t1 = t1;
		
	}
	@Override
	public void print() {
        
		System.out.println("BlockProgram( " );
		t1.print();
        System.out.println(")");

	}

}
