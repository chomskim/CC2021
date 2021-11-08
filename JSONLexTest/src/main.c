/*
 * driver.c
 *
 *  Created on: 2010. 9. 1.
 *      Author: cskim
 */
#include <stdio.h>
#include "util.h"
#include "errormsg.h"
#include "json-tokens.h"

YYSTYPE yylval;

int yylex(); /* prototype for the lexing function */



string toknames[] = {
"STRING", "NUMBER", "COMMA", "COLON", "LBRACK",
"RBRACK", "LBRACE", "RBRACE", "TRUE", "FALSE", "NULL"
};

string tokname(tok) {
  return tok<257 || tok>302 ? "BAD_TOKEN" : toknames[tok-257];
}

int main(int argc, char **argv)
{
   string fname; int tok;
   //if (argc!=2) {fprintf(stderr,"usage: a.out filename\n"); exit(1);}
   fname="test.json";
   EM_open(fname);
   for(;;) {
      tok=yylex();
      if (tok==0) break;
      switch(tok) {
      case STRING: case NUMBER:
         printf("%s (%s)\n",tokname(tok),yylval.sval);
         break;
      default:
         printf("%s \n",tokname(tok));
      }
   }
   return 0;
}

