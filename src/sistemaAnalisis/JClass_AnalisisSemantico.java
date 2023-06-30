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

public class JClass_AnalisisSemantico 
{
    private JClass_EstructuraExpresiones estructuraExpresiones = null;
    private JClass_EstructuraSimbolos estructuraSimbolos = null;
    private JClass_EstructuraErrores estructuraErrores = null;
    private JClass_EstructuraTokens estructuraTokens = null;
    private JClass_AnalizadorEdicionCodigo analisisEdicionCodigo = null;
    
    private String [] expresionesRegularesAdicionales = {"\"(.)*\"", "'.'"};
    private String [] prefijoRegularAdicional = {"STR", "CHR"};
    private int [] contadorRegularAdicional = {0, 0};
    
    private boolean asignacionTipoDatos = false;
    private boolean continuarComa = false;
    private String tipoDatoActual = "";
    private String tipoDatoSentencia = "";
    private int numeroPasoSemantico = 0;
    private int contadorErrorSemantico = 0;
    
    public JClass_AnalisisSemantico (JClass_EstructuraExpresiones estructuraExpresiones, JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores, JClass_EstructuraTokens estructuraTokens, JClass_AnalizadorEdicionCodigo analisisEdicionCodigo) 
    {
        this.estructuraExpresiones = estructuraExpresiones;
        this.estructuraSimbolos = estructuraSimbolos;
        this.estructuraErrores = estructuraErrores;
        this.estructuraTokens = estructuraTokens;
        this.analisisEdicionCodigo = analisisEdicionCodigo;
    }
    
