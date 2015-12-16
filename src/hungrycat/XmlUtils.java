package hungrycat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XmlUtils {
    
    public static Nivel readNivel(){
        String path = "input.xml";
        int m=0;
        int n=0;
        int colores = 0;
        ArrayList<Fila> filas = new ArrayList<Fila>();
        ArrayList<Columna> columnas = new ArrayList<Columna>();
        
        Nivel nivel = new Nivel();
        
        SAXBuilder builder = new SAXBuilder();
	File xmlFile = new File(path);
        try{
            //Se crea el documento a partir del archivo
            Document document = (Document) builder.build( xmlFile );
            //Se obtiene la raiz 'nivel'
            Element xmlNivel = document.getRootElement();
            
            //Leemos el tamaño del nivel
            String mm = xmlNivel.getChildTextTrim("m");
            String nn = xmlNivel.getChildTextTrim("n");
            m = Integer.parseInt(mm);
            n = Integer.parseInt(nn);
            System.out.println("tamaño: "+m+"x"+n);
            
            //Leemos la cantidad de colores
            String colors = xmlNivel.getChildTextTrim("colores");
            colores  = Integer.parseInt(colors);
            System.out.println("colores: "+colores);
            
            //Se obtiene la lista de filas
            List xmlFilas = xmlNivel.getChildren("filas");
            Element xmlElementFilas = (Element)xmlFilas.get(0);
            xmlFilas = xmlElementFilas.getChildren();
            System.out.println("Filas: "+xmlFilas.size());
            System.out.print("Restricciones: ");
            for(int i =0;i<xmlFilas.size();i++){
                Element xmlFila = (Element)xmlFilas.get(i);
                Fila fila = new Fila();
                //Se obtiene la lista de restricciones por fila
                List xmlRestricciones = xmlFila.getChildren();
                for(int j=0;i<xmlRestricciones.size();i++){
                    Element xmlRestriccion = (Element)xmlRestricciones.get(j);
                    Restriccion restriccion = new Restriccion();
                    int color = Integer.parseInt(xmlRestriccion.getChildTextTrim("color"));
                    int cantidad = Integer.parseInt(xmlRestriccion.getChildTextTrim("cantidad"));
                    Boolean continuos = Boolean.parseBoolean(xmlRestriccion.getChildTextTrim("continuos"));
                    
                    restriccion.setColor(color);
                    restriccion.setCantidad(cantidad);
                    restriccion.setContinuos(continuos);
                    
                    fila.addRestriccion(restriccion);
                }
                System.out.print("F"+(i+1)+":"+xmlRestricciones.size()+" ");
                filas.add(fila);
            }
            System.out.println();
            
            
            nivel.setM(m);
            nivel.setN(n);
            nivel.setColores(colores);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j=0; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
            nivel.setMatriz(matrix);
            nivel.setRestantes(m*n);
            
        }catch(Exception e){
            System.out.println( e.getMessage() );
        }finally{
            
        }
        
        
        
        return nivel;
    }
    
    public static Nivel loadNivel(){
        Nivel nivel = new Nivel();
        int m = 5;
        int n = 5;
        nivel.setM(m);
        nivel.setN(n);
        nivel.setColores(3);
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = 0;
            }
        }
        nivel.setMatriz(matrix);
        nivel.setRestantes(m*n);
        ArrayList<Fila> filas = new ArrayList<Fila>();
        Fila f = new Fila();
        f.addRestriccion(new Restriccion(3,5,true));
        filas.add(f);
        
        nivel.setFilas(filas);
        
        return nivel;
    }
}
