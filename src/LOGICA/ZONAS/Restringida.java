package LOGICA.ZONAS;

public class Restringida extends Zona {


    static final int capacidadMaxima = 1000;

    public Restringida(String codigo, String descripcion) {
        super(codigo, descripcion);
    }

    public int getCapacidadMaxima() {return capacidadMaxima;}
    @Override
    public char tipoZona(){return 'R';}
}
