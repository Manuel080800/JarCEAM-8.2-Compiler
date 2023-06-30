package sistemaEdicion;

import java.util.ArrayList;

public class JClass_EstructuraEdicionCodigo 
{
    private String contenidoEdicionCodigo = "";
    private int longitudContenidoEdicionCodigo = 0;
    private ArrayList <String> estructuraContenidoEdicionCodigo = new ArrayList <String> ();
    private ArrayList <Integer> inicioEstructuraEdicionCodigo = new ArrayList <Integer> ();
    private ArrayList <Integer> finalEstructuraEdicionCodigo = new ArrayList <Integer> ();
    private int totalEstructuraEdicionCodigo = 0;
    private boolean analisisEstructura = false;
    
    public JClass_EstructuraEdicionCodigo(String contenidoEdicionCodigo) 
    {
        this.contenidoEdicionCodigo = contenidoEdicionCodigo;
        this.longitudContenidoEdicionCodigo = contenidoEdicionCodigo.length();
    }
    
    public void analizarEstructuraEdicionCodigo (ArrayList <String> registroProcesos, int lineaConteo)
    {
        if (this.analisisEstructura == false)
        {
            String estructuraCodigo = "";
            Boolean inicioEstructura = false;

            for (int i = 0; i < this.contenidoEdicionCodigo.length(); i++) 
            {
                if (((i == 0) && (this.contenidoEdicionCodigo.charAt(i) == '"')) || (((i > 0)) && (this.contenidoEdicionCodigo.charAt(i - 1) == ' ') && (this.contenidoEdicionCodigo.charAt(i) == '"')))
                {
                    inicioEstructura = true;

                    for (int j = i; j < this.contenidoEdicionCodigo.length(); j++) 
                    {   
                        if ((this.contenidoEdicionCodigo.charAt(j) == '"' && i != j) || (j == (this.contenidoEdicionCodigo.length() - 1)))
                        {
                            if ((j + 1) < this.contenidoEdicionCodigo.length())
                            {
                                if ((((this.contenidoEdicionCodigo.charAt(j) == '"' && i != j)) && (this.contenidoEdicionCodigo.charAt(j + 1) == ' ')))
                                {
                                    estructuraCodigo += this.contenidoEdicionCodigo.charAt(j);

                                    this.estructuraContenidoEdicionCodigo.add(estructuraCodigo);
                                    finalEstructuraEdicionCodigo.add(j + 1);
                                    estructuraCodigo = "";
                                    this.totalEstructuraEdicionCodigo ++;
                                    i = (j + 1);
                                    break;
                                }
                            }
                            
                            if (j == (this.contenidoEdicionCodigo.length() - 1))
                            {
                                if (this.inicioEstructuraEdicionCodigo.size() == this.finalEstructuraEdicionCodigo.size())
                                {
                                    inicioEstructuraEdicionCodigo.add(j);
                                }
                                
                                estructuraCodigo += this.contenidoEdicionCodigo.charAt(j);

                                this.estructuraContenidoEdicionCodigo.add(estructuraCodigo);
                                finalEstructuraEdicionCodigo.add(j + 1);
                                estructuraCodigo = "";
                                this.totalEstructuraEdicionCodigo ++;
                                i = (j + 1);
                                break;
                            }
                            
                            estructuraCodigo += this.contenidoEdicionCodigo.charAt(j);
                        }

                        else
                        {
                            estructuraCodigo += this.contenidoEdicionCodigo.charAt(j);

                            if (inicioEstructura == true)
                            {
                                inicioEstructuraEdicionCodigo.add(j);
                                inicioEstructura = false;
                            }
                        }
                    }
                }

                else
                {   
                    if (this.contenidoEdicionCodigo.charAt(i) != ' ' && this.contenidoEdicionCodigo.charAt(i) != '\t')
                    {
                        if (inicioEstructura == false)
                        {
                            inicioEstructuraEdicionCodigo.add(i);
                            inicioEstructura = true;
                        }

                        estructuraCodigo += this.contenidoEdicionCodigo.charAt(i);

                        if (i == (this.contenidoEdicionCodigo.length() - 1))
                        {
                            this.estructuraContenidoEdicionCodigo.add(estructuraCodigo);
                            finalEstructuraEdicionCodigo.add(i + 1);
                            estructuraCodigo = "";
                            this.totalEstructuraEdicionCodigo ++;
                            inicioEstructura = false;
                        }
                    }

                    else
                    {
                        if (inicioEstructura == true)
                        {
                            this.estructuraContenidoEdicionCodigo.add(estructuraCodigo);
                            finalEstructuraEdicionCodigo.add(i);
                            estructuraCodigo = "";
                            this.totalEstructuraEdicionCodigo ++;
                            inicioEstructura = false;
                        }

                        for (int j = i; j < this.contenidoEdicionCodigo.length(); j++) 
                        {
                            if (this.contenidoEdicionCodigo.charAt(j) != ' ' || this.contenidoEdicionCodigo.charAt(j) != '\t')
                            {
                                i = j;
                                break;
                            }
                        }
                    }
                }
            }
            
            this.analisisEstructura = true;
            
            registroProcesos.add("            Linea: " + (lineaConteo + 1) + " --> [ " + contenidoEdicionCodigo + " ]\n");
            registroProcesos.add("            Longitud de contenido: " + longitudContenidoEdicionCodigo + "\n");
            registroProcesos.add("            Total de palabras encontradas: " + totalEstructuraEdicionCodigo + "\n\n");
            registroProcesos.add("            Tamaño de almacenamiento de palabras: " + estructuraContenidoEdicionCodigo.size() + "\n");
            registroProcesos.add("            Tamaño de almacenamiento de inicio: " + inicioEstructuraEdicionCodigo.size() + "\n");
            registroProcesos.add("            Tamaño de almacenamiento de final: " + finalEstructuraEdicionCodigo.size() + "\n\n");
            
            registroProcesos.add("            Inicio de analisis de palabras encontradas:" + "\n\n");

            for (int i = 0; i < totalEstructuraEdicionCodigo; i++)
            {
                if (i == (totalEstructuraEdicionCodigo - 1))
                {
                    registroProcesos.add("                  Palabra: " + (i + 1) + " --> [ " + estructuraContenidoEdicionCodigo.get(i) + " ]    -    Posicion inicial: " + inicioEstructuraEdicionCodigo.get(i) + "    -    Posicion final: " + finalEstructuraEdicionCodigo.get(i) + "\n\n");
                }
                
                else
                {
                    registroProcesos.add("                  Palabra: " + (i + 1) + " --> [ " + estructuraContenidoEdicionCodigo.get(i) + " ]    -    Posicion inicial: " + inicioEstructuraEdicionCodigo.get(i) + "    -    Posicion final: " + finalEstructuraEdicionCodigo.get(i) + "\n");
                }
            }
            
            registroProcesos.add("            Final de analisis de palabras encontradas." + "\n\n");
        }
    }
    
