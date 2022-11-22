
package AST;

public class TypeVarDeclItem extends VarDeclItem implements ASTNode{
	ASTNode t1;

	public TypeVarDeclItem(ASTNode t1) {
		this.t1 = t1;
	}

	@Override
	public void print() {
        
		System.out.println("TypeVarDeclItem( " );
        t1.print();
        System.out.println(")");

	}

}
