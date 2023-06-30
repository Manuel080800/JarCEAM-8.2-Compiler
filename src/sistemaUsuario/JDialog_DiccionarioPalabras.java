package sistemaUsuario;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraSimbolos;

public class JDialog_DiccionarioPalabras extends javax.swing.JDialog 
{

    JFrame parent = null;
    
    public JDialog_DiccionarioPalabras (java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel) 
    {
        super(parent, modal);
        this.parent = (JFrame) parent;
        initComponents();
        establecerLookAndFeel(lookAndFeel);
    }
    
    public void obtenerDiccionarioPalabras (JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores)
    {
        JClass_AdministradorTabla administradorTabla = new JClass_AdministradorTabla ();
        ArrayList <Object> palabra = new ArrayList <Object> ();
        ArrayList <Object> sintaxis = new ArrayList <Object> ();
        
        Object encabezados_Tabla [] = {"Palabra", "Sintaxis"};
        boolean columnas_NoEditar [] = {false, false};
        
        for (int i = 0; i < estructuraSimbolos.recuperarTotalSimbolos(); i++) 
        {
            palabra.add(estructuraSimbolos.recuperarLexemaRegular(i));
            sintaxis.add("Correcta");
        }
        
        for (int i = 0; i < estructuraErrores.recuperarTotalErrores(); i++) 
        {
            if (estructuraErrores.recuperarListaTokenError().get(i).toString().indexOf("ERSem") == -1)
            {
                palabra.add(estructuraErrores.recuperarLexemaError(i));
                sintaxis.add("Erronea");
            }
        }
        
        administradorTabla.establecer_LIMITADOR_DE_DATOS(2);
        administradorTabla.establecer_CONTENEDOR_DATOS_1(palabra);
        administradorTabla.establecer_CONTENEDOR_DATOS_2(sintaxis);
        administradorTabla.actualizacion_TablaDatos_MANUAL(tablaPalabras, encabezados_Tabla, columnas_NoEditar);
     
        int dimensionHorizontalFrame = this.parent.getWidth();
        int dimensionVerticalFrame = this.parent.getHeight();
        dimensionHorizontalFrame = Math.round(dimensionHorizontalFrame * 0.50f);
        dimensionVerticalFrame = Math.round(dimensionVerticalFrame * 0.80f);
        
        int reposicionHorizontalJDialog = Math.round((this.parent.getWidth() - dimensionHorizontalFrame)/2);
        int reposicionVerticalJDialog = Math.round((this.parent.getHeight() - dimensionVerticalFrame)/2);
        
        this.setBounds(this.parent.getX() + reposicionHorizontalJDialog, this.parent.getY() + reposicionVerticalJDialog, dimensionHorizontalFrame, dimensionVerticalFrame);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPalabras = new javax.swing.JTable()
        {
            public String getToolTipText(MouseEvent e)
            {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try
                {
                    tip = getValueAt(rowIndex, colIndex).toString();
                }

                catch (RuntimeException e1)
                {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        }
        ;
        filtroBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diccionario de palabras:");

        jLabel1.setText("Tabla de palabras escritas:");

        tablaPalabras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Palabra", "Sintaxis"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPalabras);

        filtroBusqueda.setToolTipText("Palabra que desea buscar en el diccionario");

        jLabel2.setText("Filtro de busqueda:");

        jButton1.setText("Buscar");
        jButton1.setToolTipText("Busca la palabra escrita en el filtro de busqueda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Inicio");
        jButton2.setToolTipText("Muestra todas las palabras del diccionario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filtroBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableRowSorter <TableModel> filtroBusquedaTabla = new TableRowSorter <TableModel> (tablaPalabras.getModel());
        actualizar_FiltroBusqueda(tablaPalabras, filtroBusquedaTabla, this.filtroBusqueda.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TableRowSorter <TableModel> filtroBusquedaTabla = new TableRowSorter <TableModel> (tablaPalabras.getModel());
        actualizar_FiltroBusqueda(tablaPalabras, filtroBusquedaTabla, "");
    }//GEN-LAST:event_jButton2ActionPerformed

    public void actualizar_FiltroBusqueda (JTable tabla_Actualizacion, TableRowSorter <TableModel> filtro_Busqueda, String texto_Filtro)
    {
        tabla_Actualizacion.setRowSorter(filtro_Busqueda);
        
        String texto_Filtro_Busqueda = texto_Filtro;

        if (texto_Filtro_Busqueda.length() == 0)
        {
                filtro_Busqueda.setRowFilter(null);
        }

        else
        {
                try
                {
                    filtro_Busqueda.setRowFilter(RowFilter.regexFilter(texto_Filtro_Busqueda));
                }

                catch (PatternSyntaxException error) 
                {
                        JOptionPane.showMessageDialog(parent, "El texto de filtro de busqueda es invalido." + "\n" + "Razon: " + error, "Error de filtro de busqueda:", JOptionPane.ERROR_MESSAGE);
                }
        }
    }
    
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
    private javax.swing.JTextField filtroBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPalabras;
    // End of variables declaration//GEN-END:variables
}
