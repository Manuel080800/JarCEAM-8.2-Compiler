package sistemaAnalisis;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sistemaEdicion.JClass_AnalizadorEdicionCodigo;
import sistemaEdicion.JClass_EstructuraEdicionCodigo;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraExpresiones;
import sistemaProcesamiento.JClass_EstructuraSimbolos;
import sistemaProcesamiento.JClass_EstructuraTokens;

public class JClass_AnalisisLexico 
{
    private JClass_EstructuraExpresiones estructuraExpresiones = null;
    private JClass_EstructuraSimbolos estructuraSimbolos = null;
    private JClass_EstructuraErrores estructuraErrores = null;
    private JClass_EstructuraTokens estructuraTokens = null;
    private JClass_AnalizadorEdicionCodigo analisisEdicionCodigo = null;
    
    private String [] expresionesRegularesAdicionales = {"\"(.)*\"", "'.'"};
    private String [] prefijoRegularAdicional = {"STR", "CHR"};
    private int [] contadorRegularAdicional = {0, 0};

    public JClass_AnalisisLexico(JClass_EstructuraExpresiones estructuraExpresiones, JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores, JClass_EstructuraTokens estructuraTokens, JClass_AnalizadorEdicionCodigo analisisEdicionCodigo) 
    {
        this.estructuraExpresiones = estructuraExpresiones;
        this.estructuraSimbolos = estructuraSimbolos;
        this.estructuraErrores = estructuraErrores;
        this.estructuraTokens = estructuraTokens;
        this.analisisEdicionCodigo = analisisEdicionCodigo;
    }
    
    public void realizarAnalisisLexico (ArrayList <String> registroProcesos)
    {
        registroProcesos.add("INICIO DE ANALISIS CONTENIDO LEXICO (ETAPA 1/3): \n\n");
        
        if (this.analisisEdicionCodigo.recuperarTotalLineaCodigo() == 0)
        {
            registroProcesos.add("      No existe contenido para analizar. \n\n");
        }
        
        for (int i = 0; i < this.analisisEdicionCodigo.recuperarTotalLineaCodigo(); i++) 
        {
            registroProcesos.add("Inicio de analisis de contenido lexico de la linea " + (i + 1) + ": \n\n");
            
            JClass_EstructuraEdicionCodigo estructuraEdicion = this.analisisEdicionCodigo.recuperarEstructuraEdicionCodigo(i);
            
            for (int j = 0; j < estructuraEdicion.recuperarTotalEstructuraContenidoEdicion(); j++) 
            {
                Boolean estructuraEncontrada = false;
                
                for (int a = 0; a < this.estructuraExpresiones.recuperarTotalExpresiones(); a++) 
                {
                    Pattern expresionRegular = Pattern.compile(this.estructuraExpresiones.recuperarExpresionRegular(a));
                    Matcher segmentoEvaluar = expresionRegular.matcher(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                    
                    if (segmentoEvaluar.matches())
                    {   
                        registroProcesos.add("      Palabra: " + (j + 1) + " --> [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] -- Expresion --> [ " + this.estructuraExpresiones.recuperarExpresionRegular(a) + " ] \n");
                        String tokenGenerado = this.estructuraExpresiones.recuperarPrefijoRegular(a) + (this.estructuraExpresiones.recuperarContadorRegular(a) + 1);
                
                        if (this.estructuraSimbolos.registrarSimbolos(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), tokenGenerado) == true)
                        {
                            this.estructuraTokens.escribirLineaContenidoToken(tokenGenerado);
                            this.estructuraExpresiones.incrementarContadorRegular(a);
                            registroProcesos.add("      Registro exitoso de palabra --> [ " + tokenGenerado + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] \n");
                            registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenGenerado + " ] \n\n");
                        }

                        else
                        {
                            int posicionToken = this.estructuraSimbolos.encontrarLexenaRegular(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                            tokenGenerado = this.estructuraSimbolos.recuperarTokenRegular(posicionToken);
                            this.estructuraTokens.escribirLineaContenidoToken(tokenGenerado);
                            registroProcesos.add("      Palabra registrada anteriormenete --> [ " + tokenGenerado + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] \n");
                            registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenGenerado + " ] \n\n");
                        }
                        
                        estructuraEncontrada = true;
                        break;
                    }
                }
                
                if (estructuraEncontrada == false)
                {
                    for (int a = 0; a < this.expresionesRegularesAdicionales.length; a++) 
                    {    
                        Pattern expresionRegular = Pattern.compile(this.expresionesRegularesAdicionales [a]);
                        Matcher segmentoEvaluar = expresionRegular.matcher(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));

                        if (segmentoEvaluar.matches())
                        {
                            registroProcesos.add("      Palabra: " + (j + 1) + " --> [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] -- Expresion adicional --> [ " + this.expresionesRegularesAdicionales [a] + " ] \n");
                            
                            String tokenGenerado = this.prefijoRegularAdicional [a] + (this.contadorRegularAdicional [a] + 1);
                
                            if (this.estructuraSimbolos.registrarSimbolos(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), tokenGenerado) == true)
                            {
                                this.estructuraTokens.escribirLineaContenidoToken(tokenGenerado);
                                this.contadorRegularAdicional [a] ++;
                                
                                registroProcesos.add("      Registro exitoso de palabra --> [ " + tokenGenerado + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] \n");
                                registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenGenerado + " ] \n\n");
                            }

                            else
                            {
                                int posicionToken = this.estructuraSimbolos.encontrarLexenaRegular(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                                tokenGenerado = this.estructuraSimbolos.recuperarTokenRegular(posicionToken);
                                this.estructuraTokens.escribirLineaContenidoToken(tokenGenerado);
                                
                                registroProcesos.add("      Palabra registrada anteriormenete --> [ " + tokenGenerado + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] \n");
                                registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenGenerado + " ] \n\n");
                            }
                            
                            estructuraEncontrada = true;
                            break;
                        }
                    }
                    
