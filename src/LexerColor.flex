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

/* Identificador  */
Letra = [A|B|C|D|E|F|G]
/*DigitoEscala = [1-8]*/
Digito = [1-9][1-6]?
/*Clave = {Letra}{Digito} //G16 es un error sintactico o semantico??*/
Nota = {Letra}{Digito}["#"|"-"]?["*"]?
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/*Numeros*/
{Digito}  { return textColor(yychar, yylength(), new Color(189,147,249)); }

/*Notas*/
{Nota} {return textColor(yychar, yylength(), new Color(165,194,97)); }
/*{Clave} {return textColor(yychar, yylength(), new Color(165,194,97)); }*/
"*"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }
"#"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }
"-"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }

/*Encabezado*/
\\"clave"  { return textColor(yychar, yylength(), new Color(139,233,253)); }
\\"compas" { return textColor(yychar, yylength(), new Color(139,233,253)); }
\\"tempo"  { return textColor(yychar, yylength(), new Color(139,233,253)); }

/*Secciones*/
\\"inicio(" { return textColor(yychar, yylength(), new Color(139,233,253)); }
\\"final)"  { return textColor(yychar, yylength(), new Color(139,233,253)); }

/*Notas*/
\\"r"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"b"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"n"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"c"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"s"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"f"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }
\\"sf"	 { return textColor(yychar, yylength(), new Color(255,121,198)); }

/*Silencio notas*/
\\"sir"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sib"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sin"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sic"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sis"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sif"	 { return textColor(yychar, yylength(), new Color(241,250,140)); }
\\"sisf" { return textColor(yychar, yylength(), new Color(241,250,140)); }

/*Compases*/
"/"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }
"|"	 { return textColor(yychar, yylength(), new Color(255,184,108)); } 
"{"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }
"}"	 { return textColor(yychar, yylength(), new Color(255,184,108)); }
"="      { return textColor(yychar, yylength(), new Color(255,184,108)); }
","	 { return textColor(yychar, yylength(), new Color(255,184,108)); }