package sistemaAnalisis;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sistemaEdicion.JClass_AnalizadorEdicionCodigo;

public class JClass_OptimizadorCodigoFuente 
{
    private ArrayList <String> variableAsignacion = new ArrayList <String>();
    private ArrayList <String> operacionAritmetica = new ArrayList <String>();
    private ArrayList <ArrayList <String>> componentesAritmetica = new ArrayList <ArrayList<String>>();
    private ArrayList <String> tipoOrden = new ArrayList <String>();
    private ArrayList <Integer> posicionInicio = new ArrayList <Integer>();
    private ArrayList <Integer> posicionFinal = new ArrayList <Integer>();

    private int totalOperaciones = 0;
    
    private String codigoFuente;
    
    private String expresionRegularAritmetica = "(\\S+)( +)(=)( +)(\\S+)( +)((\\+)|(\\-)|(\\*)|(\\/)|(\\%))( +)(\\S+)( +)(((\\+)|(\\-)|(\\*)|(\\/)|(\\%))( +)(\\S+)( +))*(\\;)";

    public JClass_OptimizadorCodigoFuente() 
    {

    }
    
    public void optimizarCodigoFuente (String codigoFuente)
    {
        this.codigoFuente = codigoFuente;
        
        Pattern expresion_Regular = Pattern.compile(expresionRegularAritmetica);
        Matcher segmento_Evaluar = expresion_Regular.matcher(codigoFuente);

        while (segmento_Evaluar.find())
        {
            preprocesoOptimizacion(segmento_Evaluar.group(), segmento_Evaluar.start(), segmento_Evaluar.end());
        }
        
        procesoOptimizacion();
    }
    
    public String recuperarCodigoOptimizado ()
    {
        return codigoFuente;
    }
    
