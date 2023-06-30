package sistemaProcesamiento;

import java.util.ArrayList;

public class JClass_EstructuraEnsamblador 
{
    private ArrayList <Integer> indiceInstruccion = new ArrayList <Integer>();
    private ArrayList <Object> etiquetaInstruccion = new ArrayList <Object>();
    private ArrayList <Object> menomicoInstruccion = new ArrayList <Object>();
    private ArrayList <Object> operandoGuardado = new ArrayList <Object>();
    private ArrayList <Object> operandoReferencia = new ArrayList <Object>();
    private int totalInstrucciones = 0;

    public JClass_EstructuraEnsamblador() 
    {
        
    }
    
    public void registrarInstruccion (String etiqueta, String menomico, String operandoGuardado, String operandoReferencia)
    {
        this.indiceInstruccion.add(totalInstrucciones + 1);
        this.etiquetaInstruccion.add(etiqueta);
        this.menomicoInstruccion.add(menomico);
        this.operandoGuardado.add(operandoGuardado);
        this.operandoReferencia.add(operandoReferencia);
        this.totalInstrucciones ++;
    }
    
    public void eliminarInstrucciones ()
    {
        this.indiceInstruccion.clear();
        this.etiquetaInstruccion.clear();
        this.menomicoInstruccion.clear();
        this.operandoGuardado.clear();
        this.operandoReferencia.clear();
        this.totalInstrucciones = 0;
    }
    
    public void eliminarInstruccion (int posicion)
    {
        this.indiceInstruccion.remove(posicion);
        this.indiceInstruccion.remove(posicion);
        this.etiquetaInstruccion.remove(posicion);
        this.menomicoInstruccion.remove(posicion);
        this.operandoGuardado.remove(posicion);
        this.operandoReferencia.remove(posicion);
        this.totalInstrucciones --;
    }
    
    public String recuperarFormatoEscrituraEnsamblador ()
    {
        if (this.totalInstrucciones == 0)
        {
            return "";
        }
        
        String formatoTiplo = "";
        int caracterMaxI = 0;
        int caracterMaxM = 0;
        int caracterMaxOG =  0;
        int caracterMaxOR =  0;
        
        for (int i = 0; i < totalInstrucciones; i++) 
        {
            if (caracterMaxI <= this.etiquetaInstruccion.get(i).toString().length())
            {
                caracterMaxI = this.etiquetaInstruccion.get(i).toString().length();
            }
            
            if (caracterMaxM <= this.menomicoInstruccion.get(i).toString().length())
            {
                caracterMaxM = this.menomicoInstruccion.get(i).toString().length();
            }
            
            if (caracterMaxOG <= this.operandoGuardado.get(i).toString().length())
            {
                caracterMaxOG = this.operandoGuardado.get(i).toString().length();
            }
            
            if (caracterMaxOR <= this.operandoReferencia.get(i).toString().length())
            {
                caracterMaxOR = this.operandoReferencia.get(i).toString().length();
            }
        }
        
        formatoTiplo += complementoFormatoTabla(etiquetaInstruccion.get(0).toString(), ' ', caracterMaxI) + "   " + complementoFormatoTabla(this.menomicoInstruccion.get(0).toString(), ' ', caracterMaxM) + "   " + complementoFormatoTabla(this.operandoGuardado.get(0).toString(), ' ', caracterMaxOG) + "   " + complementoFormatoTabla(this.operandoReferencia.get(0).toString(), ' ', caracterMaxOR);
        
        for (int i = 1; i < totalInstrucciones; i++)
        {
            formatoTiplo += "\n" + complementoFormatoTabla(etiquetaInstruccion.get(i).toString(), ' ', caracterMaxI) + "   " + complementoFormatoTabla(this.menomicoInstruccion.get(i).toString(), ' ', caracterMaxM) + "   " + complementoFormatoTabla(this.operandoGuardado.get(i).toString(), ' ', caracterMaxOG) + "   " + complementoFormatoTabla(this.operandoReferencia.get(i).toString(), ' ', caracterMaxOR);
        }
        
        return formatoTiplo;
    }
    
    private String complementoFormatoTabla (String contenidoPalabra, char contenidoComplemento, int maximoComplemento)
    {   
        if (contenidoPalabra.length() >= maximoComplemento)
        {
            return contenidoPalabra;
        }
        
        String formatoPalabra = "";
        
        for (int i = 0; i < (maximoComplemento - contenidoPalabra.length()); i++) 
        {
            formatoPalabra += contenidoComplemento;
        }
        
        return contenidoPalabra + formatoPalabra;
    }
    
    public ArrayList <Integer> recuperarListaIndice ()
    {
        return this.indiceInstruccion;
    }
    
    public ArrayList <Object> recuperarListaEtiqueta ()
    {
        return this.etiquetaInstruccion;
    }
    
    public ArrayList <Object> recuperarListaMenomico ()
    {
        return this.menomicoInstruccion;
    }
    
    public ArrayList <Object> recuperarListaOperandoGuardado ()
    {
        return this.operandoGuardado;
    }
    
    public ArrayList <Object> recuperarListaOperandoReferencia ()
    {
        return this.operandoReferencia;
    }
    
    public int recuperarIndice (int posicion)
    {
        return this.indiceInstruccion.get(posicion);
    }
    
    public String recuperarEtiqueta (int posicion)
    {
        return this.etiquetaInstruccion.get(posicion).toString();
    }
    
    public String recuperarMenomico (int posicion)
    {
        return this.menomicoInstruccion.get(posicion).toString();
    }
    
    public String recuperarOperandoGuardado (int posicion)
    {
        return this.operandoGuardado.get(posicion).toString();
    }
    
    public String recuperarOperandoReferencia (int posicion)
    {
        return this.operandoReferencia.get(posicion).toString();
    }
    
    public int recuperarTotalInstrucciones ()
    {
        return this.totalInstrucciones;
    }
    
    public static void main(String[] args) {
        JClass_EstructuraEnsamblador obj = new JClass_EstructuraEnsamblador ();
                
        obj.registrarInstruccion("contenidoPalabra", "0", "0", "0");
        obj.registrarInstruccion("contenidoPalabra", "0", "0", "0");
        obj.registrarInstruccion("contenidoPalabra", "0", "0", "0");
        
        System.out.println(obj.recuperarFormatoEscrituraEnsamblador());
    }
}
