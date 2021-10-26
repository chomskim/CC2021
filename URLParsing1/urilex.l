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

lowalpha	[a-z]
upalpha		[A-Z]
alpha		{lowalpha} | {upalpha}
digit		[0-9]
alphanum	{alpha} | {digit}
reserved	[;/?:@&=+$,]
mark		[-_\.!~*'()]
unreserved	{alphanum} | {mark}
hex			{digit} | [A-Fa-f]
escaped		%{hex}{hex}
space		[\ \t]
delims		[<>#%\"]
unwise		["{}|\\^[]`"]
uric		{reserved} | {unreserved} | {escaped}

scheme		{alpha} ({alpha} | {digit} | [+-\.])*

reg_name	({unreserved} | {escaped} | [$,;:@&=+])+
userinfo	({unreserved} | {escaped} | [$,;:@&=+])*
domainlevel	{alphanum} | {alphanum}({alphanum} | "-")*{alphanum}
toplabel	{alpha} | {alpha} ({alphanum} | "-")*{alphanum}
IPv4address	{digit}+ "." {digit}+ "." {digit}+ "." {digit}+
port		{digit}*
hostname	({domainlabel} ".")* {toplabel} "."?
host		{hostname} | {IPv4address}
hostport	{host}(:{port})?
server		(({useinfo}@)? {hostport})?

authority	{server} | {reg_name}

pchar		{unreserved} | {escaped} | [:@&=+$,]
param		{pchar}*
segment		{pchar}*(;{param})*
path_segmane	{segment}("/"{segment})*
abs_path	"/"{path_segments}
net_path	"//" {authority}{abs_path}?

uric_no_slash	{unreserved} | {escaped} | [;?:@&=+$,]
opaque_part	{uric_no_slash} {uric}*
path		{abs_path} | {opaque_part}

query		"?"{uric}*
fragment	"#"{uric}*
hier_part	({net_path} | {abs_path}){query}?
absoluteURI	{scheme} ":" ({hier_part} | {opaque_part}){fragment}?

%%

{scheme}	{ printf("%s", yytext); }
{query}		{ printf("%s", yytext); }
{fragment}	{ printf("%s", yytext); }

%%
