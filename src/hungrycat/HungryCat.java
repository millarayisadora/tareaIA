
package hungrycat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @authors  Daniela Zamora Soto
 *           Millaray Tobar Martinez
 */
public class HungryCat {

    public static void main(String[] args) {
        File archivo = null, archivo1 = null, archivo2 = null;
        FileReader fr = null, fr1 = null, fr2 = null;
        BufferedReader br = null, br1 = null, br2 = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para hacer una lectura comoda
            
            /*LECTURA DE DIMENSION DEL TABLERO DE JUEGO*/
            archivo = new File ("input.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            String[]dimensiones;
            String[]caracteres;
            int n,m;
            linea=br.readLine();
            //System.out.println(linea);
            
            dimensiones=linea.split(" ");
            n=Integer.parseInt(dimensiones[0]);
            m=Integer.parseInt(dimensiones[1]);
            System.out.println("N:"+n+" M:"+m);
            int matriz[][] = new int[n][m];
            int j=0;
            while((linea=br.readLine())!=null){
                caracteres=linea.split(" ");
                for(int i=0; i<m;i++){
                    matriz[j][i]=0;
                }
                j++;
            }
            /*LECTURA MATRIZ SUPERIOR DEL JUEGO*/
            archivo1 = new File ("inputSuperior.txt");
            fr1 = new FileReader (archivo1);
            br1 = new BufferedReader(fr1);

            String linea1;
            String[]dimensiones1;
            String[]caracteres1;
            int n1,m1;
            linea1=br1.readLine();
            //System.out.println(linea1);
            
            dimensiones1=linea1.split(" ");
            n1=Integer.parseInt(dimensiones1[0]);
            m1=Integer.parseInt(dimensiones1[1]);
            System.out.println("N:"+n1+" M:"+m1);
            int matrizSup[][] = new int[n1][m1];
            int j1=0;
            while((linea1=br1.readLine())!=null){
                caracteres1=linea1.split(" ");
                for(int i=0; i<m1;i++){
                    matrizSup[j1][i]=Integer.parseInt(caracteres1[i]);
                }
                j1++;
            }
            
            /*LECTURA MATRIZ LATERAL DEL JUEGO*/
            archivo2 = new File ("inputLateral.txt");
            fr2 = new FileReader (archivo2);
            br2 = new BufferedReader(fr2);
            
            String linea2;
            String[]dimensiones2;
            String[]caracteres2;
            int n2,m2;
            linea2=br2.readLine();
            //System.out.println(linea2);
            
            dimensiones2=linea2.split(" ");
            n2=Integer.parseInt(dimensiones2[0]);
            m2=Integer.parseInt(dimensiones2[1]);
            System.out.println("N:"+n2+" M:"+m2);
            int matrizLat[][] = new int[n2][m2];
            int j2=0;
            while((linea2=br2.readLine())!=null){
                caracteres2=linea2.split(" ");
                for(int i=0; i<m2;i++){
                    matrizLat[j2][i]=Integer.parseInt(caracteres2[i]);
                }
                j2++;
            }
                     
            int c=4;
            
            //pintar fila completa
            for(int x=0; x<n; x++){ 
                for(int y=0; y<c; y++){
                    if(Math.abs(matrizLat[x][y]) == m && matrizLat[x][y]<0){            
                        int flag=0;
                        while(flag<m){ 
                            switch(y){
                                case 0: matriz[x][flag] = -1;
                                        break;
                                case 1: matriz[x][flag] = -2;
                                        break;
                                case 2: matriz[x][flag] = -3;
                                        break;
                                case 3: matriz[x][flag] = -4;
                                        break;
                            }
                            flag++;
                        }
                        matrizLat[x][y] = 0;
                    }
                    
                }
            }

            //pintar columna completa
            for(int y=0; y<m; y++){ 
                for(int x=0; x<c; x++){
                    if(Math.abs(matrizSup[x][y]) == n && matrizSup[x][y]<0){
                        int flag=0;
                        while(flag<n){
                            switch(x){
                                case 0: matriz[flag][y] = -1;
                                        break;
                                case 1: matriz[flag][y] = -2;
                                        break;
                                case 2: matriz[flag][y] = -3;
                                        break;
                                case 3: matriz[flag][y] = -4;
                                        break;
                            }
                            flag++;
                        }
                        matrizSup[x][y] = 0;
                    }
                    
                }
            }
            
            /*
            //pintar fila con una sola restriccion por pintar
            int cont=0;
            int pos=0;
            for(int x=0; x<n; x++){ 
                for(int y=0; y<c; y++){
                    if(matrizLat[x][y] != 0){
                        cont++;
                        pos = y;
                    }
                }
                //Si hay solo una restriccion por pintar
                if (cont==1){
                    int flag=0;
                    while (matriz[x][flag] == 0 && flag<m){
                        switch(pos){
                                case 0: matriz[x][flag] = -1;
                                        break;
                                case 1: matriz[x][flag] = -2;
                                        break;
                                case 2: matriz[x][flag] = -3;
                                        break;
                                case 3: matriz[x][flag] = -4;
                                        break;
                        }
                        flag++;
                    }
                    matrizLat[x][flag]=0;
                }
                
            }
            
            //pintar columna con una sola restriccion por pintar
            cont=0;
            pos=0;
            for(int y=0; y<m; y++){ 
                for(int x=0; x<c; x++){
                    if(matrizSup[x][y] != 0 ){
                        cont++;
                        pos = x;
                    }
                }
                if (cont==1){
                    int flag=0;
                    while (matriz[flag][y] == 0 && flag<n){
                        switch(pos){
                                case 0: matriz[flag][y] = -1;
                                        break;
                                case 1: matriz[flag][y] = -2;
                                        break;
                                case 2: matriz[flag][y] = -3;
                                        break;
                                case 3: matriz[flag][y] = -4;
                                        break;
                        }
                        flag++;
                    }
                    matrizSup[flag][y] = 0;       
            }
            
            //Completar fila contiguo ya pintado
            for(int x=0; x<n; x++){ 
                for(int y=0; y<c; y++){
                    if(matrizLat[x][y]<0 && siPintadoC(matriz,x,y)){            
                        int flag=0;
                        while(flag<m){ 
                            switch(y){
                                case 0: matriz[x][flag] = -1;
                                        break;
                                case 1: matriz[x][flag] = -2;
                                        break;
                                case 2: matriz[x][flag] = -3;
                                        break;
                                case 3: matriz[x][flag] = -4;
                                        break;
                            }
                            flag++;
                        }
                        matrizLat[x][y] = 0;
                    }
            
                }
            }
            
            //Completar columna contigua ya pintada
            for(int y=0; y<m; y++){ 
                for(int x=0; x<c; x++){
                    if(Math.abs(matrizSup[x][y]) == n && matrizSup[x][y]<0){
                
                }
            }
            
            
            */
            
            /*
            System.out.println("Matriz Lateral:");
            for(int x=0; x<n ; x++){
                for(int y=0; y<c ; y++){
                    System.out.print(matrizLat[x][y]);
                }
                System.out.println();
            }
            System.out.println("Matriz Superior:");
            for(int x=0; x<c ; x++){
                for(int y=0; y<m ; y++){
                    System.out.print(matrizSup[x][y]);
                }
                System.out.println();
            }
            */
                    
                        
            System.out.println("nueva Matriz 22 de juego :");
            for(int i=0;i<n;i++){
                for(j=0; j<m;j++){
                    System.out.print(matriz[i][j]);
                }
                System.out.println();
            }
           
            
        }catch(Exception e){
            e.printStackTrace();
            }finally{
                try{                    
                   if( null != fr ){   
                      fr.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
                
                try{                    
                   if( null != fr1 ){   
                      fr1.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
                
                try{                    
                   if( null != fr2 ){   
                      fr2.close();     
                   }                  
                }catch (Exception e2){ 
                   e2.printStackTrace();
                }
                
          }
        
    }
    
}
