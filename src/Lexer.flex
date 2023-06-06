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
/*\int _{-\infty } ^{\pi }\:\log _7\left(\cot \left(\pi ^3\right)-7\right)*/
Letra = [A-Za-záéíóúÁÉÍÓÚ,.:;]
Funcion = [""|-]?\{Letra}{Letra}*
Digito = [0-9]
letrasGriegas = (alpha | beta | gamma | delta | zeta | eta | iota | kappa | lambda | mu | nu | xi | omicron | tau | upsilon | chi | psi | omega)
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }

/*Numeros*/
{Numero} { return token(yytext(), "NUMERO_ENTERO", yyline, yycolumn); }
{Numero}[.]{Digito}* { return token(yytext(), "NUMERO_REAL", yyline, yycolumn); }

/*Letras griegas*/ 
\\{letrasGriegas} { return token(yytext(), "LETRA_GRIEGA", yyline, yycolumn); }

/*Constantes universales*/
\\pi { return token(yytext(), "CU_PI", yyline, yycolumn); }
\\epsilon { return token(yytext(), "CU_EPSILON", yyline, yycolumn); }
\\phi { return token(yytext(), "CU_PHI", yyline, yycolumn); }
\\sigma { return token(yytext(), "CU_SIGMA", yyline, yycolumn); }
\\theta { return token(yytext(), "CU_THETA", yyline, yycolumn); }
\\rho { return token(yytext(), "CU_RHO", yyline, yycolumn); }

/*Operadores*/
"+"   { return token(yytext(), "OPERADOR_SUMA", yyline, yycolumn); }
"-"   { return token(yytext(), "OPERADOR_RESTA", yyline, yycolumn); }
"*"   { return token(yytext(), "OPERADOR_MULTIPLICACION", yyline, yycolumn); }
"/"   { return token(yytext(), "OPERADOR_DIVISION", yyline, yycolumn); }
"="   { return token(yytext(), "OPERADOR_IGUALACION", yyline, yycolumn); }
"^"   { return token(yytext(), "OPERADOR_POTENCIA", yyline, yycolumn); }
"_"   { return token(yytext(), "OPERADOR_SUBINIDCE", yyline, yycolumn); }
">"   { return token(yytext(), "OPERADOR_MAYORQUE", yyline, yycolumn); }
"<"   { return token(yytext(), "OPERADOR_MENORQUE", yyline, yycolumn); }
">="   { return token(yytext(), "OPERADOR_MAYORIGUAL", yyline, yycolumn); }
"<="   { return token(yytext(), "OPERADOR_MENORIGUAL", yyline, yycolumn); }

/*Funciones*/
\\"sqrt" { return token(yytext(), "FUNCION_SQRT", yyline, yycolumn); }
\\"sen" { return token(yytext(), "FUNCION_SEN", yyline, yycolumn); }
\\"cos" { return token(yytext(), "FUNCION_COS", yyline, yycolumn); }
\\"abs" { return token(yytext(), "FUNCION_ABS", yyline,yycolumn); }

/*Agrupacion*/
"(" { return token(yytext(), "AGRUPACION_INICIO_NIVEL1", yyline, yycolumn); }
")" { return token(yytext(), "AGRUPACION_FINAL_NIVEL1", yyline, yycolumn); }
"{" { return token(yytext(), "AGRUPACION_INICIO_NIVEL2", yyline, yycolumn); }
"}" { return token(yytext(), "AGRUPACION_FINAL_NIVEL2", yyline, yycolumn); }
"<!begin" { return token(yytext(), "AGRUPACION_INICIO_TEXT", yyline, yycolumn); }
"end!>" { return token(yytext(), "AGRUPACION_FINAL_TEXT", yyline, yycolumn); }
"$" { return token(yytext(), "INDICACION_MATEMATICA", yyline, yycolumn); }

/*Texto*/
{Identificador} { return token(yytext(), "TEXTO_PLANO", yyline, yycolumn); }

/*ERRORES*/
. { return token(yytext(), "ERROR", yyline, yycolumn); }
