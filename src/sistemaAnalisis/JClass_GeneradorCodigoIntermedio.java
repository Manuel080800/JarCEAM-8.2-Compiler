package sistemaAnalisis;

import java.util.ArrayList;
import sistemaEdicion.JClass_AnalizadorEdicionCodigo;
import sistemaEdicion.JClass_EstructuraEdicionCodigo;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraExpresiones;
import sistemaProcesamiento.JClass_EstructuraSimbolos;
import sistemaProcesamiento.JClass_EstructuraTiplo;
import sistemaProcesamiento.JClass_EstructuraTokens;

public class JClass_GeneradorCodigoIntermedio 
{
    private JClass_EstructuraExpresiones estructuraExpresiones = null;
    private JClass_EstructuraSimbolos estructuraSimbolos = null;
    private JClass_EstructuraErrores estructuraErrores = null;
    private JClass_EstructuraTokens estructuraTokens = null;
    private JClass_EstructuraTiplo estructuraTiplo = null;
    private JClass_AnalizadorEdicionCodigo analisisEdicionCodigo = null;
    private int identificador = 1;
    
    // Estructura interna de datos de instrucciones del preprocesamiento:
    private ArrayList <ArrayList<Object>> instruccionesEdicion = new ArrayList <ArrayList<Object>> ();
    private ArrayList <ArrayList<Object>> tokenEdicion = new ArrayList <ArrayList<Object>> ();
    private ArrayList <ArrayList<Object>> lineaEdicion = new ArrayList <ArrayList<Object>> ();
    private int totalPreprocesado = 0;
    
    // Almacen de instrucciones de procesamiento:
    private ArrayList <ArrayList<Object>> controlInstrucciones = new ArrayList <ArrayList<Object>>();
    
    // Almacen de iteradores auxiliares:
    private ArrayList <Integer> whileInicio = new ArrayList <Integer> ();
    private ArrayList <Integer> whileIdentificador = new ArrayList <Integer> ();
    private ArrayList <Integer> whilePosicion = new ArrayList <Integer> ();
    private String jerarquiaBloqueUno = "";
    private String jerarquiaBloqueDos = "";
    private boolean inicioBloque = false;
    
    // Almacen de jerarquia auxiliares:
    private ArrayList<String> frase = new ArrayList<String>();
    private int contadorTemporales = 0;
    private String variablePrincipal = "";
    
    public JClass_GeneradorCodigoIntermedio (JClass_EstructuraExpresiones estructuraExpresiones, JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores, JClass_EstructuraTokens estructuraTokens, JClass_AnalizadorEdicionCodigo analisisEdicionCodigo, JClass_EstructuraTiplo estructuraTiplo) 
    {
        this.estructuraExpresiones = estructuraExpresiones;
        this.estructuraSimbolos = estructuraSimbolos;
        this.estructuraErrores = estructuraErrores;
        this.estructuraTokens = estructuraTokens;
        this.analisisEdicionCodigo = analisisEdicionCodigo;
        this.estructuraTiplo = estructuraTiplo;
    }
    
    public void realizarCodigoIntermedio (ArrayList <String> registroProcesos)
    {
        preprocesarEdicionCodigo();
        procesarEdicionCodigo();
        posprocesarEdicionCodigo();
    }
    
    private void procesarEdicionCodigo ()
    { 
        for (int i = 0; i < totalPreprocesado; i++) 
        {
            subprocesoCiclos(instruccionesEdicion.get(i), tokenEdicion.get(i));
            subprocesoBloques(instruccionesEdicion.get(i), tokenEdicion.get(i));
            subprocesoAsignaciones(instruccionesEdicion.get(i), tokenEdicion.get(i));
        }
        
        for (int i = 0; i < controlInstrucciones.size(); i++) 
        {
            for (int a = 0; a < controlInstrucciones.get(i).size(); a++) 
            {
                System.out.println("Salida [" + i + " - " + a + "] " + controlInstrucciones.get(i).get(a));
            }
        }
    }
    
    private void posprocesarEdicionCodigo()
    {
        for (int i = 0; i < controlInstrucciones.size(); i++) 
        {
            subposprocesoAsignacion(controlInstrucciones.get(i));
            subposprocesoCiclo(controlInstrucciones.get(i));
            subposprocesoBloques(controlInstrucciones.get(i));
        }
        
        subposprocesoIdentacion();
    }
    
