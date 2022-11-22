
package AST;

public class ArrayType extends Type implements ASTNode{
	ASTNode t1;

	public ArrayType(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("ArrayType( " );
        t1.print();
        System.out.println(")");

	}

}
