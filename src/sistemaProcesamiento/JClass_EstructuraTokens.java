package sistemaProcesamiento;

import java.util.ArrayList;

public class JClass_EstructuraTokens 
{
    private ArrayList <Object> contenidoLineaTokens = new ArrayList<Object>();
    private String lineaContenidoToken= "";
    private boolean inicioLinea = true;
    private int totalLineasTokens = 0;

    public JClass_EstructuraTokens() 
    {
        
    }
    
    public void escribirLineaContenidoToken (String contenidoToken)
    {
        if (this.inicioLinea == true)
        {
            this.lineaContenidoToken += contenidoToken;
            this.inicioLinea = false;
        }

        else
        {
            this.lineaContenidoToken += (" " + contenidoToken);
        }
    }
    
    public void registrarLineaContenidoToken ()
    {
        this.contenidoLineaTokens.add(this.lineaContenidoToken);
        this.lineaContenidoToken = "";
        this.inicioLinea = true;
        this.totalLineasTokens ++;
    }
    
    public void eliminarLineasTokens ()
    {
        this.contenidoLineaTokens.clear();
        this.lineaContenidoToken = "";
        this.inicioLinea = true;
        this.totalLineasTokens = 0;
    }
    
    public ArrayList <Object> recuperarListaLineasContenidoToken ()
    {
        return this.contenidoLineaTokens;
    }
    
    public String recuperarLineaContenidoTokenEscritas ()
    {
        String lineaContenidoTokensEscrita = "";
        
        for (int i = 0; i < this.contenidoLineaTokens.size(); i++)
        {
            if (i == 0)
            {
                lineaContenidoTokensEscrita += this.contenidoLineaTokens.get(i).toString();
            }
            
            else
            {
                lineaContenidoTokensEscrita += "\n" + this.contenidoLineaTokens.get(i).toString();
            }
        }
        
        return lineaContenidoTokensEscrita;
    }
    
    public String recuperarLineaContenidoToken ()
    {
        return this.lineaContenidoToken;
    }
    
    public int recuperarTotalLineaToken ()
    {
        return this.totalLineasTokens;
    }
}