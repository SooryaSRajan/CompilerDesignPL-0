
package AST;

public class ConstantDecl extends Decl implements ASTNode{
	ASTNode t1;

	public ConstantDecl(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {

		System.out.println("ConstDecl( " );
		t1.print();
		System.out.println(")");

	}
}
