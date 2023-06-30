package sistemaEdicion;

import java.util.ArrayList;

public class JClass_AnalizadorEdicionCodigo 
{
    private String contenidoEdicionCodigo = null;
    private ArrayList <JClass_EstructuraEdicionCodigo> estructuraEdicionCodigo = new ArrayList <JClass_EstructuraEdicionCodigo> ();
    private ArrayList <Integer> longitudLineaCodigo = new ArrayList <Integer> ();
    private int totalLineaCodigo = 0;
    private boolean inicioAnalisis = false;

    public JClass_AnalizadorEdicionCodigo(String contenidoEdicionCodigo) 
    {
        this.contenidoEdicionCodigo = contenidoEdicionCodigo;
    }
    
    public void analizarEdicionCodigo (ArrayList <String> registroProcesos)
    {
        if (this.inicioAnalisis == false)
        {
            ArrayList <String> contenidoEdicionCodigo = analizarContenidoEdicionCodigo(registroProcesos);
            int longitudAlmacenada = 0;

            registroProcesos.add("Inicio de division de contenido por palabra: \n\n");
            
            if (contenidoEdicionCodigo.size() == 0)
            {
                registroProcesos.add("      No existe lineas de contenido.\n\n");
            }
            
            for (int i = 0; i < contenidoEdicionCodigo.size(); i++)
            {
                registroProcesos.add("      Inicio de division de contenido por palabras de linea " + (i + 1) +": \n\n");
                
                JClass_EstructuraEdicionCodigo analizarEstructuraEdicion = new JClass_EstructuraEdicionCodigo (contenidoEdicionCodigo.get(i));
                analizarEstructuraEdicion.analizarEstructuraEdicionCodigo(registroProcesos, i);

                longitudAlmacenada += (1 + analizarEstructuraEdicion.recuperarLongitudContenidoEdicion());
                
                this.estructuraEdicionCodigo.add(analizarEstructuraEdicion);
                this.longitudLineaCodigo.add(longitudAlmacenada);
                
                registroProcesos.add("      Final de division de contenido por palabras de linea " + (i + 1) +". \n\n");
            }
            
            this.inicioAnalisis = true;
        }
        
        registroProcesos.add("Final de division de contenido por palabra. \n\n");
        registroProcesos.add("FINAL DE ANALISIS CONTENIDO EDICION (ETAPA 1/3). \n\n");
    }
    
    private ArrayList <String> analizarContenidoEdicionCodigo (ArrayList <String> registroProcesos)
    {
        String lineaCodigo = "";
        ArrayList <String> lineaEdicionCodigo = new ArrayList <String>();
        registroProcesos.add("INICIO DE ANALISIS CONTENIDO EDICION (ETAPA 0/3): \n\n");
        registroProcesos.add("Inicio de division de contenido por linea: \n\n");
        
        if ((this.contenidoEdicionCodigo.compareTo("") == 0) || (this.contenidoEdicionCodigo == null))
        {
            registroProcesos.add("      No existe contenido de codigo fuente.");
        }
        
        for (int i = 0; i < this.contenidoEdicionCodigo.length(); i++)
        {
            if (this.contenidoEdicionCodigo.charAt(i) == '\n')
            {
                lineaEdicionCodigo.add(lineaCodigo);
                this.totalLineaCodigo ++;
                registroProcesos.add("      Linea: " + this.totalLineaCodigo + " --> [ " + lineaCodigo + " ]\n");
                lineaCodigo = "";
            }
            
            else
            {
                lineaCodigo += this.contenidoEdicionCodigo.charAt(i);
                
                if (i == (this.contenidoEdicionCodigo.length() - 1))
                {
                    lineaEdicionCodigo.add(lineaCodigo);
                    this.totalLineaCodigo ++;
                    registroProcesos.add("      Linea: " + this.totalLineaCodigo + " --> [ " + lineaCodigo + " ]\n\n");
                    lineaCodigo = "";
                }
            }
        }
        
        registroProcesos.add("Fin de division de contenido por linea.\n\n");
        
        return lineaEdicionCodigo;
    }
    
    public void restablecerEdicionCodigo ()
    {
        this.contenidoEdicionCodigo = null;
        this.estructuraEdicionCodigo.clear();
        this.longitudLineaCodigo.clear();
        this.totalLineaCodigo = 0;
        this.inicioAnalisis = false;
    }
    
    public ArrayList <JClass_EstructuraEdicionCodigo> recuperarListaEstructuraEdicionCodigo ()
    {
        return this.estructuraEdicionCodigo;
    }
    
    public ArrayList <Integer> recuperarListaLongitudLineaCodigo ()
    {
        return this.longitudLineaCodigo;
    }
    
    public JClass_EstructuraEdicionCodigo recuperarEstructuraEdicionCodigo (int posicionLineaEdicion)
    {
        return this.estructuraEdicionCodigo.get(posicionLineaEdicion);
    }
    
    public int recuperarLongitudLineaCodigo (int posicionLineaEdicion)
    {
        return this.longitudLineaCodigo.get(posicionLineaEdicion);
    } 
    
    public int recuperarTotalLineaCodigo ()
    {
        return this.totalLineaCodigo;
    }
}