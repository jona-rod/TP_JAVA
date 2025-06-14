package LOGICA.ZONAS;

public class Restringida extends Zona {

    int cantidadPersonas;

    static final int capacidadMaxima = 1000;

    public Restringida(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public int getCapacidadMaxima() {return capacidadMaxima;}
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
    @Override
    public char tipoZona(){return 'R';}
}
