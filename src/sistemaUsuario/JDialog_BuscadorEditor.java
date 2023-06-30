package sistemaUsuario;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JDialog_BuscadorEditor extends javax.swing.JDialog 
{
    private JFrame parent;
    private String palabraBuscar = "";
    
    public JDialog_BuscadorEditor (java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel) 
    {
        super(parent, modal);
        this.parent = (JFrame) parent;
        initComponents();
        establecerLookAndFeel(lookAndFeel);
    }
    
    public void realizarBusquedaContenido ()
    {
        int dimensionHorizontalFrame = this.parent.getWidth();
        int dimensionVerticalFrame = this.parent.getHeight();
        dimensionHorizontalFrame = this.getWidth();
        dimensionVerticalFrame = this.getHeight();
        
        int reposicionHorizontalJDialog = Math.round((this.parent.getWidth() - dimensionHorizontalFrame)/2);
        int reposicionVerticalJDialog = Math.round((this.parent.getHeight() - dimensionVerticalFrame)/2);
        
        this.setBounds(this.parent.getX() + reposicionHorizontalJDialog, this.parent.getY() + reposicionVerticalJDialog, dimensionHorizontalFrame, dimensionVerticalFrame);
        this.setVisible(true);
        return;
    }
    
    public String recuperarBusquedaContenido ()
    {
        return this.palabraBuscar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        busquedaContenido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar palabra:");

        jLabel2.setText("Buscar palabra:");

        busquedaContenido.setToolTipText("Ingrese una palabra para buscar.");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busquedaContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String contenidoBusqueda = this.busquedaContenido.getText();
        
        if (contenidoBusqueda.compareTo("") != -1 && contenidoBusqueda != null)
        {
            this.palabraBuscar = contenidoBusqueda;
        }
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void establecerLookAndFeel (LookAndFeel lookAndFeel) 
    {        
        try 
        {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(this);
        }
        
        catch (Exception error)
        {
            try 
            {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
                {
                    if ("Metal".equals(info.getName())) 
                    {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }

            catch (Exception errorInterno)
            {
                errorInterno.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busquedaContenido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}