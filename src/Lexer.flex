import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} 

/* Identificador  */
Letra = [A | B | C | D | E | F | G]
DigitoEscala = [1-8]
DigitoCompas = [1-9][1-6]?

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/*Numeros*/
{DigitoEscala}  { return token(yytext(), "TOKEN_DIGITO_ESCALA", yyline, yycolumn); }
{DigitoCompas}  { return token(yytext(), "TOKEN_DIGITO_COMPAS", yyline, yycolumn); }

/*Notas*/
{Letra}{DigitoEscala} { return token(yytext(), "TOKEN_NOTA", yyline, yycolumn); }

/*Encabezado*/
\\"clave"  { return token(yytext(), "TOKEN_CLAVE", yyline, yycolumn); }
\\"compas" { return token(yytext(), "TOKEN_COMPAS", yyline, yycolumn); }
\\"tempo"  { return token(yytext(), "TOKEN_TEMPO", yyline, yycolumn); }

/*Secciones*/
\\"inicio(" { return token(yytext(), "TOKEN_INICIO_PARTITURA", yyline, yycolumn); }
\\"final)"	 { return token(yytext(), "TOKEN_FINAL_PARTITURA", yyline, yycolumn); }

/*Figuras*/
\\"r"	 { return token(yytext(), "TOKEN_REDONDA", yyline, yycolumn); }
\\"b"	 { return token(yytext(), "TOKEN_BLANCA", yyline, yycolumn); }
\\"n"	 { return token(yytext(), "TOKEN_NEGRA", yyline, yycolumn); }
\\"c"	 { return token(yytext(), "TOKEN_CORCHEA", yyline, yycolumn); }
\\"s"	 { return token(yytext(), "TOKEN_SEMICORCHEA", yyline, yycolumn); }
\\"f"	 { return token(yytext(), "TOKEN_FUSA", yyline, yycolumn); }
\\"sf"	 { return token(yytext(), "TOKEN_SEMIFUSA", yyline, yycolumn); }

/*Silencio figura*/
\\"sr"	 { return token(yytext(), "TOKEN_SILENCIO_REDONDA", yyline, yycolumn); }
\\"sb"	 { return token(yytext(), "TOKEN_SILENCIO_BLANCA", yyline, yycolumn); }
\\"sn"	 { return token(yytext(), "TOKEN_SILENCIO_NEGRA", yyline, yycolumn); }
\\"sc"	 { return token(yytext(), "TOKEN_SILENCIO_CORCHEA", yyline, yycolumn); }
\\"ss"	 { return token(yytext(), "TOKEN_SILENCIO_SEMICORCHEA", yyline, yycolumn); }
\\"sf"	 { return token(yytext(), "TOKEN_SILENCIO_FUSA", yyline, yycolumn); }
\\"ssf"	 { return token(yytext(), "TOKEN_SILENCIO_SEMIFUSA", yyline, yycolumn); }

/*Extas*/
"*"	 { return token(yytext(), "TOKEN_PUNTILLO", yyline, yycolumn); }
"#"	 { return token(yytext(), "TOKEN_SOSTENIDO", yyline, yycolumn); }
"-"	 { return token(yytext(), "TOKEN_BEMOL", yyline, yycolumn); }

/*Compases*/
"/"	 { return token(yytext(), "TOKEN_DIVISOR_TEMPO", yyline, yycolumn); }
"|"	 { return token(yytext(), "TOKEN_DIVISOR_COMPAS", yyline, yycolumn); }
"{"	 { return token(yytext(), "TOKEN_APERTURA", yyline, yycolumn); }
"}"	 { return token(yytext(), "TOKEN_CIERRE", yyline, yycolumn); }
"="      { return token(yytext(), "TOKEN_ASIGNACION", yyline, yycolumn); }
","	 { return token(yytext(), "TOKEN_SEPARACION_COMPAS", yyline, yycolumn); }

/*ERRORES*/
. { return token(yytext(), "ERROR", yyline, yycolumn); }