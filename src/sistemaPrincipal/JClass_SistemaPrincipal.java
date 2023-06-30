package sistemaPrincipal;

import almacenTipografias.JClass_TipografiaSistema;
import java.awt.Font;
import sistemaInicial.JDialog_PantallaInicio;
import sistemaUsuario.JFrame_PantallaPrincipal;

public class JClass_SistemaPrincipal 
{
    private JDialog_PantallaInicio pantallaInicio = null;
    private JClass_TipografiaSistema tipografiaSistema = null;
    private JFrame_PantallaPrincipal pantallaPrincipal = null;
    private Thread ejecucionInicial = null;
    private Thread ejecucionSecundario = null;
    
    public JClass_SistemaPrincipal() 
    {
        this.pantallaPrincipal = new JFrame_PantallaPrincipal ();
        this.pantallaInicio = new JDialog_PantallaInicio (this.pantallaPrincipal, true);
        this.tipografiaSistema = new JClass_TipografiaSistema ();
        this.initProcess();
    }
    
    private void initProcess ()
    {
        Runnable procesoInicial = new Runnable ()
        {
            public void run ()            {
                pantallaInicio.setVisible(true);
            }
        };
        
        this.ejecucionInicial = new Thread (procesoInicial);
        this.ejecucionInicial.start();
        this.pauseTimeLapse(1000);
        this.pantallaInicio.actualizarTextoCarga("Cargando fuentes del sistema");
        Font [] tipografiaSistema = this.tipografiaSistema.obtenerTipografiaSistema();
        String [] nombreTipografiaSistema = this.tipografiaSistema.obtenerNombreTipografiaSistema(tipografiaSistema);
        this.pantallaInicio.actualizarTextoCarga("Ejecutando editor");
        this.pauseTimeLapse(1000);
        Runnable procesoSecundario = new Runnable ()
        {
            public void run ()            {
                pantallaPrincipal.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    public void windowOpened(java.awt.event.WindowEvent evt)
                    {
                        finalizarPantallaInicio();
                    }
                });
                
                pantallaPrincipal.iniciarPantallaUsuario(tipografiaSistema, nombreTipografiaSistema);
            }
        };
        
        this.ejecucionSecundario = new Thread (procesoSecundario);
        this.ejecucionSecundario.start();
    }
    
    private void finalizarPantallaInicio ()
    {
        this.pantallaInicio.dispose();
    }
    
    private void pauseTimeLapse (int milisegundos)
    {
        try 
        {
            Thread.sleep(milisegundos);
        } 
        
        catch (InterruptedException error) 
        {
            System.err.println ("Error al intentar dormir ejecución principal.");
            error.printStackTrace();
        }
    }
    
    public static void main(String[] args) 
    {
        new JClass_SistemaPrincipal ();
    }
}
