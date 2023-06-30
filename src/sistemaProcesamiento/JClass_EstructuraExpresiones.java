package sistemaProcesamiento;

import java.awt.Color;
import java.util.ArrayList;

public class JClass_EstructuraExpresiones 
{
    private ArrayList <String> instruccionRegular = new ArrayList <String>();
    private ArrayList <String> expresionRegular = new ArrayList <String>();
    private ArrayList <String> prefijoRegular = new ArrayList <String>();
    private ArrayList <Integer> contadorRegular = new ArrayList <Integer>();
    private ArrayList <Color> colorRegular = new ArrayList <Color>();
    private int totalExpresiones = 10;

    public JClass_EstructuraExpresiones() 
    {
        this.instruccionRegular.add("Separador");
        this.instruccionRegular.add("Aritmetica");
        this.instruccionRegular.add("Relacional");
        this.instruccionRegular.add("Asignacion");
        this.instruccionRegular.add("Logico");
        this.instruccionRegular.add("Identificador");
        this.instruccionRegular.add("Enteros");
        this.instruccionRegular.add("Decimal");
        this.instruccionRegular.add("Tipo de dato");
        this.instruccionRegular.add("Ciclo");
        
        this.expresionRegular.add("(\\()|(\\))|(\\})|(\\{)|(,)|(;)");
        this.expresionRegular.add("(\\+)|(\\-)|(\\*)|(\\/)|(\\%)");
        this.expresionRegular.add("(<=)|(>=)|(==)|(!=)|(<)|(>)");
        this.expresionRegular.add("=");
        this.expresionRegular.add("(&&)|(\\|\\|)");
        this.expresionRegular.add("-[A-Za-z]+[0-9]*-");
        this.expresionRegular.add("(\\b(7)|(-7))[0-9]+");
        this.expresionRegular.add("((\\b7)|(-7))[0-9]*\\.[0]*[1-9]+");
        this.expresionRegular.add("\\b((numPoint|text|numCerrado|simple)V)\\b");
        this.expresionRegular.add("(while)");
        
        this.prefijoRegular.add("SEP");
        this.prefijoRegular.add("ARM");
        this.prefijoRegular.add("REL");
        this.prefijoRegular.add("ASG");
        this.prefijoRegular.add("LOG");
        this.prefijoRegular.add("IDE");
        this.prefijoRegular.add("ENT");
        this.prefijoRegular.add("DEC");
        this.prefijoRegular.add("TDS");
        this.prefijoRegular.add("CCS");
        
        for (int i = 0; i < 10; i++) 
        {
            this.contadorRegular.add(0);
        }

        this.colorRegular.add(new Color (0, 101, 179));
        this.colorRegular.add(new Color (148, 70, 15));
        this.colorRegular.add(new Color (59, 91, 37));
        this.colorRegular.add(new Color (194,0,0));
        this.colorRegular.add(new Color (225,39,185));
        this.colorRegular.add(new Color (11, 122, 39));
        this.colorRegular.add(new Color (128, 93, 0));
        this.colorRegular.add(new Color (48, 11, 244));
        this.colorRegular.add(new Color (101, 44, 145));
        this.colorRegular.add(new Color (122, 55, 11));
    }
    
    public void restablecerExpresiones ()
    {
        this.contadorRegular.clear();
        
        for (int i = 0; i < 10; i++) 
        {
            this.contadorRegular.add(0);
        }
    }
    
    public ArrayList <String> recuperarListaInstruccionRegular ()
    {
        return this.instruccionRegular;
    }
    
    public ArrayList <String> recuperarListaExpresionRegular ()
    {
        return this.expresionRegular;
    }
    
    public ArrayList <String> recuperarListaListaPrefijoRegular ()
    {
        return this.prefijoRegular;
    }
    
    public ArrayList <Integer> recuperarListaContadorRegular ()
    {
        return this.contadorRegular;
    }
    
    public ArrayList <Color> recuperarListaColorRegular ()
    {
        return this.colorRegular;
    }
    
    public String recuperarInstruccionRegular (int posicionRegular)
    {
        return this.instruccionRegular.get(posicionRegular);
    }
    
    public String recuperarExpresionRegular (int posicionRegular)
    {
        return this.expresionRegular.get(posicionRegular);
    }
    
    public String recuperarPrefijoRegular (int posicionRegular)
    {
        return this.prefijoRegular.get(posicionRegular);
    }
    
    public int recuperarContadorRegular (int posicionRegular)
    {
        return this.contadorRegular.get(posicionRegular);
    }
    
    public Color recuperarColorRegular (int posicionRegular)
    {
        return this.colorRegular.get(posicionRegular);
    }
    
    public void incrementarContadorRegular (int posicionRegular)
    {
        this.contadorRegular.set(posicionRegular, this.contadorRegular.get(posicionRegular) + 1);
    }
    
    public int recuperarTotalExpresiones ()
    {
        return this.totalExpresiones;
    }
}