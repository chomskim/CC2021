/*
 * main.c
 *
 *  Created on: 2021. 11. 8.
 *      Author: cskim
 */
#include <stdio.h>
#include "util.h"
#include "errormsg.h"
#include "json-tokens.h"


YYSTYPE yylval;

string toknames[] = {
		"STRING", "NUMBER", "COMMA", "COLON", "LBRACK",
		"RBRACK", "LBRACE", "RBRACE", "TRUE", "FALSE", "NULL"
};

string tokname(int tok) {
	return tok<257 || tok>302 ? "BAD_TOKEN" : toknames[tok-257];
}

int tok;
int FIRST_VALUE[] = { LBRACE, LBRACK, STRING, NUMBER, _TRUE, _FALSE, _NULL};

int isFIRST(int tok) {
	int i;
	for (i=0; i<7; i++) {
		if (tok == FIRST_VALUE[i]) {
			return TRUE;
		}
	}
	return FALSE;
}
void yyerror (char* s) {
	printf ("*** Error: %s\n", s);
}
void json (void) {
	value ();
	//printf ("END\n");
}
void value(void){
	if (tok==LBRACE) { // tok=={
		object();
	}
	else if (tok==LBRACK) { // tok==[
		array();
	}
	else if (tok==STRING) { // tok == STRING
		printf("\"%s\"",yylval.sval);
		tok = yylex ();
	}
	else if (tok==NUMBER) { // tok == NUMBER
		printf("%s",yylval.sval);
		tok = yylex ();
	}
	else if (tok==_TRUE) {
		printf("true");
		tok = yylex ();
	}
	else if (tok==_FALSE) {
		printf("false");
		tok = yylex ();
	}
	else if (tok==_NULL) {
		printf("null");
		tok = yylex ();
	}
	else {
		yyerror(tokname(tok));
	}
}
void object(void) {
	if (tok==LBRACE) { // tok=={
		printf("{");
		tok = yylex();
		members();
		if (tok==RBRACE) { // tok==}
			printf("}");
			tok = yylex();
		}
		else {
			yyerror("expect }");
		}
	}
	else {
		yyerror("expect {");
	}

}
void members (void) {
	member ();
	while (tok == COMMA) {
		printf(",");
		tok = yylex ();
		member ();
	}
}
void member (void) {
	if (tok == STRING) {
		printf("\"%s\"",yylval.sval);
		tok = yylex();
		if (tok == COLON) {
			printf(":");
			tok = yylex();
			value();
		}
		else {
			yyerror (": expected");
		}
	}
	else {
		yyerror ("STRING expected");
	}
}
void array (void) {
	if (tok == LBRACK) {
		printf("[");
		tok = yylex();
		values0();
		if (tok == RBRACK) {
			printf("]");
			tok = yylex();
		}
		else {
			yyerror ("] expected");
		}
	}
	else {
		yyerror ("[ expected");
	}
}
void values0 () {
	if (isFIRST(tok)) {
		values();
	}
}
void values() {
	value ();
	while (tok == COMMA) {
		printf(",");
		tok = yylex ();
		value ();
	}
}

int main (void) {
	string fname ="test.json";

	EM_open(fname);
	tok = yylex ();
	json();
	return 0;
}


