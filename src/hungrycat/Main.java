package hungrycat;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Zamora Soto
 * @author Millaray Tobar Martinez
 */
public class Main {
    public static void main(String[] args) {
        Nivel nivel;
        //nivel = XmlUtils.loadNivel();
        nivel = XmlUtils.readNivel();
        
        
        int i =0;
        nivel.printMatriz(i); //imprimir matriz inicial
        while(nivel.getRestantes() != 0){
            //Aplicar las reglas
            
            if(Reglas.columnaCompleta(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.filaCompleta(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.filaSola(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.columnaSola(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.filaDosRestric(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            if(Reglas.columnaDosRestric(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.filaInter(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            if(Reglas.columnaInter(nivel)){
                nivel.printMatriz(++i); //imprimir matriz
                nivel.revisarRestricciones();
            }
            
            try {
                System.in.read(); //esperar enter para siguiente paso
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Nivel resuelto :) ");
    }
}
