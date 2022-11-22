//package TempFiles;
//
//import org.antlr.v4.runtime.Lexer;
//import org.antlr.v4.runtime.Token;
//
//public class SomeCode {
//
//    Token token;
//    Lexer lexer;
//
//    //script : sequence EOF;
//    public boolean script() {
//        sequence();
//        if(token.getType() == Token.EOF) {
//            System.out.println("EOF");
//            return true;
//        }
//        return false;
//    }
//    //sequence : temps ws? statements? | ws? statements;
//    public void sequence() {
//        temps();
//        if(token.getType() == Token.WS) {
//            ws();
//            if(token.getType() == Token.ID) {
//                statements();
//            }
//        } else if(token.getType() == Token.ID) {
//            statements();
//        }
//    }
//    //ws : (SEPARATOR | COMMENT)+;
//    public void ws() {
//        while(token.getType() == Token.SEPARATOR || token.getType() == Token.COMMENT) {
//            token = lexer.nextToken();
//        }
//    }
//    //temps : PIPE (ws? IDENTIFIER)+ ws? PIPE;
//    public void temps() {
//        if(token.getType() == Token.PIPE) {
//            token = lexer.nextToken();
//            while(token.getType() == Token.WS || token.getType() == Token.IDENTIFIER) {
//                if(token.getType() == Token.WS) {
//                    ws();
//                } else if(token.getType() == Token.IDENTIFIER) {
//                    token = lexer.nextToken();
//                }
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.PIPE) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //statements : answer ws? # StatementAnswer
//    //           | expressions ws? PERIOD ws? answer # StatementExpressionsAnswer
//    //           | expressions PERIOD? ws? # StatementExpressions
//    //           ;
//    public void statements() {
//        if(token.getType() == Token.ID) {
//            answer();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//        } else if(token.getType() == Token.ID) {
//            expressions();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.PERIOD) {
//                token = lexer.nextToken();
//                if(token.getType() == Token.WS) {
//                    ws();
//                }
//                answer();
//            }
//        } else if(token.getType() == Token.ID) {
//            expressions();
//            if(token.getType() == Token.PERIOD) {
//                token = lexer.nextToken();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//        }
//    }
//    //answer : CARROT ws? expression ws? PERIOD?;
//    public void answer() {
//        if(token.getType() == Token.CARROT) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            expression();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.PERIOD) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //expression : assignment | cascade | keywordSend | binarySend | primitive;
//    public void expression() {
//        if(token.getType() == Token.ID) {
//            assignment();
//        } else if(token.getType() == Token.ID) {
//            cascade();
//        } else if(token.getType() == Token.ID) {
//            keywordSend();
//        } else if(token.getType() == Token.ID) {
//            binarySend();
//        } else if(token.getType() == Token.ID) {
//            primitive();
//        }
//    }
//    //expressions : expression expressionList*;
//    public void expressions() {
//        expression();
//        while(token.getType() == Token.ID) {
//            expressionList();
//        }
//    }
//    //expressionList : PERIOD ws? expression;
//    public void expressionList() {
//        if(token.getType() == Token.PERIOD) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            expression();
//        }
//    }
//    //cascade : (keywordSend | binarySend) (ws? SEMI_COLON ws? message)+;
//    public void cascade() {
//        if(token.getType() == Token.ID) {
//            keywordSend();
//        } else if(token.getType() == Token.ID) {
//            binarySend();
//        }
//        while(token.getType() == Token.WS || token.getType() == Token.SEMI_COLON) {
//            if(token.getType() == Token.WS) {
//                ws();
//            } else if(token.getType() == Token.SEMI_COLON) {
//                token = lexer.nextToken();
//                if(token.getType() == Token.WS) {
//                    ws();
//                }
//                message();
//            }
//        }
//    }
//    //message : binaryMessage | unaryMessage | keywordMessage;
//    public void message() {
//        if(token.getType() == Token.ID) {
//            binaryMessage();
//        } else if(token.getType() == Token.ID) {
//            unaryMessage();
//        } else if(token.getType() == Token.ID) {
//            keywordMessage();
//        }
//    }
//    //assignment : variable ws? ASSIGNMENT ws? expression;
//    public void assignment() {
//        variable();
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        if(token.getType() == Token.ASSIGNMENT) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            expression();
//        }
//    }
//    //variable : IDENTIFIER;
//    public void variable() {
//        if(token.getType() == Token.IDENTIFIER) {
//            token = lexer.nextToken();
//        }
//    }
//    //binarySend : unarySend binaryTail?;
//    public void binarySend() {
//        unarySend();
//        if(token.getType() == Token.ID) {
//            binaryTail();
//        }
//    }
//    //unarySend : operand ws? unaryTail?;
//    public void unarySend() {
//        operand();
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        if(token.getType() == Token.ID) {
//            unaryTail();
//        }
//    }
//    //keywordSend : binarySend keywordMessage;
//    public void keywordSend() {
//        binarySend();
//        keywordMessage();
//    }
//    //keywordMessage : ws? (keywordPair ws?)+;
//    public void keywordMessage() {
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        while(token.getType() == Token.ID) {
//            keywordPair();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//        }
//    }
//    //keywordPair : KEYWORD ws? binarySend ws?;
//    public void keywordPair() {
//        if(token.getType() == Token.KEYWORD) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            binarySend();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//        }
//    }
//    //operand : literal | reference | subexpression;
//    public void operand() {
//        if(token.getType() == Token.ID) {
//            literal();
//        } else if(token.getType() == Token.ID) {
//            reference();
//        } else if(token.getType() == Token.ID) {
//            subexpression();
//        }
//    }
//    //subexpression : OPEN_PAREN ws? expression ws? CLOSE_PAREN;
//    public void subexpression() {
//        if(token.getType() == Token.OPEN_PAREN) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            expression();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.CLOSE_PAREN) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //literal : runtimeLiteral | parsetimeLiteral;
//    public void literal() {
//        if(token.getType() == Token.ID) {
//            runtimeLiteral();
//        } else if(token.getType() == Token.ID) {
//            parsetimeLiteral();
//        }
//    }
//    //runtimeLiteral : dynamicDictionary | dynamicArray | block;
//    public void runtimeLiteral() {
//        if(token.getType() == Token.ID) {
//            dynamicDictionary();
//        } else if(token.getType() == Token.ID) {
//            dynamicArray();
//        } else if(token.getType() == Token.ID) {
//            block();
//        }
//    }
//    //block : BLOCK_START blockParamList? ws? sequence? BLOCK_END;
//    public void block() {
//        if(token.getType() == Token.BLOCK_START) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.ID) {
//                blockParamList();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.ID) {
//                sequence();
//            }
//            if(token.getType() == Token.BLOCK_END) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //blockParamList : (ws? BLOCK_PARAM)+;
//    public void blockParamList() {
//        while(token.getType() == Token.WS || token.getType() == Token.BLOCK_PARAM) {
//            if(token.getType() == Token.WS) {
//                ws();
//            } else if(token.getType() == Token.BLOCK_PARAM) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //dynamicDictionary : DYNDICT_START ws? expressions? ws? DYNARR_END;
//    public void dynamicDictionary() {
//        if(token.getType() == Token.DYNDICT_START) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.ID) {
//                expressions();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.DYNARR_END) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //dynamicArray : DYNARR_START ws? expressions? ws? DYNARR_END;
//    public void dynamicArray() {
//        if(token.getType() == Token.DYNARR_START) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.ID) {
//                expressions();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.DYNARR_END) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //parsetimeLiteral : pseudoVariable | number | charConstant | literalArray | string | symbol;
//    public void parsetimeLiteral() {
//        if(token.getType() == Token.ID) {
//            pseudoVariable();
//        } else if(token.getType() == Token.ID) {
//            number();
//        } else if(token.getType() == Token.ID) {
//            charConstant();
//        } else if(token.getType() == Token.ID) {
//            literalArray();
//        } else if(token.getType() == Token.ID) {
//            string();
//        } else if(token.getType() == Token.ID) {
//            symbol();
//        }
//    }
//    //number : numberExp | hex_ | stFloat | stInteger;
//    public void number() {
//        if(token.getType() == Token.ID) {
//            numberExp();
//        } else if(token.getType() == Token.ID) {
//            hex_();
//        } else if(token.getType() == Token.ID) {
//            stFloat();
//        } else if(token.getType() == Token.ID) {
//            stInteger();
//        }
//    }
//    //numberExp : (stFloat | stInteger) EXP stInteger;
//    public void numberExp() {
//        if(token.getType() == Token.ID) {
//            if(token.getType() == Token.ID) {
//                stFloat();
//            } else if(token.getType() == Token.ID) {
//                stInteger();
//            }
//            if(token.getType() == Token.EXP) {
//                token = lexer.nextToken();
//                stInteger();
//            }
//        }
//    }
//    //charConstant : CHARACTER_CONSTANT;
//    public void charConstant() {
//        if(token.getType() == Token.CHARACTER_CONSTANT) {
//            token = lexer.nextToken();
//        }
//    }
//    //hex_ : MINUS? HEX HEXDIGIT+;
//    public void hex_() {
//        if(token.getType() == Token.ID) {
//            if(token.getType() == Token.MINUS) {
//                token = lexer.nextToken();
//            }
//            if(token.getType() == Token.HEX) {
//                token = lexer.nextToken();
//                while(token.getType() == Token.HEXDIGIT) {
//                    token = lexer.nextToken();
//                }
//            }
//        }
//    }
//    //stInteger : MINUS? DIGIT+;
//    public void stInteger() {
//        if(token.getType() == Token.ID) {
//            if(token.getType() == Token.MINUS) {
//                token = lexer.nextToken();
//            }
//            while(token.getType() == Token.DIGIT) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //stFloat : MINUS? DIGIT+ PERIOD DIGIT+;
//    public void stFloat() {
//        if(token.getType() == Token.ID) {
//            if(token.getType() == Token.MINUS) {
//                token = lexer.nextToken();
//            }
//            while(token.getType() == Token.DIGIT) {
//                token = lexer.nextToken();
//            }
//            if(token.getType() == Token.PERIOD) {
//                token = lexer.nextToken();
//                while(token.getType() == Token.DIGIT) {
//                    token = lexer.nextToken();
//                }
//            }
//        }
//    }
//    //pseudoVariable : RESERVED_WORD;
//    public void pseudoVariable() {
//        if(token.getType() == Token.RESERVED_WORD) {
//            token = lexer.nextToken();
//        }
//    }
//    //string : STRING;
//    public void string() {
//        if(token.getType() == Token.STRING) {
//            token = lexer.nextToken();
//        }
//    }
//    //symbol : HASH bareSymbol;
//    public void symbol() {
//        if(token.getType() == Token.HASH) {
//            token = lexer.nextToken();
//            bareSymbol();
//        }
//    }
//    //primitive : LT ws? KEYWORD ws? DIGIT+ ws? GT;
//    public void primitive() {
//        if(token.getType() == Token.LT) {
//            token = lexer.nextToken();
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.KEYWORD) {
//                token = lexer.nextToken();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            while(token.getType() == Token.DIGIT) {
//                token = lexer.nextToken();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//            if(token.getType() == Token.GT) {
//                token = lexer.nextToken();
//            }
//        }
//    }
//    //bareSymbol : (IDENTIFIER | BINARY_SELECTOR) | KEYWORD+ | string;
//    public void bareSymbol() {
//        if(token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR) {
//            token = lexer.nextToken();
//        } else if(token.getType() == Token.KEYWORD) {
//            while(token.getType() == Token.KEYWORD) {
//                token = lexer.nextToken();
//            }
//        } else if(token.getType() == Token.ID) {
//            string();
//        }
//    }
//    //literalArray : LITARR_START literalArrayRest;
//    public void literalArray() {
//        if(token.getType() == Token.LITARR_START) {
//            token = lexer.nextToken();
//            literalArrayRest();
//        }
//    }
//    //literalArrayRest : ws? ((parsetimeLiteral | bareLiteralArray | bareSymbol) ws?)* CLOSE_PAREN;
//    public void literalArrayRest() {
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        while(token.getType() == Token.ID || token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.CHARACTER_CONSTANT || token.getType() == Token.HEX || token.getType() == Token.MINUS || token.getType() == Token.DIGIT || token.getType() == Token.PERIOD || token.getType() == Token.RESERVED_WORD || token.getType() == Token.STRING || token.getType() == Token.HASH || token.getType() == Token.LT || token.getType() == Token.GT) {
//            if(token.getType() == Token.ID) {
//                parsetimeLiteral();
//            } else if(token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.CHARACTER_CONSTANT || token.getType() == Token.HEX || token.getType() == Token.MINUS || token.getType() == Token.DIGIT || token.getType() == Token.PERIOD || token.getType() == Token.RESERVED_WORD || token.getType() == Token.STRING || token.getType() == Token.HASH || token.getType() == Token.LT || token.getType() == Token.GT) {
//                bareLiteralArray();
//            } else if(token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.STRING) {
//                bareSymbol();
//            }
//            if(token.getType() == Token.WS) {
//                ws();
//            }
//        }
//        if(token.getType() == Token.CLOSE_PAREN) {
//            token = lexer.nextToken();
//        }
//    }
//    //bareLiteralArray : OPEN_PAREN literalArrayRest;
//    public void bareLiteralArray() {
//        if(token.getType() == Token.OPEN_PAREN) {
//            token = lexer.nextToken();
//            literalArrayRest();
//        }
//    }
//    //unaryTail : unaryMessage ws? unaryTail? ws?;
//    public void unaryTail() {
//        unaryMessage();
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        if(token.getType() == Token.ID || token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.CHARACTER_CONSTANT || token.getType() == Token.HEX || token.getType() == Token.MINUS || token.getType() == Token.DIGIT || token.getType() == Token.PERIOD || token.getType() == Token.RESERVED_WORD || token.getType() == Token.STRING || token.getType() == Token.HASH || token.getType() == Token.LT || token.getType() == Token.GT) {
//            unaryTail();
//        }
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//    }
//    //unaryMessage : ws? unarySelector;
//    public void unaryMessage() {
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        unarySelector();
//    }
//    //unarySelector : IDENTIFIER;
//    public void unarySelector() {
//        if(token.getType() == Token.IDENTIFIER) {
//            token = lexer.nextToken();
//        }
//    }
//    //keywords : KEYWORD+;
//    public void keywords() {
//        while(token.getType() == Token.KEYWORD) {
//            token = lexer.nextToken();
//        }
//    }
//    //reference : variable;
//    public void reference() {
//        variable();
//    }
//    //binaryTail : binaryMessage binaryTail?;
//    public void binaryTail() {
//        binaryMessage();
//        if(token.getType() == Token.ID || token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.CHARACTER_CONSTANT || token.getType() == Token.HEX || token.getType() == Token.MINUS || token.getType() == Token.DIGIT || token.getType() == Token.PERIOD || token.getType() == Token.RESERVED_WORD || token.getType() == Token.STRING || token.getType() == Token.HASH || token.getType() == Token.LT || token.getType() == Token.GT) {
//            binaryTail();
//        }
//    }
//
//    //binaryMessage : ws? BINARY_SELECTOR ws? (unarySend | operand);
//    public void binaryMessage() {
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        if(token.getType() == Token.BINARY_SELECTOR) {
//            token = lexer.nextToken();
//        }
//        if(token.getType() == Token.WS) {
//            ws();
//        }
//        if(token.getType() == Token.ID || token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.CHARACTER_CONSTANT || token.getType() == Token.HEX || token.getType() == Token.MINUS || token.getType() == Token.DIGIT || token.getType() == Token.PERIOD || token.getType() == Token.RESERVED_WORD || token.getType() == Token.STRING || token.getType() == Token.HASH || token.getType() == Token.LT || token.getType() == Token.GT) {
//            unarySend();
//        } else if(token.getType() == Token.IDENTIFIER || token.getType() == Token.BINARY_SELECTOR || token.getType() == Token.KEYWORD || token.getType() == Token.STRING) {
//            operand();
//        }
//    }
//
//}
