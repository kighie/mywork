/** 
 * Copyright (c) 2012 IkChan Kwon kighie@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
grammar Calcula;

options {
	language = Java;
}


@parser::header {
	package kr.simula.calcula.antlr;
	
	import java.util.List;
	import java.util.LinkedList;
	
	import kr.simula.calcula.core.*;
	import kr.simula.calcula.core.builder.*;
	import kr.simula.calcula.def.*;
}

@parser::members {
  	private CalculaHandler handler;
  	
  	public CalculaParser(TokenStream input, CalculaHandler calculaHandler){
  		this(input);
  		setBuilder(calculaHandler);
  	}
  	
  	public void setBuilder(CalculaHandler calculaHandler){
  		this.handler = calculaHandler;
  	}
  	

	public String strip( String text ) {
    	if( text != null && text.length() >= 4 ) {
    		text = text.substring( 1, text.length() - 1 );
    		text = text.replaceAll( "\'", "'" );
    		text = text.replaceAll( "\"", "\\\"" );
    	}
    	return text;
	}
}


@rulecatch {
	catch (RecognitionException re) {
	    throw re;
	} 
	catch (BuildException dsle) {
		TokenStream cts = (TokenStream)input;
		dsle.setToken(cts.get(cts.index()));
	    throw dsle;
	}
}

@lexer::header {
	package kr.simula.calcula.antlr;
}


tokens {
  	NEGATION
}


/* *************************************
 * Formula Expression
 *************************************** */

formulaExpression returns [Node result]
	: 
	( '=' '(' formulaExpressionBase ')' { $result = $formulaExpressionBase.result ; } )
	| ( '=' formulaExpressionBase { $result = $formulaExpressionBase.result ; } )
	;

formulaExpressionBase returns [Node result]
	: 
	(
	operatorExpression { $result = $operatorExpression.result ; }
	| funcCallExp { $result =  $funcCallExp.result ; }
	| methodCallExp { $result =  $methodCallExp.result ; }
	) 
	;

funcCallExp returns [Gettable result]
	: IDENT '(' arguments? ')' 
		{ $result = handler.functionCall($IDENT.text, $arguments.nodeList) ;}
	;

methodCallExp returns [Node result]
	: qualifiedName '.' IDENT '(' arguments? ')'
	;

arguments  returns [List<Node> nodeList]
	: { $nodeList = new LinkedList<Node>(); }
	( operatorExpression { $nodeList.add($operatorExpression.result); } 
		(',' arg2 = operatorExpression { $nodeList.add($arg2.result); })*
	)?
	;

formulaTerm returns [Node result]
	: BOOLEAN 			{ $result = handler.literal( ExprTokens.LIT_BOOLEAN, $BOOLEAN.text); }
	| STRING_LITERAL	{ $result = handler.literal( ExprTokens.LIT_STRING,  strip($STRING_LITERAL.text)); }
	| NUMBER			{ $result = handler.literal( ExprTokens.LIT_NUMBER, $NUMBER.text); }
	| IDENT				{ $result = handler.reference( $IDENT.text); }
	| qualifiedName		{ $result = $qualifiedName.result; }
	| funcCallExp		{ $result = $funcCallExp.result; }
	| methodCallExp
	;

qualifiedName returns [Ref result]
	: IDENT 	{ $result = handler.reference( $IDENT.text); }
	('.' IDENT	{ $result = handler.reference( $result, $IDENT.text); } )* 
	;

/* *****************************
 * Numeric Expression
 ******************************/

unary  returns [Node result]
	:  { boolean negative = false; }
		( '-' { negative = true; } )? ( 
		formulaTerm { $result = $formulaTerm.result;  }
		| '(' operatorExpression ')' { $result = $operatorExpression.result;  }
		) 
		{ 
			if(negative){
				$result = handler.operator(ExprTokens.OP_NUM_NEGATION, $result );
			} 
		}
	;

multiplicative returns [Node result]
    :	unary 	{ $result = $unary.result;  }
    	(
    		'*' 		op2 = unary 	{$result = handler.operator(ExprTokens.OP_MULTI, $result, $op2.result); }
    		| '/' 		op2 = unary  	{$result = handler.operator(ExprTokens.OP_DIVIDE, $result, $op2.result); }
    		| '%'		op2 = unary  	{$result = handler.operator(ExprTokens.OP_MOD, $result, $op2.result); }
    	)*
    ;
    
