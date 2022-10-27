package RDPFiles;

import GeneratedOutput.LexarLexer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class RDPParserPL0 {
    public void start() throws IOException {

        CharStream input = new ANTLRFileStream("/Users/sooryasrajan/AntlrCompilerDesign/src/InputFiles/sum");
        LexarLexer lexer = new LexarLexer(input);
        CommonTokenStream token = new CommonTokenStream(lexer);

    }
}
