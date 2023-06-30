package sistemaUsuario;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sistemaProcesamiento.JClass_EstructuraEnsamblador;
import sistemaProcesamiento.JClass_EstructuraTiplo;

public class JDialog_ResultadosEdicionFuenteExtendido extends javax.swing.JDialog {

    private JFrame parent = null;
    
    public JDialog_ResultadosEdicionFuenteExtendido (java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public JDialog_ResultadosEdicionFuenteExtendido (java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel)
    {
        this (parent, modal);
        this.parent = (JFrame) parent;
        establecerLookAndFeel(lookAndFeel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deslizadorResultados = new javax.swing.JSplitPane();
        deslizadorIzquierdo = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edicionCodigoFuente = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaSimbolos = new javax.swing.JTable()
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
        deslizadorDerecho = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaErrores = new javax.swing.JTable()
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        edicionCodigoToken = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultados extendidos de compilacion del programa:");

        deslizadorResultados.setDividerLocation(335);

        deslizadorIzquierdo.setDividerLocation(180);
        deslizadorIzquierdo.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setText("Edición de código fuente:");

        edicionCodigoFuente.setEditable(false);
        edicionCodigoFuente.setColumns(20);
        edicionCodigoFuente.setRows(5);
        jScrollPane1.setViewportView(edicionCodigoFuente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorIzquierdo.setTopComponent(jPanel1);

        jLabel2.setText("Tabla de código ensamblador:");

        tablaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Renglon", "Dato objeto", "Dato fuente", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaSimbolos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorIzquierdo.setRightComponent(jPanel2);

        deslizadorResultados.setLeftComponent(deslizadorIzquierdo);

        deslizadorDerecho.setDividerLocation(180);
        deslizadorDerecho.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setText("Tabla de triplo:");

        tablaErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Etiqueta", "Memónico", "Operador objeto", "Operador fuente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaErrores);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorDerecho.setTopComponent(jPanel3);

        jLabel4.setText("Edición de código optimizado:");

        edicionCodigoToken.setEditable(false);
        edicionCodigoToken.setColumns(20);
        edicionCodigoToken.setRows(5);
        jScrollPane2.setViewportView(edicionCodigoToken);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorDerecho.setRightComponent(jPanel4);

        deslizadorResultados.setRightComponent(deslizadorDerecho);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(deslizadorResultados)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(deslizadorResultados)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void obtenerResultadosAnalisis (JClass_EstructuraTiplo estructuraTiplo, JClass_EstructuraEnsamblador estructuraEnsamblador, String contenidoEdicion, String contenidoOptimizado)
    {
        JClass_AdministradorTabla administradorTablaSimbolo  = new JClass_AdministradorTabla ();
        JClass_AdministradorTabla administradorTablaErrores  = new JClass_AdministradorTabla ();
        
        Object encabezados_Tabla_Simbolo [] = {"Renglon", "Dato objeto", "Dato fuente", "Operador"};
        boolean columnas_NoEditar_Simbolo [] = {false, false, false, false};
        Object encabezados_Tabla_Error [] = {"Etiqueta", "Operación", "Operando objeto", "Operando fuente"};
        boolean columnas_NoEditar_Error [] = {false, false, false, false};
        
        ArrayList <Object> renglonTiplo = new ArrayList <Object>();
        ArrayList <Object> datoObjetoTiplo = new ArrayList <Object>(estructuraTiplo.recuperarListaTiploDatoObjeto());
        ArrayList <Object> datoFuenteTiplo = new ArrayList <Object>(estructuraTiplo.recuperarListaTiploDatoFuente());
        ArrayList <Object> operadoTiplo = new ArrayList <Object>(estructuraTiplo.recuperarListaTiploOperador());
        ArrayList <Object> etiquetaTiplo = new ArrayList <Object>(estructuraTiplo.recuperarListaTiploEtiqueta());
        datoObjetoTiplo.remove(0);
        datoFuenteTiplo.remove(0);
        operadoTiplo.remove(0);
        etiquetaTiplo.remove(0);
        
        for (int i = 0; i < estructuraTiplo.recuperarTotalTiplo() - 1; i++) 
        {
            renglonTiplo.add((i + 1));
        }
        
        administradorTablaSimbolo.establecer_LIMITADOR_DE_DATOS(4);
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_1(renglonTiplo);
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_2(datoObjetoTiplo);
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_3(datoFuenteTiplo);
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_4(operadoTiplo);
        
        administradorTablaErrores.establecer_LIMITADOR_DE_DATOS(4);
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_1(estructuraEnsamblador.recuperarListaEtiqueta());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_2(estructuraEnsamblador.recuperarListaMenomico());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_3(estructuraEnsamblador.recuperarListaOperandoGuardado());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_4(estructuraEnsamblador.recuperarListaOperandoReferencia());
        
        administradorTablaSimbolo.actualizacion_TablaDatos_MANUAL(tablaErrores, encabezados_Tabla_Simbolo, columnas_NoEditar_Simbolo);
        administradorTablaErrores.actualizacion_TablaDatos_MANUAL(tablaSimbolos, encabezados_Tabla_Error, columnas_NoEditar_Error);
        
        String temporalContenidoEdicion1 = "";
        String temporalContenidoEdicion2 = "";
        
        ArrayList <String> lineaEdicionCodigo1 = new ArrayList <String>();
        ArrayList <String> lineaEdicionCodigo2 = new ArrayList <String>();
        
        for (int i = 0; i < contenidoEdicion.length(); i++)
        {
            if (contenidoEdicion.charAt(i) == '\n')
            {
                lineaEdicionCodigo1.add(temporalContenidoEdicion1);
                temporalContenidoEdicion1 = "";
            }
            
            else
            {
                temporalContenidoEdicion1 += contenidoEdicion.charAt(i);
                
                if (i == (contenidoEdicion.length() - 1))
                {
                    lineaEdicionCodigo1.add(temporalContenidoEdicion1);
                    temporalContenidoEdicion1 = "";
                }
            }
        }
        
        for (int i = 0; i < contenidoOptimizado.length(); i++)
        {
            if (contenidoOptimizado.charAt(i) == '\n')
            {
                lineaEdicionCodigo2.add(temporalContenidoEdicion2);
                temporalContenidoEdicion2 = "";
            }
            
            else
            {
                temporalContenidoEdicion2 += contenidoOptimizado.charAt(i);
                
                if (i == (contenidoOptimizado.length() - 1))
                {
                    lineaEdicionCodigo2.add(temporalContenidoEdicion2);
                    temporalContenidoEdicion2 = "";
                }
            }
        }
        
        for (int i = 0; i < lineaEdicionCodigo1.size(); i++) 
        {
            int contadorInverso1 = 1;
            int contadorMaximo = 1;
            String espaciado1 = "";
            
            String conversionText1 = String.valueOf(i + 1);
            String conversionText2 = String.valueOf(lineaEdicionCodigo1.size());            
            
            for (int j = 0; j < conversionText1.length(); j++) 
            {
                if (j == 0)
                {
                    contadorInverso1 *= 1;
                }
                
                else
                {
                    contadorInverso1 *= 10;
                }
            }
            
            for (int j = 0; j < conversionText2.length(); j++) 
            {
                if (j == 0)
                {
                    contadorMaximo *= 1;
                }
                
                else
                {
                    contadorMaximo *= 10;
                }
            }
            
            while (contadorInverso1 < contadorMaximo)
            {
                contadorInverso1 *= 10;
                espaciado1 += "  ";
            }
            
            if (i == 0)
            {
                temporalContenidoEdicion1 += (i + 1) + espaciado1 +  "  |  " + lineaEdicionCodigo1.get(i);
            }
            
            else
            {
                temporalContenidoEdicion1 += "\n" + (i + 1) + espaciado1 +  "  |  " + lineaEdicionCodigo1.get(i);
            }            
        }
        
        for (int i = 0; i < lineaEdicionCodigo2.size(); i++) 
        {
            int contadorInverso2 = 1;
            int contadorMaximo = 1;
            String espaciado2 = "";
            
            String conversionText1 = String.valueOf(i + 1);
            String conversionText2 = String.valueOf(lineaEdicionCodigo2.size());            
            
            for (int j = 0; j < conversionText1.length(); j++) 
            {
                if (j == 0)
                {
                    contadorInverso2 *= 1;
                }
                
                else
                {
                    contadorInverso2 *= 10;
                }
            }
            
            for (int j = 0; j < conversionText2.length(); j++) 
            {
                if (j == 0)
                {
                    contadorMaximo *= 1;
                }
                
                else
                {
                    contadorMaximo *= 10;
                }
            }
            
            while (contadorInverso2 < contadorMaximo)
            {
                contadorInverso2 *= 10;
                espaciado2 += "  ";
            }
            
            if (i == 0)
            {
                temporalContenidoEdicion2 += (i + 1) + espaciado2 +  "  |  " + lineaEdicionCodigo2.get(i);
            }
            
            else
            {
                temporalContenidoEdicion2 += "\n" + (i + 1) + espaciado2 +  "  |  " + lineaEdicionCodigo2.get(i);
            } 
        }
        
        this.edicionCodigoFuente.setText(temporalContenidoEdicion1);
        this.edicionCodigoFuente.setBackground(new javax.swing.JTextArea().getBackground());
        this.edicionCodigoToken.setText(temporalContenidoEdicion2);
        this.edicionCodigoToken.setBackground(new javax.swing.JTextArea().getBackground());
        
        int dimensionHorizontalFrame = this.parent.getWidth();
        int dimensionVerticalFrame = this.parent.getHeight();
        dimensionHorizontalFrame = Math.round(dimensionHorizontalFrame * 0.90f);
        dimensionVerticalFrame = Math.round(dimensionVerticalFrame * 0.90f);
        
        int reposicionHorizontalJDialog = Math.round((this.parent.getWidth() - dimensionHorizontalFrame)/2);
        int reposicionVerticalJDialog = Math.round((this.parent.getHeight() - dimensionVerticalFrame)/2);
        
        this.setBounds(this.parent.getX() + reposicionHorizontalJDialog, this.parent.getY() + reposicionVerticalJDialog, dimensionHorizontalFrame, dimensionVerticalFrame);
        deslizadorResultados.setDividerLocation(Math.round((dimensionHorizontalFrame/2)) - 10);
        deslizadorIzquierdo.setDividerLocation(Math.round((dimensionVerticalFrame/2)) - 30);
        deslizadorDerecho.setDividerLocation(Math.round((dimensionVerticalFrame/2)) - 30);
        edicionCodigoFuente.setCaretPosition(0);
        edicionCodigoToken.setCaretPosition(0);
        this.setVisible(true);
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
    private javax.swing.JSplitPane deslizadorDerecho;
    private javax.swing.JSplitPane deslizadorIzquierdo;
    private javax.swing.JSplitPane deslizadorResultados;
    private javax.swing.JTextArea edicionCodigoFuente;
    private javax.swing.JTextArea edicionCodigoToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaErrores;
    private javax.swing.JTable tablaSimbolos;
    // End of variables declaration//GEN-END:variables
}
