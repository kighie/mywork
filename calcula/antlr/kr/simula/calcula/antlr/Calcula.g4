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
	import kr.simula.calcula.builder.*;
}

@parser::members {
  	private CalculaBuilder calculaBuilder;
  	
  	public CalculaParser(TokenStream input, CalculaBuilder calculaBuilder){
  		this(input);
  		setBuilder(calculaBuilder);
  	}
  	
  	public void setBuilder(CalculaBuilder calculaBuilder){
  		this.calculaBuilder = calculaBuilder;
  	}
  	

	public String stripString( String text ) {
    	if( text != null && text.length() >= 4 ) {
    		text = text.substring( 1, text.length() - 1 );
    		text = text.replaceAll( "\'", "'" );
    		text = text.replaceAll( "\"", "\\\"" );
    	}
    	return text;
	}
}

@lexer::header {
	package kr.simula.calcula.antlr;
}

/* *************************************
 * Formula Expression
 *************************************** */

funcExp  
	: IDENT '(' term (',' term )+  ')'
	;


term
	: BOOLEAN
	| STRING_LITERAL
	| NUMBER
	| IDENT

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

NUMBER :   DIGIT+ ('.' DIGIT+)? ;

STRING_LITERAL
	:	( '"' ( ~('"'|'\r'|'\n') )* '"' )
		| ( '\'' ( ~('\''|'\r'|'\n') )* '\'' )
	;

BOOLEAN :	('true' | 'false' | 'TRUE' | 'FALSE') ;
IDENT :  LETTER (LETTER|DIGIT)* ;

WS : (' ' | '\t'| '\n'| '\r'| '\f') + -> channel(HIDDEN);

COMMENT : '//' .* ('\n' | '\r') -> channel(HIDDEN);
MULTILINE_COMMENT : '/*' .* '*/' -> channel(HIDDEN);

fragment EOL 	
	:	(	( '\r\n' ) // DOS
		|	'\r'    // OSX
		|	'\n'    // Unix 
		)
	;
