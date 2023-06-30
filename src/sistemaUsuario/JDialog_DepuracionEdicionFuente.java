package sistemaUsuario;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraSimbolos;
import sistemaProcesamiento.JClass_EstructuraTiplo;
import sistemaProcesamiento.JClass_EstructuraTokens;

public class JDialog_DepuracionEdicionFuente extends javax.swing.JDialog {

    private JFrame parent = null;
    
    public JDialog_DepuracionEdicionFuente (java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
    }
    
    public JDialog_DepuracionEdicionFuente (java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel)
    {
        this (parent, modal);
        this.parent = (JFrame) parent;
        establecerLookAndFeel(lookAndFeel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deslizadorDepuracion = new javax.swing.JSplitPane();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaTiplo = new javax.swing.JTable()
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultados con depuración de compilacion del programa:");

        deslizadorDepuracion.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        deslizadorResultados.setDividerLocation(335);

        deslizadorIzquierdo.setDividerLocation(115);
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
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorIzquierdo.setTopComponent(jPanel1);

        jLabel2.setText("Tabla de simbolos:");

        tablaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Tipo de datos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorIzquierdo.setRightComponent(jPanel2);

        deslizadorResultados.setLeftComponent(deslizadorIzquierdo);

        deslizadorDerecho.setDividerLocation(115);
        deslizadorDerecho.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setText("Tabla de errores:");

        tablaErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Lexema", "Linea", "Descripción"
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 236, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorDerecho.setTopComponent(jPanel3);

        jLabel4.setText("Edición de código de tokens:");

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
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorDerecho.setRightComponent(jPanel4);

        deslizadorResultados.setRightComponent(deslizadorDerecho);

        deslizadorDepuracion.setTopComponent(deslizadorResultados);

        jLabel5.setText("Tabla de tiplo:");

        tablaTiplo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Renglon", "Dato objecto", "Dato fuente", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaTiplo);
        if (tablaTiplo.getColumnModel().getColumnCount() > 0) {
            tablaTiplo.getColumnModel().getColumn(0).setResizable(false);
            tablaTiplo.getColumnModel().getColumn(1).setResizable(false);
            tablaTiplo.getColumnModel().getColumn(2).setResizable(false);
            tablaTiplo.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        deslizadorDepuracion.setRightComponent(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deslizadorDepuracion)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deslizadorDepuracion)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void obtenerResultadosAnalisis (JClass_EstructuraSimbolos estructuraSimbolos, JClass_EstructuraErrores estructuraErrores, JClass_EstructuraTokens estructuraTokens, String contenidoEdicion, ArrayList <String> registroProceso, JClass_EstructuraTiplo estructuraTiplo)
    {
        JClass_AdministradorTabla administradorTablaSimbolo  = new JClass_AdministradorTabla ();
        JClass_AdministradorTabla administradorTablaErrores  = new JClass_AdministradorTabla ();
        JClass_AdministradorTabla administradorTablaTiplo  = new JClass_AdministradorTabla ();
        
        Object encabezados_Tabla_Simbolo [] = {"Token", "Lexema", "Tipo de dato"};
        boolean columnas_NoEditar_Simbolo [] = {false, false, false};
        Object encabezados_Tabla_Error [] = {"Token", "Lexema", "Linea", "Descripción"};
        boolean columnas_NoEditar_Error [] = {false, false, false, false};
        Object encabezados_Tabla_Tiplo [] = {"Renglon", "Dato objeto", "Dato fuente", "Operador", "Etiqueta"};
        boolean columnas_NoEditar_Tiplo [] = {false, false, false, false, false};
        
        administradorTablaSimbolo.establecer_LIMITADOR_DE_DATOS(3);
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_1(estructuraSimbolos.recuperarListaTokenRegular());
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_2(estructuraSimbolos.recuperarListaLexemaRegular());
        administradorTablaSimbolo.establecer_CONTENEDOR_DATOS_3(estructuraSimbolos.recuperarListaTipoRegular());
        
        administradorTablaErrores.establecer_LIMITADOR_DE_DATOS(4);
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_1(estructuraErrores.recuperarListaTokenError());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_2(estructuraErrores.recuperarListaLexemaError());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_3(estructuraErrores.recuperarListaLineaError());
        administradorTablaErrores.establecer_CONTENEDOR_DATOS_4(estructuraErrores.recuperarListaDescripcionError());
        
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
        
        administradorTablaTiplo.establecer_LIMITADOR_DE_DATOS(5);
        administradorTablaTiplo.establecer_CONTENEDOR_DATOS_1(renglonTiplo);
        administradorTablaTiplo.establecer_CONTENEDOR_DATOS_2(datoObjetoTiplo);
        administradorTablaTiplo.establecer_CONTENEDOR_DATOS_3(datoFuenteTiplo);
        administradorTablaTiplo.establecer_CONTENEDOR_DATOS_4(operadoTiplo);
        administradorTablaTiplo.establecer_CONTENEDOR_DATOS_5(etiquetaTiplo);
        
        administradorTablaSimbolo.actualizacion_TablaDatos_MANUAL(tablaSimbolos, encabezados_Tabla_Simbolo, columnas_NoEditar_Simbolo);
        administradorTablaErrores.actualizacion_TablaDatos_MANUAL(tablaErrores, encabezados_Tabla_Error, columnas_NoEditar_Error);
        administradorTablaTiplo.actualizacion_TablaDatos_MANUAL(tablaTiplo, encabezados_Tabla_Tiplo, columnas_NoEditar_Tiplo);
        
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
        
        for (int i = 0; i < estructuraTokens.recuperarLineaContenidoTokenEscritas().length(); i++)
        {
            if (estructuraTokens.recuperarLineaContenidoTokenEscritas().charAt(i) == '\n')
            {
                lineaEdicionCodigo2.add(temporalContenidoEdicion2);
                temporalContenidoEdicion2 = "";
            }
            
            else
            {
                temporalContenidoEdicion2 += estructuraTokens.recuperarLineaContenidoTokenEscritas().charAt(i);
                
                if (i == (estructuraTokens.recuperarLineaContenidoTokenEscritas().length() - 1))
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
        
        deslizadorResultados.setDividerLocation(Math.round((dimensionHorizontalFrame/2) - 10));
        deslizadorIzquierdo.setDividerLocation(Math.round(Math.round((dimensionVerticalFrame * 0.74/2))- 30));
        deslizadorDerecho.setDividerLocation(Math.round(Math.round((dimensionVerticalFrame * 0.74/2)) - 30));
        deslizadorDepuracion.setDividerLocation(Math.round(Math.round(dimensionVerticalFrame * 0.70) - 30));
        
        String contenidoProcesosDepuracion = "";
        
        for (int i = 0; i < registroProceso.size(); i++) 
        {
            contenidoProcesosDepuracion += registroProceso.get(i);
        }
        

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
    private javax.swing.JSplitPane deslizadorDepuracion;
    private javax.swing.JSplitPane deslizadorDerecho;
    private javax.swing.JSplitPane deslizadorIzquierdo;
    private javax.swing.JSplitPane deslizadorResultados;
    private javax.swing.JTextArea edicionCodigoFuente;
    private javax.swing.JTextArea edicionCodigoToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tablaErrores;
    private javax.swing.JTable tablaSimbolos;
    private javax.swing.JTable tablaTiplo;
    // End of variables declaration//GEN-END:variables
}
