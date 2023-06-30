package sistemaLectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JClass_LecturaArchivoFuente 
{
    private JFrame framePrincipal;
    private ArrayList <String> contenidoArchivo;
    private File ubicacionArchivo;

    public JClass_LecturaArchivoFuente (JFrame framePrincipal) 
    {
        this.framePrincipal = framePrincipal;
        this.contenidoArchivo = new ArrayList <String>();
        this.ubicacionArchivo = null;
    }
    
    public boolean leerArchivoFuente ()
    {
        if (seleccionarArchivoFuente())
        {
            if (leerArchivo())
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean seleccionarArchivoFuente ()
    {
        JFileChooser interfazSeleccion = new JFileChooser();
        FileNameExtensionFilter filtroSeleccion = new FileNameExtensionFilter("Archivo fuente (.txt)", "txt");
        interfazSeleccion.setDialogTitle("Abrir archivo fuente:");
        interfazSeleccion.setDialogType(JFileChooser.OPEN_DIALOG);
        interfazSeleccion.setApproveButtonText("Seleccionar");
        interfazSeleccion.setApproveButtonToolTipText("Selecciona el archivo para ser leido");
        interfazSeleccion.setMultiSelectionEnabled(false);
        interfazSeleccion.setFileFilter(filtroSeleccion);
        interfazSeleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        boolean resolicitarLectura = false;
        
        do {
            
            resolicitarLectura = false;
            if (interfazSeleccion.showOpenDialog(framePrincipal) == JFileChooser.APPROVE_OPTION)
            {
                String archivo_Seleccionado = interfazSeleccion.getSelectedFile().getAbsolutePath();
                String extencion_Seleccionado = "";

                for (int i = (archivo_Seleccionado.length() - 4); i < archivo_Seleccionado.length(); i++) 
                {
                    extencion_Seleccionado += archivo_Seleccionado.charAt(i);
                }

                if (extencion_Seleccionado.compareToIgnoreCase(".txt") == 0)
                {
                    this.ubicacionArchivo = interfazSeleccion.getSelectedFile();
                    return true;
                }

                else
                {
                    JOptionPane.showMessageDialog(framePrincipal, "El archivo fuente seleccionado no es soportado.", "Archivo incompatible:", JOptionPane.ERROR_MESSAGE);                    
                    resolicitarLectura = true;
                }
            }

            else
            {
                if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(framePrincipal, "¿Desea cancelar la lectura del archivo?", "Lectura cancelada.", JOptionPane.YES_NO_OPTION))
                {
                    resolicitarLectura = true;
                }
            }
            
        } while (resolicitarLectura == true);
        
        this.ubicacionArchivo = null;
        return false;
    }
    
    private boolean leerArchivo ()
    {
        BufferedReader lecturaArchivo = null;
        this.contenidoArchivo.clear();
        
        try
        {   
            FileReader ubicacionLectura = new FileReader (ubicacionArchivo);
            lecturaArchivo = new BufferedReader(ubicacionLectura);
            String lineaLeida = null;    
            
            while ((lineaLeida = lecturaArchivo.readLine()) != null)
            {    
                this.contenidoArchivo.add(lineaLeida);
            }
            
            lecturaArchivo.close();
        }
        
        catch (IOException error)
        {
            JOptionPane.showMessageDialog(framePrincipal, "Se ha producido un error al leer el archivo: " + ubicacionArchivo.getName(), "Error de lectura:", JOptionPane.ERROR_MESSAGE);
            this.contenidoArchivo.clear();
        }
        
        if (this.contenidoArchivo.size()> 0)
        {
            return true;
        }
        
        else
        {           
            return false;
        }
    }
    
    public String recuperarContenidoFuente ()
    {
        String contenidoArchivoFuente = "";
        
        for (int i = 0; i < this.contenidoArchivo.size(); i++) 
        {
            if (i == 0)
            {
                contenidoArchivoFuente += this.contenidoArchivo.get(i);
            }
            
            else
            {
                contenidoArchivoFuente += "\n" + this.contenidoArchivo.get(i);
            }
        }
        
        return contenidoArchivoFuente;
    }
    
    public File recuperarUbicacionArchivo ()
    {
        return this.ubicacionArchivo;
    }   
}