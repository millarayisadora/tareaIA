package hungrycat;

import java.util.ArrayList;

public class Reglas {
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static void filaCompleta(Nivel nivel){
        ArrayList<Fila> filas = nivel.getFilas();
        //revisa para cada fila.
        for(int i = 0; i<filas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = filas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la fila
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getCantidad() == nivel.getM())
                {
                    //pinta la fila 'i'
                    for(int k = 0; k<nivel.getN(); k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    System.out.println("Se ha pintado la fila "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    filas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }    
}
