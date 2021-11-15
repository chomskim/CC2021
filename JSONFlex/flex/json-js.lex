%{
#include <string.h>
#include "util.h"
#include "json-tokens.h"
#include "errormsg.h"

extern int atoi(const char*);
%}

%start C S S0

digit		[0-9]
integer		{digit}+
fraction	"."{digit}*
exponent	[eE][-+]?{integer}
ws			[\ \t]
%%

<INITIAL>\n				{ EM_newline(); continue; }
<INITIAL>{ws}			{ continue; }

<INITIAL>-?{integer}{fraction}?{exponent}?	{ yylval.sval = yytext; return NUMBER; }

<INITIAL>","			{ return COMMA; }
<INITIAL>"["            { return LBRACK; }
<INITIAL>"]"            { return RBRACK; }
<INITIAL>"{"            { return LBRACE; }
<INITIAL>"}"            { return RBRACE; }
<INITIAL>":"            { return COLON; }

<INITIAL>false			{ return _FALSE; }
<INITIAL>null			{ return _NULL; }
<INITIAL>true			{ return _TRUE; }

<INITIAL>\"				{ BEGIN S0; clearbuf(); continue; }
<S0>[_$a-zA-Z][_$a-zA-Z0-9]*\"		{
							BEGIN INITIAL; yylval.sval = String1(yytext);
							return STRING_IDENT;
						}
<S0>.					{ BEGIN S; unput(yytext[0]); }
<S>[^"\\\n]				{ putbuf(yytext[0]); continue; }
<S>\"					{ BEGIN INITIAL; yylval.sval = String(strbuf);
		  					return STRING;
						}
<S>\n					{ EM_error("Unclosed string"); 
		  					BEGIN INITIAL; continue;
						}
<S>\\t					{ putbuf('\\'); putbuf('t'); continue; }
<S>\\n					{ putbuf('\\'); putbuf('n'); continue; }
<S>\\\"					{ putbuf('\"'); continue; }
<S>\\\\					{ putbuf('\\'); continue; }
<S>\\					{ EM_error("Illegal string escape"); continue; }

.						{ EM_error("illegal token"); }

%%
