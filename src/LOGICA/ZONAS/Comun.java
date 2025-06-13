package LOGICA.ZONAS;

public class Comun extends Zona {
    int capacidadMax;

    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    int CapacidadMax;
    @Override
    public String toString() {
        return "Zona Común [" + codigo + "] " + descripcion;
    }


    public void setCapacidadMax(int capacidadMax) {this.capacidadMax = capacidadMax;}

    public int getCapacidadMax() {return capacidadMax;}
    @Override
    public char tipoZona(){return 'C';}
}