    private void procesoOptimizacion ()
    {
        ArrayList <String> expresionRegularEncuentro = new ArrayList <String>();
        ArrayList <Integer> posicionInicioSub = new ArrayList <Integer>();
        ArrayList <Integer> posicionFinalSub = new ArrayList <Integer>();
        ArrayList <String> variableSustitucion = new ArrayList <String>();
        int totalSustitucion = 0;
        
        for (int i = 0; i < componentesAritmetica.size(); i++) 
        {
            for (int j = (i + 1); j < componentesAritmetica.size(); j++) 
            {
                if (comprobarIdentidad(componentesAritmetica.get(i), componentesAritmetica.get(j)))
                {
                    if(comprobarJerarquiaOperaciones(i, j))
                    {
                        if (comprobarIntegridad(posicionInicio.get(j), posicionFinal.get(j), posicionInicioSub, posicionFinalSub, totalSustitucion))
                        {
                            expresionRegularEncuentro.add(generarExpresionRegular(componentesAritmetica.get(i)));
                            variableSustitucion.add(variableAsignacion.get(i));
                            posicionInicioSub.add(posicionInicio.get(j));
                            posicionFinalSub.add(posicionFinal.get(j));
                            totalSustitucion ++;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < totalSustitucion; i++) 
        {
            System.out.println("Expresion: " + expresionRegularEncuentro.get(i));
            System.out.println("Posision: " + posicionInicioSub.get(i) + " -> " + posicionFinalSub.get(i));
            System.out.println("Sustitucion: " + variableSustitucion.get(i));
            
            int reduccion = posProcesoOptimizacion(expresionRegularEncuentro.get(i), posicionInicioSub.get(i), posicionFinalSub.get(i), variableSustitucion.get(i));
            
            for (int j = i; j < totalSustitucion; j++) 
            {
                posicionInicioSub.set(j, posicionInicioSub.get(j) - reduccion);
                posicionFinalSub.set(j, posicionFinalSub.get(j) - reduccion);
            }
        }
    }
    
    private boolean comprobarIntegridad (int posicionInicio, int posicionFinal, ArrayList<Integer> pI, ArrayList <Integer> pF, int tL)
    {   
        for (int i = 0; i < tL; i++) 
        {
            if (pI.get(i) == posicionInicio && pF.get(i) == posicionFinal)
            {
                return false;
            }
        }
        
        return true;
    }
    
    private int posProcesoOptimizacion (String expresionRegularEncuentro, int posicionInicioSub,  int posicionFinalSub, String variableSustitucion)
    {
        String inicioCodigo = codigoFuente.substring(0, posicionInicioSub);
        String codigoOptimizar = codigoFuente.substring(posicionInicioSub, posicionFinalSub);
        String finalCodigo = codigoFuente.substring(posicionFinalSub, codigoFuente.length());
        
        Pattern expresion_Regular = Pattern.compile(expresionRegularEncuentro);
        Matcher segmento_Evaluar = expresion_Regular.matcher(codigoOptimizar);

        int posicionCorteInicio = 0; 
        int posicionCorteFinal = 0; 
        String contenidoEncontrado = "";
        
        while (segmento_Evaluar.find())
        {
            posicionCorteInicio = segmento_Evaluar.start();
            posicionCorteFinal = segmento_Evaluar.end();
            contenidoEncontrado = segmento_Evaluar.group();
        }
        
        String corteInicio = codigoOptimizar.substring(0, posicionCorteInicio);
        String corteFinal = codigoOptimizar.substring(posicionCorteFinal, codigoOptimizar.length());
        
        String codigoSustituido = corteInicio + variableSustitucion + corteFinal;
        String codigoModificado = inicioCodigo + codigoSustituido + finalCodigo;
        
        int tamanioReduccion = contenidoEncontrado.length();
        int tamanioSustitucion = variableSustitucion.length();
        int diferenciaSustitucion = tamanioReduccion - tamanioSustitucion;
        diferenciaSustitucion += 2;
        
//        System.out.println("Optimizado: \n");
//        System.out.println(codigoModificado);
        
        codigoFuente = codigoModificado;
        
        return diferenciaSustitucion;
    }
    
    private boolean comprobarJerarquiaOperaciones (int identidad, int comparador)
    {
        try
        {
            System.out.println("ER: " + this.operacionAritmetica.get(identidad));
            System.out.println("EO: " + this.operacionAritmetica.get(comparador));
            
            for (int i = 0; i < componentesAritmetica.get(comparador).size(); i++) 
            {
                boolean existe = true;
                boolean comprobacionInicial = true;
                boolean comprobacionFinal = true;
                
                for (int j = 0; j < componentesAritmetica.get(identidad).size(); j++) 
                {
                    if (componentesAritmetica.get(comparador).get(i + j).compareTo(componentesAritmetica.get(identidad).get(j)) != 0 && existe == true)
                    {
                        existe = false;
                        break;
                    }
                    
                    else
                    {
                        if (j == 0)
                        {
//                            System.out.println("Orden INICIAL: " + tipoOrden.get(identidad));
                            
                            if (tipoOrden.get(identidad).compareTo("Uno") == 0)
                            {
//                                System.out.println("VALOR: " + (i + j));
                                
                                if (i == 0)
                                {
                                    comprobacionInicial = true;
                                }
                                
                                else
                                {
//                                    System.out.println("SIMBOLO: " + componentesAritmetica.get(comparador).get(i + j - 1));
                                    
                                    if (componentesAritmetica.get(comparador).get(i + j - 1).compareTo("*") == 0 || componentesAritmetica.get(comparador).get(i + j - 1).compareTo("/") == 0 || componentesAritmetica.get(comparador).get(i + j - 1).compareTo("%") == 0) 
                                    {
                                        comprobacionInicial = false;
                                    }
                                    
                                    else
                                    {
                                        comprobacionInicial = true;
                                    }
                                }
                            }
                            
                            if (tipoOrden.get(identidad).compareTo("Dos") == 0)
                            {
                                comprobacionInicial = true;
                            }
                            
                            if (tipoOrden.get(identidad).compareTo("Uno-Dos") == 0)
                            {
//                                System.out.println("VALOR: " + (i + j));
                                
                                if (i == 0)
                                {
                                    comprobacionInicial = true;
                                }
                                
                                else
                                {
//                                    System.out.println("SIMBOLO: " + componentesAritmetica.get(comparador).get(i + j - 1));
                                    
                                    if (componentesAritmetica.get(comparador).get(i + j - 1).compareTo("*") == 0 || componentesAritmetica.get(comparador).get(i + j - 1).compareTo("/") == 0 || componentesAritmetica.get(comparador).get(i + j - 1).compareTo("%") == 0) 
                                    {
                                        comprobacionInicial = false;
                                    }
                                    
                                    else
                                    {
                                        comprobacionInicial = true;
                                    }
                                }
                            }
                        }
                        
                        if ((j + 1) == componentesAritmetica.get(identidad).size())
                        {
//                            System.out.println("Orden FINAL: " + tipoOrden.get(identidad));
                            
                            if (tipoOrden.get(identidad).compareTo("Uno") == 0)
                            {
//                                System.out.println("VALOR: " + (i + j));
                                
                                if ((i + j + 1) == componentesAritmetica.get(comparador).size())
                                {
                                    comprobacionFinal = true;
                                }
                                
                                else
                                {
//                                    System.out.println("SIMBOLO: " + componentesAritmetica.get(comparador).get(i + j + 1));
                                    
                                    if (componentesAritmetica.get(comparador).get(i + j + 1).compareTo("*") == 0 || componentesAritmetica.get(comparador).get(i + j + 1).compareTo("/") == 0 || componentesAritmetica.get(comparador).get(i + j + 1).compareTo("%") == 0) 
                                    {
                                        comprobacionFinal = false;
                                    }
                                    
                                    else
                                    {
                                        comprobacionFinal = true;
                                    }
                                }
                            }
                            
                            if (tipoOrden.get(identidad).compareTo("Dos") == 0)
                            {
                                comprobacionFinal = true;
                            }
                            
                            if (tipoOrden.get(identidad).compareTo("Uno-Dos") == 0)
                            {
//                                System.out.println("VALOR: " + i);
                                
                                if ((i + j + 1) == componentesAritmetica.get(comparador).size())
                                {
                                    comprobacionFinal = true;
                                }
                                
                                else
                                {
//                                    System.out.println("SIMBOLO: " + componentesAritmetica.get(comparador).get(i + j + 1));
                                    
                                    if (componentesAritmetica.get(comparador).get(i + j + 1).compareTo("*") == 0 || componentesAritmetica.get(comparador).get(i + j + 1).compareTo("/") == 0 || componentesAritmetica.get(comparador).get(i + j + 1).compareTo("%") == 0) 
                                    {
                                        comprobacionFinal = false;
                                    }
                                    
                                    else
                                    {
                                        comprobacionFinal = true;
                                    }
                                }
                            }
                        }
                    }
                }
                
                if (existe == true && componentesAritmetica.get(identidad).size() > 0)
                {
                    //System.out.println("Suma de control: " + comprobacionInicial + " --> " + comprobacionFinal);
                    if (comprobacionInicial == true && comprobacionFinal == true)
                    {
                        return true;
                    }
                    
                    else
                    {
                        return false;
                    }
                }
            }
        }
        
        catch (Exception ex)
        {
            System.out.println("COMPARADOR: " + identidad + " -- " + comparador);
            ex.printStackTrace();
            return false;
        }
        
        return false;
    }
    
    private String generarExpresionRegular (ArrayList <String> identidad)
    {
        String temporalExpresion = "";
        
        for (int i = 0; i < identidad.size(); i++) 
        {
            if (i == 0)
            {
                temporalExpresion += "(" + identidad.get(i) + ")" ;
            }
            
            else
            {
                if (identidad.get(i).compareTo("+") == 0 || identidad.get(i).compareTo("-") == 0 || identidad.get(i).compareTo("*") == 0 || identidad.get(i).compareTo("/") == 0 || identidad.get(i).compareTo("%") == 0)
                {
                    temporalExpresion += "( +)(\\" + identidad.get(i) + ")" ;
                }
                
                else
                {
                    temporalExpresion += "( +)(" + identidad.get(i) + ")" ;
                }
            }
        }
                
        return temporalExpresion;
    }
    
    private void preprocesoOptimizacion (String aritmetica, int inicioAritmetica, int finalAritmetica)
    {
        ArrayList <String> temporalComponentes = new ArrayList <String> ();
        JClass_AnalizadorEdicionCodigo analizador = new JClass_AnalizadorEdicionCodigo (aritmetica);
        analizador.analizarEdicionCodigo(new ArrayList<String>());
        
        for (int i = 0; i < analizador.recuperarTotalLineaCodigo(); i++) 
        {
            int posicionInicio = 0;
            int posicionFinal = 0;
            boolean tipoUno = false;
            boolean tipoDos = false;
            boolean operacionSimple = true; 
            
            String cuerpoOperacion = "";
            
            for (int j = 0; j < analizador.recuperarEstructuraEdicionCodigo(i).recuperarTotalEstructuraContenidoEdicion(); j++) 
            {   
                if (j == 0)
                {
                    variableAsignacion.add(analizador.recuperarEstructuraEdicionCodigo(i).recuperarEstructuraContenidoEdicion(j));
                }
                
                if (j == 1)
                {
                    posicionInicio = analizador.recuperarEstructuraEdicionCodigo(i).recuperarFinalEstructuraContenidoEdicion(j);
                }
                
                if (j >= 2 && (j + 1) != analizador.recuperarEstructuraEdicionCodigo(i).recuperarTotalEstructuraContenidoEdicion())
                {
                    temporalComponentes.add(analizador.recuperarEstructuraEdicionCodigo(i).recuperarEstructuraContenidoEdicion(j));
                }
                
                if ((j + 1) == analizador.recuperarEstructuraEdicionCodigo(i).recuperarTotalEstructuraContenidoEdicion())
                {
                    posicionFinal = analizador.recuperarEstructuraEdicionCodigo(i).recuperarInicioEstructuraContenidoEdicion(j);
                }
                
                String temporal = analizador.recuperarEstructuraEdicionCodigo(i).recuperarEstructuraContenidoEdicion(j);
                        
                if (temporal.compareTo("*") == 0 || temporal.compareTo("/") == 0 || temporal.compareTo("%") == 0)
                {
                    tipoDos = true;
                }
                
                if (temporal.compareTo("-") == 0 || temporal.compareTo("+") == 0)
                {
                    tipoUno = true;
                }
            }
            
            this.posicionInicio.add(inicioAritmetica);
            this.posicionFinal.add(finalAritmetica);
            cuerpoOperacion = aritmetica.substring(posicionInicio, posicionFinal);
            operacionAritmetica.add(cuerpoOperacion);
            
            if (tipoUno == true && tipoDos == true)
            {
                tipoOrden.add("Uno-Dos");
            }
            
            else
            {
                if (tipoUno == true && tipoDos == false)
                {
                    tipoOrden.add("Uno");
                }
                
                if (tipoUno == false && tipoDos == true)
                {
                    tipoOrden.add("Dos");
                }
            }
            
            componentesAritmetica.add(temporalComponentes);
            totalOperaciones ++;
        }
    }
    
    private boolean comprobarIdentidad (ArrayList <String> identidad, ArrayList <String> comparador)
    {
        try
        {
            for (int i = 0; i < comparador.size(); i++) 
            {
                boolean existe = true;
                
                for (int j = 0; j < identidad.size(); j++) 
                {
                    if (comparador.get(i + j).compareTo(identidad.get(j)) != 0 && existe == true)
                    {
                        existe = false;
                    }
                }
                
                if (existe == true && identidad.size() > 0)
                {
                    return true;
                }
            }
        }
        
        catch (Exception ex)
        {
            return false;
        }
        
        return false;
    }
}
