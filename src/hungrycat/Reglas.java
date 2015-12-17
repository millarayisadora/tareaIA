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
                if(r.getCantidad() == nivel.getN() && r.getContinuos())
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
    
    
    /**
     * Busca columnas completas de un color.<p>
     * Si una columa completa es de un color la pinta.
     * @param nivel 
     */
    public static void columnaCompleta(Nivel nivel){
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa para cada columna.
        for(int i = 0; i<columnas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la columna
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getCantidad() == nivel.getM() && r.getContinuos())
                {
                    //pinta la columna 'i'
                    for(int k = 0; k<nivel.getM(); k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    System.out.println("Se ha pintado la columna "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    columnas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    /**
     * Busca filas interseccion.<p>
     * Si una fila tiene restriccion contiuua y de cantidad Columna-1,
     * se pinta la intersección.
     * @param nivel 
     */
    public static void filaInter(Nivel nivel){
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
                if(r.getContinuos() && r.getCantidad() == (nivel.getN()-1) )
                {
                    //pinta la fila 'i'
                    for(int k = 1; k< (nivel.getN()-1); k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    System.out.println("Se ha pintado la fila "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    //rest.remove(j);
                    //filas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    /**
     * Busca columnas interseccion.<p>
     * Si una columna tiene restriccion contigua y de cantidad Filas-1,
     * se pinta la intersección.
     * @param nivel 
     */
    public static void columnaInter(Nivel nivel){
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa para cada columna.
        for(int i = 0; i<columnas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la columna
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getContinuos() && r.getCantidad() == (nivel.getM()-1) )
                {
                    //pinta la columna 'i'
                    for(int k = 1; k<nivel.getM()-1; k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    System.out.println("columnaInter Se ha pintado la columna "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    //rest.remove(j);
                    //columnas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    
    /**
     * Busca filas con 1 continuo y 1 no continuo .<p>
     * Si una fila tiene 2 restricciones, una de ellas es Cantidad 2 Continua,
     * se pinta esa cantidad (2) a los extremos. El otro color se pinta al medio.
     * @param nivel 
     */
    public static void filaDosRestric(Nivel nivel){
        ArrayList<Fila> filas = nivel.getFilas();
        //revisa para cada fila.
        for(int i = 0; i< filas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = filas.get(i).getRestricciones();
            for(int j =0; j< rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la fila
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getContinuos() && r.getCantidad() == (nivel.getN()-2) )
                {
                    //pinta la fila 'i'
                    for(int k = 1; k <(nivel.getN()-1); k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    if (r.getCantidad()==2 && !r.getContinuos()){
                        nivel.getMatriz()[i][0] = r.getColor();
                        nivel.getMatriz()[i][nivel.getN()] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-2); //uno menos a los restantes
                    }
                    //Aquí pintar el otro color no continuo(2) ????
                    System.out.println("filaDosRestric Se ha pintado la fila "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    filas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    
    /**
     * Busca filas con 1 continuo y 1 no continuo .<p>
     * Si una fila tiene 2 restricciones, una de ellas es Cantidad 2 Continua,
     * se pinta esa cantidad (2) a los extremos. El otro color se pinta al medio.
     * @param nivel 
     */
    public static void columnaDosRestric(Nivel nivel){
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa para cada columna.
        for(int i = 0; i<columnas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la columna
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getContinuos() && r.getCantidad() == (nivel.getM()-2) )
                {
                    //pinta la columna 'i'
                    for(int k = 1; k<nivel.getM()-1; k++){
                        nivel.getMatriz()[i][k] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    System.out.println("columnaDosRestric Se ha pintado la columna "+(i+1)+" de color "+r.getColor());
                    
                    if(!r.getContinuos() && r.getCantidad()==2 )
                    {
                        nivel.getMatriz()[i][0] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                        nivel.getMatriz()[i][nivel.getM()] = r.getColor();
                        nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                    }
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    columnas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    
    
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static void filaSola(Nivel nivel){
        int cont=0;
        ArrayList<Fila> filas = nivel.getFilas();
      
        //revisa para cada fila.
        for(int i = 0; i<filas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = filas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la fila
                Restriccion r = rest.get(j);
                //Si el color es el mismo 
                if (r.getCantidad() != 0) cont++;
            }
        }
        if (cont==1){
        
            for(int i = 0; i<filas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = filas.get(i).getRestricciones();
                for(int j =0; j<rest.size(); j++){
                    //System.out.println("entra al segundo loop, para cada restriccion");
                    //Para cada restricción de la fila
                    Restriccion r = rest.get(j);
                    //Si el color es el mismo 

                    for(int k = 0; k<nivel.getN(); k++){
                        if (nivel.getMatriz()[i][k] == 0){
                            nivel.getMatriz()[i][k] = r.getColor();
                            nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                        }
                    }
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    filas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }
    
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static void columnaSola(Nivel nivel){
        int cont=0;
        ArrayList<Fila> columnas = nivel.getFilas();
      
        //revisa para cada fila.
        for(int i = 0; i<columnas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(i).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //System.out.println("entra al segundo loop, para cada restriccion");
                //Para cada restricción de la fila
                Restriccion r = rest.get(j);
                //Si el color es el mismo 
                if (r.getCantidad() != 0) cont++;
            }
        }
        if (cont==1){
        
            for(int i = 0; i<columnas.size(); i++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(i).getRestricciones();
                for(int j =0; j<rest.size(); j++){
                    //System.out.println("entra al segundo loop, para cada restriccion");
                    //Para cada restricción de la fila
                    Restriccion r = rest.get(j);
                    //Si el color es el mismo 

                    for(int k = 0; k<nivel.getM(); k++){
                        if (nivel.getMatriz()[i][k] == 0){
                            nivel.getMatriz()[i][k] = r.getColor();
                            nivel.setRestantes(nivel.getRestantes()-1); //uno menos a los restantes
                        }
                    }
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    columnas.get(i).setRestricciones(rest);
                    
                    return;
                }
            }
        }
    }

}
