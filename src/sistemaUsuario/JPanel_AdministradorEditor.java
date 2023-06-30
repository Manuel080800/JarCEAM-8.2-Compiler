package sistemaUsuario;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sistemaEscritura.JClass_EscrituraArchivoFuente;

public class JPanel_AdministradorEditor extends javax.swing.JPanel {
    
    private ArrayList <JPanel_EditorCodigoFuente> listaEditor = null;
    private ArrayList <JPanel_AdministradorEditor> listaAdministrador = null;
    private ImageIcon imagenArchivo = null;
    private JTabbedPane pestañaPanel = null;
    private String tituloAdministrador = null;
    private int numeroAdministrador = 0;
    private Color colorFondoLookAndFeel = null;
    private Color colorLetraLookAndFeel = null;
    private JFrame framePrincipal = null;
    
    public JPanel_AdministradorEditor(JTabbedPane pestañaPanel, String tituloAdministrador, int numeroAdministrador, ArrayList <JPanel_EditorCodigoFuente> listaEditor, ArrayList <JPanel_AdministradorEditor> listaAdministrador, LookAndFeel lookAndFeel, JFrame framePrincipal) 
    {
        this.listaEditor = listaEditor;
        this.listaAdministrador = listaAdministrador;
        this.pestañaPanel = pestañaPanel;
        this.tituloAdministrador = tituloAdministrador;
        this.numeroAdministrador = numeroAdministrador;
        this.framePrincipal = framePrincipal;
        
        establecerLookAndFeel(lookAndFeel);
        
        initComponents();
        
        this.colorFondoLookAndFeel = botonSalida.getBackground();
        this.colorLetraLookAndFeel = botonSalida.getForeground();
        this.tituloAdministradorActual.setText(tituloAdministrador);
        this.tituloAdministradorActual.setToolTipText(tituloAdministrador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalida = new javax.swing.JButton();
        tituloAdministradorActual = new javax.swing.JLabel();
        iconoArchivo = new javax.swing.JLabel();

        setOpaque(false);

        botonSalida.setText("X");
        botonSalida.setToolTipText("Cerrar pestaña de archivo");
        botonSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonSalidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonSalidaMouseExited(evt);
            }
        });
        botonSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalidaActionPerformed(evt);
            }
        });

        tituloAdministradorActual.setText("Nuevo archivo");
        tituloAdministradorActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tituloAdministradorActualMouseClicked(evt);
            }
        });

        iconoArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/IconoArchivo.png"))); // NOI18N
        iconoArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconoArchivoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconoArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloAdministradorActual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalida))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloAdministradorActual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(iconoArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botonSalida)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalidaMouseEntered
        this.botonSalida.setForeground(Color.WHITE);
        this.botonSalida.setBackground(Color.RED);
    }//GEN-LAST:event_botonSalidaMouseEntered

    private void botonSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalidaMouseExited
        this.botonSalida.setForeground(this.colorLetraLookAndFeel);
        this.botonSalida.setBackground(this.colorFondoLookAndFeel);
    }//GEN-LAST:event_botonSalidaMouseExited

    private void botonSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalidaActionPerformed
        
        if (listaEditor.get(numeroAdministrador).recuperarEstadoEditable())
        {
            int accion = JOptionPane.showConfirmDialog(framePrincipal, "¿Desea guardar los cambios en curso?", "Edicion en curso:", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (JOptionPane.YES_OPTION == accion)
            {
                JClass_EscrituraArchivoFuente escrituraArchivoFuente = new JClass_EscrituraArchivoFuente (framePrincipal);
                escrituraArchivoFuente.escribirArchivoFuente(listaEditor.get(numeroAdministrador).recuperarUbicacionArchivo(), listaEditor.get(numeroAdministrador).recuperarContenidoEditor());
            }
            
            if (JOptionPane.CANCEL_OPTION == accion)
            {
                return;
            }
        }
        
        this.listaEditor.remove(this.numeroAdministrador);
        this.listaAdministrador.remove(this.numeroAdministrador);

        for (int i = 0; i < this.listaAdministrador.size(); i++)
        {
            this.listaAdministrador.get(i).actualizarNumeroAdministrador(i);
        }

        this.pestañaPanel.remove(this.numeroAdministrador);
    }//GEN-LAST:event_botonSalidaActionPerformed

    private void tituloAdministradorActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tituloAdministradorActualMouseClicked
        this.pestañaPanel.setSelectedIndex(this.numeroAdministrador);
    }//GEN-LAST:event_tituloAdministradorActualMouseClicked

    private void iconoArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconoArchivoMouseClicked
        this.pestañaPanel.setSelectedIndex(this.numeroAdministrador);
    }//GEN-LAST:event_iconoArchivoMouseClicked
    
    public void actualizarNumeroAdministrador (int nuevoNumeroAdministrador)
    {
        this.numeroAdministrador = nuevoNumeroAdministrador;
    }
    
    public void actualizarTituloAdministrador (String tituloAdministrador)
    {
        this.tituloAdministrador = tituloAdministrador;
        this.tituloAdministradorActual.setText(tituloAdministrador);
        this.tituloAdministradorActual.setToolTipText(tituloAdministrador);
    }
    
    public JButton obtenerBotonEliminar ()
    {
        return this.botonSalida;
    }
    
    public int obtenerNumeroAdministrador ()
    {
        return this.numeroAdministrador;
    }
    
    public String obtenerTituloAdministrador ()
    {
        return this.tituloAdministrador;
    }
    
    public void establecerLookAndFeel (LookAndFeel lookAndFeel) 
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
    private javax.swing.JButton botonSalida;
    private javax.swing.JLabel iconoArchivo;
    private javax.swing.JLabel tituloAdministradorActual;
    // End of variables declaration//GEN-END:variables
}
