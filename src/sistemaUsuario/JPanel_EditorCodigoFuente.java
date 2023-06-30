package sistemaUsuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import sistemaAnalisis.JClass_AnalizadorContenidoEdicion;
import sistemaAnalisis.JClass_OptimizadorCodigoFuente;
import sistemaProcesamiento.JClass_EstructuraEnsamblador;
import sistemaProcesamiento.JClass_EstructuraErrores;
import sistemaProcesamiento.JClass_EstructuraExpresiones;
import sistemaProcesamiento.JClass_EstructuraSimbolos;
import sistemaProcesamiento.JClass_EstructuraTiplo;
import sistemaProcesamiento.JClass_EstructuraTokens;

public class JPanel_EditorCodigoFuente extends javax.swing.JPanel 
{
    private JClass_EstructuraExpresiones estructuraExpresiones = new JClass_EstructuraExpresiones ();
    private JClass_EstructuraSimbolos estructuraSimbolos = new JClass_EstructuraSimbolos ();
    private JClass_EstructuraErrores estructuraErrores = new JClass_EstructuraErrores ();
    private JClass_EstructuraTokens estructuraTokens = new JClass_EstructuraTokens ();
    private JClass_EstructuraTiplo estructuraTiplo = new JClass_EstructuraTiplo();
    private JClass_OptimizadorCodigoFuente optimizadorFuente = new JClass_OptimizadorCodigoFuente ();
    private JClass_EstructuraEnsamblador estructuraEnsamblador = new JClass_EstructuraEnsamblador ();
    
    private Color colorFondoLookAndFeel = null;
    private File rutaAlmacenamientoArchivo = null;
    private Font fuenteEditorCodigo = null;
    private int tamañoFuenteEditor = 12;
    private String nombreArchivo = null;
    private String contenidoGuardado = null;
    private String contenidoTemporal = "";
    private JPanel_AdministradorEditor administradorActual = null;
    private boolean edicionActiva = false;    
    private int numeroLineaContada = 0;
    private LookAndFeel lookAndFeel = null;
    private ArrayList <String> registroProcesos = new ArrayList <String> ();
    private boolean identificacionExpresion = true;
    private JFrame frame = null;
    
    public JPanel_EditorCodigoFuente(LookAndFeel lookAndFeel, Font tipografiaSeleccionada, JFrame frame) 
    {
        this.lookAndFeel = lookAndFeel;
        establecerLookAndFeel(lookAndFeel);
        initComponents();
        initProcess();
        actualizarTipografiaEditor(tipografiaSeleccionada);
        this.administradorActual = administradorActual;
        this.contenidoGuardado = "";
        this.frame = frame;
    }
    
    public JPanel_EditorCodigoFuente(LookAndFeel lookAndFeel, Font tipografiaSeleccionada, File rutaAlmacenamientoArchivo, String contenidoArchivo, JFrame frame)
    {
        this(lookAndFeel, tipografiaSeleccionada, frame);
        this.rutaAlmacenamientoArchivo = rutaAlmacenamientoArchivo;
        this.panelEditorCodigoFuente.setText(contenidoArchivo);
        this.contenidoGuardado = contenidoArchivo;  
    }
    
