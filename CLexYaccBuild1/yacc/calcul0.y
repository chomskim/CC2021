%{
#include	<stdio.h>
static double store [26];

%}

%union { 
	double num;
	int id;
}

%token	<num>	NUM
%token	<id>	IDENT
%token	PRINT ASSIGN SEMI NL
%token	'+'	'-'	'*'	'/'	'('	')'
%type	<num> expression term factor

%%

program
	: statements
	  { printf ("END\n"); }
statements
	: statements SEMI statement
	| statements NL statement
	| statement
statement
	: IDENT ASSIGN expression
	  { store [$<id>1-'a'] = $<num>3; }
	| PRINT expression
	  { printf ("%f\n", $<num>2); }
	| /* empty */
expression
	: expression '+' term
	  { $$ = $1 + $3; }
	| expression '-' term
	  { $$ = $1 - $3; }
	| term
term
	: term '*' factor
	  { $$ = $1 * $3; }
	| term '/' factor
	  { $$ = $1 / $3; }
	| factor
factor
	: '(' expression ')'
	  { $$ = $2; }
	| IDENT
	  { $$ = store [$<id>1-'a']; }
	| '-' IDENT
	  { $$ = -store [$<id>2-'a']; }
	| NUM

%%
void yyerror (char* s) {
	printf ("***Error:%s\n", s);
}

int main ()
{
	yyparse ();
}