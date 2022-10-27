package RDPFiles;

import GeneratedOutput.LexarLexer;
import org.antlr.v4.runtime.Token;

public class RDPParserPL0 {
    LexarLexer lexer;
    Token token;

    public RDPParserPL0(LexarLexer lexer) {
        this.lexer = lexer;
        System.out.println(lexer);
    }

    //start : program;
    public void start() {
        token = lexer.nextToken();
        System.out.println(program());
    }

    //program : MODULE MAIN SEMICOLON block MAIN DOT;
    public boolean program() {
        if (token.getType() == LexarLexer.MODULE) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.MAIN) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.SEMICOLON) {
                    token = lexer.nextToken();
                    if (block()) {
                        if (token.getType() == LexarLexer.MAIN) {
                            token = lexer.nextToken();
                            if (token.getType() == LexarLexer.DOT) {
                                token = lexer.nextToken();
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    //block : declList BEGIN stmtList END;
    public boolean block() {
        if (declList()) {
            if (token.getType() == LexarLexer.BEGIN) {
                token = lexer.nextToken();
                if (stmtList()) {
                    if (token.getType() == LexarLexer.END) {
                        token = lexer.nextToken();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //declList : (decl SEMICOLON)*;
    public boolean declList() {
        while (decl()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
            } else {
                return false;
            }
        }
        return true;
    }

    //decl : constDecl
    //    | varDecl
    //    | procDecl;
    public boolean decl() {
        if (constDecl()) {
            return true;
        } else if (varDecl()) {
            return true;
        } else if (procDecl()) {
            return true;
        }
        return false;
    }

    //constDecl : CONST constDeclItem (COMMA constDeclItem)*;
    public boolean constDecl() {
        if (token.getType() == LexarLexer.CONST) {
            token = lexer.nextToken();
            if (constDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!constDeclItem()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    //constDeclItem : ID COLON type EQUAL constExpr;
    public boolean constDeclItem() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    if (token.getType() == LexarLexer.EQUAL) {
                        token = lexer.nextToken();
                        if (constExpr()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //constExpr : ID
    //    | INTEGER
    //    | CHARACTER;
    public boolean constExpr() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.INTEGER) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            return true;
        }
        return false;
    }

    //varDecl : VAR varDeclItem (COMMA varDeclItem)*;
    public boolean varDecl() {
        if (token.getType() == LexarLexer.VAR) {
            token = lexer.nextToken();
            if (varDeclItem()) {
                while (token.getType() == LexarLexer.COMMA) {
                    token = lexer.nextToken();
                    if (!varDeclItem()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    //varDeclItem : ID COLON type;
    public boolean varDeclItem() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    return true;
                }
            }
        }
        return false;
    }

    //procDecl : PROCEDURE ID BRACKET_OPEN (formalDecl (COMMA formalDecl)*)? BRACKET_CLOSE (COLON type)? SEMICOLON block ID;
    public boolean procDecl() {
        if (token.getType() == LexarLexer.PROCEDURE) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.ID) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.BRACKET_OPEN) {
                    token = lexer.nextToken();
                    if (formalDecl()) {
                        while (token.getType() == LexarLexer.COMMA) {
                            token = lexer.nextToken();
                            if (!formalDecl()) {
                                return false;
                            }
                        }
                    }
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        if (token.getType() == LexarLexer.COLON) {
                            token = lexer.nextToken();
                            if (!type()) {
                                return false;
                            }
                        }
                        if (token.getType() == LexarLexer.SEMICOLON) {
                            token = lexer.nextToken();
                            if (block()) {
                                if (token.getType() == LexarLexer.ID) {
                                    token = lexer.nextToken();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //formalDecl : ID COLON type;
    public boolean formalDecl() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.COLON) {
                token = lexer.nextToken();
                if (type()) {
                    return true;
                }
            }
        }
        return false;
    }

    //type : INT
    //    | CHAR
    //    | ARRAY SQ_OPEN INTEGER SQ_CLOSE OF type;

    public boolean type() {
        if (token.getType() == LexarLexer.INT) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.CHAR) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.ARRAY) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.SQ_OPEN) {
                token = lexer.nextToken();
                if (token.getType() == LexarLexer.INTEGER) {
                    token = lexer.nextToken();
                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                        token = lexer.nextToken();
                        if (token.getType() == LexarLexer.OF) {
                            token = lexer.nextToken();
                            if (type()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //stmtList : ((decl SEMICOLON)+ | (stmt SEMICOLON)+)*;
    public boolean stmtList() {
        if (decl()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
                while (decl()) {
                    if (token.getType() == LexarLexer.SEMICOLON) {
                        token = lexer.nextToken();
                    } else {
                        return false;
                    }
                }
            }
        } else if (stmt()) {
            if (token.getType() == LexarLexer.SEMICOLON) {
                token = lexer.nextToken();
                while (stmt()) {
                    if (token.getType() == LexarLexer.SEMICOLON) {
                        token = lexer.nextToken();
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //stmt : callStmt
    //    | assignStmt
    //    | returnStmt
    //    | outStmt
    //    | ifStmt
    //    | whileStmt
    //    | forStmt;

    public boolean stmt() {
        if (callStmt()) {
            return true;
        } else if (assignStmt()) {
            return true;
        } else if (returnStmt()) {
            return true;
        } else if (outStmt()) {
            return true;
        } else if (ifStmt()) {
            return true;
        } else if (whileStmt()) {
            return true;
        } else if (forStmt()) {
            return true;
        }
        return false;
    }

    //callStmt : ID BRACKET_OPEN (exprs)? BRACKET_CLOSE;
    public boolean callStmt() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.BRACKET_OPEN) {
                token = lexer.nextToken();
                if (exprs()) {
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        return true;
                    }
                } else {
                    if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                        token = lexer.nextToken();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //assignStmt : lvalue ASSIGNMENT (expr);
    public boolean assignStmt() {
        if (lvalue()) {
            if (token.getType() == LexarLexer.ASSIGNMENT) {
                token = lexer.nextToken();
                if (expr()) {
                    return true;
                }
            }
        }
        return false;
    }

    //lvalue : ID
    //    | ID SQ_OPEN sum SQ_CLOSE;
    public boolean lvalue() {
        if (token.getType() == LexarLexer.ID) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.SQ_OPEN) {
                token = lexer.nextToken();
                if (sum()) {
                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                        token = lexer.nextToken();
                        return true;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    //returnStmt : RETURN (sum)?;
    public boolean returnStmt() {
        if (token.getType() == LexarLexer.RETURN) {
            token = lexer.nextToken();
            if (sum()) {
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    //outStmt : OUTPUT ASSIGNMENT (expr | STRING);
    public boolean outStmt() {
        if (token.getType() == LexarLexer.OUTPUT) {
            token = lexer.nextToken();
            if (token.getType() == LexarLexer.ASSIGNMENT) {
                token = lexer.nextToken();
                if (expr()) {
                    return true;
                } else if (token.getType() == LexarLexer.STRING) {
                    token = lexer.nextToken();
                    return true;
                }
            }
        }
        return false;
    }

    //ifStmt : IF condition THEN stmtList (SQ_OPEN ELSE stmtList SQ_CLOSE)? END;
    public boolean ifStmt() {
        if (token.getType() == LexarLexer.IF) {
            token = lexer.nextToken();
            if (condition()) {
                if (token.getType() == LexarLexer.THEN) {
                    token = lexer.nextToken();
                    if (stmtList()) {
                        if (token.getType() == LexarLexer.SQ_OPEN) {
                            token = lexer.nextToken();
                            if (token.getType() == LexarLexer.ELSE) {
                                token = lexer.nextToken();
                                if (stmtList()) {
                                    if (token.getType() == LexarLexer.SQ_CLOSE) {
                                        token = lexer.nextToken();
                                        if (token.getType() == LexarLexer.END) {
                                            token = lexer.nextToken();
                                            return true;
                                        }
                                    }
                                }
                            }
                        } else if (token.getType() == LexarLexer.END) {
                            token = lexer.nextToken();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //whileStmt : WHILE condition DO stmtList END;
    public boolean whileStmt() {
        if (token.getType() == LexarLexer.WHILE) {
            token = lexer.nextToken();
            if (condition()) {
                if (token.getType() == LexarLexer.DO) {
                    token = lexer.nextToken();
                    if (stmtList()) {
                        if (token.getType() == LexarLexer.END) {
                            token = lexer.nextToken();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //forStmt : FOR sum TO sum DO stmtList END;
    public boolean forStmt() {
        if (token.getType() == LexarLexer.FOR) {
            token = lexer.nextToken();
            if (sum()) {
                if (token.getType() == LexarLexer.TO) {
                    token = lexer.nextToken();
                    if (sum()) {
                        if (token.getType() == LexarLexer.DO) {
                            token = lexer.nextToken();
                            if (stmtList()) {
                                if (token.getType() == LexarLexer.END) {
                                    token = lexer.nextToken();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //condition : innerStatement
    //    | innerStatement AND condition
    //    | innerStatement OR condition
    //    | NOT condition;

    public boolean condition() {
        if (innerStatement()) {
            if (token.getType() == LexarLexer.AND) {
                token = lexer.nextToken();
                if (condition()) {
                    return true;
                }
            } else if (token.getType() == LexarLexer.OR) {
                token = lexer.nextToken();
                if (condition()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (token.getType() == LexarLexer.NOT) {
            token = lexer.nextToken();
            if (condition()) {
                return true;
            }
        }
        return false;
    }

    //innerStatement :  ODD sum
    //    | sum relop sum;
    public boolean innerStatement() {
        if (token.getType() == LexarLexer.ODD) {
            token = lexer.nextToken();
            if (sum()) {
                return true;
            }
        } else if (sum()) {
            if (relop()) {
                if (sum()) {
                    return true;
                }
            }
        }
        return false;
    }

    //relop : LT
    //    | LTE
    //    | EQUAL
    //    | GTE
    //    | GT
    //    | NOTEQUAL;
    public boolean relop() {
        if (token.getType() == LexarLexer.LT) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.LTE) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.EQUAL) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.GTE) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.GT) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.NOTEQUAL) {
            token = lexer.nextToken();
            return true;
        }
        return false;
    }

    //exprs : expr (COMMA expr)*;
    public boolean exprs() {
        if (expr()) {
            while (token.getType() == LexarLexer.COMMA) {
                token = lexer.nextToken();
                if (!expr()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //expr : sum
    //    | CHARACTER;

    public boolean expr() {
        if (sum()) {
            return true;
        } else if (token.getType() == LexarLexer.CHARACTER) {
            token = lexer.nextToken();
            return true;
        }
        return false;
    }

    //sum : term ((PLUS | MINUS) term)*;
    public boolean sum() {
        if (term()) {
            while (token.getType() == LexarLexer.PLUS || token.getType() == LexarLexer.MINUS) {
                token = lexer.nextToken();
                if (!term()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //term : factor ((MULTIPLICATION | DIVISION) factor)*;
    public boolean term() {
        if (factor()) {
            while (token.getType() == LexarLexer.MULTIPLICATION || token.getType() == LexarLexer.DIVISION) {
                token = lexer.nextToken();
                if (!factor()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //factor : MINUS factor
    //    | lvalue
    //    | INTEGER
    //    | INPUT
    //    | callStmt
    //    | BRACKET_OPEN expr BRACKET_CLOSE;
    public boolean factor() {
        if (token.getType() == LexarLexer.MINUS) {
            token = lexer.nextToken();
            if (factor()) {
                return true;
            }
        } else if (lvalue()) {
            return true;
        } else if (token.getType() == LexarLexer.INTEGER) {
            token = lexer.nextToken();
            return true;
        } else if (token.getType() == LexarLexer.INPUT) {
            token = lexer.nextToken();
            return true;
        } else if (callStmt()) {
            return true;
        } else if (token.getType() == LexarLexer.BRACKET_OPEN) {
            token = lexer.nextToken();
            if (expr()) {
                if (token.getType() == LexarLexer.BRACKET_CLOSE) {
                    token = lexer.nextToken();
                    return true;
                }
            }
        }
        return false;
    }




}