    private void subposprocesoIdentacion ()
    {
        ArrayList <Integer> sinRepeticion = new ArrayList <Integer> ();
        int contadorAdicciones = 0;
        
        for (int i = 1; i < estructuraTiplo.recuperarTotalTiplo(); i++) 
        {   
            try 
            {
                int posicion = Integer.parseInt(estructuraTiplo.recuperarTiploOperador(i));
                
                if (1 > posicion || posicion > (estructuraTiplo.recuperarTotalTiplo() - 1))
                {
                    boolean encontrado = false;
                    
                    for (int j = 0; j < sinRepeticion.size(); j++) 
                    {
                        if (sinRepeticion.get(j) == posicion)
                        {
                            encontrado = true;
                        }
                    }
                    
                    if (encontrado == false)
                    {
                        sinRepeticion.add(posicion);
                        contadorAdicciones ++;
                    }
                }
            }

            catch (Exception ex)
            {
                System.out.println("Traduccion erronea: " + (i));
            }
        }
        
        for (int i = 0; i < contadorAdicciones; i++) 
        {
            estructuraTiplo.registrarTiplo("", "", "", "ADICIONAL");
        }
    }
    
    private void subposprocesoBloques (ArrayList <Object> instruccionesTiplo)
    {
        boolean inicial = false;
        boolean modalidad = false;
        boolean paridad = false;
        
        for (int a = 0; a < instruccionesTiplo.size(); a++) 
        {
            if (a == 0)
            {
                if (instruccionesTiplo.get(a).toString().compareTo("Bloque 1") == 0)
                {
                    modalidad = false;
                    inicial = true;
                }
                
                else
                {
                    if (instruccionesTiplo.get(a).toString().compareTo("Bloque 2") == 0)
                    {
                        modalidad = true;
                        inicial = true;
                    }

                    else
                    {
                        return;
                    }
                }
            }
            
            if (a == 0 && inicial == true)
            {
                if (modalidad == false)
                {
                    for (int j = 0; j < whilePosicion.size(); j++) 
                    {
                        if (whileIdentificador.get(j) == (identificador - 1))
                        {
                            if (paridad == false)
                            {
                                paridad = true;
                                
                                int posicionTiplo = estructuraTiplo.recuperarTotalTiplo();
                                
                                for (int i = 0; i < estructuraTiplo.recuperarTotalTiplo(); i++) 
                                {
                                    if (i == whilePosicion.get(j) - 1)
                                    {
                                        if (estructuraTiplo.recuperarTiploDatoFuente(i).compareTo("True") == 0 && estructuraTiplo.recuperarTiploOperador(i).compareTo("") == 0)
                                        {
                                            estructuraTiplo.recuperarListaTiploOperador().set(i, posicionTiplo);
                                        }
                                    }
                                }
                            }

                            else
                            {
                                paridad = false;
                            }
                        }
                    }
                }
                
                else
                {
                    ArrayList <Integer> eliminar = new ArrayList <Integer> ();
                    
                    try 
                    {
                        int posicionInicio = whileInicio.get(whileInicio.size() - 1);
                        estructuraTiplo.registrarTiplo("", String.valueOf(posicionInicio), "JR", "Retorno");
                        whileInicio.remove(whileInicio.size() - 1);
                    }
                    
                    catch (Exception ex)
                    {
                        System.err.println("Error de bloque final de while");
                    }
                    
                    for (int j = 0; j < whilePosicion.size(); j++) 
                    {
                        if (whileIdentificador.get(j) == (identificador - 1))
                        {
                            if (paridad == true)
                            {
                                paridad = false;
                                
                                int posicionTiplo = estructuraTiplo.recuperarTotalTiplo();
                                
                                for (int i = 0; i < estructuraTiplo.recuperarTotalTiplo(); i++) 
                                {
                                    if (i == whilePosicion.get(j) - 1)
                                    {
                                        eliminar.add(j - 1);
                                        eliminar.add(j);
                                        
                                        if (estructuraTiplo.recuperarTiploDatoFuente(i).compareTo("False") == 0 && estructuraTiplo.recuperarTiploOperador(i).compareTo("") == 0)
                                        {
                                            estructuraTiplo.recuperarListaTiploOperador().set(i, posicionTiplo);
                                        }
                                    }
                                }
                            }

                            else
                            {
                                paridad = true;
                            }
                        }
                    }
                                       
                    for (int o = eliminar.size() - 1; o >= 0; o--) 
                    {
                        whileIdentificador.remove(( int) eliminar.get(o));
                        whilePosicion.remove((int) eliminar.get(o));
                    }

                    if (eliminar.size() > 0)
                    {
                        identificador --;
                    }
                }
            }
        }
    }
    
