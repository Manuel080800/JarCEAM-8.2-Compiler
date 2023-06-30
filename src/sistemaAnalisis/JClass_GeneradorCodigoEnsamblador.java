package sistemaAnalisis;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sistemaProcesamiento.JClass_EstructuraEnsamblador;
import sistemaProcesamiento.JClass_EstructuraTiplo;

public class JClass_GeneradorCodigoEnsamblador 
{
    private JClass_EstructuraTiplo estructuraTiplo;
    private JClass_EstructuraEnsamblador estructuraEnsamblador;
    
    public JClass_GeneradorCodigoEnsamblador( JClass_EstructuraTiplo estructuraTiplo, JClass_EstructuraEnsamblador estructuraEnsamblador) 
    {
        this.estructuraTiplo = estructuraTiplo;
        this.estructuraEnsamblador = estructuraEnsamblador;
    }
    
    public void generarCodigoEnsamblador ()
    {
        for (int i = 0; i < this.estructuraTiplo.recuperarTotalTiplo(); i++) 
        {
            if (this.estructuraTiplo.recuperarTiploEtiqueta(i).compareTo("Asignacion") == 0)
            {
                int ID = i;
                JClass_EstructuraTiplo analisisTemporal = new JClass_EstructuraTiplo ();
                analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(i), this.estructuraTiplo.recuperarTiploDatoFuente(i), this.estructuraTiplo.recuperarTiploOperador(i), this.estructuraTiplo.recuperarTiploEtiqueta(i));
                
                for (int j = (i + 1); j < this.estructuraTiplo.recuperarTotalTiplo(); j++)
                {
                    if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") == 0)
                    {
                        analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(j), this.estructuraTiplo.recuperarTiploDatoFuente(j), this.estructuraTiplo.recuperarTiploOperador(j), this.estructuraTiplo.recuperarTiploEtiqueta(j));
                        System.out.println("Entro 1");
                    }
                    
                    System.out.println(j + " --> " + ((j + 1) == this.estructuraTiplo.recuperarTotalTiplo()));
                   
                    if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") != 0 || (j + 1) == this.estructuraTiplo.recuperarTotalTiplo())
                    {
                        System.out.println("Entro 2");
                        generarEnsambladorAsignacion(analisisTemporal, ID);
                        i = (j - 1);
                        break;
                    }
                }
            }
            
            if (this.estructuraTiplo.recuperarTiploEtiqueta(i).compareTo("Aritmetica") == 0)
            {
                int ID = i;
                JClass_EstructuraTiplo analisisTemporal = new JClass_EstructuraTiplo ();
                analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(i), this.estructuraTiplo.recuperarTiploDatoFuente(i), this.estructuraTiplo.recuperarTiploOperador(i), this.estructuraTiplo.recuperarTiploEtiqueta(i));
                
                for (int j = (i + 1); j < this.estructuraTiplo.recuperarTotalTiplo(); j++)
                {
                    if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") == 0)
                    {
                        analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(j), this.estructuraTiplo.recuperarTiploDatoFuente(j), this.estructuraTiplo.recuperarTiploOperador(j), this.estructuraTiplo.recuperarTiploEtiqueta(j));
                    }
                    
                    System.out.println(j + " --> " + ((j + 1) == this.estructuraTiplo.recuperarTotalTiplo()));
                   
