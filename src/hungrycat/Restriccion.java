package hungrycat;

public class Restriccion {
    private int color;
    private int cantidad;
    private Boolean continuos;

    public Restriccion(){}
    
    public Restriccion(int color, int cantidad, Boolean continuos) {
        this.color = color;
        this.cantidad = cantidad;
        this.continuos = continuos;
    }
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getContinuos() {
        return continuos;
    }

    public void setContinuos(Boolean continuos) {
        this.continuos = continuos;
    }
    
    
}