    private void initProcess ()
    {   
        this.deslizadorEditorCodigoFuente.setVerticalScrollBar(this.deslizadorContadorLineaCodigo.getVerticalScrollBar());
        this.colorFondoLookAndFeel = panelEditorCodigoFuente.getBackground();
        this.panelEditorPrincipal.setBackground(this.colorFondoLookAndFeel);
        actualizarLayoutEditor(1);
        
        JPopupMenu menuContextual = new JPopupMenu ();
        
        JMenuItem copiarMenu = new JMenuItem ();
        copiarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Copiar.png")));
        copiarMenu.setText("Copiar");
        copiarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarContenidoFuente(false);
            }
        });
        menuContextual.add(copiarMenu);
        
        JMenuItem cortarMenu = new JMenuItem ();
        cortarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Cortar.png")));
        cortarMenu.setText("Cortar");
        cortarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarContenidoFuente(true);
            }
        });
        menuContextual.add(cortarMenu);
        
        JMenuItem pegarMenu = new JMenuItem ();
        pegarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Pegar.png")));
        pegarMenu.setText("Pegar");
        pegarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarContenidoFuente();
            }
        });
        menuContextual.add(pegarMenu);
        
        JMenuItem agregarMenu = new JMenuItem ();
        agregarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/SangriaAgregar.png")));
        agregarMenu.setText("Agregar sangria");
        agregarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTabulacionContenido(true);
            }
        });
        menuContextual.add(agregarMenu);
        
        JMenuItem eliminarMenu = new JMenuItem ();
        eliminarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/SangriaEliminar.png")));
        eliminarMenu.setText("Eliminar sangria");
        eliminarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTabulacionContenido(false);
            }
        });
        menuContextual.add(eliminarMenu);
       
        this.panelEditorCodigoFuente.add(menuContextual);
        this.panelEditorCodigoFuente.setComponentPopupMenu(menuContextual);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelEditorPrincipal = new javax.swing.JPanel();
        separator1 = new javax.swing.JSeparator();
        deslizadorEditorCodigoFuente = new javax.swing.JScrollPane();
        panelEditorCodigoFuente = new javax.swing.JTextArea();
        deslizadorContadorLineaCodigo = new javax.swing.JScrollPane();
        contadorLineaCodigo = new javax.swing.JTextArea();
        identificadorSintaxis = new javax.swing.JButton();
        diccionarioPalabras = new javax.swing.JButton();
        contadorLinea = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        contadorPalabra = new javax.swing.JLabel();
        IndicatorSintaxix = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        posicionTexto = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        jLabel1.setText("Editor de codigo fuente:");

        panelEditorPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        deslizadorEditorCodigoFuente.setBorder(null);

        panelEditorCodigoFuente.setColumns(20);
        panelEditorCodigoFuente.setRows(5);
        panelEditorCodigoFuente.setBorder(null);
        panelEditorCodigoFuente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                panelEditorCodigoFuenteCaretUpdate(evt);
            }
        });
        deslizadorEditorCodigoFuente.setViewportView(panelEditorCodigoFuente);

        deslizadorContadorLineaCodigo.setBorder(null);
        deslizadorContadorLineaCodigo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        deslizadorContadorLineaCodigo.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        contadorLineaCodigo.setColumns(20);
        contadorLineaCodigo.setRows(5);
        contadorLineaCodigo.setText("1");
        contadorLineaCodigo.setBorder(null);
        contadorLineaCodigo.setFocusable(false);
        deslizadorContadorLineaCodigo.setViewportView(contadorLineaCodigo);

        javax.swing.GroupLayout panelEditorPrincipalLayout = new javax.swing.GroupLayout(panelEditorPrincipal);
        panelEditorPrincipal.setLayout(panelEditorPrincipalLayout);
        panelEditorPrincipalLayout.setHorizontalGroup(
            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deslizadorContadorLineaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deslizadorEditorCodigoFuente)
                .addContainerGap())
        );
        panelEditorPrincipalLayout.setVerticalGroup(
            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deslizadorEditorCodigoFuente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(separator1)
                    .addComponent(deslizadorContadorLineaCodigo))
                .addContainerGap())
        );

        identificadorSintaxis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Identificador.png"))); // NOI18N
        identificadorSintaxis.setToolTipText("Identificador de sintaxis activado");
        identificadorSintaxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorSintaxisActionPerformed(evt);
            }
        });

        diccionarioPalabras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Diccionario.png"))); // NOI18N
        diccionarioPalabras.setToolTipText("Diccionario de palabras");
        diccionarioPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diccionarioPalabrasActionPerformed(evt);
            }
        });

        contadorLinea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contadorLinea.setText("Numero de lineas: 1");
        contadorLinea.setToolTipText("Contador de numero de lineas escritas");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        contadorPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contadorPalabra.setText("Numero de palabras: 0");
        contadorPalabra.setToolTipText("Contador de numero de palabras escritas");

        IndicatorSintaxix.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        IndicatorSintaxix.setText("Sintasix: Correcta");
        IndicatorSintaxix.setToolTipText("Indicador de sintaxis");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        posicionTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posicionTexto.setText("1:0");
        posicionTexto.setToolTipText("Posicion actual del cursor de texto");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(identificadorSintaxis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diccionarioPalabras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(contadorLinea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contadorPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(posicionTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IndicatorSintaxix, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(identificadorSintaxis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diccionarioPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(IndicatorSintaxix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(posicionTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(contadorPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(contadorLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void buscarContenido ()
    {
        JDialog_BuscadorEditor buscarContenido = new JDialog_BuscadorEditor(frame, true, lookAndFeel);
        buscarContenido.realizarBusquedaContenido();
        String textoBusqueda = buscarContenido.recuperarBusquedaContenido();
        String textoFuente = this.panelEditorCodigoFuente.getText();
        
        if (textoFuente == null && textoBusqueda.compareTo("") == -1)
        {
            return;
        }
        
        if (textoBusqueda == null && textoFuente.compareTo("") == -1)
        {
            return;
        }

        ArrayList <Integer> posicionInicio = new ArrayList <Integer> ();
        ArrayList <Integer> posicionFinal = new ArrayList <Integer> ();
        int contador = 0;
        int contadorInterno = 0;
        int posicionIni = 0;
        int posicionFin = 0;
        
        for (int i = 0; i < textoFuente.length(); i++) 
        {
            boolean encontrar = false;
            
            if (contadorInterno < textoBusqueda.length() && textoFuente.charAt(i) == textoBusqueda.charAt(contadorInterno))
            {
                contadorInterno ++;
                encontrar = true;
            }
            
            else
            {
                contadorInterno = 0;
            }
            
            if (encontrar == true)
            {
                if (contador == 0)
                {
                    posicionIni = i;
                }
                
                if (contador < textoBusqueda.length())
                {
                    contador ++;
                }
                
                else
                {
                    contador = 0;
                }
                
                if (contador == textoBusqueda.length())
                {
                    posicionFin = i + 1;
                }
                
                if (i == (textoFuente.length() - 1))
                {
                    if (textoBusqueda.length() <= contador)
                    {
                        posicionInicio.add(posicionIni);
                        posicionFinal.add(posicionFin);
                    }

                    contador = 0;
                    posicionIni = 0;
                    posicionFin = 0;
                }
            }
            
            else
            {
                if (textoBusqueda.length() <= contador)
                {
                    posicionInicio.add(posicionIni);
                    posicionFinal.add(posicionFin);
                }
                 
                contador = 0;
                posicionIni = 0;
                posicionFin = 0;
            }
        }
           
        this.panelEditorCodigoFuente.getHighlighter().removeAllHighlights();

        for (int i = 0; i < posicionInicio.size(); i++) 
        {
            Highlighter.HighlightPainter colorEstructura = new DefaultHighlighter.DefaultHighlightPainter(new Color (3, 155, 146));

            try 
            {
                this.panelEditorCodigoFuente.getHighlighter().addHighlight(posicionInicio.get(i), posicionFinal.get(i), colorEstructura);
            } 

            catch (BadLocationException ex) 
            {
                System.out.println ("Error al resaltar codigo fuente");
            }
        }
        
        return;
    }
    
    private void panelEditorCodigoFuenteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_panelEditorCodigoFuenteCaretUpdate
  
        if (this.panelEditorCodigoFuente.getSelectedText() != null)
        {
            this.panelEditorCodigoFuente.getHighlighter().removeAllHighlights();
            
            int posicionInicio = this.panelEditorCodigoFuente.getSelectionStart();
            int posicionFinal = this.panelEditorCodigoFuente.getSelectionEnd();
            
            try 
            {    
                int posicionCaracterInicial = posicionInicio;
                int lineaActualInicial = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterInicial);
                int columnaActualInicial = posicionCaracterInicial - this.panelEditorCodigoFuente.getLineStartOffset(lineaActualInicial);
                
                int posicionCaracterFinal = posicionFinal;
                int lineaActualFinal = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterFinal);
                int columnaActualFinal = posicionCaracterFinal - this.panelEditorCodigoFuente.getLineStartOffset(lineaActualFinal);
                
                this.posicionTexto.setText((lineaActualInicial + 1) + ":" + columnaActualInicial + " - " + (lineaActualFinal + 1) + ":" + columnaActualFinal);
            } 

            catch (BadLocationException ex) 
            {
                this.posicionTexto.setText("0:0");
            }
            
            Highlighter.HighlightPainter colorEstructura = new DefaultHighlighter.DefaultHighlightPainter(this.panelEditorCodigoFuente.getSelectionColor());

            try 
            {
                this.panelEditorCodigoFuente.getHighlighter().addHighlight(posicionInicio, posicionFinal, colorEstructura);
            } 

            catch (BadLocationException ex) 
            {
                System.out.println ("Error al resaltar codigo fuente");
            }
            
            return;
        }
        
        actualizarContadorLineas();
        comprobarContenidoGuardado ();
        analisisIdentificacionUsuario ();
            
        try 
        {    
            int posicionCaracter = this.panelEditorCodigoFuente.getCaretPosition();
            int lineaActual = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracter);
            int columnaActual = posicionCaracter - this.panelEditorCodigoFuente.getLineStartOffset(lineaActual);
            this.posicionTexto.setText((lineaActual + 1) + ":" + columnaActual);
        } 
        
        catch (BadLocationException ex) 
        {
            this.posicionTexto.setText("0:0");
        }
        
        if (estructuraErrores.recuperarTotalErrores() == 0)
        {
            this.IndicatorSintaxix.setText("Sintasix: Correcta");
        }
        
        else
        {
            this.IndicatorSintaxix.setText("Sintasix: Erronea");
        }
        
    }//GEN-LAST:event_panelEditorCodigoFuenteCaretUpdate

    private void identificadorSintaxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorSintaxisActionPerformed
        if (identificacionExpresion == true)
        {
            identificacionExpresion = false;
            identificadorSintaxis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/No-identificador.png")));
            identificadorSintaxis.setToolTipText("Identificador de sintaxis desactivado");
        }
        
        else
        {
            identificacionExpresion = true;
            identificadorSintaxis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/Identificador.png")));
            identificadorSintaxis.setToolTipText("Identificador de sintaxis activado");
        }

        analisisIdentificacionUsuario();
    }//GEN-LAST:event_identificadorSintaxisActionPerformed

    private void diccionarioPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diccionarioPalabrasActionPerformed
        JDialog_DiccionarioPalabras diccionarioPalabras = new JDialog_DiccionarioPalabras(frame, true, lookAndFeel);
        diccionarioPalabras.obtenerDiccionarioPalabras(estructuraSimbolos, estructuraErrores);
    }//GEN-LAST:event_diccionarioPalabrasActionPerformed

    public void copiarContenidoFuente (boolean cortar)
    {
        if (cortar == true)
        {
            String contenidoCopiar = this.panelEditorCodigoFuente.getSelectedText();
            
            if (contenidoCopiar != null)
            {
                copiarPortapapeles(contenidoCopiar);
                
                String contenidoParteUno = this.panelEditorCodigoFuente.getText().substring(0, this.panelEditorCodigoFuente.getSelectionStart());
                String contenidoParteDos = this.panelEditorCodigoFuente.getText().substring(this.panelEditorCodigoFuente.getSelectionEnd(), this.panelEditorCodigoFuente.getText().length());
                String contenidoCortado = contenidoParteUno + contenidoParteDos;
                this.panelEditorCodigoFuente.setText(contenidoCortado);
                analisisIdentificacionUsuario();
            }
        }
        
        else
        {
            String contenidoCopiar = this.panelEditorCodigoFuente.getSelectedText();
            
            if (contenidoCopiar != null)
            {
                copiarPortapapeles(contenidoCopiar);
            }
        }
    }
    
    public void pegarContenidoFuente ()
    {
        try 
        {
            String contenidoPegado = pegarPortapapeles();
        
            if (panelEditorCodigoFuente.getSelectedText() != null)
            {
                String contenidoParteUno = this.panelEditorCodigoFuente.getText().substring(0, this.panelEditorCodigoFuente.getSelectionStart());
                String contenidoParteDos = this.panelEditorCodigoFuente.getText().substring(this.panelEditorCodigoFuente.getSelectionEnd(), this.panelEditorCodigoFuente.getText().length());
                String contenidoCortado = contenidoParteUno + contenidoPegado +  contenidoParteDos;
                this.panelEditorCodigoFuente.setText(contenidoCortado);
            }

            else
            {
                String contenidoParteUno = this.panelEditorCodigoFuente.getText().substring(0, this.panelEditorCodigoFuente.getCaretPosition());
                String contenidoParteDos = this.panelEditorCodigoFuente.getText().substring(this.panelEditorCodigoFuente.getCaretPosition(), this.panelEditorCodigoFuente.getText().length());
                String contenidoCortado = contenidoParteUno + contenidoPegado +  contenidoParteDos;
                this.panelEditorCodigoFuente.setText(contenidoCortado);
            }
        } 
        
        catch (UnsupportedFlavorException ex) 
        {
            Logger.getLogger(JPanel_EditorCodigoFuente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        catch (IOException ex) 
        {
            Logger.getLogger(JPanel_EditorCodigoFuente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        analisisIdentificacionUsuario();
    }
    
    private void copiarPortapapeles(String pegado)
    {
        StringSelection contenidoCopia = new StringSelection(pegado);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(contenidoCopia, null);  
    }
    
    private String pegarPortapapeles() throws UnsupportedFlavorException, IOException 
    {
        Transferable portapapelesSistema = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String copiado = (String) portapapelesSistema.getTransferData(DataFlavor.stringFlavor);
        return copiado;
    }
    
    public void agregarTabulacionContenido (boolean agregarTabulacion)
    {
        String lineaCodigo = "";
        ArrayList <String> lineaEdicionCodigo = new ArrayList <String>();
        String contenidoEdicionCodigo = this.panelEditorCodigoFuente.getText();
        int posicionCursor = 0;
        
        if ((contenidoEdicionCodigo.compareTo("") == 0) || (contenidoEdicionCodigo == null))
        {
            return;
        }
        
        for (int i = 0; i < contenidoEdicionCodigo.length(); i++)
        {
            if (contenidoEdicionCodigo.charAt(i) == '\n')
            {
                lineaEdicionCodigo.add(lineaCodigo);
                lineaCodigo = "";
            }
            
            else
            {
                lineaCodigo += contenidoEdicionCodigo.charAt(i);
                
                if (i == (contenidoEdicionCodigo.length() - 1))
                {
                    lineaEdicionCodigo.add(lineaCodigo);
                    lineaCodigo = "";
                }
            }
        }
        
        String contenidoTabulado = "";
        
        if (agregarTabulacion == true)
        {
            if (this.panelEditorCodigoFuente.getSelectedText() == null || this.panelEditorCodigoFuente.getSelectedText().compareTo("") == 0)
            {
                try 
                {    
                    int posicionCaracter = this.panelEditorCodigoFuente.getCaretPosition();
                    int lineaActual = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracter);
                    
                    for (int i = 0; i < lineaEdicionCodigo.size(); i++) 
                    {
                        if (lineaActual == i)
                        {
                            lineaEdicionCodigo.set(i, "\t" + lineaEdicionCodigo.get(i));
                        }
                        
                        if (i == 0)
                        {
                            contenidoTabulado += lineaEdicionCodigo.get(i);
                        }
                        
                        else
                        {
                             contenidoTabulado += "\n" + lineaEdicionCodigo.get(i);
                        }
                    }
                    
                    posicionCursor = posicionCaracter + 1;
                } 

                catch (BadLocationException ex) 
                {
                   System.out.println("Error de agregacion de tabulacion");
                }
            }
            
            else
            {
                int posicionInicio = this.panelEditorCodigoFuente.getSelectionStart();
                int posicionFinal = this.panelEditorCodigoFuente.getSelectionEnd();
                int cantidadTab = 0;

                try 
                {    
                    int posicionCaracterInicial = posicionInicio;
                    int lineaActualInicial = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterInicial);

                    int posicionCaracterFinal = posicionFinal;
                    int lineaActualFinal = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterFinal);

                    for (int i = 0; i < lineaEdicionCodigo.size(); i++) 
                    {
                        
                        if (lineaActualInicial <= i && lineaActualFinal >= i)
                        {
                            lineaEdicionCodigo.set(i, "\t" + lineaEdicionCodigo.get(i));
                            cantidadTab ++;
                        }
                        
                        if (i == 0)
                        {
                            contenidoTabulado += lineaEdicionCodigo.get(i);
                        }
                        
                        else
                        {
                             contenidoTabulado += "\n" + lineaEdicionCodigo.get(i);
                        }
                    }
                    
                    posicionCursor = posicionFinal + (1 * cantidadTab);
                } 

                catch (BadLocationException ex) 
                {
                    System.out.println("Error de agregacion de tabulacion");
                }
            }
        }
        
        else
        {
            if (this.panelEditorCodigoFuente.getSelectedText() == null || this.panelEditorCodigoFuente.getSelectedText().compareTo("") == 0)
            {
                try 
                {    
                    int posicionCaracter = this.panelEditorCodigoFuente.getCaretPosition();
                    int lineaActual = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracter);
                    boolean eliminarTab = false;
                    
                    for (int i = 0; i < lineaEdicionCodigo.size(); i++) 
                    {
                        if (lineaActual == i)
                        {
                            String contenidoEdicionEliminacion = eliminarTabulacionLinea(lineaEdicionCodigo.get(i));
                            
                            if (contenidoEdicionEliminacion.length() != lineaEdicionCodigo.get(i).length())
                            {
                                eliminarTab = true;
                                lineaEdicionCodigo.set(i, contenidoEdicionEliminacion);
                            }
                        }
                        
                        if (i == 0)
                        {
                            contenidoTabulado += lineaEdicionCodigo.get(i);
                        }
                        
                        else
                        {
                             contenidoTabulado += "\n" + lineaEdicionCodigo.get(i);
                        }
                    }
                    
                    if (eliminarTab == true)
                    {
                        posicionCursor = posicionCaracter - 1;
                    }
                    
                    else
                    {
                        posicionCursor = posicionCaracter;
                    }
                } 

                catch (BadLocationException ex) 
                {
                   System.out.println("Error de eliminacion de tabulacion");
                }
            }
            
            else
            {
                int posicionInicio = this.panelEditorCodigoFuente.getSelectionStart();
                int posicionFinal = this.panelEditorCodigoFuente.getSelectionEnd();
                int eliminarTab = 0;

                try 
                {    
                    int posicionCaracterInicial = posicionInicio;
                    int lineaActualInicial = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterInicial);

                    int posicionCaracterFinal = posicionFinal;
                    int lineaActualFinal = this.panelEditorCodigoFuente.getLineOfOffset(posicionCaracterFinal);

                    for (int i = 0; i < lineaEdicionCodigo.size(); i++) 
                    {
                        if (lineaActualInicial <= i && lineaActualFinal >= i)
                        {
                            String contenidoEdicionEliminacion = eliminarTabulacionLinea(lineaEdicionCodigo.get(i));
                            
                            if (contenidoEdicionEliminacion.length() != lineaEdicionCodigo.get(i).length())
                            {
                                eliminarTab ++;
                                lineaEdicionCodigo.set(i, contenidoEdicionEliminacion);
                            }
                        }
                        
                        if (i == 0)
                        {
                            contenidoTabulado += lineaEdicionCodigo.get(i);
                        }
                        
                        else
                        {
                             contenidoTabulado += "\n" + lineaEdicionCodigo.get(i);
                        }
                    }
                    
                    if (eliminarTab > 0)
                    {
                        posicionCursor = posicionFinal - (1 * eliminarTab);
                    }
                    
                    else
                    {
                        posicionCursor = posicionFinal;
                    }
                } 

                catch (BadLocationException ex) 
                {
                    System.out.println("Error de eliminacion de tabulacion");
                }
            }
        }
        
        this.panelEditorCodigoFuente.setText("");
        this.panelEditorCodigoFuente.setText(contenidoTabulado);
        this.panelEditorCodigoFuente.setCaretPosition(posicionCursor);
        analisisIdentificacionUsuario();
    }
    
    private String eliminarTabulacionLinea (String lineaContenido)
    {
        String contenidoSinTabulado = "";
        int numEspacios = 0;
        
        for (int i = 0; i < lineaContenido.length(); i++) 
        {
            if (lineaContenido.charAt(i) == '\t' && numEspacios < 1)
            {
                numEspacios ++;
            }
            
            else
            {
                numEspacios = 1;
                contenidoSinTabulado += lineaContenido.charAt(i);
            }
        }
        
        return contenidoSinTabulado;
    }
    
    public void realizarAnalisisResultados (JFrame parent)
    {
        JDialog_ResultadosEdicionFuente resultadoAnalisis = new JDialog_ResultadosEdicionFuente (parent, true, this.lookAndFeel);
        resultadoAnalisis.obtenerResultadosAnalisis(estructuraSimbolos, estructuraErrores, estructuraTokens, panelEditorCodigoFuente.getText());
    }
    
    public void realizarAnalisisDepuracion (JFrame parent)
    {
        JDialog_ResultadosEdicionFuenteExtendido resultadoDepuracion = new JDialog_ResultadosEdicionFuenteExtendido (parent, true, this.lookAndFeel);
        resultadoDepuracion.obtenerResultadosAnalisis(estructuraTiplo, estructuraEnsamblador, panelEditorCodigoFuente.getText(), optimizadorFuente.recuperarCodigoOptimizado());
    }
    
    private void analisisIdentificacionUsuario ()
    {
        this.registroProcesos.clear();
        this.estructuraExpresiones = new JClass_EstructuraExpresiones ();
        this.estructuraSimbolos = new JClass_EstructuraSimbolos ();
        this.estructuraErrores = new JClass_EstructuraErrores ();
        this.estructuraTokens = new JClass_EstructuraTokens ();
        this.estructuraTiplo = new JClass_EstructuraTiplo ();
        this.optimizadorFuente = new JClass_OptimizadorCodigoFuente ();
        this.estructuraEnsamblador = new JClass_EstructuraEnsamblador();
        
        JClass_AnalizadorContenidoEdicion analisisContenido = new JClass_AnalizadorContenidoEdicion(this.panelEditorCodigoFuente, this.estructuraExpresiones, this.estructuraSimbolos, this.estructuraErrores, estructuraTokens, this.estructuraTiplo, this.optimizadorFuente, this.estructuraEnsamblador);
        analisisContenido.analizarContenidoEdicion(registroProcesos, identificacionExpresion);
        
        int totalPalabras = estructuraSimbolos.recuperarTotalSimbolos() + estructuraErrores.recuperarTotalErrores();
        this.contadorPalabra.setText("Numero de palabras: " + totalPalabras);
    }
    
    private void comprobarContenidoGuardado()
    {
        if (administradorActual == null)
        {
            return;
        }
        
        if (this.panelEditorCodigoFuente.getText().compareTo(this.contenidoGuardado) != 0)
        {
            if (this.edicionActiva == false)
            {
                if (this.administradorActual.obtenerTituloAdministrador().compareTo("Nuevo archivo") == 0)
                {
                    this.administradorActual.actualizarTituloAdministrador("Nuevo archivo*");
                }

                else
                {
                    this.administradorActual.actualizarTituloAdministrador(this.administradorActual.obtenerTituloAdministrador() + "*");
                }

                this.edicionActiva = true;
            }
        }
        
        else
        {
            if (this.edicionActiva == true)
            {
                if (this.administradorActual.obtenerTituloAdministrador().compareTo("Nuevo archivo*") == 0)
                {
                    this.administradorActual.actualizarTituloAdministrador("Nuevo archivo");
                }

                else
                {
                    String tituloTemporal = this.administradorActual.obtenerTituloAdministrador();
                    tituloTemporal = tituloTemporal.substring(0, tituloTemporal.length()-1);
                    this.administradorActual.actualizarTituloAdministrador(tituloTemporal);
                }

                this.edicionActiva = false;
            }
        }
    }
    
    private void actualizarContadorLineas ()
    {
        int contadorLinea = 1;
        String textoEditor = this.panelEditorCodigoFuente.getText();
        
        for (int i = 0; i < textoEditor.length(); i++) 
        {
            if (textoEditor.charAt(i) == '\n')
            {
                contadorLinea ++;
            }
        }
        
        this.contadorLinea.setText("Numero de lineas: " + (contadorLinea));
       
        if (this.numeroLineaContada != contadorLinea)
        {
            this.numeroLineaContada = contadorLinea;

            this.contadorLineaCodigo.setText("");
            String textoContadorEditor = "";            

            for (int i = 1; i <= contadorLinea; i++) 
            {
                if (i == 1)
                {
                    textoContadorEditor += (String.valueOf(i));
                }

                else
                {
                    textoContadorEditor +=  ('\n' + String.valueOf(i));
                }
            }

            this.contadorLineaCodigo.setText(textoContadorEditor);
        }
        
        String numeroExpancionContador = "10";
        int numeroDigitoExpancion = 1;
        
        while (contadorLinea >= Integer.parseInt (numeroExpancionContador))
        {
            numeroExpancionContador += '0';
            numeroDigitoExpancion ++;
        }
        
        this.actualizarLayoutEditor(numeroDigitoExpancion);
    }
    
    public void establecerContenidoArchivo (File rutaArchivo, String contenidoArchivo)
    {
        if (administradorActual == null)
        {
            return;
        }
        
        this.rutaAlmacenamientoArchivo = rutaArchivo;
        this.contenidoGuardado = contenidoArchivo;
        administradorActual.actualizarTituloAdministrador(rutaArchivo.getName());
        panelEditorCodigoFuente.setText(contenidoArchivo);
        actualizarEstadoEditable();
    }
    
    private void actualizarLayoutEditor (int numeroDigitoExpancion)
    {   
        int expanzorMultiplicador = tamañoFuenteEditor - 10;
        int multriplicadorDigital = 12 + (numeroDigitoExpancion * 8) + expanzorMultiplicador;
        
//        javax.swing.GroupLayout panelEditorPrincipalLayout = new javax.swing.GroupLayout(panelEditorPrincipal);
//        panelEditorPrincipal.setLayout(panelEditorPrincipalLayout);
//        panelEditorPrincipalLayout.setHorizontalGroup(
//            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(deslizadorContadorLineaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, multriplicadorDigital, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(deslizadorEditorCodigoFuente, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
//                .addContainerGap())
//        );
//        panelEditorPrincipalLayout.setVerticalGroup(
//            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(deslizadorEditorCodigoFuente)
//                    .addComponent(deslizadorContadorLineaCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
//                    .addComponent(separator1, javax.swing.GroupLayout.Alignment.LEADING))
//                .addContainerGap())
//        );

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(0, 0, 0)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addGap(0, 0, 0))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(12, 12, 12)
//                .addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addGap(26, 26, 26))
//        );
        
        javax.swing.GroupLayout panelEditorPrincipalLayout = new javax.swing.GroupLayout(panelEditorPrincipal);
        panelEditorPrincipal.setLayout(panelEditorPrincipalLayout);
        panelEditorPrincipalLayout.setHorizontalGroup(
            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deslizadorContadorLineaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, multriplicadorDigital, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deslizadorEditorCodigoFuente)
                .addContainerGap())
        );
        panelEditorPrincipalLayout.setVerticalGroup(
            panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deslizadorEditorCodigoFuente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(separator1)
                    .addComponent(deslizadorContadorLineaCodigo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(identificadorSintaxis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diccionarioPalabras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(contadorLinea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contadorPalabra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(posicionTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IndicatorSintaxix))
                    .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEditorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(identificadorSintaxis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diccionarioPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(IndicatorSintaxix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(posicionTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(contadorPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(contadorLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        this.deslizadorContadorLineaCodigo.getHorizontalScrollBar().setValue(0);
    }
    
    public void actualizarTipografiaEditor (Font nuevaTipografia)
    {
        this.fuenteEditorCodigo = new Font(nuevaTipografia.getName(), 0, this.tamañoFuenteEditor);
        panelEditorCodigoFuente.setFont(this.fuenteEditorCodigo);
        contadorLineaCodigo.setFont(this.fuenteEditorCodigo);
        this.actualizarContadorLineas ();
    }
    
    public void actualizarTamañoTipografiaEditor (Boolean aumentarTamaño)
    {
        if (aumentarTamaño == true)
        {
            if (this.tamañoFuenteEditor < 40)
            {
                this.tamañoFuenteEditor += 1;
            }
        }
        
        else
        {
            if (this.tamañoFuenteEditor > 10)
            {
                this.tamañoFuenteEditor -= 1;
            }
        }
        
        this.actualizarTipografiaEditor(this.fuenteEditorCodigo);
        this.actualizarContadorLineas ();
    }
    
    public void establecerAdministradorEditor (JPanel_AdministradorEditor administradorActual)
    {
        this.administradorActual = administradorActual;
    }
    
    public void actualizarTamañoTipografiaEditor (int tamañoExacto)
    {
        this.tamañoFuenteEditor = tamañoExacto;
        this.actualizarTipografiaEditor(this.fuenteEditorCodigo);
        this.actualizarContadorLineas ();
    }
    
    public void actualizarEstadoEditable ()
    {
        this.contenidoGuardado = this.panelEditorCodigoFuente.getText();
        this.edicionActiva = false;
        comprobarContenidoGuardado();
    }
    
    public void actualizarUbicacionArchivo (File ubicacionArchivo)
    {
        this.rutaAlmacenamientoArchivo = ubicacionArchivo;
    }
    
    public Font recuperarTipografiaEditor ()
    {
        return this.fuenteEditorCodigo;
    }
    
    public JTextArea recuperarAreaTexto ()
    {
        return this.panelEditorCodigoFuente;
    }
    
    public int recuperarTamañoTipografiaEditor ()
    {
        return this.tamañoFuenteEditor;
    }
    
    public boolean recuperarEstadoEditable ()
    {
        return this.edicionActiva;
    }
    
    public String recuperarContenidoEditor ()
    {
        return this.panelEditorCodigoFuente.getText();
    }
    
    public File recuperarUbicacionArchivo ()
    {
        return this.rutaAlmacenamientoArchivo;
    }
    
    public String recuperarContenidoTokens ()
    {
        return this.estructuraTokens.recuperarLineaContenidoTokenEscritas();
    }
    
    public String recuperarContenidoTiplo ()
    {
        return this.estructuraTiplo.recuperarFormatoEscrituraTriplo();
    }
    
    public String recuperarCodigoOptimizado ()
    {
        return this.optimizadorFuente.recuperarCodigoOptimizado();
    }
    
    public String recuperarCodigoEnsamblador ()
    {
        return this.estructuraEnsamblador.recuperarFormatoEscrituraEnsamblador();
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
    private javax.swing.JLabel IndicatorSintaxix;
    private javax.swing.JLabel contadorLinea;
    private javax.swing.JTextArea contadorLineaCodigo;
    private javax.swing.JLabel contadorPalabra;
    private javax.swing.JScrollPane deslizadorContadorLineaCodigo;
    private javax.swing.JScrollPane deslizadorEditorCodigoFuente;
    private javax.swing.JButton diccionarioPalabras;
    private javax.swing.JButton identificadorSintaxis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea panelEditorCodigoFuente;
    private javax.swing.JPanel panelEditorPrincipal;
    private javax.swing.JLabel posicionTexto;
    private javax.swing.JSeparator separator1;
    // End of variables declaration//GEN-END:variables
}
