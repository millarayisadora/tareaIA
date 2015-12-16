package hungrycat;

import java.util.ArrayList;

public class Columna {

    public ArrayList<Restriccion> getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(ArrayList<Restriccion> restricciones) {
        this.restricciones = restricciones;
    }
    private ArrayList<Restriccion> restricciones;
    
    public Columna(){
        restricciones = new ArrayList<Restriccion>();
    }
    
    public void addRestriccion(Restriccion r){
        this.restricciones.add(r);
    }
}
