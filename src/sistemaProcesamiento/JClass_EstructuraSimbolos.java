package sistemaProcesamiento;

import java.util.ArrayList;

public class JClass_EstructuraSimbolos 
{
    private ArrayList <Object> lexemaRegular = new ArrayList <Object>();
    private ArrayList <Object> tokenRegular = new ArrayList <Object>();
    private ArrayList <Object> tipoRegular = new ArrayList <Object>();
    private int totalSimbolos = 0;

    public JClass_EstructuraSimbolos() 
    {
        
    }    
    
    public boolean registrarSimbolos (String lexemaRegular, String tokenRegular)
    {
        if (this.encontrarLexenaRegular(lexemaRegular) != -1)
        {
            return false;
        }
        
        else
        {
            this.lexemaRegular.add(lexemaRegular);
            this.tokenRegular.add(tokenRegular);
            this.tipoRegular.add("");
            this.totalSimbolos ++;
            return true;
        }
    }
    
    public int encontrarLexenaRegular (String lexemaRegular)
    {   
        for (int i = 0; i < this.lexemaRegular.size(); i ++)
        {
            if (lexemaRegular.compareTo(this.lexemaRegular.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarTokenRegular (String tokenRegular)
    {   
        for (int i = 0; i < this.tokenRegular.size(); i ++)
        {
            if (tokenRegular.compareTo(this.tokenRegular.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public void eliminarSimbolos ()
    {
        this.lexemaRegular.clear();
        this.tokenRegular.clear();
        this.tipoRegular.clear();
        this.totalSimbolos = 0;
    }
    
    public ArrayList <Object> recuperarListaLexemaRegular ()
    {
        return this.lexemaRegular;
    }
    
    public ArrayList <Object> recuperarListaTokenRegular ()
    {
        return this.tokenRegular;
    }
    
    public ArrayList <Object> recuperarListaTipoRegular ()
    {
        return this.tipoRegular;
    }
    
    public String recuperarLexemaRegular (int posicionSimbolo)
    {
        return this.lexemaRegular.get(posicionSimbolo).toString();
    }
    
    public String recuperarTokenRegular (int posicionSimbolo)
    {
        return this.tokenRegular.get(posicionSimbolo).toString();
    }
    
    public String recuperarTipoRegular (int posicionSimbolo)
    {
        return this.tipoRegular.get(posicionSimbolo).toString();
    }
    
    public int recuperarTotalSimbolos ()
    {
        return this.totalSimbolos;
    }
}