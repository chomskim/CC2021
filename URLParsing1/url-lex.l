%{
/* 
*	Lex Program for URI Parse
*	programmed by cskim, CSE, hufs.ac.kr
*	Copy Right -- Free for Educational Purpose
*
*/

extern int atoi(const char*);
%}

alpha			[a-zA-Z]
digit			[0-9]
alphanum		{alpha}|{digit}
hex				{digit}|[A-Fa-f]
escaped			"%"{hex}{hex}
unreserved		{alphanum}|[-$_.+!*'(),]
xchar1			{unreserved}|{escaped}|[;?:@&=]
xchar			{unreserved}|{escaped}|[;?:@&=/]
digits			{digit}+

space			[\ \t]

scheme			{alpha}({alpha}|{digit}|[-+])*

userinfo		({unreserved}|{escaped}|[$,;:@&=+])+

domainlabel		{alphanum}|{alphanum}({alphanum}|"-")*{alphanum}
toplabel		{alpha}|{alpha}({alphanum}|"-")*{alphanum}
hostname		({domainlabel}".")*{toplabel}"."?
IPv4address		{digit}+"."{digit}+"."{digit}+"."{digit}+
host			{hostname}|{IPv4address}

port			{digits}

pchar			{unreserved}|{escaped}|[$,:@&=+]
param			{pchar}*
segment			{param}(";"{param})*
path			"/"{segment}("/"{segment}|"/")*

query			{xchar}*

fragment		{xchar}*

%start SCHEME SCHEMEPART AUTH HOST
%%

<INITIAL>{scheme}":"			{ printf("scheme=%s\n", yytext); BEGIN SCHEME; }
<SCHEME>"//"					{ BEGIN AUTH; }
<SCHEME>"/"{xchar1}{xchar}*		{ printf("schemepart=%s\n", yytext); BEGIN SCHEMEPART; }
<SCHEME>{xchar1}{xchar}*		{ printf("schemepart=%s\n", yytext); BEGIN SCHEMEPART; }
<AUTH>{userinfo}"@"				{ printf("userinfo=%s\n", yytext); }
<AUTH>{host}					{ printf("host=%s\n", yytext); BEGIN HOST; }
<HOST>":"{port}					{ printf("port=%s\n", yytext); }
<HOST>{path}					{ printf("path=%s\n", yytext); }
<HOST>"?"{query}				{ printf("query=%s\n", yytext); }
<HOST>"#"{fragment}				{ printf("fragment=%s\n", yytext); }
<HOST>{space}*$					{ BEGIN INITIAL; }
<SCHEMEPART>{space}*$			{ BEGIN INITIAL; }
%%