    public void restablecerEstructurasContenidoEdicionCodigo ()
    {
        this.estructuraContenidoEdicionCodigo.clear();
        this.finalEstructuraEdicionCodigo.clear();
        this.inicioEstructuraEdicionCodigo.clear();
        this.totalEstructuraEdicionCodigo = 0;
        this.analisisEstructura = false;
    }
    
    public ArrayList <String> recuperarListaEstructuraContenidoEdicion ()
    {
        return this.estructuraContenidoEdicionCodigo;
    }
    
    public ArrayList <Integer> recuperarListaInicioEstructuraContenidoEdicion ()
    {
        return this.inicioEstructuraEdicionCodigo;
    }
    
    public ArrayList <Integer> recuperarListaFinalEstructuraContenidoEdicion ()
    {
        return this.finalEstructuraEdicionCodigo;
    }
    
    public String recuperarEstructuraContenidoEdicion (int posicionEstructura)
    {
        return this.estructuraContenidoEdicionCodigo.get(posicionEstructura);
    }
    
    public int recuperarInicioEstructuraContenidoEdicion (int posicionEstructura)
    {
        return this.inicioEstructuraEdicionCodigo.get(posicionEstructura);
    }
    
    public int recuperarFinalEstructuraContenidoEdicion (int posicionEstructura)
    {
        return this.finalEstructuraEdicionCodigo.get(posicionEstructura);
    }
    
    public int recuperarLongitudContenidoEdicion ()
    {
        return this.longitudContenidoEdicionCodigo;
    }
    
    public int recuperarTotalEstructuraContenidoEdicion ()
    {
        return this.totalEstructuraEdicionCodigo;
    }
}