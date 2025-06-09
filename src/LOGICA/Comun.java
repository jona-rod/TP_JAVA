package LOGICA;

public class Comun extends Zona {

    public Comun(String codigo, String descripcion) {
        super(codigo, descripcion);
    }
    int CapacidadMax;
    @Override
    public String toString() {
        return "Zona Común [" + codigo + "] " + descripcion;
    }
}
