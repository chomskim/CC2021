%{
/* 
*	Lex Program for URI Parse
*	programmed by cskim, CSE, hufs.ac.kr
*	Copy Right -- Free for Educational Purpose
*
*/
#include <string.h>
typedef union  {
	int ival;
	string sval;
	} YYSTYPE;
extern YYSTYPE yylval;
#include "errormsg.h"

extern int atoi(const char*);
%}

alpha		[a-zA-Z]
digit		[0-9]
alphanum	{alpha} | {digit}
reserved	[;/?:@&=+$,]
mark		[-_\.!~*'()]
unreserved	{alphanum} | {mark}
hex			{digit} | [A-Fa-f]
escaped		%{hex}{hex}
space		[\ \t]
uric		{reserved} | {unreserved} | {escaped}

scheme		{alpha} ({alpha} | {digit} | [+-\.])* ":"

userinfo	({unreserved} | {escaped} | [$,;:@&=+])+ "@"

domainlevel	{alphanum} | {alphanum}({alphanum} | "-")*{alphanum}
toplabel	{alpha} | {alpha} ({alphanum} | "-")*{alphanum}
hostname	({domainlabel} ".")* {toplabel} "."?
IPv4address	{digit}+ "." {digit}+ "." {digit}+ "." {digit}+
host		{hostname} | {IPv4address}

port		":" {digit}+

pchar		{unreserved} | {escaped} | [$,:@&=+]
param		{pchar}+
segment		{param} (";" {param})*
abs_path		"/" {segment}("/"{segment})*

authority	{useinfo}? {host} {port}?
net_path	"//" {authority}{abs_path}?

query		"?"{uric}*

fragment	"#"{uric}*

hier_part	{net_path} | {abs_path}
absoluteURI	{scheme} {hier_part} {query}? {fragment}?

%%

{absoluteURI}	{ printf("%s", yytext); }

%%
