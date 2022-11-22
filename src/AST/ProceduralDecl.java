
package AST;

public class ProceduralDecl extends Decl implements ASTNode{
	ASTNode t1;

	public ProceduralDecl(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {

		System.out.println("ProcDecl( ");
		t1.print();
		System.out.println(")");

	}
}
