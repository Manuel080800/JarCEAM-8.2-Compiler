package almacenTipografias;

import java.awt.Font;
import java.io.InputStream;

public class JClass_TipografiaPrivada 
{
    private String [] ubicacionTipografia = null;
    private int tipografiaSelecto = 0;

    public JClass_TipografiaPrivada(int tipografia) 
    {
        this.ubicacionTipografia = new String [2];
        this.ubicacionTipografia [0] = "FranklinGothicDemiCond.ttf";
        this.ubicacionTipografia [1] = "CalibriNormal.ttf";
        
        if (tipografia >= 0 && tipografia < 2)
        {
            this.tipografiaSelecto = tipografia;
        }
        
        else
        {
            System.err.println ("Tipografia seleccionada no existente, se selecciono el por defecto.");
        }
    }
    
    public Font obtenerTipografia ()
    {
        try 
        {
            InputStream lecturaTipografia =  getClass().getResourceAsStream(ubicacionTipografia [tipografiaSelecto]);
            return Font.createFont(Font.TRUETYPE_FONT, lecturaTipografia);
        }
        
        catch (Exception error) 
        {            
            System.err.println("Se produjo un error al obtener la tipografia " + ubicacionTipografia [tipografiaSelecto] + ".");
            return new Font("Arial", Font.PLAIN, 14);            
        }
    }
    
    public Font obtenerTipografia (int estilo)
    {
        Font tipografia = this.obtenerTipografia();
        return tipografia.deriveFont(estilo);
    }
    
    public Font obtenerTipografia (float tamaño)
    {
        Font tipografia = this.obtenerTipografia();
        return tipografia.deriveFont(tamaño);
    }
    
    public Font obtenerTipografia (int estilo, float tamaño)
    {
        Font tipografia = this.obtenerTipografia();
        return tipografia.deriveFont(estilo, tamaño);
    }
}