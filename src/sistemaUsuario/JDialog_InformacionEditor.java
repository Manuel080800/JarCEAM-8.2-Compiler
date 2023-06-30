package sistemaUsuario;

import almacenTipografias.JClass_TipografiaPrivada;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class JDialog_InformacionEditor extends javax.swing.JDialog 
{
    private JFrame parent;
    
    public JDialog_InformacionEditor(java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel) 
    {
        super(parent, modal);
        initComponents();
        this.parent = (JFrame) parent;
        establecerLookAndFeel(lookAndFeel);
        editorJarCEAM.setFont(new JClass_TipografiaPrivada (0).obtenerTipografia(22f));
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.getViewport().setBorder(null);
        jScrollPane2.setViewportBorder(null);
        jScrollPane2.getViewport().setBorder(null);
        
    }
    
    public void mostrarInformacion ()
    {
        int dimensionHorizontalFrame = this.parent.getWidth();
        int dimensionVerticalFrame = this.parent.getHeight();
        dimensionHorizontalFrame = Math.round(dimensionHorizontalFrame * 0.48f);
        dimensionVerticalFrame = Math.round(dimensionVerticalFrame * 0.95f);
        
        if (dimensionHorizontalFrame > 426)
        {
            dimensionHorizontalFrame = 426;
        }
        
        if(dimensionVerticalFrame > 496)
        {
            dimensionVerticalFrame = 496;
        }
        
        int reposicionHorizontalJDialog = Math.round((this.parent.getWidth() - dimensionHorizontalFrame)/2);
        int reposicionVerticalJDialog = Math.round((this.parent.getHeight() - dimensionVerticalFrame)/2);
        
        this.setBounds(this.parent.getX() + reposicionHorizontalJDialog, this.parent.getY() + reposicionVerticalJDialog, dimensionHorizontalFrame, dimensionVerticalFrame);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane()
        {
            @Override
            public void setBorder(Border border)
            {
                // No!
            }
        }
        ;
        jTextArea1 = new javax.swing.JTextArea()
        {
            @Override
            public void setBorder(Border border)
            {
                // No!
            }
        }
        ;
        imagenJarcCEAM = new javax.swing.JLabel();
        editorJarCEAM = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane()
        {
            @Override
            public void setBorder(Border border)
            {
                // No!
            }
        }
        ;
        jTextArea2 = new javax.swing.JTextArea()
        {
            @Override
            public void setBorder(Border border)
            {
                // No!
            }
        }
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion del editor:");

        jLabel1.setText("Acerca del editor:");

        jScrollPane1.setBorder(null);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Version de editor: 1.4\nTipo de version: Estable (DIC 2021)\nVersion de compilacion: Java 1.8.281 ORACLE\nFecha de actualización: 4/Diciembre/2021\nDesarrollador: Manuel Antonio Cetina Aguilar");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        imagenJarcCEAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenJarcCEAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Logo1.png"))); // NOI18N
        imagenJarcCEAM.setToolTipText("");

        editorJarCEAM.setForeground(new java.awt.Color(132, 212, 255));
        editorJarCEAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editorJarCEAM.setText("Editor de código JarCEAM 8.2");

        jLabel4.setText("Agradecimientos:");

        jScrollPane2.setBorder(null);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Le agradecemos a nuestra docente María Italia Jimenez Ochoa la cual nos enseño la base  fundamental para poder desarrollar este compilador. Tambien agradecemos  a Gerardo Arturo Pérez Pérez por la contribucion al desarrollo de las estructuras finales del compilador.");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(null);
        jTextArea2.setFocusable(false);
        jTextArea2.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editorJarCEAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagenJarcCEAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(imagenJarcCEAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editorJarCEAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel editorJarCEAM;
    private javax.swing.JLabel imagenJarcCEAM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
