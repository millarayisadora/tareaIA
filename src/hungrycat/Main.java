package hungrycat;

import java.io.IOException;
import java.util.ArrayList;
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
            ++i;
            //Aplicar las reglas
            
            Reglas.filaCompleta(nivel);
            Reglas.columnaCompleta(nivel);
            Reglas.filaInter(nivel);
            Reglas.columnaInter(nivel);
            Reglas.filaDosRestric(nivel);
            Reglas.columnaDosRestric(nivel);
            
            nivel.printMatriz(i); //imprimir matriz
            try {
                System.in.read(); //esperar enter para siguiente paso
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
