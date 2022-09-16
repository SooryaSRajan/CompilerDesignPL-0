import GeneratedOutput.Lexar;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class Main {

    public static void main(String[] args) {

        try {
            CharStream input = new ANTLRFileStream("/Users/sooryasrajan/AntlrCompilerDesign/src/InputFiles/fibonacci");
            /* give your filepath in the above place*/
            Lexar lexer = new Lexar(input);
            String[] ruleNames = lexer.getRuleNames();
            Token token;
            while ((token = lexer.nextToken()).getType() != -1) {
                System.err.println("<" + ruleNames[token.getType() - 1] + ", \"" + token.getText() + "\">");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}