                    if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") != 0 || (j + 1) == this.estructuraTiplo.recuperarTotalTiplo())
                    {
                        generarEnsambladorAritmetico(analisisTemporal, ID);
                        i = (j - 1);
                        break;
                    }
                }
            }
            
            if (this.estructuraTiplo.recuperarTiploEtiqueta(i).compareTo("Ciclo: Operando 1") == 0)
            {
                int ID = i;
                JClass_EstructuraTiplo analisisTemporal = new JClass_EstructuraTiplo ();
                analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(i), this.estructuraTiplo.recuperarTiploDatoFuente(i), this.estructuraTiplo.recuperarTiploOperador(i), this.estructuraTiplo.recuperarTiploEtiqueta(i));
                
                for (int j = (i + 1); j < this.estructuraTiplo.recuperarTotalTiplo(); j++)
                {
                    if ((this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Ciclo: Operando 1") != 0 && this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Asignacion") != 0 && this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Aritmetica") != 0 && this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Retorno") != 0 && this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("ADICIONAL") != 0))
                    {
                        analisisTemporal.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(j), this.estructuraTiplo.recuperarTiploDatoFuente(j), this.estructuraTiplo.recuperarTiploOperador(j), this.estructuraTiplo.recuperarTiploEtiqueta(j));
                    }
                    
                    System.out.println(j + " --> " + ((j + 1) == this.estructuraTiplo.recuperarTotalTiplo()));
                   
                    if ((this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Ciclo: Operando 1") == 0 || this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Asignacion") == 0 || this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Aritmetica") == 0 || this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("Retorno") == 0 || this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("ADICIONAL") == 0) || (j + 1) == this.estructuraTiplo.recuperarTotalTiplo())
                    {
                        generarEnsambladorCiclo(analisisTemporal, ID);
                        i = (j - 1);
                        break;
                    }
                }
            }
            
            if (this.estructuraTiplo.recuperarTiploEtiqueta(i).compareTo("Retorno") == 0)
            {
                int ID = i;
                this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "JMP", "ETI-" + this.estructuraTiplo.recuperarTiploDatoFuente(i), "");   
            }
            
            if (this.estructuraTiplo.recuperarTiploEtiqueta(i).compareTo("ADICIONAL") == 0)
            {
                int ID = i;
                this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "", "", "");   
            }
        }
        
//      DESCONTINUADO: MODULO DE ELIMINACION MOV AX, CX --> MOV CX, AX YA QUE REQUIERE DE DOBLE MOVIMIENTO Y PUEDE PRESENTAR ERRORES DE INDICE.
//        for (int i = this.estructuraEnsamblador.recuperarTotalInstrucciones(); i < 0; i--) 
//        {
//            if (this.estructuraEnsamblador.recuperarMenomico(i).compareTo("MOV") == 0 && this.estructuraEnsamblador.recuperarOperandoGuardado(i).compareTo("CX") == 0 && this.estructuraEnsamblador.recuperarOperandoReferencia(i).compareTo("AX") == 0)
//            {
//                if (this.estructuraEnsamblador.recuperarMenomico(i - 1).compareTo("MOV") == 0 && this.estructuraEnsamblador.recuperarOperandoGuardado(i - 1).compareTo("AX") == 0 && this.estructuraEnsamblador.recuperarOperandoReferencia(i - 1).compareTo("CX") == 0)
//                {
//                    
//                }
//            }
//        }
        
        for (int i = 0; i < this.estructuraEnsamblador.recuperarTotalInstrucciones(); i++) 
        {
            boolean encontrado = false;
            
            for (int j = 0; j < this.estructuraEnsamblador.recuperarTotalInstrucciones(); j++) 
            {
                if (this.estructuraEnsamblador.recuperarEtiqueta(i).compareTo(this.estructuraEnsamblador.recuperarOperandoGuardado(j)) == 0)
                {
                    encontrado = true;
                }
            }
            
            if (encontrado == false)
            {
                this.estructuraEnsamblador.recuperarListaEtiqueta().set(i, "");
            }
        }
        
