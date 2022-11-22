
package AST;

public class TypeFormalDecl extends FormalDecl implements ASTNode{
	ASTNode t1;

	public TypeFormalDecl(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("TypeFormalDecl( " );
        t1.print();
        System.out.println(")");

	}

}