    private void subposprocesoCiclo (ArrayList <Object> instruccionesTiplo)
    {
        boolean ciclo = false;
        boolean temporal = false;
        boolean operacionSimpleUno = true;
        boolean operacionSimpleDos = true;
        String condicionBloqueUno = "";
        String condicionBloqueDos = "";
        
        ArrayList <String> operacionesLineales = new ArrayList <String> ();
        
        for (int a = 0; a < instruccionesTiplo.size(); a++) 
        {
            boolean interrupcionCiclo = false;
            
            if (a == 0)
            {
                if (instruccionesTiplo.get(a).toString().compareTo("Ciclo") == 0)
                {
                    this.inicioBloque = true;
                    ciclo = true;
                    whileInicio.add(estructuraTiplo.recuperarTotalTiplo());
                }
                
                else
                {
                    return;
                }
            }
            
            if (instruccionesTiplo.get(a).toString().compareTo("Temporal 1") == 0)
            {
                temporal = false;
                
                operacionSimpleUno = true;
                condicionBloqueUno = "";
                interrupcionCiclo = true;
            }
                
            if (instruccionesTiplo.get(a).toString().compareTo("Temporal 2") == 0)
            {
                temporal = true;
                
                operacionSimpleDos = true;
                condicionBloqueDos = "";
                interrupcionCiclo = true;
                
                if (operacionesLineales.size() > 0 && operacionSimpleUno == false)
                {
                    sistemaAnalisisJerarquiaO(operacionesLineales, false, false);
                }
                
                else
                {
                    this.contadorTemporales ++;
                    jerarquiaBloqueUno = "T" + this.contadorTemporales;
                    
                    if (this.inicioBloque == true)
                    {
                        estructuraTiplo.registrarTiplo(jerarquiaBloqueUno, condicionBloqueUno, "=", "Ciclo: Operando 1");
                        this.inicioBloque = false;
                    }
                    
                    else
                    {
                        estructuraTiplo.registrarTiplo(jerarquiaBloqueUno, condicionBloqueUno, "=", "Operando 1");
                    }
                }
            }
            
            if (instruccionesTiplo.get(a).toString().compareTo("Or") == 0 || instruccionesTiplo.get(a).toString().compareTo("And") == 0 || (a + 1) == instruccionesTiplo.size())
            {
                if ((a + 1) == instruccionesTiplo.size())
                {
                    if (instruccionesTiplo.get(a).toString().compareTo("==") == 0 || instruccionesTiplo.get(a).toString().compareTo("<=") == 0 || instruccionesTiplo.get(a).toString().compareTo(">=") == 0 || instruccionesTiplo.get(a).toString().compareTo("!=") == 0 || instruccionesTiplo.get(a).toString().compareTo("<") == 0 || instruccionesTiplo.get(a).toString().compareTo(">") == 0)
                    {
                        if (operacionSimpleUno == true && operacionSimpleDos == true)
                        {
                            estructuraTiplo.registrarTiplo("T2", condicionBloqueDos, "=", "Operando 2");
                            estructuraTiplo.registrarTiplo("T1", "T2", instruccionesTiplo.get(a).toString(), "Condicion");
                            jerarquiaBloqueUno = "";
                            jerarquiaBloqueDos = "";
                            condicionBloqueUno = "";
                            condicionBloqueDos = "";
                            operacionSimpleUno = true;
                            operacionSimpleDos = true;
                            this.contadorTemporales = 0;
                        }
                        
                        else
                        {
                            if (operacionesLineales.size() > 0 && operacionSimpleDos == false)
                            {
                                sistemaAnalisisJerarquiaO(operacionesLineales, false, true);
                            }
                            
                            else
                            {
                                this.contadorTemporales ++;
                                jerarquiaBloqueDos = "T" + this.contadorTemporales;
                                estructuraTiplo.registrarTiplo(jerarquiaBloqueDos, condicionBloqueDos, "=", "Operando 2");
                            }

                            estructuraTiplo.registrarTiplo(jerarquiaBloqueUno, jerarquiaBloqueDos, instruccionesTiplo.get(a).toString(), "Condicion");
                            jerarquiaBloqueUno = "";
                            jerarquiaBloqueDos = "";
                            condicionBloqueUno = "";
                            condicionBloqueDos = "";
                            operacionSimpleUno = true;
                            operacionSimpleDos = true;
                            this.contadorTemporales = 0;
                        }
                    }
                    
                    estructuraTiplo.registrarTiplo("TR1", "True", String.valueOf(estructuraTiplo.recuperarTotalTiplo() + 2), "Salto true");
                    whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                    whileIdentificador.add(identificador);
                    estructuraTiplo.registrarTiplo("TR1", "False", "", "Salto false");
                    whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                    whileIdentificador.add(identificador);
                    interrupcionCiclo = true;
                    identificador ++;
                }
                
                else
                {
                    if (instruccionesTiplo.get(a).toString().compareTo("And") == 0)
                    {
                        jerarquiaBloqueUno = "";
                        jerarquiaBloqueDos = "";
                        condicionBloqueUno = "";
                        condicionBloqueDos = "";
                        operacionSimpleUno = true;
                        operacionSimpleDos = true;
                        this.contadorTemporales = 0;
                        
                        estructuraTiplo.registrarTiplo("TR1", "True", String.valueOf(estructuraTiplo.recuperarTotalTiplo() + 2), "Salto true");
                        whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                        whileIdentificador.add(identificador);
                        estructuraTiplo.registrarTiplo("TR1", "False", "", "Salto false");
                        whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                        whileIdentificador.add(identificador);
                    }
                    
                    else
                    {
                        jerarquiaBloqueUno = "";
                        jerarquiaBloqueDos = "";
                        condicionBloqueUno = "";
                        condicionBloqueDos = "";
                        operacionSimpleUno = true;
                        operacionSimpleDos = true;
                        this.contadorTemporales = 0;
                        
                        estructuraTiplo.registrarTiplo("TR1", "True", "", "Salto true");
                        whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                        whileIdentificador.add(identificador);
                        estructuraTiplo.registrarTiplo("TR1", "False", String.valueOf(estructuraTiplo.recuperarTotalTiplo() + 1), "Salto false");
                        whilePosicion.add(estructuraTiplo.recuperarTotalTiplo());
                        whileIdentificador.add(identificador);
                    }
                    
                    interrupcionCiclo = true;
                }
            }
            
            if (a != 0 && ciclo == true && interrupcionCiclo == false)
            {
                if (temporal == false)
                {
                    if (instruccionesTiplo.get(a).toString().compareTo("+") == 0 || instruccionesTiplo.get(a).toString().compareTo("-") == 0 || instruccionesTiplo.get(a).toString().compareTo("*") == 0 || instruccionesTiplo.get(a).toString().compareTo("-") == 0 || instruccionesTiplo.get(a).toString().compareTo("%") == 0)
                    {
                        operacionesLineales.add(instruccionesTiplo.get(a).toString());
                        operacionSimpleUno = false;
                    }

                    else
                    {
                        operacionesLineales.add(instruccionesTiplo.get(a).toString());
                        
                        if (condicionBloqueUno.compareTo("") == 0)
                        {
                            condicionBloqueUno = instruccionesTiplo.get(a).toString();
                        }
                    }
                }
                
                else
                {
                    if (instruccionesTiplo.get(a).toString().compareTo("==") == 0 || instruccionesTiplo.get(a).toString().compareTo("<=") == 0 || instruccionesTiplo.get(a).toString().compareTo(">=") == 0 || instruccionesTiplo.get(a).toString().compareTo("!=") == 0 || instruccionesTiplo.get(a).toString().compareTo("<") == 0 || instruccionesTiplo.get(a).toString().compareTo(">") == 0)
                    {
                        if (operacionSimpleUno == true && operacionSimpleDos == true)
                        {
                            estructuraTiplo.registrarTiplo("T2", condicionBloqueDos, "=", "Operando 2");
                            estructuraTiplo.registrarTiplo("T1", "T2", instruccionesTiplo.get(a).toString(), "Condicion");
                            jerarquiaBloqueUno = "";
                            jerarquiaBloqueDos = "";
                            condicionBloqueUno = "";
                            condicionBloqueDos = "";
                            operacionSimpleUno = true;
                            operacionSimpleDos = true;
                            this.contadorTemporales = 0;
                        }
                        
                        else
                        {
                            if (operacionesLineales.size() > 0 && operacionSimpleDos == false)
                            {
                                sistemaAnalisisJerarquiaO(operacionesLineales, false, true);
                            }
                            
                            else
                            {
                                this.contadorTemporales ++;
                                jerarquiaBloqueDos = "T" + this.contadorTemporales;
                                estructuraTiplo.registrarTiplo(jerarquiaBloqueDos, condicionBloqueDos, "=", "Operando 2");
                            }

                            estructuraTiplo.registrarTiplo(jerarquiaBloqueUno, jerarquiaBloqueDos, instruccionesTiplo.get(a).toString(), "Condicion");
                            jerarquiaBloqueUno = "";
                            jerarquiaBloqueDos = "";
                            condicionBloqueUno = "";
                            condicionBloqueDos = "";
                            operacionSimpleUno = true;
                            operacionSimpleDos = true;
                            this.contadorTemporales = 0;
                        }
                    }
                    
                    else
                    {
                        if (instruccionesTiplo.get(a).toString().compareTo("+") == 0 || instruccionesTiplo.get(a).toString().compareTo("-") == 0 || instruccionesTiplo.get(a).toString().compareTo("*") == 0 || instruccionesTiplo.get(a).toString().compareTo("/") == 0 || instruccionesTiplo.get(a).toString().compareTo("%") == 0)
                        {
                            operacionesLineales.add(instruccionesTiplo.get(a).toString());
                            operacionSimpleDos = false;
                        }

                        else
                        {
                            operacionesLineales.add(instruccionesTiplo.get(a).toString());
                            
                            if (condicionBloqueDos.compareTo("") == 0)
                            {
                                condicionBloqueDos = instruccionesTiplo.get(a).toString();
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void procesoJerarquiaOperaciones(ArrayList <String> frase, boolean modalidadAsignacion, boolean modalidadSegunda) 
    {
        boolean primero = false;
        boolean inicio = true;
        
        for (int i = 1; i < frase.size() - 1; i++) 
        {
            if (frase.get(i).equals("%") || frase.get(i).equals("/") || frase.get(i).equals("*")) 
            {
                this.contadorTemporales ++;
                
                if (inicioBloque == true )
                {
                    if (modalidadAsignacion == true)
                    {
                        estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "Aritmetica");
                    }
                    
                    if (modalidadAsignacion == false)
                    {
                        estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "Ciclo");
                    }
                    
                    inicioBloque = false;
                }
                
                else
                {
                    estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "");
                }
                
                if (modalidadAsignacion == false)
                {
                    if (estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1).isEmpty() && inicio == true)
                    {
                        if (modalidadSegunda == false)
                        {
                            estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, "Operando 1");
                        }
                        
                        else
                        {
                            estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, "Operando 2");
                        }
                        
                        inicio = false;
                    }
                    
                    else
                    {
                        if (inicio == true)
                        {
                            if (modalidadSegunda == false)
                            {
                                estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size()-1) + ": Operando 1");
                            }

                            else
                            {
                                estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size()-1) + ": Operando 2");
                            }

                            inicio = false;
                        }
                    }
                }
                
                estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i + 1), frase.get(i), "");
                
                frase.set(i - 1, "T" + contadorTemporales);
                frase.remove(i + 1);
                frase.remove(i);
                i = 0;
            }
        }
        
        for (int i = 1; i < frase.size() - 1; i++) 
        {   
            if (frase.get(i).equals("+") || frase.get(i).equals("-")) 
            {
                if (primero == false) 
                {
                    this.contadorTemporales ++;
                    
                    if (inicioBloque == true )
                    {
                        if (modalidadAsignacion == true)
                        {
                            estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "Aritmetica");
                        }

                        if (modalidadAsignacion == false)
                        {
                            estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "Ciclo");
                        }

                        inicioBloque = false;
                    }

                    else
                    {
                        estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i - 1), "=", "");
                    }
                    
                    primero = true;
                }
                
                if (modalidadAsignacion == false)
                {
                    if (estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1).isEmpty() && inicio == true)
                    {
                        if (modalidadSegunda == false)
                        {
                            estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, "Operando 1");
                        }
                        
                        else
                        {
                            estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, "Operando 2");
                        }
                        
                        inicio = false;
                    }
                    
                    else
                    {
                        if (inicio == true)
                        {
                            if (modalidadSegunda == false)
                            {
                                estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size()-1) + ": Operando 1");
                            }

                            else
                            {
                                estructuraTiplo.recuperarListaTiploEtiqueta().set(estructuraTiplo.recuperarListaTiploEtiqueta().size() - 1, estructuraTiplo.recuperarTiploEtiqueta(estructuraTiplo.recuperarListaTiploEtiqueta().size()-1) + ": Operando 2");
                            }

                            inicio = false;
                        }
                    }
                }
                
                estructuraTiplo.registrarTiplo("T" + this.contadorTemporales, frase.get(i + 1), frase.get(i), "");

                frase.set(i - 1, "T" + this.contadorTemporales);
                frase.remove(i + 1);
                frase.remove(i);
                i --;
            }
        }
              
        frase.clear();
    }

    private void sistemaAnalisisJerarquiaO(ArrayList<String> operacionesLineales, boolean modalidadAsignacion, boolean modalidadSegunda) 
    {
        this.procesoJerarquiaOperaciones(operacionesLineales, modalidadAsignacion, modalidadSegunda);
        
        if (modalidadAsignacion == true)
        {
            estructuraTiplo.registrarTiplo(this.variablePrincipal, "T" + this.contadorTemporales, "=", "");
            
            this.variablePrincipal = "";
            this.contadorTemporales = 0;
        }
        
        if (modalidadAsignacion == false && modalidadSegunda == false)
        {
            jerarquiaBloqueUno = "T" + this.contadorTemporales;
        }
        
        if (modalidadAsignacion == false && modalidadSegunda == true)
        {
            jerarquiaBloqueDos = "T" + this.contadorTemporales;
            this.variablePrincipal = "";
            this.contadorTemporales = 0;
        }
    }
    
    private void subposprocesoAsignacion (ArrayList <Object> instruccionesTiplo)
    {
        
        boolean asignacion = false;
        boolean operacionSimple = true;
        String operacionDato = "";
        
        ArrayList <String> operacionesLineales = new ArrayList <String> ();
        
        for (int a = 0; a < instruccionesTiplo.size(); a++) 
        {
            if (a == 0)
            {
                if (instruccionesTiplo.get(a).toString().compareTo("Asignacion") == 0)
                {
                    asignacion = true;
                    this.inicioBloque = true;
                }
                
                else
                {
                    return;
                }
            }
            
            if (a != 0 && asignacion == true)
            {

                if ((a + 1) == instruccionesTiplo.size())
                {
                    variablePrincipal = instruccionesTiplo.get(a).toString();
                    asignacion = false;
                    break;
                }

                if (instruccionesTiplo.get(a).toString().compareTo("+") == 0 || instruccionesTiplo.get(a).toString().compareTo("-") == 0 || instruccionesTiplo.get(a).toString().compareTo("*") == 0 || instruccionesTiplo.get(a).toString().compareTo("/") == 0 || instruccionesTiplo.get(a).toString().compareTo("%") == 0)
                {
                    operacionesLineales.add(instruccionesTiplo.get(a).toString());
                    operacionSimple = false;
                }

                else
                {
                    operacionesLineales.add(instruccionesTiplo.get(a).toString());
                    
                    if (operacionDato.compareTo("") == 0)
                    {
                        operacionDato = instruccionesTiplo.get(a).toString();
                    }
                }
            }
        }
        
        if (operacionesLineales.size() > 0 && operacionSimple == false)
        {
            sistemaAnalisisJerarquiaO(operacionesLineales, true, false);
        }
        
        else
        {
            estructuraTiplo.registrarTiplo("T1", operacionDato, "=", "Asignacion");
            estructuraTiplo.registrarTiplo(variablePrincipal, "T1", "=", "");
            variablePrincipal = "";
            this.inicioBloque = false;
        }
    }
       
    private boolean subprocesoAsignaciones (ArrayList <Object> contenidoEdicion, ArrayList <Object> contenidoToken)
    {   
        String inicializacion = "";
        ArrayList <Object> operaciones = new ArrayList <Object>();
        
        boolean continuaOperador = false;
        boolean inicioAsignacion = false;
        boolean continuarAsignacion = false;
        
        for (int i = 0; i < contenidoEdicion.size(); i++) 
        {   
            if (inicioAsignacion == false) 
            {
                if (contenidoToken.get(i).toString().indexOf("IDE") != -1 || contenidoToken.get(i).toString().indexOf("ERL") != -1) 
                {
                    operaciones.add("Asignacion");
                    continuarAsignacion = true;
                    inicioAsignacion = true;
                    inicializacion = contenidoEdicion.get(i).toString();
                    
                    if ((i + 1) < contenidoEdicion.size())
                    {
                        i ++;
                    }
                }
            }
            
            if (continuarAsignacion == true)
            {
                if (contenidoEdicion.get(i).toString().compareTo("=") == 0)
                {
                    continuarAsignacion = false;
                }
                
                else
                {
                    inicializacion = "";
                    continuaOperador = false;
                    inicioAsignacion = false;
                    continuarAsignacion = false;
                    operaciones.clear();
                    return false;
                }
            }
            
            else
            {
                if(inicioAsignacion == true)
                {
                    if (contenidoToken.get(i).toString().indexOf("IDE") != -1 || contenidoToken.get(i).toString().indexOf("ENT") != -1 || contenidoToken.get(i).toString().indexOf("DEC") != -1 ||
                    contenidoToken.get(i).toString().indexOf("STR") != -1 || contenidoToken.get(i).toString().indexOf("CHR") != -1 || contenidoToken.get(i).toString().indexOf("ERL") != -1)
                    {
                        if (continuaOperador == false)
                        {
                            continuaOperador = true;
                            operaciones.add(contenidoEdicion.get(i));
                        }
                        
                        else
                        {
                            inicializacion = "";
                            continuaOperador = false;
                            inicioAsignacion = false;
                            continuarAsignacion = false;
                            operaciones.clear();
                            return false;
                        }
                    }

                    else
                    {
                        if (continuaOperador == true)
                        {
                            if (contenidoToken.get(i).toString().indexOf("ARM") != -1)
                            {
                                continuaOperador = false;
                                operaciones.add(contenidoEdicion.get(i));
                            }

                            else
                            {
                                if(contenidoEdicion.get(i).toString().compareTo(";") == 0)
                                {
                                    operaciones.add(inicializacion);
                                    this.controlInstrucciones.add(operaciones);
                                    return true;
                                }

                                else
                                {
                                    inicializacion = "";
                                    continuaOperador = false;
                                    inicioAsignacion = false;
                                    continuarAsignacion = false;
                                    operaciones.clear();
                                    return false;
                                }
                            }
                        }
                        
                        else
                        {
                            inicializacion = "";
                            continuaOperador = false;
                            inicioAsignacion = false;
                            continuarAsignacion = false;
                            operaciones.clear();
                            return false;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean subprocesoCiclos (ArrayList <Object> contenidoEdicion, ArrayList <Object> contenidoToken)
    {   
        ArrayList <Object> operaciones = new ArrayList <Object>();
        ArrayList <Object> operacionesRelacionales = new ArrayList <Object> ();
        boolean continuaRelacion = false;
        boolean inicioAsignacion = false;
        boolean continuarParentesis = false;
        boolean permitirLogica = false;
        int contadorRelacion = 0;
        int contadorLogico = 0;
        
        for (int i = 0; i < contenidoEdicion.size(); i++) 
        {
            if (inicioAsignacion == false) 
            {
                if (contenidoToken.get(i).toString().indexOf("CCS") != -1) 
                {
                    operaciones.add("Ciclo");
                    continuarParentesis = true;
                    inicioAsignacion = true;
                    
                    if ((i + 1) < contenidoEdicion.size())
                    {
                        i ++;
                    }
                }
            }
            
            if (continuarParentesis == true)
            {
                if (contenidoEdicion.get(i).toString().compareTo("(") == 0)
                {
                    continuarParentesis = false;
                    operaciones.add("Temporal 1");
                }
                
                else
                {
                    continuaRelacion = false;
                    inicioAsignacion = false;
                    continuarParentesis = false;
                    permitirLogica = false;
                    contadorRelacion = 0;
                    contadorLogico = 0;
                    operaciones.clear();
                    return false;
                }
            }
            
            else
            {
                if(inicioAsignacion == true)
                {
                    if (contenidoToken.get(i).toString().indexOf("IDE") != -1 || contenidoToken.get(i).toString().indexOf("ENT") != -1 || contenidoToken.get(i).toString().indexOf("DEC") != -1 ||
                    contenidoToken.get(i).toString().indexOf("STR") != -1 || contenidoToken.get(i).toString().indexOf("CHR") != -1 || contenidoToken.get(i).toString().indexOf("ERL") != -1)
                    {
                        if (continuaRelacion == false)
                        {
                            continuaRelacion = true;
                            operaciones.add(contenidoEdicion.get(i));
                        }
                        
                        else
                        {
                            continuaRelacion = false;
                            inicioAsignacion = false;
                            continuarParentesis = false;
                            permitirLogica = false;
                            contadorRelacion = 0;
                            contadorLogico = 0;
                            operaciones.clear();
                            return false;
                        }
                    }

                    else
                    {
                        if (continuaRelacion == true)
                        {
                            if (contenidoToken.get(i).toString().indexOf("REL") != -1)
                            {
                                continuaRelacion = false;
                                operacionesRelacionales.add(contenidoEdicion.get(i));
                                contadorRelacion ++;
                                operaciones.add("Temporal 2");
                            }

                            else
                            {
                                if(contenidoEdicion.get(i).toString().compareTo(")") == 0 && ((contadorRelacion == 1 && contadorLogico == 0) || (contadorRelacion > 0 && contadorLogico == (contadorRelacion - 1))))
                                {
                                    try 
                                    {
                                        operaciones.add(operacionesRelacionales.get(contadorRelacion - 1));
                                        this.controlInstrucciones.add(operaciones);
                                        return true;
                                    }

                                    catch (Exception ex)
                                    {
                                        System.err.println("Error de sintaxis de WHILE");
                                    }
                                }

                                else
                                {
                                    if (contenidoToken.get(i).toString().indexOf("LOG") != -1 && permitirLogica == false)
                                    {
                                        try 
                                        {
                                            operaciones.add(operacionesRelacionales.get(contadorRelacion - 1));
                                        }
                                        
                                        catch (Exception ex)
                                        {
                                            System.err.println("Error de sintaxis de WHILE");
                                        }
                                        
                                        if (contenidoEdicion.get(i).toString().compareTo("||") == 0)
                                        {
                                            operaciones.add("Or");
                                            operaciones.add("Temporal 1");
                                        }
                                        
                                        else
                                        {
                                            operaciones.add("And");
                                            operaciones.add("Temporal 1");
                                        }
                                        
                                        continuaRelacion = false;
                                        contadorLogico ++;
                                    }
                                    
                                    else
                                    {
                                        if (contenidoToken.get(i).toString().indexOf("ARM") != -1)
                                        {
                                            operaciones.add(contenidoEdicion.get(i));
                                            continuaRelacion = false;
                                        }
                                        
                                        else
                                        {
                                            continuaRelacion = false;
                                            inicioAsignacion = false;
                                            continuarParentesis = false;
                                            permitirLogica = false;
                                            contadorRelacion = 0;
                                            contadorLogico = 0;
                                            operaciones.clear();
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        
                        else
                        {
                            continuaRelacion = false;
                            inicioAsignacion = false;
                            continuarParentesis = false;
                            permitirLogica = false;
                            contadorRelacion = 0;
                            contadorLogico = 0;
                            operaciones.clear();
                            return false;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean subprocesoBloques (ArrayList <Object> contenidoEdicion, ArrayList <Object> contenidoToken)
    {   
        ArrayList <Object> operaciones = new ArrayList <Object>();
        
        for (int i = 0; i < contenidoEdicion.size(); i++) 
        {            
            if (contenidoEdicion.get(i).toString().compareTo("{") == 0) 
            {
                operaciones.add("Bloque 1");
                controlInstrucciones.add(operaciones);
                return true;
            }
            
            if (contenidoEdicion.get(i).toString().compareTo("}") == 0) 
            {
                operaciones.add("Bloque 2");
                controlInstrucciones.add(operaciones);
                return true;
            }
        }
        
        return false;
    }
    
    private void preprocesarEdicionCodigo ()
    {
        for (int i = 0; i < this.analisisEdicionCodigo.recuperarTotalLineaCodigo(); i++) 
        {
            JClass_EstructuraEdicionCodigo estructuraEdicion = this.analisisEdicionCodigo.recuperarEstructuraEdicionCodigo(i);
            ArrayList <Object> instruccionesEdicion = new ArrayList <Object> ();
            ArrayList <Object> tokenEdicion = new ArrayList <Object> ();
            ArrayList <Object> lineaEdicion = new ArrayList <Object> ();
            
            for (int j = 0; j < estructuraEdicion.recuperarTotalEstructuraContenidoEdicion(); j++) 
            {
                instruccionesEdicion.add(estructuraEdicion.recuperarEstructuraContenidoEdicion(j));
                 
                if (this.estructuraSimbolos.encontrarLexenaRegular(estructuraEdicion.recuperarEstructuraContenidoEdicion(j)) != -1)
                {
                    tokenEdicion.add(this.estructuraSimbolos.recuperarTokenRegular(this.estructuraSimbolos.encontrarLexenaRegular(estructuraEdicion.recuperarEstructuraContenidoEdicion(j))));
                }
                
                else
                {
                    tokenEdicion.add(this.estructuraErrores.recuperarTokenError(this.estructuraErrores.encontrarLexenaError(estructuraEdicion.recuperarEstructuraContenidoEdicion(j))));
                }
                
                lineaEdicion.add(i);
            }
            
            this.instruccionesEdicion.add(instruccionesEdicion);
            this.tokenEdicion.add(tokenEdicion);
            this.lineaEdicion.add(lineaEdicion);
            this.totalPreprocesado ++;
        }
    }
}