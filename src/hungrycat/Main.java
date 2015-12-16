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
        
        System.out.println("Size: "+nivel.getN()+" x "+nivel.getM());
        System.out.println(nivel.toString());
        
        int i =0;
        while(nivel.getRestantes() != 0){
            ++i;
            //Aplicar las reglas
            nivel.printMatriz(i);//imprimir matriz
            try {
                System.in.read(); //esperar enter para siguiente paso
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
