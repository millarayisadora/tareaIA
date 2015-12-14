package hungrycat;

import java.util.ArrayList;

public class XmlUtils {
    
    public static Nivel readNivel(){
        Nivel nivel = new Nivel();
        
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