additiveExpression returns [Node result]
    :   multiplicative { $result = $multiplicative.result;  }
    ( 
    	'+' 	op2 = multiplicative	{$result = handler.operator(ExprTokens.OP_PLUS, $result, $op2.result); }
    	| '-' 	op2 = multiplicative	{$result = handler.operator(ExprTokens.OP_MINUS, $result, $op2.result); }
    )*
    ;
    
/*
	String Expression
*/

stringExpression returns [Node result]
    :   additiveExpression { $result = $additiveExpression.result;  }
    ( 
    	'&' op2 = additiveExpression {$result = handler.operator(ExprTokens.OP_CONCAT, $result, $op2.result); }
    )* 
    ;
  
/*
	Logical Expression
*/
comparison returns [Node result]
	: stringExpression  { $result = $stringExpression.result;  }
	( 
		'='  op2 = stringExpression {$result = handler.operator(ExprTokens.OP_EQ, $result, $op2.result); }
		|'!=' op2 = stringExpression {$result = handler.operator(ExprTokens.OP_NOT_EQ, $result, $op2.result); }
		|'<>' op2 = stringExpression {$result = handler.operator(ExprTokens.OP_NOT_EQ, $result, $op2.result); }
		|'>'  op2 = stringExpression {$result = handler.operator(ExprTokens.OP_GT, $result, $op2.result); }
		|'>=' op2 = stringExpression {$result = handler.operator(ExprTokens.OP_EQ_GT, $result, $op2.result); }
		|'<'  op2 = stringExpression {$result = handler.operator(ExprTokens.OP_LT, $result, $op2.result); }
		|'<=' op2 = stringExpression {$result = handler.operator(ExprTokens.OP_EQ_LT, $result, $op2.result); }
	)*
	;
	
notExpression returns [Node result]
	: 
	(
		comparison { $result = $comparison.result;  }
		| 'not' comparison {$result = handler.operator(ExprTokens.OP_NOT, $comparison.result); }
		| 'NOT' comparison {$result = handler.operator(ExprTokens.OP_NOT, $comparison.result); }
		
	)
	;
	
logicalExpression returns [Node result]
	: notExpression { $result = $notExpression.result;  }
	( 
		'and' 	op2 = operatorExpression {$result = handler.operator(ExprTokens.OP_AND, $result, $op2.result); }
		| 'AND'	op2 = operatorExpression {$result = handler.operator(ExprTokens.OP_AND, $result, $op2.result); }
		|'or' 	op2 = operatorExpression {$result = handler.operator(ExprTokens.OP_OR, $result, $op2.result); }
		| 'OR' 	op2 = operatorExpression {$result = handler.operator(ExprTokens.OP_OR, $result, $op2.result); } 
		
	)*
	;
    
operatorExpression returns [Node result]
	: logicalExpression { $result = $logicalExpression.result;  }
	;
    
    
/* *********************************************
	Lexer rules
********************************************* */
fragment DIGIT	: '0'..'9' ;

/* LATIN ALPAHBETs, $, _ and Korean charset*/
fragment LETTER
    : 	'$'
    	| 'A'..'Z' 
    	| '_' | 'a'..'z'
    	| '\uAC00'..'\uD7AF'
    	| '\u3130'..'\u318F'
//       | '\u1100'..'\u11FF'
    ;

NUMBER : DIGIT+ ('.' DIGIT+)? ;

STRING_LITERAL
	:	( '"' ( ~('"'|'\r'|'\n') )* '"' )
		| ( '\'' ( ~('\''|'\r'|'\n') )* '\'' )
	;

BOOLEAN :	('true' | 'false' | 'TRUE' | 'FALSE') ;
IDENT :  LETTER (LETTER|DIGIT)* ;

WS : (' ' | '\t'| '\n'| '\r'| '\f') + -> channel(HIDDEN);

COMMENT : '//' ()* EOL -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' ()* '*/' -> channel(HIDDEN);

fragment EOL 	
	:	(	( '\r\n' ) // DOS
		|	'\r'    // OSX
		|	'\n'    // Unix 
		)
	;
