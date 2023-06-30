package almacenTipografias;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class JClass_TipografiaSistema 
{
    public JClass_TipografiaSistema() 
    {
        
    }
    
    public Font [] obtenerTipografiaSistema ()
    {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    }
    
    public String [] obtenerNombreTipografiaSistema (Font [] tipografiaSistema)
    {
        String [] nombreTipografiaSistema = new String [tipografiaSistema.length];
        
        for (int i = 0; i < tipografiaSistema.length; i++) 
        {
            nombreTipografiaSistema [i] = tipografiaSistema [i].getFontName();
        }
        
        return nombreTipografiaSistema;
    }
}
