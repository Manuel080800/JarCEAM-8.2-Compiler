package sistemaAnalisis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import sistemaProcesamiento.JClass_EstructuraExpresiones;
import sistemaProcesamiento.JClass_EstructuraSimbolos;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraTokens;
import sistemaEdicion.JClass_AnalizadorEdicionCodigo;
import sistemaEdicion.JClass_EstructuraEdicionCodigo;
import sistemaProcesamiento.JClass_EstructuraEnsamblador;
import sistemaProcesamiento.JClass_EstructuraTiplo;

public class JClass_AnalizadorContenidoEdicion 
{
    private JClass_EstructuraExpresiones estructuraExpresiones = null;
    private JClass_EstructuraSimbolos estructuraSimbolos = null;
    private JClass_EstructuraErrores estructuraErrores = null;
    private JClass_EstructuraTokens estructuraTokens = null;
    private JClass_EstructuraTiplo estructuraTiplo = null;
    private JTextArea areaContenidoEdicion = null;
    private JClass_OptimizadorCodigoFuente optimizadorFuente;
    private JClass_EstructuraEnsamblador estructuraEnsamblador;

    public JClass_AnalizadorContenidoEdicion(JTextArea areaContenidoEdicion, JClass_EstructuraExpresiones estructuraExpresiones, JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores, JClass_EstructuraTokens estructuraTokens, JClass_EstructuraTiplo estructuraTiplo, JClass_OptimizadorCodigoFuente optimizadorFuente, JClass_EstructuraEnsamblador estructuraEnsamblador) 
    {
        this.areaContenidoEdicion = areaContenidoEdicion;
        this.estructuraExpresiones = estructuraExpresiones;
        this.estructuraSimbolos = estructuraSimbolos;
        this.estructuraErrores = estructuraErrores;
        this.estructuraTokens = estructuraTokens;
        this.estructuraTiplo = estructuraTiplo;
        this.optimizadorFuente = optimizadorFuente;
        this.estructuraEnsamblador = estructuraEnsamblador;
    }
    
    public void analizarContenidoEdicion (ArrayList <String> registroProcesos, boolean identificacionExpresion)
    {
        JClass_AnalizadorEdicionCodigo analisisEdicionCodigo = new JClass_AnalizadorEdicionCodigo (this.areaContenidoEdicion.getText());
        analisisEdicionCodigo.analizarEdicionCodigo(registroProcesos);
        
        if (identificacionExpresion == true)
        {
            this.procesamientoIdentificacionUsuario (analisisEdicionCodigo);
        }
        
        else
        {
             this.areaContenidoEdicion.getHighlighter().removeAllHighlights();
        }
        
        this.procesamientoAnalisisLexico (analisisEdicionCodigo, registroProcesos);
        this.procesamientoAnalisisSemantico (analisisEdicionCodigo, registroProcesos);
        this.procesamientoCodigoIntermedio(registroProcesos);
        this.procesamientoCodigoEnsamblador(registroProcesos);
    }
    
