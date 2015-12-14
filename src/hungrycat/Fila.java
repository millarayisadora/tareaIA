package hungrycat;

import java.util.ArrayList;

public class Fila {
    private ArrayList<Restriccion> restricciones;    
    
    public Fila(){
        restricciones = new ArrayList<Restriccion>();
    }

    public ArrayList<Restriccion> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(ArrayList<Restriccion> restricciones) {
        this.restricciones = restricciones;
    }
    
    public void addRestriccion(Restriccion r){
        this.restricciones.add(r);
    }
}
