package LOGICA;

public class Escenario extends Zona{

    int cantidadPersonas;

    static final int capacidadMaxima = 1000;

    public Escenario(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
}
