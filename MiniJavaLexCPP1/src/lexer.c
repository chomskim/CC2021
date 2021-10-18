/*
 * lexer.c
 *
 *  Created on: 2012. 9. 20.
 *      Author: cskim
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include "util.h"
#include "errormsg.h"
#include "tokens.h"

FILE *yyin;

char ch = -1;
int state = 0;

enum { DIGIT, LETTER, SPECIAL, WHITESPACE };
int charClass(char ch){
	if (ch >= '0' && ch <= '9')
		return DIGIT;
	else if ((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <='Z') || ch == '$' || ch == '_')
		return LETTER;
	else if ((ch == ' ' || ch == '\t' || ch == '\n'))
		return WHITESPACE;
	else
		return SPECIAL;
}

int yylex(){
	clearbuf();
	if (ch == -1)
		ch = getc(yyin);

	while (1){

		switch (state) {
		case 0:
			if (charClass(ch) == DIGIT){
				putbuf(ch);
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 1;
			}
			else if (charClass(ch) == LETTER){
				putbuf(ch);
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 2;
			}
			else {
				state = 99;
			}
			break;
		case 1:
			if (charClass(ch) == DIGIT){
				putbuf(ch);
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 1;
			}
			else {
				yylval.ival = atoi(String(strbuf));
				state = 0;
				return INTLIT;
			}
			break;
		case 2:
			if (charClass(ch) == DIGIT || charClass(ch) == LETTER){
				putbuf(ch);
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 2;
			}
			else {
				yylval.sval = String(strbuf);
				state = 0;
				return ID;
			}
			break;
		case 99:
			if (charClass(ch) == WHITESPACE){
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 0;
			}
			else {
				int tok = ch;
				ch = getc(yyin);
				if (ch==EOF) return 0;
				state = 0;
				return tok;
			}
			break;
		}
	}
}
