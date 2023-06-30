package sistemaProcesamiento;

import java.util.ArrayList;

public class JClass_EstructuraTiplo
{
    private ArrayList <Integer> tiploIndice = new ArrayList <Integer>();
    private ArrayList <Object> tiploDatoObjeto = new ArrayList <Object>();
    private ArrayList <Object> tiploDatoFuente = new ArrayList <Object>();
    private ArrayList <Object> tiploOperador = new ArrayList <Object>();
    private ArrayList <Object> tiploEtiqueta = new ArrayList <Object>();
    private int totalTiplo = 1;

    public JClass_EstructuraTiplo() 
    {
        this.tiploIndice.add(0);
        this.tiploDatoObjeto.add("Dato objeto:");
        this.tiploDatoFuente.add("Dato fuente:");
        this.tiploOperador.add("Operador:");
        this.tiploEtiqueta.add("");
    }
    
    public void registrarTiplo (String datoObjeto, String datoFuente, String operador, String etiqueta)
    {
        this.tiploIndice.add(this.totalTiplo);
        this.tiploDatoObjeto.add(datoObjeto);
        this.tiploDatoFuente.add(datoFuente);
        this.tiploOperador.add(operador);
        this.tiploEtiqueta.add(etiqueta);
        this.totalTiplo ++;
    }
    
    public String recuperarFormatoEscrituraTriplo ()
    {
        String formatoTiplo = "";
        int caracterMaxDO = 0;
        int caracterMaxDF = 0;
        int caracterMaxO =  0;
        int caracterTotalTiplo = 0;
        
        for (int i = 0; i < totalTiplo; i++) 
        {
            if (caracterMaxDO <= this.tiploDatoObjeto.get(i).toString().length())
            {
                caracterMaxDO = this.tiploDatoObjeto.get(i).toString().length();
            }
            
            if (caracterMaxDF <= this.tiploDatoFuente.get(i).toString().length())
            {
                caracterMaxDF = this.tiploDatoFuente.get(i).toString().length();
            }
            
            if (caracterMaxO <= this.tiploOperador.get(i).toString().length())
            {
                caracterMaxO = this.tiploOperador.get(i).toString().length();
            }
        }
        
        caracterTotalTiplo = String.valueOf(this.totalTiplo - 1).length();
        
        formatoTiplo += complementoFormatoTabla("", ' ', caracterTotalTiplo) + "   " + complementoFormatoTabla(this.tiploDatoObjeto.get(0).toString(), ' ', caracterMaxDO) + "   " + complementoFormatoTabla(this.tiploDatoFuente.get(0).toString(), ' ', caracterMaxDF) + "   " + complementoFormatoTabla(this.tiploOperador.get(0).toString(), ' ', caracterMaxO);
        
        for (int i = 1; i < totalTiplo; i++)
        {
            formatoTiplo += "\n" + complementoFormatoTabla(String.valueOf(i), ' ', caracterTotalTiplo) + "   " + complementoFormatoTabla(this.tiploDatoObjeto.get(i).toString(), ' ', caracterMaxDO) + "   " + complementoFormatoTabla(this.tiploDatoFuente.get(i).toString(), ' ', caracterMaxDF) + "   " + complementoFormatoTabla(this.tiploOperador.get(i).toString(), ' ', caracterMaxO);
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
    
    public int encontrarIndice (int indice)
    {   
        for (int i = 0; i < this.tiploIndice.size(); i ++)
        {
            if (indice == this.tiploIndice.get(i))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarIndice (int indice, int posicionInicial, int posicionFinal)
    {   
        for (int i = posicionInicial; i < posicionFinal; i ++)
        {
            if (indice == this.tiploIndice.get(i))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarDatoObjecto (String datoObjeto)
    {   
        for (int i = 0; i < this.tiploDatoObjeto.size(); i ++)
        {
            if (datoObjeto.compareTo(this.tiploDatoObjeto.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarDatoObjecto (String datoObjeto, int posicionInicial, int posicionFinal)
    {   
        for (int i = posicionInicial; i < posicionFinal; i ++)
        {
            if (datoObjeto.compareTo(this.tiploDatoObjeto.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarDatoFuente (String datoFuente)
    {   
        for (int i = 0; i < this.tiploDatoFuente.size(); i ++)
        {
            if (datoFuente.compareTo(this.tiploDatoFuente.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarDatoFuente (String datoFuente, int posicionInicial, int posicionFinal)
    {   
        for (int i = posicionInicial; i < posicionFinal; i ++)
        {
            if (datoFuente.compareTo(this.tiploDatoFuente.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarOperador (String operador)
    {   
        for (int i = 0; i < this.tiploOperador.size(); i ++)
        {
            if (operador.compareTo(this.tiploOperador.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarOperador (String operador, int posicionInicial, int posicionFinal)
    {   
        for (int i = posicionInicial; i < posicionFinal; i ++)
        {
            if (operador.compareTo(this.tiploOperador.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarEtiqueta (String etiqueta)
    {   
        for (int i = 0; i < this.tiploOperador.size(); i ++)
        {
            if (etiqueta.compareTo(this.tiploEtiqueta.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarEtiqueta (String etiqueta, int posicionInicial, int posicionFinal)
    {   
        for (int i = posicionInicial; i < posicionFinal; i ++)
        {
            if (etiqueta.compareTo(this.tiploEtiqueta.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public void eliminarTiplo ()
    {
        this.tiploIndice.clear();
        this.tiploDatoObjeto.clear();
        this.tiploDatoFuente.clear();
        this.tiploOperador.clear();
        this.tiploEtiqueta.clear();
        this.totalTiplo = 1;
        
        this.tiploIndice.add(0);
        this.tiploDatoObjeto.add("Dato objeto:");
        this.tiploDatoFuente.add("Dato fuente:");
        this.tiploOperador.add("Operador:");
        this.tiploEtiqueta.add("");
    }
    
    public ArrayList <Integer> recuperarListaTiploIndice ()
    {
        return this.tiploIndice;
    }
    
    public ArrayList <Object> recuperarListaTiploDatoObjeto ()
    {
        return this.tiploDatoObjeto;
    }
    
    public ArrayList <Object> recuperarListaTiploDatoFuente ()
    {
        return this.tiploDatoFuente;
    }
    
    public ArrayList <Object> recuperarListaTiploOperador ()
    {
        return this.tiploOperador;
    }
    
    public ArrayList <Object> recuperarListaTiploEtiqueta ()
    {
        return this.tiploEtiqueta;
    }
    
    public int recuperarTiploIndice (int posicion)
    {
        return this.tiploIndice.get(posicion);
    }
    
    public String recuperarTiploDatoObjecto (int posicion)
    {
        return this.tiploDatoObjeto.get(posicion).toString();
    }
    
    public String recuperarTiploDatoFuente (int posicion)
    {
        return this.tiploDatoFuente.get(posicion).toString();
    }
    
    public String recuperarTiploOperador (int posicion)
    {
        return this.tiploOperador.get(posicion).toString();
    }
    
    public String recuperarTiploEtiqueta (int posicion)
    {
        return this.tiploEtiqueta.get(posicion).toString();
    }
    
    public int recuperarTotalTiplo ()
    {
        return this.totalTiplo;
    }
}