package hungrycat;

import java.util.ArrayList;

public class Reglas {
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static Boolean filaCompleta(Nivel nivel){
        Boolean salida = false;
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
                    //System.out.println("Se pinta la fila "+(i+1)+" de color "+r.getColor());
                    //pinta la fila 'i'
                    for(int k = 0; k<nivel.getN(); k++){
                        nivel.pintarCuadro(i, k, r.getColor());
                    }
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    System.out.println("Elimina restricción en fila "+(i+1)+" - "+r.toString());
                    filas.get(i).setRestricciones(rest);
                    
                    return true;
                }
            }
        }
        return salida;
    }
    
    /**
     * Busca columnas completas de un color.<p>
     * Si una columa completa es de un color la pinta.
     * @param nivel 
     */
    public static Boolean columnaCompleta(Nivel nivel){
        Boolean salida = false;
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa para cada columna.
        for(int col = 0; col<columnas.size(); col++){
            //System.out.println("entra al primer loop (para cada fila)");
            ArrayList<Restriccion> rest = columnas.get(col).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                //Para cada restricción de la columna
                Restriccion r = rest.get(j);
                //Si la restriccion es del mismo numero de cuadros que la cantidad total de filas, la pinta.
                //System.out.println(r.getCantidad()+" - "+nivel.getM());
                if(r.getCantidad() == nivel.getM() && r.getContinuos())
                {
                    System.out.println("Se pinta la columna "+(col+1)+" de color "+r.getColor());
                    //pinta la columna 'i'
                    for(int k = 0; k<nivel.getM(); k++){
                        nivel.pintarCuadro(k, col, r.getColor());
                    }
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    System.out.println("Elimina restricción en columna "+(col+1)+" - "+r.toString());
                    columnas.get(col).setRestricciones(rest);
                    
                    return true;
                }
            }
        }
        return salida;
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
    public static Boolean filaDosRestric(Nivel nivel){
        Boolean salida = false;
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
                        nivel.pintarCuadro(i, k, r.getColor());
                    }
                    System.out.println("filaDosRestric Se ha pintado la fila "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    filas.get(i).setRestricciones(rest);
                    
                    return true;
                }
            }
        }
        return salida;
    }
    
    /**
     * Busca filas con 1 continuo y 1 no continuo .<p>
     * Si una fila tiene 2 restricciones, una de ellas es Cantidad 2 Continua,
     * se pinta esa cantidad (2) a los extremos. El otro color se pinta al medio.
     * @param nivel 
     */
    public static Boolean columnaDosRestric(Nivel nivel){
        Boolean salida = false;
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
                        nivel.pintarCuadro(k, i, r.getColor());
                    }
                    System.out.println("columnaDosRestric Se ha pintado la columna "+(i+1)+" de color "+r.getColor());
                    
                    //borrar regla para que no entre de nuevo a esta
                    rest.remove(j);
                    columnas.get(i).setRestricciones(rest);
                    
                    return true;
                }
            }
        }
        return salida;
    }
    
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static Boolean filaSola(Nivel nivel){
        //para cada fila
        Boolean salida = false;
        ArrayList<Fila> filas = nivel.getFilas();
        //revisa para cada fila.
        for(int f = 0; f<filas.size(); f++){
            ArrayList<Restriccion> rest = filas.get(f).getRestricciones();
            if(rest.size()==1){
                Restriccion r = rest.get(0);
                //pinta toda la fila
                for(int k = 0; k<nivel.getN(); k++){
                    if(nivel.getMatriz()[f][k] == 0){
                        nivel.pintarCuadro(f, k, r.getColor());
                    }
                }
                rest.remove(0);
                System.out.println("Elimina restricción en fila "+(f+1)+" - "+r.toString());
                filas.get(f).setRestricciones(rest);
                System.out.println("Solo una restricción en la fila "+(f+1));
                return true;
            }
        }
        return salida;
    }
    
    /**
     * Busca filas completas de un color.<p>
     * Si una fila completa es de un color la pinta.
     * @param nivel 
     */
    public static Boolean columnaSola(Nivel nivel){
        //para cada columna
        Boolean salida = false;
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa para cada columna.
        for(int c = 0; c<columnas.size(); c++){
            ArrayList<Restriccion> rest = columnas.get(c).getRestricciones();
            if(rest.size()==1){
                Restriccion r = rest.get(0);
                //pinta toda la columna
                for(int k = 0; k<nivel.getM(); k++){
                    if(nivel.getMatriz()[k][c] == 0){
                        nivel.pintarCuadro(k, c, r.getColor());
                    }
                }
                rest.remove(0);
                System.out.println("Elimina restricción en columna "+(c+1)+" - "+r.toString());
                columnas.get(c).setRestricciones(rest);
                System.out.println("Solo una restricción en la columna "+(c+1));
                return true;
            }
        }
        return salida;
    }
    
    
    public static void verificarColoresPorFila(Nivel nivel, int f, int color){
        int cant = nivel.cuentaColorFila(f, color);
        ArrayList<Fila> filas = nivel.getFilas();
        //revisa fila f.
        ArrayList<Restriccion> rest = filas.get(f).getRestricciones();
        for(int j =0; j<rest.size(); j++){
            Restriccion r = rest.get(j);
            // igual cantidad y color
            if(r.getCantidad() == cant && r.getColor() ==color){
                System.out.println("verificó fila ("+(f+1)+")  al pintar - "+r.toString());
                rest.remove(j);
                filas.get(f).setRestricciones(rest);
                return;
            }
        }
    }
    
    public static void verificarColoresPorColumna(Nivel nivel, int c, int color){
        int cant = nivel.cuentaColorColumna(c, color);
        ArrayList<Columna> columnas = nivel.getColumnas();
        //revisa columna c
        ArrayList<Restriccion> rest = columnas.get(c).getRestricciones();
        for(int j =0; j<rest.size(); j++){
            Restriccion r = rest.get(j);
            // igual cant y color
            if(r.getCantidad() == cant && r.getColor() ==color){
                System.out.println("verificó columna ("+(c+1)+") - "+r.toString());
                rest.remove(j);
                columnas.get(c).setRestricciones(rest);
                return;
            }
        }
    }

}