    private void procesamientoIdentificacionUsuario (JClass_AnalizadorEdicionCodigo analisisEdicionCodigo)
    {
        this.areaContenidoEdicion.getHighlighter().removeAllHighlights();
        
        for (int i = 0; i < analisisEdicionCodigo.recuperarTotalLineaCodigo(); i++) 
        {
            JClass_EstructuraEdicionCodigo estructuraEdicion = analisisEdicionCodigo.recuperarEstructuraEdicionCodigo(i);
            
            for (int j = 0; j < estructuraEdicion.recuperarTotalEstructuraContenidoEdicion(); j++) 
            {
                Boolean estructuraEncontrada = false;
                
                for (int a = 0; a < this.estructuraExpresiones.recuperarTotalExpresiones(); a++) 
                {
                    Pattern expresionRegular = Pattern.compile(this.estructuraExpresiones.recuperarExpresionRegular(a));
                    Matcher segmentoEvaluar = expresionRegular.matcher(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                    
                    if (segmentoEvaluar.matches())
                    {   
                        Highlighter.HighlightPainter colorEstructura = new DefaultHighlighter.DefaultHighlightPainter(this.estructuraExpresiones.recuperarColorRegular(a));
                        
                        try 
                        {
                            if (i == 0)
                            {
                                this.areaContenidoEdicion.getHighlighter().addHighlight(estructuraEdicion.recuperarInicioEstructuraContenidoEdicion(j), estructuraEdicion.recuperarFinalEstructuraContenidoEdicion(j), colorEstructura);
                            }
                            
                            else
                            {
                                int longitudAlmacenada = analisisEdicionCodigo.recuperarLongitudLineaCodigo(i - 1);
                                this.areaContenidoEdicion.getHighlighter().addHighlight(longitudAlmacenada + estructuraEdicion.recuperarInicioEstructuraContenidoEdicion(j), longitudAlmacenada + estructuraEdicion.recuperarFinalEstructuraContenidoEdicion(j), colorEstructura);
                            }
                        } 
                        
                        catch (BadLocationException ex) 
                        {
                            System.out.println ("Error al resaltar codigo fuente");
                        }
                        
                        estructuraEncontrada = true;
                        break;
                    }
                }
                
                if (estructuraEncontrada == false)
                {
                    String [] expresionesRegularesAdicionales = {"\"(.)*\"", "'.'"};
                    Color  [] coloresRegularesAdicionales = {new Color (117, 105, 0), new Color (133, 96, 0)};
                    
                    for (int a = 0; a < expresionesRegularesAdicionales.length; a++) 
                    {    
                        Pattern expresionRegular = Pattern.compile(expresionesRegularesAdicionales [a]);
                        Matcher segmentoEvaluar = expresionRegular.matcher(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));

                        if (segmentoEvaluar.matches())
                        {
                            Highlighter.HighlightPainter colorEstructura = new DefaultHighlighter.DefaultHighlightPainter(coloresRegularesAdicionales [a]);

                            try 
                            {
                                if (i == 0)
                                {
                                    this.areaContenidoEdicion.getHighlighter().addHighlight(estructuraEdicion.recuperarInicioEstructuraContenidoEdicion(j), estructuraEdicion.recuperarFinalEstructuraContenidoEdicion(j), colorEstructura);
                                }

                                else
                                {
                                    int longitudAlmacenada = analisisEdicionCodigo.recuperarLongitudLineaCodigo(i - 1);
                                    this.areaContenidoEdicion.getHighlighter().addHighlight(longitudAlmacenada + estructuraEdicion.recuperarInicioEstructuraContenidoEdicion(j), longitudAlmacenada + estructuraEdicion.recuperarFinalEstructuraContenidoEdicion(j), colorEstructura);
                                }
                            } 

                            catch (BadLocationException ex) 
                            {
                                System.out.println ("Error al resaltar codigo fuente");
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void procesamientoAnalisisLexico (JClass_AnalizadorEdicionCodigo analisisEdicionCodigo, ArrayList <String> registroProcesos)
    {
        JClass_AnalisisLexico analisisLexico = new JClass_AnalisisLexico (estructuraExpresiones, estructuraSimbolos, estructuraErrores, estructuraTokens, analisisEdicionCodigo);
        analisisLexico.realizarAnalisisLexico(registroProcesos);
    }
    
    private void procesamientoAnalisisSemantico (JClass_AnalizadorEdicionCodigo analisisEdicionCodigo, ArrayList <String> registroProcesos)
    {
        JClass_AnalisisSemantico analisisSemantico = new JClass_AnalisisSemantico (estructuraExpresiones, estructuraSimbolos, estructuraErrores, estructuraTokens, analisisEdicionCodigo);
        analisisSemantico.realizarAnalisisSemantico(registroProcesos);
    }
    
    private void procesamientoCodigoIntermedio (ArrayList <String> registroProcesos)
    {
        String codigoEdicion = this.areaContenidoEdicion.getText();
        optimizadorFuente.optimizarCodigoFuente(codigoEdicion);
        String codigoOptimizado = optimizadorFuente.recuperarCodigoOptimizado();
        
        System.out.println("");
        System.out.println("Codigo optimizado: ");
        System.out.println(codigoOptimizado);
        System.out.println("");


        while (codigoEdicion.compareTo(codigoOptimizado) != 0)
        {
            codigoEdicion = codigoOptimizado;
            optimizadorFuente = new JClass_OptimizadorCodigoFuente ();
            optimizadorFuente.optimizarCodigoFuente(codigoEdicion);
            codigoOptimizado = optimizadorFuente.recuperarCodigoOptimizado();
        }
        
        System.out.println("");
        System.out.println("Codigo optimizado: ");
        System.out.println(codigoOptimizado);
        System.out.println("");
        
//x = 77 + 33 ;
//y = x - 22 ;
//r = x - 22 ;
//o = 7 ;
        
        JClass_EstructuraExpresiones estructuraExpresionesOP = new JClass_EstructuraExpresiones();
        JClass_EstructuraSimbolos estructuraSimbolosOP = new JClass_EstructuraSimbolos();
        JClass_EstructuraErrores estructuraErroresOP = new JClass_EstructuraErrores();
        JClass_EstructuraTokens estructuraTokensOP = new JClass_EstructuraTokens();
        
        JClass_AnalizadorEdicionCodigo analisisEdicionCodigo = new JClass_AnalizadorEdicionCodigo (codigoOptimizado);
        analisisEdicionCodigo.analizarEdicionCodigo(registroProcesos);
        
        JClass_AnalisisLexico analisisLexico = new JClass_AnalisisLexico (estructuraExpresionesOP, estructuraSimbolosOP, estructuraErroresOP, estructuraTokensOP, analisisEdicionCodigo);
        analisisLexico.realizarAnalisisLexico(registroProcesos);
        
        JClass_AnalisisSemantico analisisSemantico = new JClass_AnalisisSemantico (estructuraExpresionesOP, estructuraSimbolosOP, estructuraErroresOP, estructuraTokensOP, analisisEdicionCodigo);
        analisisSemantico.realizarAnalisisSemantico(registroProcesos);
        
        JClass_GeneradorCodigoIntermedio codigoIntermedio = new JClass_GeneradorCodigoIntermedio(estructuraExpresionesOP, estructuraSimbolosOP, estructuraErroresOP, estructuraTokensOP, analisisEdicionCodigo, estructuraTiplo);
        codigoIntermedio.realizarCodigoIntermedio(registroProcesos);
    }
    
    private void procesamientoCodigoEnsamblador (ArrayList <String> registroProcesos)
    {
        JClass_GeneradorCodigoEnsamblador codigoEnsamblador = new JClass_GeneradorCodigoEnsamblador (this.estructuraTiplo, this.estructuraEnsamblador);
        codigoEnsamblador.generarCodigoEnsamblador();
    }
}