//        DESCONTINUADO: MODULO DE ELIMINACION DE REPETICION.
//        for (int i = 0; i < this.estructuraEnsamblador.recuperarTotalInstrucciones(); i++) 
//        {
//            boolean encontrado = false;
//            int reseteo = 0;
//            
//            for (int j = i + 1; j < this.estructuraEnsamblador.recuperarTotalInstrucciones(); j++) 
//            {
//                if (this.estructuraEnsamblador.recuperarEtiqueta(i).compareTo(this.estructuraEnsamblador.recuperarEtiqueta(j)) == 0)
//                {
//                    encontrado = true;
//                    reseteo = j;
//                }
//            }
//            
//            if (encontrado == true)
//            {
//                this.estructuraEnsamblador.recuperarListaEtiqueta().set(reseteo, "");
//            }
//        }
        
        System.out.println("Codigo ensamblador: ");
        System.out.println("");
        System.out.println(this.estructuraEnsamblador.recuperarFormatoEscrituraEnsamblador());
    }
    
    private void generarEnsambladorAsignacion (JClass_EstructuraTiplo analisisTemporal, int ID)
    {
        System.out.println("tamanio: " + analisisTemporal.recuperarTotalTiplo());
        
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            String registroMemoriaIZQ = "";
            String registroMemoriaDER = "";

            Pattern expresion_Regular = Pattern.compile("(T)([0-9]+)");
            Matcher segmento_EvaluarIZQ = expresion_Regular.matcher(analisisTemporal.recuperarTiploDatoObjecto(i));
            Matcher segmento_EvaluarDER = expresion_Regular.matcher(analisisTemporal.recuperarTiploDatoFuente(i));

            if (segmento_EvaluarIZQ.matches())
            {
                registroMemoriaIZQ = "AX";
            }

            else
            {
                registroMemoriaIZQ = analisisTemporal.recuperarTiploDatoObjecto(i);
            }

            if (segmento_EvaluarDER.matches())
            {
                registroMemoriaDER = "AX";
            }

            else
            {
                registroMemoriaDER = analisisTemporal.recuperarTiploDatoFuente(i);
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("=") == 0 && analisisTemporal.recuperarTiploEtiqueta(i).compareTo("Asignacion") == 0)
            {   
                this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", registroMemoriaIZQ, registroMemoriaDER);
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("=") == 0 && analisisTemporal.recuperarTiploEtiqueta(i).compareTo("") == 0)
            {
                this.estructuraEnsamblador.registrarInstruccion("", "MOV", registroMemoriaIZQ, registroMemoriaDER);
            }
        }
    }
    
    private void generarEnsambladorAritmetico (JClass_EstructuraTiplo analisisTemporal, int ID)
    {
        boolean primerOrden = false;
        boolean segundoOrden = false;
        boolean inicial = true;
        
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                primerOrden = true;
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                segundoOrden = true;
            }
        }
        
        // Solo suma y resta
        if (primerOrden == true && segundoOrden == false)
        {
            generarEnsambladorAritmeticoPrimerOrden(analisisTemporal, ID, inicial);
        }
        
        // Solo multiplicacion, division y modulo
        if (primerOrden == false && segundoOrden == true)
        {
            generadorEnsambladorAritmeticoSegundoOrden(analisisTemporal, ID, inicial);
        }
        
        // Aritmetica compuesta
        if (primerOrden == true && segundoOrden == true)
        {
            ArrayList <String> temporal = new ArrayList <String> ();
            ArrayList <Integer> inicioTemporal = new ArrayList <Integer> ();
            ArrayList <Integer> finalTemporal = new ArrayList <Integer> ();
            int contador = 0;
            String memoriaTemporal = "";
            
            for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (memoriaTemporal.compareTo("") == 0)
                    {
                        memoriaTemporal = analisisTemporal.recuperarTiploDatoObjecto(i - 1);
                        inicioTemporal.add(i - 1);
                    }

                    else
                    {
                        if (analisisTemporal.recuperarTiploDatoFuente(i - 1).compareTo(memoriaTemporal) == 0)
                        {
                            memoriaTemporal = analisisTemporal.recuperarTiploDatoObjecto(i - 1);
                        }

                        else
                        {
                           contador ++;
                           temporal.add(memoriaTemporal);
                           memoriaTemporal = "";
                           finalTemporal.add(i - 2);
                           i -= 2;
                        }
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                {
                    contador ++;
                    temporal.add(memoriaTemporal);
                    memoriaTemporal = "";
                    finalTemporal.add(i - 2);
                    i -= 2;
                    break;
                }
            }
            
            System.out.println("CONTROL: " + temporal.size() + " --> " + inicioTemporal.size() + " --> " + finalTemporal.size());
            
            for (int i = 0; i < contador; i++) 
            {
                System.out.println("MEM: " + temporal.get(i) + " --> " + inicioTemporal.get(i) + " - " + finalTemporal.get(i));
            }
            
            generadorEnsambladorAritmeticoCompuesto(analisisTemporal, ID, inicial, temporal, inicioTemporal, finalTemporal, contador);
        }
    }
    
    private void generarEnsambladorAritmeticoPrimerOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial)
    {
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                }
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("=") == 0 && (i + 1) == analisisTemporal.recuperarTotalTiplo())
            {
                this.estructuraEnsamblador.registrarInstruccion("", "MOV", analisisTemporal.recuperarTiploDatoObjecto(i), "AX");
            }
        }
    }
    
    private void generadorEnsambladorAritmeticoSegundoOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial)
    {
        boolean omitir = false;
        
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " *");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "MUL", "BL", "");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " /");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " %");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AL", "AH");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("=") == 0 && (i + 1) == analisisTemporal.recuperarTotalTiplo())
            {
                this.estructuraEnsamblador.registrarInstruccion("", "MOV", analisisTemporal.recuperarTiploDatoObjecto(i), "AX");
            }
        }
    }
    
    private void generadorEnsambladorAritmeticoCompuesto (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial, ArrayList <String> MEM, ArrayList <Integer> IMEN, ArrayList <Integer> FMEN, int contador)
    {
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                boolean encontrado = false;
                
                for (int j = 0; j < contador; j++) 
                {
                    if (analisisTemporal.recuperarTiploDatoFuente(i - 1).compareTo(MEM.get(j)) == 0 && analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                    {
                        subGeneradorEnsambladorAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                        encontrado = true;
                        inicial = false;
                    }
                }
                
                if (encontrado == true)
                {
                    boolean encontradoDOS = false;
                    
                    for (int j = 0; j < contador; j++) 
                    {
                        if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                        {
                            subGeneradorEnsambladorAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                            encontradoDOS = true;
                        }
                    }
                    
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                    }
                    
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                        this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                        this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                    }
                }
                
                if (encontrado == false)
                {
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0)
                    {
                        if (inicial)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            inicial = false;
                        }

                        else
                        {
                            if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                            {
                                this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            }
                        }

                        boolean encontradoDOS = false;
                    
                        for (int j = 0; j < contador; j++) 
                        {
                            if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                            {
                                subGeneradorEnsambladorAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                                encontradoDOS = true;
                            }
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                        }
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                    {
                        if (inicial)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            inicial = false;
                        }

                        else
                        {
                            if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                            {
                                this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            }
                        }

                        boolean encontradoDOS = false;
                    
                        for (int j = 0; j < contador; j++) 
                        {
                            if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                            {
                                subGeneradorEnsambladorAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                                encontradoDOS = true;
                            }
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                        }
                    }
                }
            }

            if (analisisTemporal.recuperarTiploOperador(i).compareTo("=") == 0 && (i + 1) == analisisTemporal.recuperarTotalTiplo())
            {
                this.estructuraEnsamblador.registrarInstruccion("", "MOV", analisisTemporal.recuperarTiploDatoObjecto(i), "AX");
            }
        }
    }
    
    private void subGeneradorEnsambladorAritmeticoSegundoOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial, int IMEN, int FMEN)
    {
        boolean omitir = false;
        
        for (int i = IMEN; i <= FMEN; i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "MUL", "BL", "");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AL", "AH");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
            }
        }
    }
    
    private void generarEnsambladorCiclo (JClass_EstructuraTiplo analisisTemporal, int ID)
    {
        System.out.println("CICLO:");
        System.out.println(analisisTemporal.recuperarFormatoEscrituraTriplo());

        boolean inicio = true;
        boolean compuestoIZQ = false;
        boolean compuestoDER = false;

        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploEtiqueta(i).compareTo("Ciclo: Operando 1") == 0 || analisisTemporal.recuperarTiploEtiqueta(i).compareTo("Operando 1") == 0)
            {
                if (analisisTemporal.recuperarTiploEtiqueta(i + 1).compareTo("Operando 2") == 0)
                {
                    if (inicio == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i));
                        inicio = false;
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i));
                    }
                    
                    compuestoIZQ = false;
                }
                
                else
                {
                    JClass_EstructuraTiplo analisisAritmetico = new JClass_EstructuraTiplo ();
                    analisisAritmetico.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(i), this.estructuraTiplo.recuperarTiploDatoFuente(i), this.estructuraTiplo.recuperarTiploOperador(i), this.estructuraTiplo.recuperarTiploEtiqueta(i));
                
                    for (int j = (i + 1); j < this.estructuraTiplo.recuperarTotalTiplo(); j++)
                    {
                        if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") == 0)
                        {
                            analisisAritmetico.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(j), this.estructuraTiplo.recuperarTiploDatoFuente(j), this.estructuraTiplo.recuperarTiploOperador(j), this.estructuraTiplo.recuperarTiploEtiqueta(j));
                        }
                        
                        if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") != 0 || (j + 1) == this.estructuraTiplo.recuperarTotalTiplo())
                        {
                            generarEnsambladorCicloAritmetico(analisisAritmetico, ID, inicio);
                            i = (j - 1);
                            break;
                        }
                    }
                    
                    compuestoIZQ = true;
                }
            }
            
            if (analisisTemporal.recuperarTiploEtiqueta(i).compareTo("Operando 2") == 0)
            {
                if (analisisTemporal.recuperarTiploEtiqueta(i + 1).compareTo("Condicion") == 0)
                {
                    if (compuestoIZQ == false)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    }
                    
                    compuestoDER = false;
                }
                
                else
                {
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "DX", "AX");
                    
                    JClass_EstructuraTiplo analisisAritmetico = new JClass_EstructuraTiplo ();
                    analisisAritmetico.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(i), this.estructuraTiplo.recuperarTiploDatoFuente(i), this.estructuraTiplo.recuperarTiploOperador(i), this.estructuraTiplo.recuperarTiploEtiqueta(i));
                
                    for (int j = (i + 1); j < this.estructuraTiplo.recuperarTotalTiplo(); j++)
                    {
                        if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") == 0)
                        {
                            analisisAritmetico.registrarTiplo(this.estructuraTiplo.recuperarTiploDatoObjecto(j), this.estructuraTiplo.recuperarTiploDatoFuente(j), this.estructuraTiplo.recuperarTiploOperador(j), this.estructuraTiplo.recuperarTiploEtiqueta(j));
                        }
                        
                        if (this.estructuraTiplo.recuperarTiploEtiqueta(j).compareTo("") != 0 || (j + 1) == this.estructuraTiplo.recuperarTotalTiplo())
                        {
                            generarEnsambladorCicloAritmetico(analisisAritmetico, ID, inicio);
                            i = (j - 1);
                            break;
                        }
                    }
                    
                    compuestoDER = true;
                }
            }
            
            if (analisisTemporal.recuperarTiploEtiqueta(i).compareTo("Condicion") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("<=") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "LE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "LE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo(">=") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "GE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "GE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("==") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "EQ", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "EQ", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("!=") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "NE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "NE", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("<") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "LT", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "LT", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo(">") == 0)
                {
                    if (compuestoDER == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "DX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "GT", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                    
                    else
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "CMP", "AX", "BX");
                        this.estructuraEnsamblador.registrarInstruccion("", "GT", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 1), "");
                        this.estructuraEnsamblador.registrarInstruccion("", "JMP", "ETI-" + analisisTemporal.recuperarTiploOperador(i + 2), "");
                    }
                }
                
                compuestoIZQ = false;
                compuestoDER = false;
                inicio = true;
                ID = this.estructuraTiplo.recuperarTiploIndice(ID + i + 2);
            }
        }
    }
    
    private void generarEnsambladorCicloAritmetico (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial)
    {
        boolean primerOrden = false;
        boolean segundoOrden = false;
        
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                primerOrden = true;
            }
            
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                segundoOrden = true;
            }
        }
        
        // Solo suma y resta
        if (primerOrden == true && segundoOrden == false)
        {
            generarEnsambladorCicloAritmeticoPrimerOrden(analisisTemporal, ID, inicial);
        }
        
        // Solo multiplicacion, division y modulo
        if (primerOrden == false && segundoOrden == true)
        {
            generadorEnsambladorCicloAritmeticoSegundoOrden(analisisTemporal, ID, inicial);
        }
        
        // Aritmetica compuesta
        if (primerOrden == true && segundoOrden == true)
        {
            ArrayList <String> temporal = new ArrayList <String> ();
            ArrayList <Integer> inicioTemporal = new ArrayList <Integer> ();
            ArrayList <Integer> finalTemporal = new ArrayList <Integer> ();
            int contador = 0;
            String memoriaTemporal = "";
            
            for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (memoriaTemporal.compareTo("") == 0)
                    {
                        memoriaTemporal = analisisTemporal.recuperarTiploDatoObjecto(i - 1);
                        inicioTemporal.add(i - 1);
                    }

                    else
                    {
                        if (analisisTemporal.recuperarTiploDatoFuente(i - 1).compareTo(memoriaTemporal) == 0)
                        {
                            memoriaTemporal = analisisTemporal.recuperarTiploDatoObjecto(i - 1);
                        }

                        else
                        {
                           contador ++;
                           temporal.add(memoriaTemporal);
                           memoriaTemporal = "";
                           finalTemporal.add(i - 2);
                           i -= 2;
                        }
                    }
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                {
                    contador ++;
                    temporal.add(memoriaTemporal);
                    memoriaTemporal = "";
                    finalTemporal.add(i - 2);
                    i -= 2;
                    break;
                }
            }
            
            System.out.println("CONTROL: " + temporal.size() + " --> " + inicioTemporal.size() + " --> " + finalTemporal.size());
            
            for (int i = 0; i < contador; i++) 
            {
                System.out.println("MEM: " + temporal.get(i) + " --> " + inicioTemporal.get(i) + " - " + finalTemporal.get(i));
            }
            
            generadorEnsambladorAritmeticoCompuesto(analisisTemporal, ID, inicial, temporal, inicioTemporal, finalTemporal, contador);
        }
    }
    
    private void generarEnsambladorCicloAritmeticoPrimerOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial)
    {
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                }
            }
        }
    }
    
    private void generadorEnsambladorCicloAritmeticoSegundoOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial)
    {
        boolean omitir = false;
        
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " *");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "MUL", "BL", "");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " /");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        System.err.println("EXTRAÑO: " + omitir + " --> " + i + " %");
                        System.err.println("??? " + (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0) + " = " + (omitir == false));
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AL", "AH");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
            }
        }
    }
    
    private void generadorEnsambladorCicloAritmeticoCompuesto (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial, ArrayList <String> MEM, ArrayList <Integer> IMEN, ArrayList <Integer> FMEN, int contador)
    {
        for (int i = 1; i < analisisTemporal.recuperarTotalTiplo(); i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
            {
                boolean encontrado = false;
                
                for (int j = 0; j < contador; j++) 
                {
                    if (analisisTemporal.recuperarTiploDatoFuente(i - 1).compareTo(MEM.get(j)) == 0 && analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                    {
                        subGeneradorEnsambladorCicloAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                        encontrado = true;
                        inicial = false;
                    }
                }
                
                if (encontrado == true)
                {
                    boolean encontradoDOS = false;
                    
                    for (int j = 0; j < contador; j++) 
                    {
                        if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                        {
                            subGeneradorEnsambladorCicloAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                            encontradoDOS = true;
                        }
                    }
                    
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                    }
                    
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                        this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                        this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                    }
                }
                
                if (encontrado == false)
                {
                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0)
                    {
                        if (inicial)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            inicial = false;
                        }

                        else
                        {
                            if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                            {
                                this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            }
                        }

                        boolean encontradoDOS = false;
                    
                        for (int j = 0; j < contador; j++) 
                        {
                            if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                            {
                                subGeneradorEnsambladorCicloAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                                encontradoDOS = true;
                            }
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                        }
                    }

                    if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0)
                    {
                        if (inicial)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            inicial = false;
                        }

                        else
                        {
                            if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0)
                            {
                                this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            }
                        }

                        boolean encontradoDOS = false;
                    
                        for (int j = 0; j < contador; j++) 
                        {
                            if (analisisTemporal.recuperarTiploDatoFuente(i).compareTo(MEM.get(j)) == 0 && (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0))
                            {
                                subGeneradorEnsambladorCicloAritmeticoSegundoOrden(analisisTemporal, ID, inicial, IMEN.get(j), FMEN.get(j));
                                encontradoDOS = true;
                            }
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == true)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", "CX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("-") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "SUB", "AX", "BX");
                        }

                        if (analisisTemporal.recuperarTiploOperador(i).compareTo("+") == 0 && encontradoDOS == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BX", analisisTemporal.recuperarTiploDatoFuente(i));
                            this.estructuraEnsamblador.registrarInstruccion("", "ADD", "AX", "BX");
                        }
                    }
                }
            }
        }
    }
    
    private void subGeneradorEnsambladorCicloAritmeticoSegundoOrden (JClass_EstructuraTiplo analisisTemporal, int ID, boolean inicial, int IMEN, int FMEN)
    {
        boolean omitir = false;
        
        for (int i = IMEN; i <= FMEN; i++) 
        {
            if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0 || analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
            {
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("*") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "MUL", "BL", "");
                }

                if (analisisTemporal.recuperarTiploOperador(i).compareTo("/") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
                
                if (analisisTemporal.recuperarTiploOperador(i).compareTo("%") == 0)
                {
                    if (inicial)
                    {
                        this.estructuraEnsamblador.registrarInstruccion("ETI-" + ID, "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                        inicial = false;
                        omitir = true;
                    }
                    
                    else
                    {
                        if (analisisTemporal.recuperarTiploOperador(i - 1).compareTo("=") == 0 && omitir == false)
                        {
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "CX", "AX");
                            this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AX", analisisTemporal.recuperarTiploDatoFuente(i - 1));
                            omitir = true;
                        }
                    }
                    
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "BL", analisisTemporal.recuperarTiploDatoFuente(i));
                    this.estructuraEnsamblador.registrarInstruccion("", "DIV", "BL", "");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AL", "AH");
                    this.estructuraEnsamblador.registrarInstruccion("", "MOV", "AH", "0");
                }
            }
        }
    }
}
