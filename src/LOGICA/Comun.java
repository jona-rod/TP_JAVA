package LOGICA;

public class Comun extends Zona {
    int capacidadMax;

    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    public void setCapacidadMax(int capacidadMax) {this.capacidadMax = capacidadMax;}

    public int getCapacidadMax() {return capacidadMax;}
}
