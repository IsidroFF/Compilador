import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-záéíóúÁÉÍÓÚ,:;]
Funcion = [""|-]?\{Letra}{Letra}*
Digito = [0-9]
letrasGriegas = (alpha | beta | gamma | delta | zeta | eta | iota | kappa | lambda | mu | nu | xi | omicron | tau | upsilon | chi | psi | omega)
Identificador = {Letra}({Letra}|{Digito})*

/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/*Numeros*/
{Numero} { return textColor(yychar, yylength(), new Color(128, 0, 128)); }
{Numero}[.]{Digito}* { return textColor(yychar, yylength(), new Color(128, 0, 128)); }

/*Letras griegas*/ 
\\{letrasGriegas} { return textColor(yychar, yylength(), new Color(0, 0, 255)); }

/*Constantes universales*/
\\pi { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
\\epsilon { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
\\phi { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
\\sigma { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
\\theta { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
\\rho { return textColor(yychar, yylength(), new Color(0, 128, 0)); }

/*Operadores*/
"+"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"-"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"*"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"/"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"="   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"^"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
">"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"<"   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
">="   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }
"<="   { return textColor(yychar, yylength(), new Color(255, 0, 0)); }

/*Funciones*/
\\"sqrt" { return textColor(yychar, yylength(), new Color(192, 192, 0)); }
\\"sen" { return textColor(yychar, yylength(), new Color(192, 192, 0)); }
\\"cos" { return textColor(yychar, yylength(), new Color(192, 192, 0)); }
\\"abs" { return textColor(yychar, yylength(), new Color(192, 192, 0)); }

/*Agrupacion*/
"(" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
")" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
"{" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
"}" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
"<!inicio" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
"fin!>" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }
"$" { return textColor(yychar, yylength(), new Color(255, 192, 203)); }

/*Texto*/
{Identificador} { return textColor(yychar, yylength(), new Color(255, 165, 0)); }

. { /* Ignorar */ }