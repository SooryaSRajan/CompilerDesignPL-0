
package AST;

public abstract class VarDecl implements ASTNode{
    @Override
    public void print() {

        if (this instanceof ItemsVarDecl) this.print();


    }
}
