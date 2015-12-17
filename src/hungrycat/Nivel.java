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
        matriz[f][c] = color;
        restantes--; //uno menos a los restantes
        
        // De aqui hacia abajo, todo lo que hay que verificar
        // cuando se pinta un cuadrito :)
        
        // Verificar en f/c que la suma del color no sea una restriccion si es así, borrarla
        Reglas.verificarColoresPorFila(this, f, color);
        Reglas.verificarColoresPorColumna(this, c, color);
        
    }
    
    public int cuentaColorFila(int f, int color){
        int count =0;
        for(int i =0; i<m;i++){
            if(matriz[i][n-1] == color) count++;
        }
        return count;
    }
    
    public int cuentaColorColumna(int c, int color){
        int count =0;
        for(int f =0; f<n;f++){
            if(matriz[m-1][f] == color) count++;
        }
        return count;
    }
}
