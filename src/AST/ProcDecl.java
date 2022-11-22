
package AST;

public abstract class ProcDecl implements ASTNode{
    @Override
    public void print() {

        if (this instanceof BlockProcDecl) this.print();


    }
}
