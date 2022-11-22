
package AST;

public class VariableDecl extends Decl implements ASTNode {
    ASTNode t1;

    public VariableDecl(ASTNode t1) {
        this.t1 = t1;
    }

    @Override
    public void print() {

        System.out.println("VarDecl( ");
        t1.print();
        System.out.println(")");

    }
}
