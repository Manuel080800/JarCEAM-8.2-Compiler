package sistemaEscritura;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JClass_EscrituraArchivoFuente
{
    private JFrame framePrincipal;
    private File ubicacionArchivo = null;

    public JClass_EscrituraArchivoFuente(JFrame framePrincipal) 
    {
        this.framePrincipal = framePrincipal;
    }
    
    public boolean escribirArchivoFuente (File ubicacionArchivo, String contenidoArchivo)
    {
        if (ubicacionArchivo == null)
        {
            File archivoUbicacion = seleccionarUbicacionDestino(true);
            
            if (archivoUbicacion == null)
            {
                return false;
            }
            
            else
            {
                escribirArchivo(archivoUbicacion, contenidoArchivo, false, 0, 0);
                this.ubicacionArchivo = archivoUbicacion;
                return true;
            }
        }
        
        else
        {
            escribirArchivo(ubicacionArchivo, contenidoArchivo, false, 0, 0);
            this.ubicacionArchivo = ubicacionArchivo;
            return true;
        }
    }
    
    public boolean escribirArchivoTokens (File ubicacionArchivo, String contenidoArchivo)
    {
        if (ubicacionArchivo == null)
        {
            File archivoUbicacion = seleccionarUbicacionDestino(false);
            
            if (archivoUbicacion == null)
            {
                return false;
            }
            
            else
            {
                escribirArchivo(archivoUbicacion, contenidoArchivo, true, 1, 0);
                this.ubicacionArchivo = archivoUbicacion;
                return true;
            }
        }
        
        else
        {
            escribirArchivo(ubicacionArchivo, contenidoArchivo, true, 1, 0);
            this.ubicacionArchivo = ubicacionArchivo;
            return true;
        }
    }
    
    public boolean escribirArchivoTiplo (File ubicacionArchivo, String contenidoArchivo)
    {
        if (ubicacionArchivo == null)
        {
            File archivoUbicacion = seleccionarUbicacionDestino(false);
            
            if (archivoUbicacion == null)
            {
                return false;
            }
            
            else
            {
                escribirArchivo(archivoUbicacion, contenidoArchivo, true, 2, 0);
                this.ubicacionArchivo = archivoUbicacion;
                return true;
            }
        }
        
        else
        {
            escribirArchivo(ubicacionArchivo, contenidoArchivo, true, 2, 0);
            this.ubicacionArchivo = ubicacionArchivo;
            return true;
        }
    }
    
    public boolean escribirArchivoOptimizado (File ubicacionArchivo, String contenidoArchivo)
    {
        if (ubicacionArchivo == null)
        {
            File archivoUbicacion = seleccionarUbicacionDestino(false);
            
            if (archivoUbicacion == null)
            {
                return false;
            }
            
            else
            {
                escribirArchivo(archivoUbicacion, contenidoArchivo, true, 0, 1);
                this.ubicacionArchivo = archivoUbicacion;
                return true;
            }
        }
        
        else
        {
            escribirArchivo(ubicacionArchivo, contenidoArchivo, true, 0, 1);
            this.ubicacionArchivo = ubicacionArchivo;
            return true;
        }
    }
    
    public boolean escribirArchivoEnsamblador (File ubicacionArchivo, String contenidoArchivo)
    {
        if (ubicacionArchivo == null)
        {
            File archivoUbicacion = seleccionarUbicacionDestino(false);
            
            if (archivoUbicacion == null)
            {
                return false;
            }
            
            else
            {
                escribirArchivo(archivoUbicacion, contenidoArchivo, true, 0, 2);
                this.ubicacionArchivo = archivoUbicacion;
                return true;
            }
        }
        
        else
        {
            escribirArchivo(ubicacionArchivo, contenidoArchivo, true, 0, 2);
            this.ubicacionArchivo = ubicacionArchivo;
            return true;
        }
    }
    
    private File seleccionarUbicacionDestino (boolean modalidad)
    {
        JFileChooser interfazSeleccion = new JFileChooser();
        boolean resolicitarGuardado = false;
        
        if (modalidad)
        {
            interfazSeleccion.setDialogTitle("Guardar archivo fuente:");
            interfazSeleccion.setApproveButtonText("Guardar");
            interfazSeleccion.setApproveButtonToolTipText("Guarda el archivo fuente en la ubicación seleccionada");
        }
        
        else
        {
            interfazSeleccion.setDialogTitle("Guardar archivo de compilacion:");
            interfazSeleccion.setApproveButtonText("Guardar");
            interfazSeleccion.setApproveButtonToolTipText("Guarda el archivo de compilacion en la ubicación seleccionada");
        }
        
        interfazSeleccion.setMultiSelectionEnabled(false);
        interfazSeleccion.setDialogType(JFileChooser.SAVE_DIALOG);
        
        interfazSeleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        do {
            resolicitarGuardado = false;
            int opcion = interfazSeleccion.showSaveDialog(framePrincipal);

            if (opcion == JFileChooser.APPROVE_OPTION)
            {
                File ubicacionArchivo = new File (interfazSeleccion.getSelectedFile().toString() + ".txt");
                return ubicacionArchivo;
            }

            else
            {
                if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(framePrincipal, "¿Desea cancelar el guardadado del archivo?", "Guardado cancelado.", JOptionPane.YES_NO_OPTION))
                {
                    resolicitarGuardado = true;
                }
            }
        } while (resolicitarGuardado);
        
        return null;
    }
    
    private boolean escribirArchivo (File ubicacionArchivo, String contenidoArchivo, boolean modalidad, int procesado, int finalizacion)
    {
        PrintWriter escribirArchivo = null;
        
        if (modalidad == true)
        {
            String ubicacionTemporal = "";
            
            for (int i = 0; i < (ubicacionArchivo.getAbsolutePath().length() - 4); i++) 
            {
                ubicacionTemporal += ubicacionArchivo.getAbsolutePath().charAt(i);
            }
            
            if (procesado == 1 && finalizacion == 0)
            {
                ubicacionTemporal += "-compilacion.txt";
            }
            
            if (procesado == 2 && finalizacion == 0)
            {
                ubicacionTemporal += "-tiplo.txt";
            }
            
            if (procesado == 0 && finalizacion == 1)
            {
                ubicacionTemporal += "-optimizacion.txt";
            }
            
            if (procesado == 0 && finalizacion == 2)
            {
                ubicacionTemporal += "-ensamblador.txt";
            }
            
            ubicacionArchivo = new File (ubicacionTemporal);
        }
        
        try
        {
            FileWriter ubicacion_Escritura = new FileWriter(ubicacionArchivo);
            escribirArchivo = new PrintWriter(ubicacionArchivo);
            escribirArchivo.print(contenidoArchivo);            
            escribirArchivo.close();
            return true;
        } 
        
        catch (IOException error) 
        {
            JOptionPane.showMessageDialog(framePrincipal, "Se ha producido un error al escribir el archivo: " + ubicacionArchivo.getName(), "Error de escritura:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public File recuperarUbicacionArchivo ()
    {
        return this.ubicacionArchivo;
    }
}
