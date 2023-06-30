package sistemaUsuario;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JDialog_ManualUsuario extends javax.swing.JDialog 
{
    private JFrame parent;
    
    public JDialog_ManualUsuario(java.awt.Frame parent, boolean modal, LookAndFeel lookAndFeel) 
    {
        super(parent, modal);
        initComponents();
        this.parent = (JFrame) parent;
        establecerLookAndFeel(lookAndFeel);
    }
    
    public void mostrarManual ()
    {
        int dimensionHorizontalFrame = this.parent.getWidth();
        int dimensionVerticalFrame = this.parent.getHeight();
        dimensionHorizontalFrame = Math.round(dimensionHorizontalFrame * 0.75f);
        dimensionVerticalFrame = Math.round(dimensionVerticalFrame * 0.75f);
        
        if (dimensionHorizontalFrame > 745)
        {
            dimensionHorizontalFrame = 745;
        }
        
        if(dimensionVerticalFrame > 444)
        {
            dimensionVerticalFrame = 444;
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
        seccion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        seccionFuncionamiento = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manual del usuario:");

        jLabel1.setText("Seccion de funcionamiento:");

        seccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guia rápida", "Precauciones", "Funciones del editor", "Funciones de compilación" }));
        seccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seccionItemStateChanged(evt);
            }
        });

        seccionFuncionamiento.setColumns(20);
        seccionFuncionamiento.setLineWrap(true);
        seccionFuncionamiento.setRows(5);
        seccionFuncionamiento.setText("Este editor de código le permite la edición de código fuente para el futuro lenguaje de programación MP, basado en 12 diferentes expresiones regulares.\n\nPara editar un código fuente, primero describa las instruccíones de alto nivel en el panel de edición de codigo fuente, posteriormente guarde el archivo para evitar su permida y compile el codigo anteriormente escrito para obtener un archivo de tokens y un archivo de tiplo en una ubicación de destino seleccionada.\n\nAl momento de compilar podra optar en los modos de compilación de normal o extendida, donde uno permitira visualizar la edición de código fuente, tabla de simbolos, tabla de errores y la edición del codigo de tokens; y el otro le permitira visualizar exactamente lo mismo pero incluyendo la tabla de tiplo.\n\nEl editor posee un diccionario de instrucciones escritas, asi como un resaltador de expresiones validad identificadas en el programa.\n\nPuede emplear las siguientes combinaciones de teclas:\n\n\tAbrir un archivo: CTRL + E\n\tNuevo archivo de edicion: CTRL + N\n\tGuardar archivo actual: CTRL + S\n\tCompilar programa normal: CTRL + I\n\tCompilar programa extendido: CTRL + O");
        seccionFuncionamiento.setWrapStyleWord(true);
        seccionFuncionamiento.setFocusable(false);
        jScrollPane1.setViewportView(seccionFuncionamiento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_seccionItemStateChanged
        // TODO add your handling code here:
        switch (seccion.getSelectedIndex())
        {
            case 0:
            {
                seccionFuncionamiento.setText("Este editor de código le permite la edición de código fuente para el futuro lenguaje de programación MP, basado en 12 diferentes expresiones regulares.\n" + "\n" + "Para editar un código fuente, primero describa las instruccíones de alto nivel en el panel de edición de codigo fuente, posteriormente guarde el archivo para evitar su permida y compile el codigo anteriormente escrito para obtener un archivo de tokens y un archivo de tiplo en una ubicación de destino seleccionada.\n" + "\n" + "Al momento de compilar podra optar en los modos de compilación de normal o extendida, donde uno permitira visualizar la edición de código fuente, tabla de simbolos, tabla de errores y la edición del codigo de tokens; y el otro le permitira visualizar exactamente lo mismo pero incluyendo la tabla de tiplo.\n" + "\n" + "El editor posee un diccionario de instrucciones escritas, asi como un resaltador de expresiones validad identificadas en el programa.\n" + "\n" + "Puede emplear las siguientes combinaciones de teclas:\n" + "\n" + "	Abrir un archivo: CTRL + E\n" + "	Nuevo archivo de edicion: CTRL + N\n" + "	Guardar archivo actual: CTRL + S\n" + "	Compilar programa normal: CTRL + I\n" + "	Compilar programa extendido: CTRL + O");
                break;
            }

            case 1:
            {
                seccionFuncionamiento.setText("Para emplear del buen uso de este editor, es necesario leer las siguientes advertencias de ejecución definidas por el desarrollador:\n" + "\n" + "1. Este editor necesita de al menos un editor de código fuente activo, si este es eliminado entonces se volvera a instanciar otro.\n" + "\n" + "2. Este editor compila mientras escribe cada instruccíon del programa, por lo que el uso de muchas instrucciones podria comprometer el rendimiento del sistema de compilador.\n" + "\n" + "3. Este editor solo puede reconocer las instrucciones fundamentales del futuro lenguaje de programación MP, por lo que cualquier otra instrucción no declarada por el desarrollador no sera valida y le marcara sintaxis error.\n" + "\n" + "4. Este editor posee limitantes con respecto al uso de las fuentes del sistema para el empleo del contador de lineas de codigo del editor de código fuente. Por lo que ciertas fuentes podrian comprometer el aspecto visual del editor.\n" + "\n" + "5. Este editor se diseño para el uso del temas oscuros, por lo que cualquier intento de cambio de tema solo comprometera el aspecto visual y rendimiento del editor.\n" + "\n" + "6. Este editor solo valida el cierre de los archivos de codigo fuente en sus pestañas, por lo que cerrar el programa principal solo perderia su avance del programa.");
                break;
            }

            case 2:
            {
                seccionFuncionamiento.setText("Este editor posee las siguientes funcionalidades:\n" + "\n" + "1. Resaltado de expresiones regulares validad, por lo que cada instrucción escrita resaltara de un color determinado para identificarlo a la expresión que pertenece y si es valida.\n" + "\n" + "2. Buscador de instrucciones inexactas, por lo que se resaltara con un color la instrucción a buscar permitiendo así, su rapida identificación.\n" + "\n" +  "3. Personalización de la fuente de edición, por lo que podra manipular el tamaño y la fuente de texto de edición.\n" + "\n" + "4. Uso multipestaña, por lo que podra abrir varios archivos de instrucciones a la vez.\n" + "\n" + "5. Identificador de sintaxis, por lo que cada conjunto de instrucciones seran validadas mientras los escribe permitiendo identificar la correcta implementacion de la sintaxis del futuro lenguaje de programación MP.\n" + "\n" + "6. Diccionario de instrucciones, por lo que podrá buscar las instrucciones ingresadas y identificar su estado léxico.\n" + "\n" + "7. Contador de lineas de código y palabras y, ubicación de cursos de texto, por lo que siempre estara al tanto de las instrucciones que escribe y su ubicación en el editor de código fuente.");
                break;
            }

            case 3:
            {
                seccionFuncionamiento.setText("Este editor posee los siguientes sistemas de compilación del futuro lenguaje de programación MP:\n" + "\n" + "1. Sistema de compilación lexica, por lo que cada instrucciones ingresada en el editor de código fuente es evaluda y analizada para identificar si pertenece a alguna de las 12 diferentes expresiones regulares definidas en este editor.\n" + "\n" + "2. Sistema de compilación sintactica, por lo que cada instrucción anteriormente analizada por el sistema de compilación léxica es agregada a una tabla de simbolos o una tabla de errores, comprobando así la integridad de las instrucciónes y su inrepetibilidad de cada uno.\n" + "\n" + "3. Sistema de compilación semantica, este analiza y evalua los conjuntos de instrucciones para validad la sintaxis de las reglas definidas en el editor, permitiendo la asignación de datos inmediatos en la tabla de simbolos o la agregación de errores semanticos por errores de sintaxis.\n" + "\n" + "4. Sistema de generación de codigo intermedio, este analiza y evalua las operaciones aritmeticas, asignación, relacion y lógicas para la generación del codigo intermedio del las instrucciones del programa, permitiendo así un traducción casi inmediata a codigo Ensamblador.");                break;
            }
        }

        seccionFuncionamiento.setCaretPosition(0);
    }//GEN-LAST:event_seccionItemStateChanged

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> seccion;
    private javax.swing.JTextArea seccionFuncionamiento;
    // End of variables declaration//GEN-END:variables
}
