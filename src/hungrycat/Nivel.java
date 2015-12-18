package hungrycat;

import java.util.ArrayList;


public class Nivel {
    private int restantes;  //Cantidad de cuadros por rellenar
    private int n;  //Dimensiones del nivel
    private int m;  //Dimensiones del nivel
    private int colores;
    private ArrayList<Fila> filas;
    private ArrayList<Columna> columnas;
    private int[][] matriz;

    
    public Nivel() {
        this.filas = new ArrayList();
        this.columnas = new ArrayList();
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return the m
     */
    public int getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(int m) {
        this.m = m;
    }
    
    public int getRestantes() {
        return restantes;
    }

    public void setRestantes(int restantes) {
        this.restantes = restantes;
    }

    public int getColores() {
        return colores;
    }

    public void setColores(int colores) {
        this.colores = colores;
    }

    public ArrayList<Fila> getFilas() {
        return filas;
    }

    public void setFilas(ArrayList<Fila> filas) {
        this.filas = filas;
    }

    public ArrayList<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Columna> columnas) {
        this.columnas = columnas;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        return "Nivel{" + "restantes=" + restantes + ", n=" + n + ", m=" + m + ", colores=" + colores + ", filas=" + filas + ", columnas=" + columnas + ", matriz=" + matriz + '}';
    }
    
    public void printMatriz(int count){
        System.out.println("\n("+count+")---------------\n");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(" "+matriz[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    
    public void pintarCuadro(int f, int c, int color){
        this.matriz[f][c] = color;
        restantes--; //uno menos a los restantes
        
        // De aqui hacia abajo, todo lo que hay que verificar
        // cuando se pinta un cuadrito :)
        
        // Verificar en f/c que la suma del color no sea una restriccion si es así, borrarla
        //Reglas.verificarColoresPorFila(this, f, color);
        //Reglas.verificarColoresPorColumna(this, c, color);
        
    }
    
    public int cuentaColorFila(int f, int color){
        int count =0;
        for(int i =0; i<n;i++){
            if(matriz[f][i] == color) count++;
        }
        //System.out.println("fila "+f+" color: "+color+" cantidad:"+count);
        return count;
    }
    
    public int cuentaColorColumna(int c, int color){
        int count =0;
        for(int i =0; i<m;i++){
            if(matriz[i][c] == color) count++;
        }
        return count;
    }
    
    public void revisarRestricciones(){
        System.out.println("entró");
        // Revisar filas
        for(int f =0; f<m; f++){
            ArrayList<Restriccion> rest = filas.get(f).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                Restriccion r = rest.get(j);
                //System.out.println(r.getCantidad()+" - "+cuentaColorFila(f, r.getColor()));
                if (r.getCantidad() == cuentaColorFila(f, r.getColor())){
                    System.out.println("verificó fila ("+(f+1)+") - "+r.toString());
                    rest.remove(j);
                    System.out.println("Elimina restricción en fila "+(f+1)+" - "+r.toString());
                    filas.get(f).setRestricciones(rest);
                }
            }
        }
        
        //revisar columnas
        for(int c =0; c<n; c++){
            ArrayList<Restriccion> rest = columnas.get(c).getRestricciones();
            for(int j =0; j<rest.size(); j++){
                Restriccion r = rest.get(j);
                if (r.getCantidad() == cuentaColorColumna(c, r.getColor())){
                    System.out.println("verificó columna ("+(c+1)+") - "+r.toString());
                    rest.remove(j);
                    System.out.println("Elimina restricción en columna "+(c+1)+" - "+r.toString());
                    columnas.get(c).setRestricciones(rest);
                }
            }
        }
    }
}
