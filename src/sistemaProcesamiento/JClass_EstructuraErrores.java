package sistemaProcesamiento;

import java.util.ArrayList;

public class JClass_EstructuraErrores 
{
    private ArrayList <Object> tokenError = new ArrayList <Object>();
    private ArrayList <Object> lexemaError = new ArrayList <Object>();
    private ArrayList <Object> lineaError = new ArrayList <Object>();
    private ArrayList <Object> descripcionError = new ArrayList <Object>();
    private int totalErrores = 0;

    public JClass_EstructuraErrores() 
    {
        
    }
    
    public boolean registrarError (String lexemaError, String tokenError, String lineaError, String descripcionError)
    {   
        if (this.encontrarLexenaError(lexemaError) != -1)
        {
            int posicion_Lexema = this.encontrarLexenaError(lexemaError);
            String lineaErrorCompletada = comprobarLinea(lineaError, this.lineaError.get(posicion_Lexema).toString());
            this.lineaError.set(posicion_Lexema, lineaErrorCompletada);
            return false;
        }
        
        else
        {
            this.lexemaError.add(lexemaError);
            this.tokenError.add(tokenError);
            this.lineaError.add(lineaError);
            this.descripcionError.add(descripcionError);
            this.totalErrores ++;
            return true;
        }
    }
    
    public int encontrarLexenaError (String lexemaError)
    {   
        for (int i = 0; i < this.lexemaError.size(); i ++)
        {
            if (lexemaError.compareTo(this.lexemaError.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public int encontrarTokenError (String tokenError)
    {   
        for (int i = 0; i < this.tokenError.size(); i ++)
        {
            if (tokenError.compareTo(this.tokenError.get(i).toString()) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    private String comprobarLinea (String lineaError, String lineaAnterior)
    {        
        if (lineaAnterior.indexOf(lineaError) == -1)
        {
            return lineaAnterior + "," + lineaError; 
        }
        
        else
        {
            return lineaAnterior;
        }
    }
    
    public void eliminarErrores ()
    {
        this.lexemaError.clear();
        this.tokenError.clear();
        this.lineaError.clear();
        this.descripcionError.clear();
        this.totalErrores = 0;
    }
    
    public ArrayList <Object> recuperarListaLexemaError ()
    {
        return this.lexemaError;
    }
    
    public ArrayList <Object> recuperarListaTokenError ()
    {
        return this.tokenError;
    }
    
    public ArrayList <Object> recuperarListaLineaError ()
    {
        return this.lineaError;
    }
    
    public ArrayList <Object> recuperarListaDescripcionError ()
    {
        return this.descripcionError;
    }
    
    public String recuperarLexemaError (int posicionError)
    {
        return this.lexemaError.get(posicionError).toString();
    }
    
    public String recuperarTokenError (int posicionError)
    {
        return this.tokenError.get(posicionError).toString();
    }
    
    public String recuperarLineaError (int posicionError)
    {
        return this.lineaError.get(posicionError).toString();
    }
    
    public String recuperarDescripcionError (int posicionError)
    {
        return this.descripcionError.get(posicionError).toString();
    }
    
    public int recuperarTotalErrores ()
    {
        return this.totalErrores;
    }
}