    public void realizarAnalisisSemantico (ArrayList <String> registroProcesos)
    {
        registroProcesos.add("INICIO DE ANALISIS CONTENIDO SEMANTICO (ETAPA 2/3): \n\n");
        
        if (this.analisisEdicionCodigo.recuperarTotalLineaCodigo() == 0)
        {
            registroProcesos.add("      No existe contenido para analizar. \n\n");
        }
        
        for (int i = 0; i < this.analisisEdicionCodigo.recuperarTotalLineaCodigo(); i++) 
        {   
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
                        asignarTiposDatosInmediato(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), registroProcesos);
                        asignarTipoDatosIdentificador (estructuraEdicion.recuperarEstructuraContenidoEdicion(j), registroProcesos);
                        deteccionErroresSemanticos(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), (i + 1), registroProcesos);                   
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
                            asignarTiposDatosInmediato(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), registroProcesos);
                            asignarTipoDatosIdentificador (estructuraEdicion.recuperarEstructuraContenidoEdicion(j), registroProcesos);
                            deteccionErroresSemanticos(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), (i + 1), registroProcesos);
                            estructuraEncontrada = true;
                            break;
                        }
                    }
                    
                    if (estructuraEncontrada == false)
                    {
                        deteccionErroresSemanticos(estructuraEdicion.recuperarEstructuraContenidoEdicion(j), (i + 1), registroProcesos);
                    }
                }
            }            
        }
        
        registroProcesos.add("FINAL DE ANALISIS CONTENIDO SEMANTICO (ETAPA 3/3).");
    }
    
    private boolean asignarTiposDatosInmediato (String palabraAsignacion, ArrayList <String> registroProcesos)
    {
        int posicionPalabra = estructuraSimbolos.encontrarLexenaRegular(palabraAsignacion);
        
        if (posicionPalabra != -1)
        {
            if (estructuraSimbolos.recuperarListaTokenRegular().get(posicionPalabra).toString().indexOf("ENT") != -1)
            {
                estructuraSimbolos.recuperarListaTipoRegular().set(posicionPalabra, "numCerradoV");
                return true;
            }

            if (estructuraSimbolos.recuperarListaTokenRegular().get(posicionPalabra).toString().indexOf("DEC") != -1)
            {
                estructuraSimbolos.recuperarListaTipoRegular().set(posicionPalabra, "numPointV");
                return true;
            }

            if (estructuraSimbolos.recuperarListaTokenRegular().get(posicionPalabra).toString().indexOf("STR") != -1)
            {
                estructuraSimbolos.recuperarListaTipoRegular().set(posicionPalabra, "textV");
                return true;
            }

            if (estructuraSimbolos.recuperarListaTokenRegular().get(posicionPalabra).toString().indexOf("CHR") != -1)
            {
                estructuraSimbolos.recuperarListaTipoRegular().set(posicionPalabra, "simpleV");
                return true;
            }
        }
        
        return false;
    }
    
    public void asignarTipoDatosIdentificador (String palabraAsignacion, ArrayList <String> registroProcesos)
    {
        int posicionPalabra = estructuraSimbolos.encontrarLexenaRegular(palabraAsignacion);
        
        if (posicionPalabra != -1)
        {
            String tokenRegular = estructuraSimbolos.recuperarTokenRegular(posicionPalabra);

            if (continuarComa == true) 
            {
                if (palabraAsignacion.compareTo(",") == 0) 
                {
                    continuarComa = false;
                } 

                else 
                {
                    if (palabraAsignacion.compareTo(";") == 0) 
                    {
                        asignacionTipoDatos = false;
                        continuarComa = false;
                        tipoDatoActual = "";
                    } 
                }
            } 

            else 
            {
                if (tokenRegular.indexOf("TDS") != -1) 
                {
                    if (palabraAsignacion.compareTo("simpleV") == 0)
                    {
                            tipoDatoActual = "simpleV";
                    }
                    
                    if (palabraAsignacion.compareTo("textV") == 0)
                    {
                            tipoDatoActual = "textV";
                    }
                    
                    if (palabraAsignacion.compareTo("numPointV") == 0)
                    {
                            tipoDatoActual = "numPointV";
                    }
                    
                    if (palabraAsignacion.compareTo("numCerradoV") == 0)
                    {
                            tipoDatoActual = "numCerradoV";
                    }
                    
                    asignacionTipoDatos = true;
                }
            }

            if (asignacionTipoDatos == true) 
            {
                if (tokenRegular.indexOf("IDE") != -1) 
                {
                    estructuraSimbolos.recuperarListaTipoRegular().set(posicionPalabra, tipoDatoActual);
                    continuarComa = true;
                }
            }
        }
    }
    
    public void deteccionErroresSemanticos (String palabraAsignacion, int numeroLinea, ArrayList <String> registroProcesos)
    {   
        int posicionPalabra = estructuraSimbolos.encontrarLexenaRegular(palabraAsignacion);
        
        if (posicionPalabra != -1)
        {
            String tokenRegular = estructuraSimbolos.recuperarTokenRegular(posicionPalabra);

            if (numeroPasoSemantico == 0) 
            {
                if (tokenRegular.indexOf("IDE") != -1) 
                {
                    if (estructuraSimbolos.recuperarListaTipoRegular().get(posicionPalabra).toString().isEmpty()) 
                    {
                        String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                        if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Variable indefinida"))
                        {
                            contadorErrorSemantico ++;
                        }
                        
                        numeroPasoSemantico = -1;                      
                    } 
                    
                    else 
                    {
                        tipoDatoSentencia = estructuraSimbolos.recuperarTipoRegular(posicionPalabra);
                    }
                }
                
                else 
                {

                    numeroPasoSemantico = -1;
                }
            }

            if (numeroPasoSemantico == 1) 
            {
                if (palabraAsignacion.compareTo("=") != 0) 
                {
                    numeroPasoSemantico = -1;
                }
            }
            
            if (numeroPasoSemantico == 2) 
            {
                if(estructuraSimbolos.recuperarTipoRegular(posicionPalabra).isEmpty())
                {
                    String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                    if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Variable indefinida"))
                    {
                        contadorErrorSemantico ++;
                    }               
                    numeroPasoSemantico = -1;   
                    return;
                }
                
                if (tokenRegular.indexOf("IDE") != -1)  
                {
                    if (tipoDatoSentencia.isEmpty()) 
                    {
                        numeroPasoSemantico = -1;
                    } 
                    
                    else 
                    {
                        if (estructuraSimbolos.recuperarTipoRegular(posicionPalabra).compareTo(tipoDatoSentencia) != 0)
                        {
                            if(tipoDatoSentencia.compareTo("numPointV")==0 && estructuraSimbolos.recuperarTipoRegular(posicionPalabra).compareTo("numCerradoV") == 0)
                            {
                                System.out.println("error1");
                                numeroPasoSemantico++;
                                return;
                            }

                            String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                            if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Incompatibilidad de tipo " + tipoDatoSentencia))
                            {
                                contadorErrorSemantico ++;
                            }
                            
                            else 
                            {
                                int posicionDescripcion = estructuraErrores.encontrarLexenaError(palabraAsignacion);
                                
                                if (estructuraErrores.recuperarDescripcionError(posicionDescripcion).indexOf(tipoDatoSentencia) == -1)
                                {
                                    estructuraErrores.recuperarListaDescripcionError().set(posicionDescripcion, estructuraErrores.recuperarDescripcionError(posicionDescripcion) + ", " + tipoDatoSentencia);
                                }
                            }
                            
                            numeroPasoSemantico = -1;
                            
                        } 
                    }
                } 
                
                else 
                {
                    if (estructuraSimbolos.recuperarTipoRegular(posicionPalabra).compareTo(tipoDatoSentencia) != 0) 
                    {
                        if(tipoDatoSentencia.compareTo("numPointV")==0 && estructuraSimbolos.recuperarTipoRegular(posicionPalabra).compareTo("numCerradoV") == 0)
                        {
                            System.out.println("error2");
                            numeroPasoSemantico++;
                            return;
                        }
                        
                        String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                        if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Incompatibilidad de tipo " + tipoDatoSentencia))
                        {
                            contadorErrorSemantico ++;
                        }
                        
                        else 
                        {
                            int posicionDescripcion = estructuraErrores.encontrarLexenaError(palabraAsignacion);

                            if (estructuraErrores.recuperarDescripcionError(posicionDescripcion).indexOf(tipoDatoSentencia) == -1)
                            {
                                estructuraErrores.recuperarListaDescripcionError().set(posicionDescripcion, estructuraErrores.recuperarDescripcionError(posicionDescripcion) + ", " + tipoDatoSentencia);
                            }
                        }
                        
                        numeroPasoSemantico = -1; // Temporal indexación.
                    }
                }
            }

            if (numeroPasoSemantico == 3) 
            {
                if (palabraAsignacion.compareTo(";") == 0) 
                {
                    numeroPasoSemantico = -1;
                    tipoDatoSentencia = "";
                } 
                
                else 
                {

                    if (tipoDatoSentencia.compareTo("textV") == 0 || tipoDatoSentencia.compareTo("simpleV") == 0) 
                    {
                        if (palabraAsignacion.compareTo("+") == 0) 
                        {
                            numeroPasoSemantico = 1;
                        } 
                        
                        else 
                        {
                            String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                            if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Operando no permitido de " + palabraAsignacion))
                            {
                                contadorErrorSemantico ++;
                            }
                            numeroPasoSemantico = -1;
                        }
                    } 
                    
                    else 
                    {
                        if (tipoDatoSentencia.compareTo("numCerradoV") == 0 || tipoDatoSentencia.compareTo("numPointV") == 0) 
                        {
                            if (palabraAsignacion.compareTo("+") == 0 || palabraAsignacion.compareTo("-") == 0 || palabraAsignacion.compareTo("/") == 0 || palabraAsignacion.compareTo("*") == 0) 
                            {
                                numeroPasoSemantico = 1;
                            } 
                            
                            else 
                            {
                                String tokenError = "ERSem" + (contadorErrorSemantico + 1);
                                if (estructuraErrores.registrarError(palabraAsignacion, tokenError, String.valueOf(numeroLinea), "Operando no permitido de " + palabraAsignacion))
                                {
                                    contadorErrorSemantico ++;
                                }
                                numeroPasoSemantico = -1;
                            }
                        } 
                    }
                }
            }

            numeroPasoSemantico ++;
        }
        
        else
        {
            numeroPasoSemantico = 0;
        }
    }
}