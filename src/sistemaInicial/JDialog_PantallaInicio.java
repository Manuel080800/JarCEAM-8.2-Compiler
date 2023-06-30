package sistemaInicial;

import almacenTipografias.JClass_TipografiaPrivada;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JDialog_PantallaInicio extends javax.swing.JDialog 
{
    private String ubicacionLogo [] = null;
    private Timer actualizarLogo = null;
    private int numeroLogo = 0;
    private boolean sentidoAnimacion = false;
    
    public JDialog_PantallaInicio(java.awt.Frame parent, boolean modal) 
    {        
        super(parent, modal);
        initComponents();
        initProcess();
    }
    
    private void initProcess ()
    {
        tituloPrincipal.setFont(new JClass_TipografiaPrivada (0).obtenerTipografia(24f));
        tituloSecundario.setFont(new JClass_TipografiaPrivada (1).obtenerTipografia(0, 18.4f));
        
        this.ubicacionLogo = new String [20];
        
        for (int i = 0; i < 20; i++) 
        {
            this.ubicacionLogo [i] = "/almacenImagenes/Logo" + (i + 1) + ".png";
        }
        
        this.animarTransparenciaLogo();
        
        actualizarLogo = new Timer(60, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                animarTransparenciaLogo();
            }
        });
        
        actualizarLogo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicial = new javax.swing.JPanel();
        logoAnimado = new javax.swing.JLabel();
        tituloPrincipal = new javax.swing.JLabel();
        tituloSecundario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        panelInicial.setBackground(new java.awt.Color(40, 43, 48));

        logoAnimado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoAnimado.setAutoscrolls(true);

        tituloPrincipal.setBackground(new java.awt.Color(132, 212, 255));
        tituloPrincipal.setForeground(new java.awt.Color(132, 212, 255));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Editor de código JarCEAM 8.2");

        tituloSecundario.setBackground(new java.awt.Color(132, 212, 255));
        tituloSecundario.setForeground(new java.awt.Color(132, 212, 255));
        tituloSecundario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloSecundario.setText("Iniciando editor");

        javax.swing.GroupLayout panelInicialLayout = new javax.swing.GroupLayout(panelInicial);
        panelInicial.setLayout(panelInicialLayout);
        panelInicialLayout.setHorizontalGroup(
            panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicialLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(logoAnimado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(152, 152, 152))
            .addGroup(panelInicialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tituloSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInicialLayout.setVerticalGroup(
            panelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicialLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(logoAnimado, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void animarTransparenciaLogo ()
    {
        Image redimencionLogo = new ImageIcon (getClass().getResource(this.ubicacionLogo [this.numeroLogo])).getImage();
        redimencionLogo = redimencionLogo.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
        logoAnimado.setIcon(new ImageIcon (redimencionLogo));
        
        if (this.sentidoAnimacion)
        {
            if (this.numeroLogo > 1)
            {
                this.numeroLogo --;
            }
            
            else
            {
               this.sentidoAnimacion = false;
               this.numeroLogo = 1;
            }
        }
        
        else
        {
            if (this.numeroLogo < 18)
            {
                this.numeroLogo ++;
            }
            
            else
            {
               this.sentidoAnimacion = true;
               this.numeroLogo = 18;
            }
        }
    }
    
    public void actualizarTextoCarga (String textoCarga)
    {
        tituloSecundario.setText(textoCarga);
    }
    
    public JPanel obtenerPanelInicial ()
    {
        return this.panelInicial;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logoAnimado;
    private javax.swing.JPanel panelInicial;
    private javax.swing.JLabel tituloPrincipal;
    private javax.swing.JLabel tituloSecundario;
    // End of variables declaration//GEN-END:variables
}