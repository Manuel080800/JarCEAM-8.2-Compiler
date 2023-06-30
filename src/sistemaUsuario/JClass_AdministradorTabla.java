package sistemaUsuario;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JClass_AdministradorTabla
{
    // Atributos:
    private int LIMITADOR_DE_DATOS = 0;
    private int ancho_Celda = 20;
    
    private ArrayList<Object> CONTENEDOR_DATOS_1;
    private ArrayList<Object> CONTENEDOR_DATOS_2;
    private ArrayList<Object> CONTENEDOR_DATOS_3;
    private ArrayList<Object> CONTENEDOR_DATOS_4;
    private ArrayList<Object> CONTENEDOR_DATOS_5;
    private ArrayList<Object> CONTENEDOR_DATOS_6;
    private ArrayList<Object> CONTENEDOR_DATOS_7;
    private ArrayList<Object> CONTENEDOR_DATOS_8;
    private ArrayList<Object> CONTENEDOR_DATOS_9;
    private ArrayList<Object> CONTENEDOR_DATOS_10;   
    
    // Constructores:
    public JClass_AdministradorTabla() 
    {
        
    }
    
    // Metodos:
    public void restablecer_ContenedorDatos ()
    {
        CONTENEDOR_DATOS_1 = null;
        CONTENEDOR_DATOS_2 = null;
        CONTENEDOR_DATOS_3 = null;
        CONTENEDOR_DATOS_4 = null;
        CONTENEDOR_DATOS_5 = null;
        CONTENEDOR_DATOS_6 = null;
        CONTENEDOR_DATOS_7 = null;
        CONTENEDOR_DATOS_8 = null;
        CONTENEDOR_DATOS_9 = null;
        CONTENEDOR_DATOS_10 = null;
    }
    
    public void actualizacion_TablaDatos_MANUAL (JTable tabla_Actualizacion, Object [] encabezados_Tabla, boolean  [] columnas_NoEditables)
    {
        
        Object contenedor_TablaDatos [][] = new Object [CONTENEDOR_DATOS_1.size()][LIMITADOR_DE_DATOS];
        incluir_ContenidosDatos(contenedor_TablaDatos);

        tabla_Actualizacion.setModel(new javax.swing.table.DefaultTableModel(contenedor_TablaDatos, encabezados_Tabla)
        {
            boolean[] canEdit = columnas_NoEditables;

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return canEdit [columnIndex];
            }
        });
        
        tabla_Actualizacion.setRowHeight(ancho_Celda);
        tabla_Actualizacion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        alineacion_Central_TablaDatos(tabla_Actualizacion);
    }
    
    private void alineacion_Central_TablaDatos (JTable actualizar_Tabla)
    {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < actualizar_Tabla.getColumnCount(); i ++)
        {
            actualizar_Tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);  
        }  
    }
    
    public String [] conversion_Object_a_String (Object [] contenedor_Datos)
    {
        String [] contenedor_String = new String [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_String [i] = contenedor_Datos [i].toString();
        }
        
        return contenedor_String;
    }
    
    public int [] conversion_Object_a_int (Object [] contenedor_Datos)
    {
        int [] contenedor_int = new int [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_int [i] = Integer.parseInt(contenedor_Datos [i].toString());
        }
        
        return contenedor_int;
    }
    
    public float [] conversion_Object_a_float (Object [] contenedor_Datos)
    {
        float [] contenedor_float = new float [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_float [i] = Float.parseFloat(contenedor_Datos [i].toString());
        }
        
        return contenedor_float;
    }
    
    public double [] conversion_Object_a_double (Object [] contenedor_Datos)
    {
        double [] contenedor_double = new double [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_double [i] = Double.parseDouble(contenedor_Datos [i].toString());
        }
        
        return contenedor_double;
    }
    
    public boolean [] conversion_Object_a_boolean (Object [] contenedor_Datos)
    {
        boolean [] contenedor_boolean = new boolean [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_boolean [i] = Boolean.parseBoolean(contenedor_Datos [i].toString());
        }
        
        return contenedor_boolean;
    }
    
    public Object [] conversion_String_a_Object (String [] contenedor_Datos)
    {
        Object [] contenedor_Object = new Object [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_Object [i] = contenedor_Datos [i];
        }
        
        return contenedor_Object;
    }
    
    public Object [] conversion_int_a_Object (int [] contenedor_Datos)
    {
        Object [] contenedor_Object = new Object [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_Object [i] = contenedor_Datos [i];
        }
        
        return contenedor_Object;
    }
    
    public Object [] conversion_float_a_Object (float [] contenedor_Datos)
    {
        Object [] contenedor_Object = new Object [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_Object [i] = contenedor_Datos [i];
        }
        
        return contenedor_Object;
    }
    
    public Object [] conversion_double_a_Object (double [] contenedor_Datos)
    {
        Object [] contenedor_Object = new Object [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_Object [i] = contenedor_Datos [i];
        }
        
        return contenedor_Object;
    }
    
    public Object [] conversion_boolean_a_Object (boolean [] contenedor_Datos)
    {
        Object [] contenedor_Object = new Object [contenedor_Datos.length];
        
        for (int i = 0; i < contenedor_Datos.length; i ++)
        {
            contenedor_Object [i] = contenedor_Datos [i];
        }
        
        return contenedor_Object;
    }
    
    private void incluir_ContenidosDatos (Object [][] contenedor_TablaDatos)
    {
        for (int i = 0; i < CONTENEDOR_DATOS_1.size(); i ++)
        {
            if (LIMITADOR_DE_DATOS > 0)
            {
                contenedor_TablaDatos [i][0] = CONTENEDOR_DATOS_1.get(i);
            }

            if (LIMITADOR_DE_DATOS > 1)
            {
                contenedor_TablaDatos [i][1] = CONTENEDOR_DATOS_2.get(i);
            }

            if (LIMITADOR_DE_DATOS > 2)
            {
                contenedor_TablaDatos [i][2] = CONTENEDOR_DATOS_3.get(i);
            }

            if (LIMITADOR_DE_DATOS > 3)
            {
                contenedor_TablaDatos [i][3] = CONTENEDOR_DATOS_4.get(i);
            }

            if (LIMITADOR_DE_DATOS > 4)
            {
                contenedor_TablaDatos [i][4] = CONTENEDOR_DATOS_5.get(i);
            }

            if (LIMITADOR_DE_DATOS > 5)
            {
                contenedor_TablaDatos [i][5] = CONTENEDOR_DATOS_6.get(i);
            }

            if (LIMITADOR_DE_DATOS > 6)
            {
                contenedor_TablaDatos [i][6] = CONTENEDOR_DATOS_7.get(i);
            }

            if (LIMITADOR_DE_DATOS > 7)
            {
                contenedor_TablaDatos [i][7] = CONTENEDOR_DATOS_8.get(i);
            }

            if (LIMITADOR_DE_DATOS > 8)
            {
                contenedor_TablaDatos [i][8] = CONTENEDOR_DATOS_9.get(i);
            }

            if (LIMITADOR_DE_DATOS > 9)
            {
                contenedor_TablaDatos [i][9] = CONTENEDOR_DATOS_10.get(i);
            }
        }   
    }
    
    // -------------------------- SET AND GET ------------------------------------
    public int recuperar_ANCHO_DE_CELDAS() 
    {
        return ancho_Celda;
    }

    public void establecer_ANCHO_DE_CELDAS(int ANCHO_DE_CELDAS) 
    {
        this.ancho_Celda = ANCHO_DE_CELDAS;
    }
    
    public int recuperar_LIMITADOR_DE_DATOS() 
    {
        return LIMITADOR_DE_DATOS;
    }

    public void establecer_LIMITADOR_DE_DATOS(int LIMITADOR_DE_DATOS) 
    {
        this.LIMITADOR_DE_DATOS = LIMITADOR_DE_DATOS;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_1() 
    {
        return CONTENEDOR_DATOS_1;
    }

    public void establecer_CONTENEDOR_DATOS_1(ArrayList<Object> CONTENEDOR_DATOS_1) 
    {
        this.CONTENEDOR_DATOS_1 = CONTENEDOR_DATOS_1;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_2() 
    {
        return CONTENEDOR_DATOS_2;
    }

    public void establecer_CONTENEDOR_DATOS_2(ArrayList<Object> CONTENEDOR_DATOS_2) 
    {
        this.CONTENEDOR_DATOS_2 = CONTENEDOR_DATOS_2;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_3() 
    {
        return CONTENEDOR_DATOS_3;
    }

    public void establecer_CONTENEDOR_DATOS_3(ArrayList<Object> CONTENEDOR_DATOS_3) 
    {
        this.CONTENEDOR_DATOS_3 = CONTENEDOR_DATOS_3;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_4() 
    {
        return CONTENEDOR_DATOS_4;
    }

    public void establecer_CONTENEDOR_DATOS_4(ArrayList<Object> CONTENEDOR_DATOS_4) 
    {
        this.CONTENEDOR_DATOS_4 = CONTENEDOR_DATOS_4;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_5() 
    {
        return CONTENEDOR_DATOS_5;
    }

    public void establecer_CONTENEDOR_DATOS_5(ArrayList<Object> CONTENEDOR_DATOS_5) 
    {
        this.CONTENEDOR_DATOS_5 = CONTENEDOR_DATOS_5;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_6() 
    {
        return CONTENEDOR_DATOS_6;
    }

    public void establecer_CONTENEDOR_DATOS_6(ArrayList<Object> CONTENEDOR_DATOS_6) 
    {
        this.CONTENEDOR_DATOS_6 = CONTENEDOR_DATOS_6;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_7() 
    {
        return CONTENEDOR_DATOS_7;
    }

    public void establecer_CONTENEDOR_DATOS_7(ArrayList<Object> CONTENEDOR_DATOS_7) 
    {
        this.CONTENEDOR_DATOS_7 = CONTENEDOR_DATOS_7;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_8() 
    {
        return CONTENEDOR_DATOS_8;
    }

    public void establecer_CONTENEDOR_DATOS_8(ArrayList<Object> CONTENEDOR_DATOS_8) 
    {
        this.CONTENEDOR_DATOS_8 = CONTENEDOR_DATOS_8;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_9() 
    {
        return CONTENEDOR_DATOS_9;
    }

    public void establecer_CONTENEDOR_DATOS_9(ArrayList<Object> CONTENEDOR_DATOS_9) 
    {
        this.CONTENEDOR_DATOS_9 = CONTENEDOR_DATOS_9;
    }

    public ArrayList<Object> recuperar_CONTENEDOR_DATOS_10() 
    {
        return CONTENEDOR_DATOS_10;
    }

    public void establecer_CONTENEDOR_DATOS_10(ArrayList<Object> CONTENEDOR_DATOS_10) 
    {
        this.CONTENEDOR_DATOS_10 = CONTENEDOR_DATOS_10;
    }
}