                    if (estructuraEncontrada == false)
                    {
                        registroProcesos.add("      Palabra: " + (j + 1) + " --> [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ] no coincidio con alguna expresion regular. \n");
                        
                        String tokenError = "ERL" + (this.estructuraErrores.recuperarTotalErrores() + 1);

                        if (this.estructuraErrores.registrarError(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), tokenError, String.valueOf(i + 1), "Error léxico"))
                        {
                            this.estructuraTokens.escribirLineaContenidoToken(tokenError);
                            registroProcesos.add("      Registro exitoso de palabra erronea --> [ " + tokenError + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ]  -  [ " + String.valueOf(i + 1) + " ]  -  [ Error léxico ] \n");
                            registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenError + " ] \n\n");
                        }

                        else
                        {
                            int posicionToken = this.estructuraErrores.encontrarLexenaError(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                            tokenError = this.estructuraErrores.recuperarTokenError(posicionToken);
                            this.estructuraTokens.escribirLineaContenidoToken(tokenError);
                            
                            registroProcesos.add("      Palabra erronea registrada anteriormenete --> [ " + tokenError + " ]  -  [ " + estructuraEdicion.recuperarEstructuraContenidoEdicion(j) + " ]  -  [ " + String.valueOf(i + 1) + " ]  -  [ Error léxico ] \n");
                            registroProcesos.add("      Token escrito en el archivo de tokens --> [ " + tokenError + " ] \n\n");
                        }
                    }
                }
            }
            
            estructuraTokens.registrarLineaContenidoToken();
            registroProcesos.add("Final de analisis de contenido lexico de la linea " + (i + 1) + ". \n\n");
        }
        
        registroProcesos.add("FINAL DE ANALISIS CONTENIDO LEXICO (ETAPA 2/3). \n\n");
    }
}