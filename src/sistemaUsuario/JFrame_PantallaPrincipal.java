package sistemaUsuario;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import sistemaEscritura.JClass_EscrituraArchivoFuente;
import sistemaLectura.JClass_LecturaArchivoFuente;

public class JFrame_PantallaPrincipal extends javax.swing.JFrame 
{
    private ArrayList <JPanel_AdministradorEditor> administradorEditor = null;
    private ArrayList <JPanel_EditorCodigoFuente> administradorCodigo = null;
    private Font [] tipografiaSistema = null;
    private int tipografiaSeleccionada = 0;
    private LookAndFeel [] lookAndFeelDisponible = null;
    private int lookAndFeelSeleccionado = 0;
    
    public JFrame_PantallaPrincipal() 
    {
       this.lookAndFeelDisponible = new LookAndFeel [1];
       this.lookAndFeelDisponible [0] = new FlatDarkLaf();
        
       initComponents();
    }
    
    private void initProcess ()
    {
        Image icono_Aplicacion = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/almacenImagenes/Logo1.png"));
        icono_Aplicacion = icono_Aplicacion.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        this.setIconImage(icono_Aplicacion);
        
        administradorEditor = new ArrayList <JPanel_AdministradorEditor>();
        administradorCodigo = new ArrayList <JPanel_EditorCodigoFuente>();
        agregarEditorCodigoFuente(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        nuevoArchivo = new javax.swing.JButton();
        abrirArchivo = new javax.swing.JButton();
        separator1 = new javax.swing.JSeparator();
        guardarArchivo = new javax.swing.JButton();
        copiarTexto = new javax.swing.JButton();
        cortarTexto = new javax.swing.JButton();
        pegarTexto = new javax.swing.JButton();
        separator2 = new javax.swing.JSeparator();
        buscarTexto = new javax.swing.JButton();
        reducirSangria = new javax.swing.JButton();
        agregarSangria = new javax.swing.JButton();
        ejecutarCodigo = new javax.swing.JButton();
        ejecutarDebugger = new javax.swing.JButton();
        separator4 = new javax.swing.JSeparator();
        listaFuentes = new javax.swing.JComboBox<>();
        aplicarFuente = new javax.swing.JButton();
        aumentarTexto = new javax.swing.JButton();
        reducirFuente = new javax.swing.JButton();
        separator5 = new javax.swing.JSeparator();
        administradorCodigoFuente = new javax.swing.JTabbedPane();
        tamañoFuente = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor de código JarCEAM 8.2");

        jLabel1.setText("Herramientas de edición:");

        nuevoArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/NuevoArchivo.png"))); // NOI18N
        nuevoArchivo.setToolTipText("Crear nuevo archivo");
        nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoActionPerformed(evt);
            }
        });

        abrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/AbrirArchivo.png"))); // NOI18N
        abrirArchivo.setToolTipText("Abrir un archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        guardarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/GuardarArchivo.png"))); // NOI18N
        guardarArchivo.setToolTipText("Guardar archivo actual");
        guardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoActionPerformed(evt);
            }
        });

        copiarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/CopiarTexto.png"))); // NOI18N
        copiarTexto.setToolTipText("Copiar texto seleccionado");
        copiarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarTextoActionPerformed(evt);
            }
        });

        cortarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/CortarTexto.png"))); // NOI18N
        cortarTexto.setToolTipText("Cortar texto seleccionado");
        cortarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarTextoActionPerformed(evt);
            }
        });

        pegarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/PegarTexto.png"))); // NOI18N
        pegarTexto.setToolTipText("Pegar texto copiado o cortado");
        pegarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarTextoActionPerformed(evt);
            }
        });

        separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buscarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/BuscarTexto.png"))); // NOI18N
        buscarTexto.setToolTipText("Buscar texto");
        buscarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTextoActionPerformed(evt);
            }
        });

        reducirSangria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/SangriaIzquierda.png"))); // NOI18N
        reducirSangria.setToolTipText("Eliminar tabulación inicial");
        reducirSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducirSangriaActionPerformed(evt);
            }
        });

        agregarSangria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/SangriaDerecha.png"))); // NOI18N
        agregarSangria.setToolTipText("Agregar tabulación inicial");
        agregarSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSangriaActionPerformed(evt);
            }
        });

        ejecutarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/EjecutarCodigo.png"))); // NOI18N
        ejecutarCodigo.setToolTipText("Compilar programa");
        ejecutarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarCodigoActionPerformed(evt);
            }
        });

        ejecutarDebugger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/EjecutarDebugger.png"))); // NOI18N
        ejecutarDebugger.setToolTipText("Compilar programa de forma extendida");
        ejecutarDebugger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarDebuggerActionPerformed(evt);
            }
        });

        separator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listaFuentes.setToolTipText("Fuentes de texto");

        aplicarFuente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/AplicarFuente.png"))); // NOI18N
        aplicarFuente.setToolTipText("Aplicar fuente de texto seleccionado");
        aplicarFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarFuenteActionPerformed(evt);
            }
        });

        aumentarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/AumentarTexto.png"))); // NOI18N
        aumentarTexto.setToolTipText("Aumentar tamaño de fuente");
        aumentarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aumentarTextoActionPerformed(evt);
            }
        });

        reducirFuente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/ReducirTexto.png"))); // NOI18N
        reducirFuente.setToolTipText("Disminuir tamaño de fuente");
        reducirFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducirFuenteActionPerformed(evt);
            }
        });

        separator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        administradorCodigoFuente.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        administradorCodigoFuente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                administradorCodigoFuenteStateChanged(evt);
            }
        });

        tamañoFuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        tamañoFuente.setSelectedIndex(2);
        tamañoFuente.setToolTipText("Tamaño de fuente de texto");

        menuArchivo.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/NuevoArchivoMenu.png"))); // NOI18N
        jMenuItem1.setText("  Nuevo archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/AbrirArchivoMenu.png"))); // NOI18N
        jMenuItem2.setText("  Abrir archivo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/AbrirArchivoPestaniaMenu.png"))); // NOI18N
        jMenuItem3.setText("  Abrir archivo en nueva pestaña");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/GuardarArchivoMenu.png"))); // NOI18N
        jMenuItem4.setText("  Guardar archivo actual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/SalirMenu.png"))); // NOI18N
        jMenuItem5.setText("  Salir del editor");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem5);

        jMenuBar1.add(menuArchivo);

        menuAyuda.setText("Acerca");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/ManualMenu.png"))); // NOI18N
        jMenuItem7.setText("  Manual del usuario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem7);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/InformacionMenu.png"))); // NOI18N
        jMenuItem6.setText("  Información del editor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem6);

        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/almacenImagenes/TablaMenu.png"))); // NOI18N
        jMenuItem16.setText("  Expresiones regulares del editor");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem16);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(administradorCodigoFuente)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(nuevoArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abrirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copiarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cortarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pegarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reducirSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarSangria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ejecutarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ejecutarDebugger, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaFuentes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tamañoFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aplicarFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aumentarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reducirFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevoArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator1)
                    .addComponent(copiarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cortarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pegarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator2)
                    .addComponent(aplicarFuente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aumentarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reducirFuente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reducirSangria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregarSangria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(separator5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(ejecutarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ejecutarDebugger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaFuentes)
                    .addComponent(tamañoFuente))
                .addGap(10, 10, 10)
                .addComponent(administradorCodigoFuente, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoActionPerformed
        agregarEditorCodigoFuente(false);
    }//GEN-LAST:event_nuevoArchivoActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        abrirArchivoNuevo();
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void abrirArchivoNuevo ()
    {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea abrir el archivo en la pestaña actual?", "Abrir archivo:", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION)
        {
            JClass_LecturaArchivoFuente lecturaArchivoFuente = new JClass_LecturaArchivoFuente (this);
            
            if (lecturaArchivoFuente.leerArchivoFuente())
            {
                this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).establecerContenidoArchivo(lecturaArchivoFuente.recuperarUbicacionArchivo(), lecturaArchivoFuente.recuperarContenidoFuente());
            }
        }
        
        else
        {
            agregarEditorCodigoFuente(true);
        }
    }
    
    private void administradorCodigoFuenteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_administradorCodigoFuenteStateChanged
        // TODO add your handling code here:
        if (administradorCodigoFuente.getTabCount() == 0)
        {
            agregarEditorCodigoFuente(false);
            return;
        }
        
        Font tipografiaEditor = this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarTipografiaEditor();
        
        for (int i = 0; i < this.tipografiaSistema.length; i++) 
        {
            if(this.tipografiaSistema[i].getName().compareTo(tipografiaEditor.getName()) == 0)
            {
                listaFuentes.setSelectedIndex(i);
                break;
            }
        }
        
        this.tamañoFuente.setSelectedIndex(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarTamañoTipografiaEditor() - 10);
    }//GEN-LAST:event_administradorCodigoFuenteStateChanged

    private void aplicarFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarFuenteActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarTamañoTipografiaEditor(tamañoFuente.getSelectedIndex() + 10);
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarTipografiaEditor(this.tipografiaSistema[listaFuentes.getSelectedIndex()]);
    }//GEN-LAST:event_aplicarFuenteActionPerformed

    private void aumentarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aumentarTextoActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarTamañoTipografiaEditor(true);
        this.tamañoFuente.setSelectedIndex(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarTamañoTipografiaEditor() - 10);
    }//GEN-LAST:event_aumentarTextoActionPerformed

    private void reducirFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducirFuenteActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarTamañoTipografiaEditor(false);
        this.tamañoFuente.setSelectedIndex(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarTamañoTipografiaEditor() - 10);
    }//GEN-LAST:event_reducirFuenteActionPerformed

    private void guardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoActionPerformed
        guardarArchivoActual ();
    }//GEN-LAST:event_guardarArchivoActionPerformed

    private void guardarArchivoActual ()
    {
        JClass_EscrituraArchivoFuente escrituraArchivoFuente = new JClass_EscrituraArchivoFuente (this);
        if (escrituraArchivoFuente.escribirArchivoFuente(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor()))
        {
            File ubicacionArchivo = escrituraArchivoFuente.recuperarUbicacionArchivo();
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarUbicacionArchivo(ubicacionArchivo);
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
            this.administradorEditor.get(administradorCodigoFuente.getSelectedIndex()).actualizarTituloAdministrador(ubicacionArchivo.getName());
        }
    }
    
    private void ejecutarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarCodigoActionPerformed
        ejecutarNormal();
    }//GEN-LAST:event_ejecutarCodigoActionPerformed

    private void ejecutarNormal ()
    {
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor() == null || this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(this, "Sin contenido en el panel de edición.", "Panel vacio:", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JClass_EscrituraArchivoFuente escrituraArchivoFuente = new JClass_EscrituraArchivoFuente (this);
        
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo() != null)
        {
            if (escrituraArchivoFuente.escribirArchivoFuente(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor()))
            {
                File ubicacionArchivo = escrituraArchivoFuente.recuperarUbicacionArchivo();
                this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarUbicacionArchivo(ubicacionArchivo);
                this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
                this.administradorEditor.get(administradorCodigoFuente.getSelectedIndex()).actualizarTituloAdministrador(ubicacionArchivo.getName());
            }
            
            escrituraArchivoFuente.escribirArchivoTokens(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTokens());
            escrituraArchivoFuente.escribirArchivoTiplo(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTiplo());
            escrituraArchivoFuente.escribirArchivoOptimizado(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoOptimizado());
            escrituraArchivoFuente.escribirArchivoEnsamblador(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoEnsamblador());
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
        }
        
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo() == null)
        {        
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea guardar el archivo de compilacíon?", "Guardar archivo de compilación:", JOptionPane.YES_NO_OPTION))
            {    
                escrituraArchivoFuente.escribirArchivoTokens(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTokens());            
                escrituraArchivoFuente.escribirArchivoTiplo(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTiplo());
                escrituraArchivoFuente.escribirArchivoOptimizado(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoOptimizado());
                escrituraArchivoFuente.escribirArchivoEnsamblador(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoEnsamblador());
            }
        }
       
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).realizarAnalisisResultados(this);
    }
    
    private void ejecutarDebuggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarDebuggerActionPerformed
        ejecutarExtendido();
    }//GEN-LAST:event_ejecutarDebuggerActionPerformed

    private void ejecutarExtendido ()
    {
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor() == null || this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(this, "Sin contenido en el panel de edición.", "Panel vacio:", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JClass_EscrituraArchivoFuente escrituraArchivoFuente = new JClass_EscrituraArchivoFuente (this);
        
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo() != null)
        {
            
            if (escrituraArchivoFuente.escribirArchivoFuente(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor()))
            {
                File ubicacionArchivo = escrituraArchivoFuente.recuperarUbicacionArchivo();
                this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarUbicacionArchivo(ubicacionArchivo);
                this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
                this.administradorEditor.get(administradorCodigoFuente.getSelectedIndex()).actualizarTituloAdministrador(ubicacionArchivo.getName());
            }
            
            escrituraArchivoFuente.escribirArchivoTokens(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTokens());
            escrituraArchivoFuente.escribirArchivoTiplo(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTiplo());
            escrituraArchivoFuente.escribirArchivoOptimizado(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoOptimizado());
            escrituraArchivoFuente.escribirArchivoEnsamblador(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoEnsamblador());
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
        }
        
        if (this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo() == null)
        {        
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "¿Desea guardar el archivo de compilacíon?", "Guardar archivo de compilación:", JOptionPane.YES_NO_OPTION))
            {    
                escrituraArchivoFuente.escribirArchivoTokens(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTokens());            
                escrituraArchivoFuente.escribirArchivoTiplo(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoTiplo());
                escrituraArchivoFuente.escribirArchivoOptimizado(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoOptimizado());
                escrituraArchivoFuente.escribirArchivoEnsamblador(escrituraArchivoFuente.recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarCodigoEnsamblador());
            }
        }
        
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).realizarAnalisisDepuracion(this);
    }
    
    private void agregarSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSangriaActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).agregarTabulacionContenido(true);
    }//GEN-LAST:event_agregarSangriaActionPerformed

    private void reducirSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducirSangriaActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).agregarTabulacionContenido(false);
    }//GEN-LAST:event_reducirSangriaActionPerformed

    private void copiarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarTextoActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).copiarContenidoFuente(false);
    }//GEN-LAST:event_copiarTextoActionPerformed

    private void cortarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarTextoActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).copiarContenidoFuente(true);
    }//GEN-LAST:event_cortarTextoActionPerformed

    private void pegarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarTextoActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).pegarContenidoFuente();
    }//GEN-LAST:event_pegarTextoActionPerformed

    private void buscarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarTextoActionPerformed
        this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).buscarContenido();
    }//GEN-LAST:event_buscarTextoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        agregarEditorCodigoFuente(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JClass_LecturaArchivoFuente lecturaArchivoFuente = new JClass_LecturaArchivoFuente (this);
            
        if (lecturaArchivoFuente.leerArchivoFuente())
        {
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).establecerContenidoArchivo(lecturaArchivoFuente.recuperarUbicacionArchivo(), lecturaArchivoFuente.recuperarContenidoFuente());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        agregarEditorCodigoFuente(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JClass_EscrituraArchivoFuente escrituraArchivoFuente = new JClass_EscrituraArchivoFuente (this);
        if (escrituraArchivoFuente.escribirArchivoFuente(this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarUbicacionArchivo(), this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).recuperarContenidoEditor()))
        {
            File ubicacionArchivo = escrituraArchivoFuente.recuperarUbicacionArchivo();
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarUbicacionArchivo(ubicacionArchivo);
            this.administradorCodigo.get(administradorCodigoFuente.getSelectedIndex()).actualizarEstadoEditable();
            this.administradorEditor.get(administradorCodigoFuente.getSelectedIndex()).actualizarTituloAdministrador(ubicacionArchivo.getName());
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        JDialog_ExpresionesRegulares expresionesRegulares = new JDialog_ExpresionesRegulares (this, true, lookAndFeelDisponible [lookAndFeelSeleccionado]);
        expresionesRegulares.mostrarTabla();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        JDialog_InformacionEditor informacion = new JDialog_InformacionEditor(this, true, lookAndFeelDisponible [lookAndFeelSeleccionado]);
        informacion.mostrarInformacion();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        JDialog_ManualUsuario manual = new JDialog_ManualUsuario(this, true, lookAndFeelDisponible [lookAndFeelSeleccionado]);
        manual.mostrarManual();
    }//GEN-LAST:event_jMenuItem7ActionPerformed
    
    private void agregarEditorCodigoFuente (boolean archivoLeido)
    {
        if (archivoLeido == true)
        {
            JClass_LecturaArchivoFuente lecturaArchivoFuente = new JClass_LecturaArchivoFuente (this);
        
            if (lecturaArchivoFuente.leerArchivoFuente())
            {
                JPanel_EditorCodigoFuente editorCodigoFuente = new JPanel_EditorCodigoFuente (lookAndFeelDisponible [lookAndFeelSeleccionado], this.tipografiaSistema [this.tipografiaSeleccionada], lecturaArchivoFuente.recuperarUbicacionArchivo(), lecturaArchivoFuente.recuperarContenidoFuente(), this);
                editorCodigoFuente.recuperarAreaTexto().addKeyListener(new KeyListener() 
                    {
                        @Override
                        public void keyTyped(KeyEvent e) 
                        {
                            return;
                        }

                        @Override
                        public void keyPressed(KeyEvent e) 
                        {
                            boolean controlUP = false;

                            if(e.isControlDown())
                            {
                                controlUP = true;
                            }

                            if (controlUP && e.getKeyCode() == KeyEvent.VK_S)
                            {
                                guardarArchivoActual();
                                return;
                            }

                            if (controlUP && e.getKeyCode() == KeyEvent.VK_N)
                            {
                                agregarEditorCodigoFuente(false);
                                return;
                            }

                            if (controlUP && e.getKeyCode() == KeyEvent.VK_E)
                            {
                                abrirArchivoNuevo();
                                return;
                            }
                            
                            if (controlUP && e.getKeyCode() == KeyEvent.VK_I)
                            {
                                ejecutarNormal();
                                return;
                            }
                            
                            if (controlUP && e.getKeyCode() == KeyEvent.VK_O)
                            {
                                ejecutarExtendido();
                                return;
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) 
                        {
                            return;
                        }
                    }
                );
                this.administradorCodigo.add(editorCodigoFuente);
                JPanel_AdministradorEditor administradorEditor = new JPanel_AdministradorEditor(this.administradorCodigoFuente, lecturaArchivoFuente.recuperarUbicacionArchivo().getName(), this.administradorEditor.size(), this.administradorCodigo, this.administradorEditor, lookAndFeelDisponible [lookAndFeelSeleccionado], this);
                this.administradorEditor.add(administradorEditor);
                editorCodigoFuente.establecerAdministradorEditor(administradorEditor);

                this.administradorCodigoFuente.add(editorCodigoFuente);
                this.administradorCodigoFuente.setTabComponentAt(administradorEditor.obtenerNumeroAdministrador(), administradorEditor);
                this.administradorCodigoFuente.setSelectedIndex(administradorEditor.obtenerNumeroAdministrador());
            }
        }
        
        else
        {               
            JPanel_EditorCodigoFuente editorCodigoFuente = new JPanel_EditorCodigoFuente (lookAndFeelDisponible [lookAndFeelSeleccionado], this.tipografiaSistema [this.tipografiaSeleccionada], this);
            this.administradorCodigo.add(editorCodigoFuente);
            editorCodigoFuente.recuperarAreaTexto().addKeyListener(new KeyListener() 
                {
                    @Override
                    public void keyTyped(KeyEvent e) 
                    {
                        return;
                    }

                    @Override
                    public void keyPressed(KeyEvent e) 
                    {
                        boolean controlUP = false;
                        
                        if(e.isControlDown())
                        {
                            controlUP = true;
                        }
                        
                        if (controlUP && e.getKeyCode() == KeyEvent.VK_S)
                        {
                            guardarArchivoActual();
                            return;
                        }
                        
                        if (controlUP && e.getKeyCode() == KeyEvent.VK_N)
                        {
                            agregarEditorCodigoFuente(false);
                            return;
                        }
                        
                        if (controlUP && e.getKeyCode() == KeyEvent.VK_E)
                        {
                            abrirArchivoNuevo();
                            return;
                        }
                        
                        if (controlUP && e.getKeyCode() == KeyEvent.VK_I)
                        {
                            ejecutarNormal();
                            return;
                        }

                        if (controlUP && e.getKeyCode() == KeyEvent.VK_O)
                        {
                            ejecutarExtendido();
                            return;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) 
                    {
                        return;
                    }
                }
            );
            JPanel_AdministradorEditor administradorEditor = new JPanel_AdministradorEditor(this.administradorCodigoFuente, "Nuevo archivo", this.administradorEditor.size(), this.administradorCodigo, this.administradorEditor, lookAndFeelDisponible [lookAndFeelSeleccionado], this);
            this.administradorEditor.add(administradorEditor);
            editorCodigoFuente.establecerAdministradorEditor(administradorEditor);
            
            this.administradorCodigoFuente.add(editorCodigoFuente);
            this.administradorCodigoFuente.setTabComponentAt(administradorEditor.obtenerNumeroAdministrador(), administradorEditor);
            this.administradorCodigoFuente.setSelectedIndex(administradorEditor.obtenerNumeroAdministrador());
        }
    }
    
    public void iniciarPantallaUsuario (Font [] tipografiaSistema, String [] nombreTipografiaSistema) 
    {   
        this.tipografiaSistema = tipografiaSistema;
        listaFuentes.setModel(new DefaultComboBoxModel (nombreTipografiaSistema));
        
        for (int i = 0; i < nombreTipografiaSistema.length; i++) 
        {
            if(nombreTipografiaSistema [i].compareTo("Segoe UI") == 0)
            {
                listaFuentes.setSelectedIndex(i);
                this.tipografiaSeleccionada = i;
                break;
            }
        }
        
        try 
        {
            if (lookAndFeelSeleccionado < 0 && lookAndFeelSeleccionado > 10)
            {
                this.lookAndFeelSeleccionado = 0;
                System.err.println("El LookAndFeel seleccionado no esta disponible, por lo que se a seleccionado el por defecto.");
            }
            
            UIManager.setLookAndFeel(lookAndFeelDisponible [lookAndFeelSeleccionado]);
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
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                initProcess();
                setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirArchivo;
    private javax.swing.JTabbedPane administradorCodigoFuente;
    private javax.swing.JButton agregarSangria;
    private javax.swing.JButton aplicarFuente;
    private javax.swing.JButton aumentarTexto;
    private javax.swing.JButton buscarTexto;
    private javax.swing.JButton copiarTexto;
    private javax.swing.JButton cortarTexto;
    private javax.swing.JButton ejecutarCodigo;
    private javax.swing.JButton ejecutarDebugger;
    private javax.swing.JButton guardarArchivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> listaFuentes;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JButton nuevoArchivo;
    private javax.swing.JButton pegarTexto;
    private javax.swing.JButton reducirFuente;
    private javax.swing.JButton reducirSangria;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator4;
    private javax.swing.JSeparator separator5;
    private javax.swing.JComboBox<String> tamañoFuente;
    // End of variables declaration//GEN-END:variables
}